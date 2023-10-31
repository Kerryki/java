//------------------------------------------
// Assignment 1
// Part 1
// Written by: Kigham Kerry Kinyuy, 40207088
//------------------------------------------
package fourth;

import one.WheeledTransportation;

/**
 * Monowheel represents a class for describing monowheel vehicles, extending the WheeledTransportation class.
 * It includes information about the maximum weight it can carry and a serial number.
 * This class provides constructors, getters, setters, and comparison methods.
 *
 * @author Kigham Kerry Kinyuy
 */
public class Monowheel extends WheeledTransportation {
    // Fields
    private int maxweight;
    private static long monowheelSerialNumberCounter = 55000;

    /**
     * Default constructor for Monowheel.
     */
    public Monowheel() {
        super();
    }
 
    
    
    /**
     * Parameterized constructor for Monowheel.
     *
     * @param numofwheels The number of wheels on the monowheel.
     * @param maxspeed    The maximum speed of the monowheel.
     * @param maxweight   The maximum weight the monowheel can carry.
     */
    public Monowheel(int numofwheels, double maxspeed, int maxweight) {
        super(numofwheels, maxspeed);
        this.maxweight = maxweight;
        serialnum=monowheelSerialNumberCounter;
        monowheelSerialNumberCounter++;
    }

    /**
     * Copy constructor for Monowheel.
     *
     * @param obj Another Monowheel object to copy.
     */
    public Monowheel(Monowheel obj) {
        super(obj);
        this.maxweight = obj.maxweight;
    }

    /**
     * Get the next serial number for a monowheel.
     *
     * @return The next serial number.
     */
    public long getNextSerialNumber() {
        return serialnum;
    }

    /**
     * Get the maximum weight the monowheel can carry.
     *
     * @return The maximum weight.
     */
    public int getMaxweight() {
        return maxweight;
    }

    /**
     * Set the maximum weight.
     *
     * @param maxweight the maximum weight to set.
     */

    public void setMaxweight(int maxweight) {
		this.maxweight = maxweight;
	}

	/**
     * Create a string representation of the Monowheel object.
     *
     * @return A string representation of the monowheel.
     */
    public String toString() {
        return " There's a Monowheel with serial number " + this.serialnum + " and max weight " + maxweight;
    }

    /**
     * Check if this Monowheel object is equal to another object.
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
            Monowheel otherMonowheel = (Monowheel) otherObject;
            return this.maxweight == otherMonowheel.maxweight;
        }
    }
}
