package com.spockgeb.tutorial

import spock.lang.IgnoreIf
import spock.lang.Specification

/**
 * Samples for the Spock/Geb Tutorials
 * @author Ian Kelly
 */
class ExtensionsSpecification extends Specification {

    @IgnoreIf({ System.getProperty("os.name").contains("windows") })
    def "I'll run on all OS's except windows"() {
        expect:
        !System.getProperty("os.name").contains("windows")
    }
}
