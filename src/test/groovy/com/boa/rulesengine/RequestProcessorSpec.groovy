package com.boa.rulesengine

import spock.lang.Ignore
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class RequestProcessorSpec extends Specification {

    @Shared
    private Map<String, Set<Node>> rulesCache

//    def setupSpec() {
//        rulesCache = RequestProcessor.loadRules()
//    }

    @Unroll
    @Ignore
    void "test the rule engine #input #output"() {
        expect:
        output == RequestProcessor.getResult(input, rulesCache)

        where:
        input                     | output
        "Tax,NSE,2001,*,AA,*"     | "100"
        "Tax,*,3001,IN,AB,CD"     | "90"
        "Tax,*,*,*,*,*"           | "50"
        "Instrument,NSDQ,1001,US" | "10"
        "Instrument,NYSE,1001,US" | "20"
        "Instrument,BSE,1001,*"   | "10"
        "Instrument,BSE,*,*"      | "5"
        "Instrument,*,2001,IN"    | "2"
        "Instrument,*,*,US"       | "6"
        "Instrument,*,*,*"        | "20"
        "Instrument,NSE,2001,*"   | "20"
        "Fees,NSE,2001,*"         | null
        "Fees,NSE,*,*"            | null
        "Fees,NSE,*,*"            | null
    }

    @Unroll
    @Ignore
    void "test the rule engine for exception #input"() {
        when:
        RequestProcessor.getResult(input, rulesCache)

        then:
        thrown(Exception)

        where:
        input << ["vijay"]
    }
}