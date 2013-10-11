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