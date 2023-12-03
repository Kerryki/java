import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;
public class main {
    public static void main (String[] args){
        Scanner sc= null;

        try{
            sc=new Scanner(new FileInputStream("file1.text"));
        }
        catch (FileNotFoundException fne){
            System.out.println("Your file was not found");
        }

        ObjectOutputStream object=null;
        try {
            object = new ObjectOutputStream(new FileOutputStream("binary1"));
        }
        catch (FileNotFoundException fnfe){
            System.out.println("File was not found");
        }
        catch (IOException ioe){
            System.out.println("IO exception");
        }
        String line;
        while(sc.hasNextLine()){
            line=sc.nextLine();
            String[]arr=line.split(" ");
            String id=arr[0];
            String name=arr[1];
            double GPA= Double.parseDouble(arr[2]);
            Student student = new Student(id,name,GPA);
            try {
                object.writeObject(student);
            }
            catch (IOException ioee){
                System.out.println("IO exception");
            }
        }
        sc.close();
        try {
            object.close();
        }
        catch (IOException f){
            System.out.println("IO exception");
        }

    }
}
