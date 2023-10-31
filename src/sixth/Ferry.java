//------------------------------------------
// Assignment 1
// Part 1
// Written by: Kigham Kerry Kinyuy, 40207088
//------------------------------------------
package sixth;
import one.Vehicle;

/**
 * Ferry represents a class for describing ferry vehicles.
 * It includes information about maximum speed, maximum load capacity, and a serial number.
 * This class provides constructors, getters, setters, and comparison methods.
 *
 * @author Kigham Kerry Kinyuy
 */
public class Ferry extends Vehicle {
    // Fields
    private double maxspeed;
    private double maxload;
    private static long ferryNumberCounter = 70000;

    /**
     * Default constructor for Ferry.
     */
    public Ferry() {

    }
  

    /**
     * Parameterized constructor for Ferry.
     *
     * @param maxspeed The maximum speed of the ferry.
     * @param maxload  The maximum load capacity of the ferry.
     */
    public Ferry(double maxspeed, double maxload) {
        this.maxspeed = maxspeed;
        this.maxload = maxload;
        serialnum=ferryNumberCounter;
        ferryNumberCounter++;

    }

    /**
     * Copy constructor for Ferry.
     *
     * @param obj Another Ferry object to copy.
     */
    public Ferry(Ferry obj) {
        this.maxspeed = obj.maxspeed;
        this.maxload = obj.maxload;
    }

    /**
     * Get the next serial number for a ferry.
     *
     * @return The next serial number.
     */
    public long getNextSerialNumber() {
        return serialnum;
    }

    /**
     * Get the maximum speed of the ferry.
     *
     * @return The maximum speed.
     */
    public double getMaxspeed() {
        return maxspeed;
    }

    /**
     * Get the maximum load capacity of the ferry.
     *
     * @return The maximum load capacity.
     */
    public double getMaxload() {
        return maxload;
    }

  
    
    /**
     * Set the maximum speed.
     *
     * @param maxspeed maximum speed to set.
     */

    public void setMaxspeed(double maxspeed) {
		this.maxspeed = maxspeed;
	}
    
    /**
     * Set the maximum load.
     *
     * @param maxload maximum load to set.
     */

	public void setMaxload(double maxload) {
		this.maxload = maxload;
	}

	/**
     * Create a string representation of the Ferry object.
     *
     * @return A string representation of the ferry.
     */
    public String toString() {
        return "This Ferry with serial number " + this.serialnum + " has a max speed of " + maxspeed +
                " and the maximum load it can take is " + maxload;
    }

    /**
     * Check if this Ferry object is equal to another object.
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
            Ferry otherFerry = (Ferry) otherObject;
            return this.maxspeed == otherFerry.maxspeed && this.maxload == otherFerry.maxload;
        }
    }
}
