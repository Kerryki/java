//------------------------------------------
// Assignment 1
// Part 1
// Written by: Kigham Kerry Kinyuy, 40207088
//------------------------------------------
package two;

import one.WheeledTransportation;

/**
 * Train represents a class for describing train vehicles, extending WheeledTransportation.
 * It includes information about the number of vehicles, starting and ending stations, and a serial number.
 * This class provides constructors, getters, setters, and comparison methods.
 *
 * @author Kigham Kerry Kinyuy
 */
public class Train extends WheeledTransportation {
    // Fields
    protected int numvehicles;
    protected String startname;
    protected String endname;
    private static long trainSerialNumberCounter = 10000;

    
    

    /**
     * Default constructor for Train.
     */
    public Train() {
    	super();
    	
    }
 

    /**
     * Parameterized constructor for Train.
     *
     * @param numofwheels The number of wheels on the train.
     * @param maxspeed    The maximum speed of the train.
     * @param numvehicles The number of vehicles attached to the train.
     * @param startname   The starting station of the train.
     * @param endname     The ending station of the train.
     */
    public Train(int numofwheels, double maxspeed, int numvehicles, String startname, String endname) {
        super(numofwheels, maxspeed);
        this.numvehicles = numvehicles;
        this.startname = startname;
        this.endname = endname;
        serialnum= trainSerialNumberCounter;
        trainSerialNumberCounter++;
        
    }

    /**
     * Copy constructor for Train.
     *
     * @param obj Another Train object to copy.
     */
    public Train(Train obj) {
        super(obj);
        this.numvehicles = obj.numvehicles;
        this.startname = obj.startname;
        this.endname = obj.endname;
    }


    /**
     * Get the number of vehicles attached to the train.
     *
     * @return The number of vehicles.
     */
    public int getNumvehicles() {
        return numvehicles;
    }

    /**
     * Get the starting station of the train.
     *
     * @return The starting station.
     */
    public String getStartname() {
        return startname;
    }

    /**
     * Get the ending station of the train.
     *
     * @return The ending station.
     */
    public String getEndname() {
        return endname;
    }
    
    /**
     * Set the number of vehicles.
     *
     * @param numvehicles The number of vehicles to set.
     */

    public void setNumvehicles(int numvehicles) {
		this.numvehicles = numvehicles;
	}
    
    /**
     * Set the destination name.
     *
     * @param endname the start date to set.
     */

	public void setEndname(String endname) {
		this.endname = endname;
	}
	
	
	  /**
     * Set the start name.
     *
     * @param startname the destination date to set.
     */
	
	public void setStartname(String startname) {
		this.startname = startname;
	}

	/**
     * Create a string representation of the Train object.
     *
     * @return A string representation of the train.
     */
    public String toString() {
        return " This train with serial number " + serialnum + " with " + numvehicles + " number of vehicles. " +
                "and its starting and destination stations are " + startname + " and " + endname;
    }

    /**
     * Check if this Train object is equal to another object.
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
            Train otherTrain = (Train) otherObject;
            return (this.numvehicles == otherTrain.numvehicles) &&
                    this.startname.equals(otherTrain.startname) &&
                    this.endname.equals(otherTrain.endname);
        }
    }
}

