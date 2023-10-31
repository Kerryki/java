//------------------------------------------
// Assignment 1
// Part 1
// Written by: Kigham Kerry Kinyuy, 40207088
//------------------------------------------
package two;

import three.Metro;

/**
 * Tram represents a class for describing tram vehicles, extending the Metro class.
 * It includes information about the year of creation and a serial number.
 * This class provides constructors, getters, setters, and comparison methods.
 *
 * @author Kigham Kerry Kinyuy
 */
public class Tram extends Metro {
    // Fields
    private int creationyr;
    private static long TramSerialNumberCounter = 30000;
    

    /**
     * Default constructor for Tram.
     */
    public Tram() {
        super();
    }
  

    /**
     * Parameterized constructor for Tram.
     *
     * @param numofwheels The number of wheels on the tram.
     * @param maxspeed    The maximum speed of the tram.
     * @param numvehicles The number of vehicles attached to the tram.
     * @param startname   The starting station of the tram.
     * @param endname     The ending station of the tram.
     * @param numstops    The number of stops for the tram.
     * @param creationyr  The year of creation of the tram.
     */
    public Tram(int numofwheels, double maxspeed, int numvehicles, String startname, String endname, int numstops, int creationyr) {
        super(numofwheels, maxspeed, numvehicles, startname, endname, numstops);
        this.creationyr = creationyr;
        serialnum=TramSerialNumberCounter;
        TramSerialNumberCounter++;
      
    }

    /**
     * Copy constructor for Tram.
     *
     * @param obj Another Tram object to copy.
     */
    public Tram(Tram obj) {
        super(obj);
        this.creationyr = obj.creationyr;
    }

    /**
     * Set the creation year.
     *
     * @param creationyr creation year to set.
     */

    public void setCreationyr(int creationyr) {
		this.creationyr = creationyr;
	}

	/**
     * Get the year of creation of the tram.
     *
     * @return The year of creation.
     */
    public int getCreationyr() {
        return creationyr;
    }



    /**
     * Create a string representation of the Tram object.
     *
     * @return A string representation of the tram.
     */
    public String toString() {
        return " There is a tram with serial number " + this.serialnum + " which was made in the year " + creationyr;
    }

    /**
     * Check if this Tram object is equal to another object.
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
            Tram otherTram = (Tram) otherObject;
            return this.creationyr == otherTram.creationyr;
        }
    }
}
