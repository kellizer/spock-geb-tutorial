package com.spockgeb.spock.extensions

import spock.lang.AutoCleanup
import spock.lang.Specification

/**
 * Samples for the Spock/Geb Tutorials
 * @author Ian Kelly
 */
class InputStreamSpec extends Specification {

    @AutoCleanup(quiet = true)
    def input = new FileInputStream("myfile.txt")

    def "some input stream tests"() {
        // …
    }

}


