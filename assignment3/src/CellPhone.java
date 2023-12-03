import java.util.Objects;

// -----------------------------------------------------
// Assignment 3
// Written by: Kigham Kerry Kinyuy 40207088 and Armaan Waels 40196241
// -----------------------------------------------------

/**
 * Name(s) and ID(s): Kigham Kerry Kinyuy 40207088 and Armaan Waels 40196241
 * COMP249 Assignment #3
 * Due Date: 3 Dec 2023
 * **/
/**
 * The {@code CellPhone} class represents a mobile phone with various attributes
 * such as serial number, brand, year of release, and price.
 *
 * <p>This class provides methods to retrieve and modify each attribute, as well
 * as a custom {@code acopy} method to copy the values from another CellPhone
 * object and update the serial number.
 *
 * <p>The {@code equals} method is overridden to compare the equality of two
 * CellPhone objects based on brand, year, and price.
 *
 * <p>The {@code clone} method is overridden to support object cloning.
 */
public class CellPhone implements Cloneable {

    /**
     * The serial number of the cell phone.
     */
    public long serialNum;

    /**
     * The brand of the cell phone.
     */
    public String brand;

    /**
     * The year of release of the cell phone.
     */
    public int year;

    /**
     * The price of the cell phone.
     */
    public double price;

    /**
     * Constructs a new CellPhone with the specified serial number, brand, year, and price.
     *
     * @param serialNum the serial number of the cell phone
     * @param brand the brand of the cell phone
     * @param price the price of the cell phone
     * @param year the year of release of the cell phone
     */
    public CellPhone(long serialNum, String brand, double price, int year) {
        this.serialNum = serialNum;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    /**
     * Gets the serial number of the cell phone.
     *
     * @return the serial number of the cell phone
     */
    public long getSerialNum() {
        return serialNum;
    }

    /**
     * Sets the serial number of the cell phone.
     *
     * @param serialNum the new serial number to set
     */
    public void setSerialNum(long serialNum) {
        this.serialNum = serialNum;
    }

    /**
     * Gets the brand of the cell phone.
     *
     * @return the brand of the cell phone
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets the brand of the cell phone.
     *
     * @param brand the new brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Gets the year of release of the cell phone.
     *
     * @return the year of release of the cell phone
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year of release of the cell phone.
     *
     * @param year the new year of release to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Gets the price of the cell phone.
     *
     * @return the price of the cell phone
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the cell phone.
     *
     * @param price the new price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Copies the values from another CellPhone object and updates the serial number.
     *
     * @param a the CellPhone object to copy values from
     * @param b the new serial number to set
     */
    public void acopy(CellPhone a, long b) {
        this.year = a.year;
        this.brand = a.brand;
        this.price = a.price;
        this.serialNum = b;
    }

    /**
     * Overrides the {@code clone} method to support object cloning.
     *
     * @return a clone of this CellPhone object
     * @throws CloneNotSupportedException if cloning is not supported
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * Overrides the {@code toString} method to provide a string representation of the CellPhone object.
     *
     * @return a string representation of the CellPhone object
     */
    @Override
    public String toString() {
        return "[" + serialNum + ": " + " " + brand + " " + price + " " + year + "]";
    }

    /**
     * Overrides the {@code equals} method to compare the equality of two CellPhone objects
     * based on brand, year, and price.
     *
     * @param obj the object to compare with
     * @return {@code true} if the objects are equal, {@code false} otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        } else {
            CellPhone cellphone = (CellPhone) obj;
            return (brand.equals(cellphone.brand)) && (year == cellphone.year) && (price == cellphone.price);
        }
    }
}

