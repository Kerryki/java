//-------------------------------------------
// Assignment 1
// Part 1
// Written by: Kigham Kerry Kinyuy, 40207088
//-------------------------------------------

package one;

/**
 * WheeledTransportation represents a basic class for wheeled vehicles.
 * It includes information about the number of wheels, maximum speed, and a unique serial number.
 * This class provides constructors, getters, setters, and comparison methods.
 *
 * @author Kigham Kerry Kinyuy
 */
public class WheeledTransportation extends Vehicle {
    // Fields
    protected int numofwheels;
    protected double maxspeed;
    private static long serialNumberCounter=1;
  

    /**
     * Default constructor for WheeledTransportation.
     */
    public WheeledTransportation() {
    	

    }

    /**
     * Parameterized constructor for WheeledTransportation.
     *
     * @param numofwheels The number of wheels on the vehicle.
     * @param maxspeed    The maximum speed of the vehicle.

     */
    public WheeledTransportation(int numofwheels, double maxspeed) {
        this.numofwheels = numofwheels;
        this.maxspeed = maxspeed;
        this.serialnum= serialNumberCounter;
        serialNumberCounter++;
    }
   
    
    /**
     * Copy constructor for WheeledTransportation.
     *
     * @param obj Another WheeledTransportation object to copy.
     */
    public WheeledTransportation(WheeledTransportation obj) {
        this.numofwheels = obj.numofwheels;
        this.maxspeed = obj.maxspeed;

    }

    // Getters and Setters
    
    

    /**
     * Get the number of wheels.
     *
     * @return The number of wheels.
     */
    public int getNumofwheels() {
        return numofwheels;
    }

    /**
     * Get the maximum speed.
     *
     * @return The maximum speed.
     */
    public double getMaxspeed() {
        return maxspeed;
    }

   

    /**
     * Set the number of wheels.
     *
     * @param numofwheels The number of wheels to set.
     */
    public void setNumofwheels(int numofwheels) {
        this.numofwheels = numofwheels;
    }

    /**
     * Set the maximum speed.
     *
     * @param maxspeed The maximum speed to set.
     */
    public void setMaxspeed(double maxspeed) {
        this.maxspeed = maxspeed;
    }



    /**
     * Create a string representation of the WheeledTransportation object.
     *
     * @return A string representation of the object.
     */
    public String toString() {
        return "This WheeledTransportation - serial# " + this.serialnum + " has " + numofwheels + " wheels and a max speed of " + maxspeed;
    }

    /**
     * Check if this WheeledTransportation object is equal to another object.
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
            WheeledTransportation otherWheeledTransport = (WheeledTransportation) otherObject;
            return (this.numofwheels == otherWheeledTransport.numofwheels) &&
                    (this.maxspeed == otherWheeledTransport.maxspeed);
        }
    }
}
