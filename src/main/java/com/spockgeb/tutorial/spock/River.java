package com.spockgeb.tutorial.spock;

/**
 * Samples for the Spock/Geb Tutorials
 *
 * @author Ian Kelly
 */
public class River {

    private String name;
    private boolean saintPatrickDay;

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
     * Sets the name of the river.
     * @param name - the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The Colour of the river
     *
     * @return the river colour
     */
    public String getColour() {
        if (name.equalsIgnoreCase("chicago") && saintPatrickDay) return "Green";
        return "Blue";
    }

    /**
     * Sets if it is saint patricks days.
     * @param isSaintPatrickDay - is it saint patricks day.
     */
    public void setSaintPatrickDay(boolean isSaintPatrickDay) {
        saintPatrickDay = isSaintPatrickDay;
    }
}
