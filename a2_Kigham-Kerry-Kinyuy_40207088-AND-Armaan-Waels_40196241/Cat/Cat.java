import java.io.*;
import java.util.Scanner;

public class Cat {

    public class Main {
        public static void main(String[] args) {
            //reading from the file
            Scanner sc=null;
            ball();

            }

    public static void ball(File file) {
        RandomAccessFile input = null;
        String line = null;
        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            return;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
           input.close();
                }
            }
        }
    }
}
