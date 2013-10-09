package com.spockgeb.spock.mocking

import com.spockgeb.tutorial.spock.customer.AirMilesProcessor
import com.spockgeb.tutorial.spock.customer.Customer
import com.spockgeb.tutorial.spock.customer.CustomerRepository
import spock.lang.Specification

/**
 * Samples for the Spock/Geb Tutorials
 * @author Ian Kelly
 */
class ValidateAirMileProcessorSpecification extends Specification {

    CustomerRepository customerRepository = Mock()
    AirMilesProcessor airMilesProcessor;

    def setup() {
        airMilesProcessor = new AirMilesProcessor(customerRepository)
    }

    def "load customer and applying airmiles where customer doesn't exist"() {
        when:
        airMilesProcessor.applyAirMiles(332211, 4000)
        then:
        1 * customerRepository.findById(332211) >> null
        thrown(IllegalStateException)
    }

    def "load customer and applying air-miles"() {
        when:
        airMilesProcessor.applyAirMiles(customer.customerId, 4000)
        then:
        2..4 * customerRepository.findById(332211) >> customer

        customer.airMiles == 4000
        where:
        customer = new Customer(customerId: 332211)
    }

}
