package com.spockgeb.tutorial

import spock.lang.Specification
import spock.lang.Stepwise

/**
 * Samples for the Spock/Geb Tutorials
 * @author Ian Kelly
 */
@Stepwise
class StepwiseSpecification extends Specification {

    def "step 1"() {
        expect: false
        println("step 1")
    }

    def "step 2"() {
        expect: true
        println("step 2")
    }

    def "step 3"() {
        expect: true
        println("step 3")

    }
}
