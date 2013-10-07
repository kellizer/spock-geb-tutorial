package com.spockgeb.tutorial.spock.customer;

/**
 * Samples for the Spock/Geb Tutorials
 *
 * @author Ian Kelly
 */
public interface CustomerRepository {

    /**
     * Finds the customer based on their ID.
     *
     * @param id - their ID
     * @return the custom
     */
    Customer findById(long id);

    void save(Customer customer);


}
