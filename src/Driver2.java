//------------------------------------------
// Assignment 1
// Part 2
// Written by: Kigham Kerry Kinyuy, 40207088
//-------------------------------------------
import fifth.Aircraft;
import fifth.WorldWar2Plane;
import two.Train;
import two.Tram;
import three.Metro;
import fourth.Monowheel;
import sixth.Ferry;
import one.Vehicle;
import one.WheeledTransportation;

/**
 * Driver2 is the main class for copying objects and printing the content of the original array.
 * It creates various objects, copies them, and prints the contents.
 */
/**
 * This class provides a method to copy objects from a source array to a new array and print their contents.
 */
public class Driver2 {

    /**
     * Copy objects from the source array to a new array and print their contents.
     *
     * @param object The source array containing objects.
     */
    public static void copyTheObjects(Vehicle[] object) {
      
    	// Create a new array to copy the objects into
    	Vehicle[] copy = new Vehicle[object.length];
    	
    	// Copy each object from the source array to the new array
    	for(int i = 0; i < object.length; i++) {
    		copy[i] = (Vehicle)(object[i]);
    	}
    	
    	// Print the contents of the copied objects
    	for(int j = 0; j < object.length; j++) {
    		System.out.println(copy[j]);
    	}
    }

    /**
     * The main method to demonstrate the creation of various vehicles and copying them into an array.
     *
     * @param args The command-line arguments (not used in this program).
     */

    public static void main(String[] args) {
    	Vehicle[] wheeledtransport=new Vehicle[15];

        wheeledtransport[0]  = new WheeledTransportation(43,44.4);
        wheeledtransport[1] = new WheeledTransportation(35,49.5);
        wheeledtransport[2] = new Train(15, 14.2, 16, "Ottawa", "Montreal");

        wheeledtransport[3] = new Train(15, 11.2, 17, "Toronto", "Vancouver");
        wheeledtransport[4] = new Metro(12, 13.6,13, "qwe", "art", 13);

        wheeledtransport[5]= new Metro(14, 12.5, 16, "fwe", "fart", 16);
        wheeledtransport[6] = new Tram(12, 13.6, 13, "weq", "sart", 17, 2012);
        wheeledtransport[7] = new Tram(16, 18.6, 18, "well", "root", 15, 2014);

        wheeledtransport[8] = new Monowheel(12, 35, 90);
        wheeledtransport[9] = new Monowheel(14, 38, 80);
        wheeledtransport[10]= new Ferry(55.7, 66);
        wheeledtransport[11]= new Ferry(43.7, 55);
        wheeledtransport[12] = new Aircraft(25.6, 55.7);
        wheeledtransport[13] = new Aircraft(35.6, 25.6);
        wheeledtransport[14] = new WorldWar2Plane(110.4, 55.4, true);


        copyTheObjects(wheeledtransport);

        System.out.println();
        System.out.println("HERE ARE THE CONTENTS OF THE COPIED ARRAY:\n");

        for (Vehicle vehicle : wheeledtransport) {
            System.out.println(vehicle);
        }
    }
}

