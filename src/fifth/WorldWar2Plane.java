//------------------------------------------
// Assignment 1
// Part 1
// Written by: Kigham Kerry Kinyuy, 40207088
//------------------------------------------
package fifth;

/**
 * WorldWar2Plane represents a class for describing World War II era planes, extending the Aircraft class.
 * It includes information about whether the plane has twin engines and a serial number.
 * This class provides constructors, getters, setters, and comparison methods.
 *
 * @author Kigham Kerry Kinyuy
 */
public class WorldWar2Plane extends Aircraft {
    // Fields
    private boolean twinengine;
    private static long worldwarplaneserialNumberCounter = 80000;

    /**
     * Default constructor for WorldWar2Plane.
     */
    public WorldWar2Plane() {
        super();
    }
  
    /**
     * Parameterized constructor for WorldWar2Plane.
     *
     * @param price        The price of the World War II plane.
     * @param maxelevation The maximum elevation the plane can reach.
     * @param twinengine   Whether the plane has twin engines.
     */
    public WorldWar2Plane(double price, double maxelevation, boolean twinengine) {
        super(price, maxelevation);
        this.twinengine = twinengine;
        this.maxelevation=maxelevation;
        this.twinengine=twinengine;
        serialnum= worldwarplaneserialNumberCounter;
        worldwarplaneserialNumberCounter++;
       
    }

    /**
     * Copy constructor for WorldWar2Plane.
     *
     * @param obj Another WorldWar2Plane object to copy.
     */
    public WorldWar2Plane(WorldWar2Plane obj) {
        super(obj);
        this.twinengine = obj.twinengine;
    }

 

    /**
     * Check if the plane has twin engines.
     *
     * @return True if the plane has twin engines, false otherwise.
     */
    public boolean isTwinengine() {
        return twinengine;
    }

    	
  

    /**
     * Set whether the plane has twin engines.
     *
     * @param twinengine True if the plane has twin engines, false otherwise.
     */
    public void setTwinengine(boolean twinengine) {
        this.twinengine = twinengine;
    }

   
 

    /**
     * Create a string representation of the WorldWar2Plane object.
     *
     * @return A string representation of the plane.
     */
    public String toString() {
        return " This World War II Plane with serial number " + serialnum + " and the claim of being a twin engine is " + twinengine;
    }

    /**
     * Check if this WorldWar2Plane object is equal to another object.
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
            WorldWar2Plane otherWorldWar2Plane = (WorldWar2Plane) otherObject;
            return this.twinengine == otherWorldWar2Plane.twinengine;
        }
    }
}
