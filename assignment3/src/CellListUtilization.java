import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Name(s) and ID(s): Kigham Kerry Kinyuy 40207088 and Armaan Waels 40196241
 * COMP249 Assignment #3
 * Due Date: 3 Dec 2023
 * **/
/**
 * A class that demonstrates the utilization of the CellList class.
 */
public class CellListUtilization {
    /**
     * The main method that showcases the functionality of the CellList class.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[]args){
        Scanner keyboard= new Scanner(System.in);
        CellList ask=new CellList();
        CellList dont=new CellList();

        Scanner se= null;

        try{
            se=new Scanner(new FileInputStream("Cell_info.txt"));
        }
        catch(FileNotFoundException fnfe){
            System.out.println("Your file was not found");
            System.exit(0);
        }

        String line=null;

        while(se.hasNextLine()){
            long sn=se.nextLong();
            String brand=se.next();
            double price=se.nextDouble();
            int year= se.nextInt();
            CellPhone phone= new CellPhone(sn,brand,price,year);
            if(ask.contains(sn)){
                continue;
            }else{
                ask.AddToStart(phone);
            }
        }
        ask.showcontents();

        System.out.println("Enter serial numbers for search (or exit to quit)");
        ArrayList<Long>numbers=new ArrayList<>();
       // boolean k=true;
        while (true) {
            System.out.println("Enter a value (or type 'exit' to stop):");

            String input = keyboard.next();

            if (input.equalsIgnoreCase("exit")) {
               break;  // Exit the loop if the user enters 'exit'
            }

            try {
                long n = Long.parseLong(input);
                numbers.add(n);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid long value.");
            }
        }
            int count=0;
        for(int i=0; i<numbers.size(); i++){
            ask.find(numbers.get(i));
            count++;
        }
        System.out.println("count= " + count);

        System.out.println(
        );
        System.out.println();
        ask.AddToEnd(new CellPhone(11111,"Kerry", 15.3, 2022));
        ask.deleteFromIndex(3);
        ask.insertAtIndex(new CellPhone(11111,"Kerry", 15.3, 2022),5);
        ask.AddToStart(new CellPhone(112221,"Bryan", 14.3, 2023));
        ask.deepCopy(dont);


    }




}
