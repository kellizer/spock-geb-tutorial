package com.spockgeb.tutorial.spock.customer;

/**
 * Samples for the Spock/Geb Tutorials
 *
 * @author Ian Kelly
 */
public class Customer {
    private long customerId;
    private String name;
    private int age;
    private long airMiles;


    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addAirMiles(int miles) {
        airMiles += miles;
    }

    public long getAirMiles() {
        return airMiles;
    }
}
