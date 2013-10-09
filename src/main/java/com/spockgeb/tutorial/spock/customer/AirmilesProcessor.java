package com.spockgeb.tutorial.spock.customer;

/**
 * Samples for the Spock/Geb Tutorials
 *
 * @author Ian Kelly
 */
public class AirmilesProcessor {

    private CustomerRepository customerRepository;

    public AirmilesProcessor(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void applyAirMiles(long customerId, int miles) {
        Customer customer = customerRepository.findById(customerId);
        if (customer == null)
            throw new IllegalStateException("customer must be valid");
        customer.addAirMiles(miles);
    }
}
