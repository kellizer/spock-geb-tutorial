package com.spockgeb.spock.simple

import com.spockgeb.tutorial.spock.River
import spock.lang.Specification

/**
 * Simple Test Life cycles.
 * @author Ian Kelly
 */
class LifecycleTestSpecification extends Specification {

    // fields
    def thamesRiver = new River("Thames")

    /**
     * 101 - feature method with a setup/when/then block
     */
    def "The chicago river should be green if it is saint patrick's"() {
        setup: "The River runs through chicago"
        def river = new River("Chicago")
        when: "it is saint patrick day"
        river.setSaintPatrickDay(true)
        then: "the river should be green"
        river.colour == 'Green'
    }

    /**
     * 102-feature method with a given/when/then block - identical to the 101 test
     */
    def "The chicago river should be green if it is saint patrick's day with a given block."() {
        given: "The River runs through chicago with a given block which is identical to a setup blco"
        def river = new River("Chicago")
        when: "it is saint patrick day"
        river.setSaintPatrickDay(true)
        then: "the river should be green"
        river.colour == 'Green'
    }

    /**
     * 103 - feature method
     */
    def "The chicago river should be blue when it is not saint patrick's day."() {
        setup:
        def river = new River("Chicago")
        when:
        river.setSaintPatrickDay(false)
        then:
        river.colour == 'Blue'
    }

    /**
     * 104 - Using a specification level field.
     */
    def "Change the thames name to the Danube"() {
        when:
        thamesRiver.name = "Danube"
        then:
        thamesRiver.name == "Danube"
    }

    /**
     * 105 - Using a specification level field again.
     */
    def "The River Thames should be defaulted"() {
        expect:
        thamesRiver.name == "Thames"
    }

    /**
     * 106 - This is a feature method that shows the expect block
     */
    def "2 should be larger than 1"() {
        expect:
        Math.max(1, 2)  ==  2
    }

}
