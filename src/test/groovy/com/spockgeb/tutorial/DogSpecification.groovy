package com.spockgeb.tutorial

import com.spockgeb.tutorial.spock.Dog
import spock.lang.Specification

class DogSpecification extends Specification {

    def "Dogs should bark when told to speak"() {
        setup:
        def chip = new Dog()
        expect:
        chip.speak() == 'Woof'
    }


}