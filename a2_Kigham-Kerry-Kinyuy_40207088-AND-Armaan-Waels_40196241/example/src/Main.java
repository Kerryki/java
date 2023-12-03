import java.io.*;
import java.util.Scanner;
import java.io.FileInputStream;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //reading from the file
        Scanner sc=null;
        try{
            sc= new Scanner(new FileInputStream("file.txt"));
        }
        catch(FileNotFoundException fnfx){
            System.out.println("Cannot find file");
            System.exit(0);

        }

        PrintWriter write1=null;
        PrintWriter write2=null;

        try{
            write1= new PrintWriter(new FileOutputStream("file1.text"));
            write2= new PrintWriter(new FileOutputStream("file2.text"));
        }

        catch (FileNotFoundException fnf ){
            System.out.println("Cannot open an output file");
            System.exit(0);
        }
        String ass;

        //printing an object from a binary file
        while(sc.hasNextLine()){

       ass=sc.nextLine();
            String[]arr=ass.split(" ");
           String ID =arr[0];
           String name=arr[1];
           double gpa= Double.parseDouble(arr[2]);
            if(gpa<3.0){
                write1.println(ID + " " +  name + " " + gpa);
            }
            if(gpa>3.0){
                write2.println(ID + " " +  name + " " + gpa);
            }
        }
            sc.close();
            write1.close();
            write2.close();
    }
    }
