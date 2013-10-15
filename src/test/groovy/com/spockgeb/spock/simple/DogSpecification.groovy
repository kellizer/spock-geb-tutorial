package com.spockgeb.spock.simple

import com.spockgeb.tutorial.spock.Dog
import spock.lang.Specification

class DogSpecification extends Specification {

    def "Dogs should bark when told to speak like a dog"() {
        setup:
        def chip = new Dog()
        expect:
        chip.speak() == 'WOOF'
    }

    /**
     * Demos how chip will speak with a when/then.
     */
    def "Dogs should bark when told to speak like a dog with the when/then structure"() {
        given:
        def chip = new Dog()
        when:
        def spoken = chip.speak()
        then:
        spoken == 'WOOF'
    }

     def "Dogs should bark when told to speak like a dog with a sore voice"() {
        setup:
        def chip = new Dog()
        expect:
        chip.speak() == 'WooF'
    }

    def "Dogs should bark when told to speak like a duck"() {
        setup:
        def chip = new Dog()
        expect:
        chip.speak() == 'Quack'
    }


}