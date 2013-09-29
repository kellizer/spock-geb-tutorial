package com.spockgeb.tutorial

import com.spockgeb.tutorial.spock.River
import spock.lang.Specification

/**
 * Created with IntelliJ IDEA.
 * Date: 29/09/13
 * Time: 12:05
 */
class LifecycleTestSpecification extends Specification {


    def "The colour of the Hudson river should be blue"() {
        def river = new River("Hudson")
        expect:
        river.colour == 'Blue'
    }

    def "The chicago river should be green..."() {
        when:
        def river = new River("Chicago")
        then:
        river.colour == 'Green'
    }

}
