//------------------------------------------
// Assignment 1
// Part 1
// Written by: Kigham Kerry Kinyuy, 40207088
//------------------------------------------
package fifth;
import one.Vehicle;

/**
 * Aircraft represents a class for describing aircraft.
 * It includes information about the price, maximum elevation, and a serial number.
 * This class provides constructors, getters, setters, and comparison methods.
 *
 * @author Kigham Kerry Kinyuy
 */
public class Aircraft extends Vehicle {
    // Fields
    protected double price;
    protected double maxelevation;
    private static long serialNumberCounter=1;

    /**
     * Default constructor for Aircraft.
     */
    public Aircraft() {

    }

    /**
     * Parameterized constructor for Aircraft.
     *
     * @param price        The price of the aircraft.
     * @param maxelevation The maximum elevation the aircraft can reach.
     */
    public Aircraft(double price, double maxelevation) {
        this.price = price;
        this.maxelevation = maxelevation;
        serialnum=serialNumberCounter;
        serialNumberCounter++;

       
    }
 

    /**
     * Copy constructor for Aircraft.
     *
     * @param obj Another Aircraft object to copy.
     */
    public Aircraft(Aircraft obj) {
        this.price = obj.price;
        this.maxelevation = obj.maxelevation;
    }

    /**
     * Get the price of the aircraft.
     *
     * @return The price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Get the maximum elevation the aircraft can reach.
     *
     * @return The maximum elevation.
     */
    public double getMaxelevation() {
        return maxelevation;
    }
    
    /**
     * Set the price.
     *
     * @param price the price to set.
     */

	public void setPrice(double price) {
		this.price = price;
	}
	
	  /**
     * Set the maximum elevation.
     *
     * @param maxelevation maximum elevation to set.
     */

	public void setMaxelevation(double maxelevation) {
		this.maxelevation = maxelevation;
	}

	/**
     * Create a string representation of the Aircraft object.
     *
     * @return A string representation of the aircraft.
     */
    public String toString() {
        return "This Aircraft costs " + price + "$, it has a maximum elevation of " + maxelevation +
                ", and its serial number is " + serialnum;
    }

    /**
     * Check if this Aircraft object is equal to another object.
     *
     * @param otherObject The object to compare.
     * @return True if the objects are equal, false otherwise.
     */
    public boolean equals(Object otherObject) {
        if (otherObject == null)
            return false;
        else if (getClass() != otherObject.getClass())
            return false;
        else {
            Aircraft otherAircraft = (Aircraft) otherObject;
            return this.price == otherAircraft.price && this.maxelevation == otherAircraft.maxelevation;
        }
    }
}
