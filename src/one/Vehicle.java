package one;

/**
 * The `Vehicle` class represents a base class for all vehicles.
 */
public class Vehicle {
    
    protected long serialnum;
    
    /**
     * Constructs a new Vehicle instance.
     */
    public Vehicle() {
        
    }
    
    /**
     * Get the serial number of the vehicle.
     *
     * @return The serial number of the vehicle.
     */
    public long getSerialnum() {
        return serialnum;
    }

    /**
     * Set the serial number of the vehicle.
     *
     * @param serialnum The serial number to set for the vehicle.
     */
    public void setSerialnum(long serialnum) {
        this.serialnum = serialnum;
    }
}




