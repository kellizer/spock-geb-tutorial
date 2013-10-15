package com.spockgeb.spock.mocking

import com.spockgeb.tutorial.spock.customer.AirmilesProcessor
import com.spockgeb.tutorial.spock.customer.Customer
import com.spockgeb.tutorial.spock.customer.CustomerRepository
import spock.lang.Specification
import spock.lang.Subject

/**
 * Samples for the Spock/Geb Tutorials
 * @author Ian Kelly
 */
class ValidateAirMileProcessorSpecification extends Specification {

    CustomerRepository customerRepository = Mock()
    @Subject
    AirmilesProcessor airMilesProcessor;

    def setup() {
        airMilesProcessor = new AirmilesProcessor(customerRepository)
    }

    def "load customer and apply airmiles but customer doesn't exist"() {
        when:
        airMilesProcessor.applyAirMiles(332211, 4000)
        then:
        1 * customerRepository.findById(332211) >> null
        thrown(IllegalStateException)
    }

    /**
     * Also shows an eloquent use of the where clause to consolidate and drive the test.
     *
     */
    def "load customer and applying air-miles"() {
        when:
        airMilesProcessor.applyAirMiles(customer.customerId, 4000)
        then:
        1.._ * customerRepository.findById(332211) >> customer
        customer.airMiles == 4000
        where:
        customer = new Customer(customerId: 332211)
    }

    /**
     * Shows where working with mocking
     */
    def "load customer and applying air-miles with multiple customers"() {
        when:
        airMilesProcessor.applyAirMiles(customer.customerId, 4000)
        then:
        1 * customerRepository.findById(customer.customerId) >> customer
        customer.airMiles == 4000
        where:
        customer << [new Customer(customerId: 332211), new Customer(customerId: 43221)] //we could use a DB here.
    }

    /**
     * Shows how to return different values based on the number of times called.
     */
    def "load customer and return different read values"() {
        when:
        def firstTimeRead = airMilesProcessor.readAirMilesTotalForCustomer(customer.customerId)
        def secondTimeRead = airMilesProcessor.readAirMilesTotalForCustomer(customer.customerId)
        def thirdTimeRead = airMilesProcessor.readAirMilesTotalForCustomer(customer.customerId)
        def fourthTimeRead = airMilesProcessor.readAirMilesTotalForCustomer(customer.customerId)
        then:
        customerRepository.currentBalance(customer.customerId) >>> [100, 200, 999] //not the >>> operator
        println("Balance on first call was $firstTimeRead")
        println("Balance on second call was $secondTimeRead")
        println("Balance on third call was $thirdTimeRead")
        println("Balance on fourth call was $fourthTimeRead")
        where:
        customer << [new Customer(customerId: 1)]
    }

    /**
     * Shows mocking having customer id being passed into the closure
     */
    def "load customer and applying air-miles but throw an exception"() {
        when:
        airMilesProcessor.applyAirMiles(customer.customerId, 4000)
        then:
        1 * customerRepository.findById(customer.customerId) >> { it ->
            throw new IllegalStateException("You shouldn't have run this for customer ($it)")
        }
        customer.airMiles == 4000
        where:
        customer = new Customer(customerId: 43221)
    }


}
