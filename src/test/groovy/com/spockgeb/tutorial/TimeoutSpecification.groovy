package com.spockgeb.tutorial

import com.spockgeb.tutorial.spock.customer.Customer
import spock.lang.Specification
import spock.lang.Timeout
import spock.util.concurrent.PollingConditions

/**
 * Samples for the Spock/Geb Tutorials
 * @author Ian Kelly
 */
class TimeoutSpecification extends Specification {

    def "shows timeout when using PolingConditions"() {
        setup:
        def conditions = new PollingConditions(timeout: 10)
        def person = new Customer(name: "Fred", age: 22)
        when:
        Thread.start {
            sleep(3000)
            person.age = 42
            sleep(5000)
            person.name = "Barney"
        }
        then:
        conditions.within(1) {
            assert person.age == 42
        }
        conditions.eventually {
            assert person.name == "Barney"
        }
    }

    @Timeout(value = 5)
    def "timeout feature method if not completed after 5 seconds"() {
        def person = new Customer(name: "Fred", age: 22)
        when:
        person.age = 42
        Thread.sleep(7000)
        then:
        person.age == 42
    }



}
