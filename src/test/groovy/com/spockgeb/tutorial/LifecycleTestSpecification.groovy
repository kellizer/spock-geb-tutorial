package com.spockgeb.tutorial

import com.spockgeb.tutorial.spock.River
import spock.lang.Specification

/**
 * Created with IntelliJ IDEA.
 * Date: 29/09/13
 * Time: 12:05
 */
class LifecycleTestSpecification extends Specification {

    // fields
    // fixture methods
    // feature methods
    // helper methods

    /**
     * This is a feature method
     */
    def "The colour of the Hudson river should be blue"() {
        def river = new River("Hudson")
        expect: "Nice when you want to describe the stimulus and the expected result in single block"
        river.colour == 'Blue'
    }


    def "The chicago river should be green if it is saint patrick's day..."() {
        setup: "The River runs through chicago"
        def river = new River("Chicago")
        when: "it is saint patrick day"
        river.setSaintPatrickDay(true)
        then: "the river should be green"
        river.colour == 'Green'
    }


    def "The chicago river should be blue when it is not saint patrick's day..."() {
        when:
        def river = new River("Chicago")
        then:
        river.colour == 'Green'
    }


    def "The name should be the same as the defined name"() {
        given:
        def river = new River("Thames")
        when:
        river.name = "Danube"
        then:
        river.name == "Danube"
    }


}
