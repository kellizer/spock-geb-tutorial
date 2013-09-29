package com.spockgeb.tutorial.spock;

/**
 * Samples for the Spock/Geb Tutorials
 *
 * @author Ian Kelly
 */
public class River {

    private String name;

    public River(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the river
     *
     * @return name of the river
     */
    public String getName() {
        return name;
    }

    /**
     * The Colour of the river
     *
     * @return the river colour
     */
    public String getColour() {
        if (name.equalsIgnoreCase("chicago")) return "Green";
        return "Blue";
    }
}
