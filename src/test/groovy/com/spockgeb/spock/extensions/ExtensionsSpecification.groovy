package com.spockgeb.spock.extensions

import spock.lang.FailsWith
import spock.lang.IgnoreIf
import spock.lang.IgnoreRest
import spock.lang.Specification

/**
 * Samples for the Spock/Geb Tutorials
 * @author Ian Kelly
 */
class ExtensionsSpecification extends Specification {

    @IgnoreIf({ System.getProperty("os.name").contains("windows") })
//    @IgnoreIf({ System.getProperty("os.name").contains("Mac OS X") })
    def "I'll run on all OS's except windows"() {
        println("I'm running and my OS - " + System.getProperty("os.name"))
        expect:
        true
    }


    @FailsWith(IllegalStateException)
    def "I will throw an exception if you run me"() {
        expect:
        throw new IllegalStateException("I TOLD YOU NOT TO RUN ME")
    }

    @IgnoreRest
    def "Anyone after me will not run"() {
        expect:
        true
    }
}
