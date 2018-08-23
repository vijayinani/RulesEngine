package com.boa.rulesengine;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class RequestProcessorTest {

    private Map<String, Set<Node>> rulesCache;

    @Before
    public void setUp() {
        rulesCache = RequestProcessor.loadRules();
    }

    @Test
    public void testResults() {
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
        String input12 = "Fees,NSE,2001,*";
        String input13 = "Fees,NSE,*,*";
        assertEquals("100", RequestProcessor.getResult(input1, rulesCache));
        assertEquals("90", RequestProcessor.getResult(input2, rulesCache));
        assertEquals("50", RequestProcessor.getResult(input3, rulesCache));
        assertEquals("10", RequestProcessor.getResult(input4, rulesCache));
        assertEquals("20", RequestProcessor.getResult(input5, rulesCache));
        assertEquals("10", RequestProcessor.getResult(input6, rulesCache));
        assertEquals("5", RequestProcessor.getResult(input7, rulesCache));
        assertEquals("2", RequestProcessor.getResult(input8, rulesCache));
        assertEquals("6", RequestProcessor.getResult(input9, rulesCache));
        assertEquals("20", RequestProcessor.getResult(input10, rulesCache));
        assertEquals("20", RequestProcessor.getResult(input11, rulesCache));
        assertNull(RequestProcessor.getResult(input12, rulesCache));
        assertNull(RequestProcessor.getResult(input13, rulesCache));
    }
}