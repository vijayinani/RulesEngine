package com.boa.rulesengine;

import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RequestProcessor {

    public static void main(String[] args) {
        Map<String, Set<Node>> rulesCache = loadRules();
        String input1 = "Tax,NSE,2001,*,AA,*";
        String input2 = "Tax,*,3001,IN,AB,CD";
        String input3 = "Tax,*,*,*,*,*";
        String input4 = "Instrument,NSDQ,1001,US";
        String input5 = "Instrument,NYSE,1001,US";
        String input6 = "Instrument,BSE,1001,*";
        String input7 = "Instrument,BSE,*,*";
        String input8 = "Instrument,*,2001,IN";
        String input9 = "Instrument,*,*,US";
        String input10 = "Instrument,*,*,*";
        String input11 = "Instrument,NSE,2001,*";
        String input12 = "Feex,NSE,2001,*";
        System.out.println(getResult(input1, rulesCache));
        System.out.println(getResult(input2, rulesCache));
        System.out.println(getResult(input3, rulesCache));
        System.out.println(getResult(input4, rulesCache));
        System.out.println(getResult(input5, rulesCache));
        System.out.println(getResult(input6, rulesCache));
        System.out.println(getResult(input7, rulesCache));
        System.out.println(getResult(input8, rulesCache));
        System.out.println(getResult(input9, rulesCache));
        System.out.println(getResult(input10, rulesCache));
        System.out.println(getResult(input11, rulesCache));
        System.out.println(getResult(input12, rulesCache));
    }

    public static String getResult(String input, Map<String, Set<Node>> rulesCache) {
        String[] inputSplit = input.split(",");
        Set<Node> current = rulesCache.get(inputSplit[0]);
        if (current == null) {
            return null;
        }
        Node node = new Node();
        for (int i = 1; i < inputSplit.length; i++) {
            node.setValue(inputSplit[i]);
            if (current.contains(node)) {
                current = getNode(current, node);
            } else {
                node.setValue("*");
                if (current.contains(node)) {
                    current = getNode(current, node);
                } else {
                    return null;
                }
            }
        }
        return current.stream().findFirst().get().getValue();
    }

    private static Set<Node> getNode(Set<Node> current, Node node) {
        return current.stream().filter(node::equals).findAny().get().getChildren();
    }

    public static Map<String, Set<Node>> loadRules() {

        Map<String, Set<Node>> rulesCache = new HashMap<>();

        final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        final String userName = "scott";
        final String password = "scott";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(url, userName, password);
            String query = "select RULESET_ID, LISTAGG(attribute_value, ',') " +
                    "WITHIN GROUP (ORDER BY ruleset_id, rule_id, priority) \"priority_values\" " +
                    "FROM rules_set " +
                    "group by ruleset_id, rule_id";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            createCache(rulesCache, resultSet);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rulesCache;
    }

    private static void createCache(Map<String, Set<Node>> rulesCache, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String rulesetId = resultSet.getString("RULESET_ID");
            String priorityValues = resultSet.getString("PRIORITY_VALUES");

            if (!rulesCache.containsKey(rulesetId)) {
                rulesCache.put(rulesetId, new HashSet<>());
            }
            Set<Node> nodes = rulesCache.get(rulesetId);

            String[] values = priorityValues.split(",");
            for (int i = 0; i < values.length - 1; i++) {

                Node node = new Node();
                node.setValue(values[i]);
                if (nodes.contains(node)) {
                    Node currentNode = nodes.stream().filter(node::equals).findAny().get();
                    nodes = currentNode.getChildren();
                } else {
                    node.setChildren(new HashSet<>());
                    nodes.add(node);
                    nodes = node.getChildren();
                }

            }
            Node node = new Node();
            node.setValue(values[values.length - 1]);
            nodes.add(node);
        }
    }
}