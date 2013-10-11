package com.spockgeb.spock.extensions

import spock.lang.Specification
import spock.lang.Stepwise

/**
 * Samples for the Spock/Geb Tutorials
 * @author Ian Kelly
 */
@Stepwise
class StepwiseSpecification extends Specification {

    def "step 1"() {
        println(System.getProperty("os.name"))
        expect: false
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
