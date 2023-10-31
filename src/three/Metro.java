//------------------------------------------
// Assignment 1
// Part 1
// Written by: Kigham Kerry Kinyuy, 40207088
//------------------------------------------
package three;

import two.Train;

/**
 * Metro represents a class for describing metro trains, extending the Train class.
 * It includes information about the number of stops and a serial number.
 * This class provides constructors, getters, setters, and comparison methods.
 *
 * @author Kigham Kerry Kinyuy
 */
public class Metro extends Train {
    // Fields
    protected int numstops;
    protected static long metroSerialNumberCounter = 25000;

    /**
     * Default constructor for Metro.
     */
    public Metro() {
        super();
    }
  

    /**
     * Parameterized constructor for Metro.
     *
     * @param numofwheels The number of wheels on the metro train.
     * @param maxspeed    The maximum speed of the metro train.
     * @param numvehicles The number of vehicles attached to the metro train.
     * @param startname   The starting station of the metro train.
     * @param endname     The ending station of the metro train.
     * @param numstops    The number of stops for the metro train.
     */
    public Metro(int numofwheels, double maxspeed, int numvehicles, String startname, String endname, int numstops) {
        super(numofwheels, maxspeed, numvehicles, startname, endname);
        this.numstops = numstops;
        serialnum=metroSerialNumberCounter;
        metroSerialNumberCounter++;
 
    }

    /**
     * Copy constructor for Metro.
     *
     * @param obj Another Metro object to copy.
     */
    public Metro(Metro obj) {
        super(obj);
        this.numstops = obj.numstops;
    }

  

    /**
     * Get the number of stops for the metro train.
     *
     * @return The number of stops.
     */
    public int getNumstops() {
        return numstops;
    }

    /**
     * Set the number of stops.
     *
     * @param numstops the number of stops to set.
     */

    public void setNumstops(int numstops) {
		this.numstops = numstops;
	}

	/**
     * Create a string representation of the Metro object.
     *
     * @return A string representation of the metro train.
     */
    public String toString() {
        return   " There is a metro with serial number " + this.serialnum + " with " + numstops + " number of stops.";
    }

    /**
     * Check if this Metro object is equal to another object.
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
            Metro otherMetro = (Metro) otherObject;
            return this.numstops == otherMetro.numstops;
        }
    }
}
