//------------------------------------------
//Assignment 1
//Part 1
//Written by: Kigham Kerry Kinyuy, 40207088
//-------------------------------------------
package one;


import fifth.Aircraft;
import fifth.WorldWar2Plane;
import two.Train;
import two.Tram;
import three.Metro;
import fourth.Monowheel;
import sixth.Ferry;
/**
 * Driver is the main class for testing and demonstrating the classes related to wheeled transportation, trains, trams, metro, monowheels, ferries, aircraft, and World War 2 planes.
 * It creates various objects, prints their details, and finds the least and most expensive aircraft.
 *
 * @author Kigham Kerry Kinyuy
 */
public class Driver {

    /**
     * The main method that creates instances of various transportation objects, performs operations, and prints results.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
			
        WheeledTransportation wheeledtr1 = new WheeledTransportation(43, 44.3);
        WheeledTransportation wheeledtr2 = new WheeledTransportation(39, 45.3);
        Train train1 = new Train(15, 14.2, 16, "Ottawa", "Montreal");
        Train train3 = new Train(15, 14.2, 16, "Ottawa", "Montreal");
        Train train2 = new Train(15, 11.2, 17, "Toronto", "Vancouver");
        Metro metro1 = new Metro(12, 13.6, 13, "qwe", "art", 13);
        Metro metro3 = new Metro(18, 11.6, 23, "we", "at", 17);
        Metro metro2 = new Metro(14, 12.5, 16, "fwe", "fart", 16);
        Tram tram1 = new Tram(12, 13.6, 13, "weq", "sart", 17, 2012);
        Tram tram2 = new Tram(16, 18.6, 18, "well", "root", 15, 2014);
        Tram tram3 = new Tram(16, 18.6, 18, "well", "root", 15, 2014);
        Monowheel monowheel1 = new Monowheel(12, 35, 90);
        Monowheel monowheel2 = new Monowheel(14, 38, 80);
        Ferry ferry1 = new Ferry(55.7, 66);
        Ferry ferry2 = new Ferry(43.7, 55);
        Aircraft aircraft1 = new Aircraft(25.6, 55.7);
        Aircraft aircraft2 = new Aircraft(35.6, 25.6);
        WorldWar2Plane worldwarplane1 = new WorldWar2Plane(110.4, 55.4, true);
        WorldWar2Plane worldwarplane2 = new WorldWar2Plane(10.4, 55.4, false);

        System.out.println(wheeledtr1.toString());
        System.out.println(wheeledtr2.toString());
        System.out.println(train1.toString());
        System.out.println(train2.toString());
        System.out.println(metro1.toString());
        System.out.println(metro2.toString());
        System.out.println(tram1.toString());
        System.out.println(tram2.toString());
        System.out.println(monowheel1.toString());
        System.out.println(monowheel2.toString());
        System.out.println(ferry1.toString());
        System.out.println(ferry2.toString());
        System.out.println(aircraft1.toString());
        System.out.println(aircraft2.toString());
        System.out.println(worldwarplane1.toString());
        System.out.println(worldwarplane2.toString());
        System.out.println();
        
        boolean isequal1 = train1.equals(ferry2);
        boolean isequal2 = train1.equals(train2);
        boolean isequal3 = train1.equals(train3);
        
        System.out.println(isequal1);
        System.out.println(isequal2);
        System.out.println(isequal3);
        System.out.println();
        
        Object[] array1 = new Object[15];
        Object[] array2 = new Object[15];
        
        array1[0] = wheeledtr1;
        array1[1] = wheeledtr2;
        array1[2] = train1;
        array1[3] = train2;
        array1[4] = metro1;
        array1[5] = metro2;
        array1[6] = tram1;
        array1[7] = tram2;
        array1[8] = monowheel1;
        array1[9] = monowheel2;
        array1[10] = ferry1;
        array1[11] = ferry2;
        array1[12] = aircraft1;
        array1[13] = aircraft2;
        array1[14] = worldwarplane1;
        array2[0] = wheeledtr1;
        array2[1] = wheeledtr2;
        array2[2] = train1;
        array2[3] = train2;
        array2[4] = metro1;
        array2[5] = metro2;
        array2[6] = tram1;
        array2[7] = tram2;
        array2[8] = monowheel1;
        array2[9] = monowheel2;
        array2[10] = ferry1;
        array2[11] = ferry2;
        array2[12] = metro3;
        array2[13] = train3;
        array2[14] = tram3;

        findLeastAndMostExpensiveAircraft(array1);
        System.out.println();
        findLeastAndMostExpensiveAircraft(array2);
    }

    /**
     * Find the least and most expensive aircraft from an array of objects.
     *
     * @param aircraftArray The array of objects to search for aircraft.
     */
    public static void findLeastAndMostExpensiveAircraft(Object[] aircraftArray) {
        
        Aircraft leastexpensiveAircraft = null;
        Aircraft mostexpensiveAircraft = null;
        int count = 0;

        for (Object obj : aircraftArray) {
            if (obj instanceof Aircraft) {
                if (obj instanceof WorldWar2Plane) {
                    continue;
                } else {
                    count++;
                    Aircraft aircraft = (Aircraft) obj;
                    if (count == 1) {
                        if (leastexpensiveAircraft == null || aircraft.getPrice() <= leastexpensiveAircraft.getPrice()) {
                            leastexpensiveAircraft = aircraft;
                        }
                    }
                    if (count >= 2) {
                        if (leastexpensiveAircraft == null || aircraft.getPrice() <= leastexpensiveAircraft.getPrice()) {
                            leastexpensiveAircraft = aircraft;
                        }

                        if (mostexpensiveAircraft == null || aircraft.getPrice() >= mostexpensiveAircraft.getPrice()) {
                            mostexpensiveAircraft = aircraft;
                        }
                    }
                }
            }
        }

        if (leastexpensiveAircraft != null && mostexpensiveAircraft != null) {
            System.out.println("Least Expensive Aircraft: ");
            System.out.println(leastexpensiveAircraft.toString());

            System.out.println();

            System.out.println("Most Expensive Aircraft: ");
            System.out.println(mostexpensiveAircraft.toString());
	    } else {
	        System.out.println("No Aircraft objects found in the array.");
	        
	        System.out.println();
	        System.out.println("Thankyou for using my code, see ya! ");
	    }
	}
	}


