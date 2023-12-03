//-------------------------------------------
// Assignment 2
//
// Written by: Kigham Kerry Kinyuy, 40207088 and Armaan Waels 40196241
//-------------------------------------------



import Exceptions.*;

import java.io.*;
import java.util.Scanner;


/**
 * The {@code Main} class contains the main method to execute the three parts of the program.
 * <p>
 * It invokes the methods {@code do_part1()}, {@code do_part2()}, and {@code do_part3()} to perform the necessary actions.
 * </p>
 *
 * @author [Your Name]
 * @version [Version Number]
 * @since [Date or Version Number]
 */
public class Main {

    /**
     * Name(s) and ID(s): Kigham Kerry Kinyuy 40207088 and Armaan Waels 40196241
     * COMP249 Assignment #2
     * Due Date: 11 Nov 2023
     * **/

    /**
     * Default constructor for the {@code Main} class.
     * <p>
     * This constructor does not perform any specific initialization.
     * </p>
     */
    public Main() {
        // Default constructor
    }
    /**
     * The main method of the program, responsible for executing the three parts of the program.
     *
     * @param args the command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        do_part1();
        do_part2();
        do_part3();
    }

    /**
     *
     * Parses input files for different genres, validates and serializes the records,
     * and handles semantic errors, such as invalid ISBN, price, and year.
     * <p>
     * The method performs the following steps:
     * <ol>
     *   <li>Opens input files and corresponding output streams for serialization.</li>
     *   <li>Reads each line from the input files, parses the fields, and creates Book objects.</li>
     *   <li>Validates ISBN, price, and year, throwing specific exceptions for semantic errors.</li>
     *   <li>Serializes valid Book objects to corresponding output streams.</li>
     *   <li>Catches and logs semantic errors, writing details to a semantic error file.</li>
     *   <li>Closes input scanners, output streams, and semantic error file writer.</li>
     * </ol>
     *
     * <p>
     * Note: This method assumes that the input files have a specific CSV format,
     * and Book objects are serialized to corresponding output files.
     * </p>
     *
     * throws valid exceptions:          If an I/O exception occurs while working with files.
     * Or    If a record has an invalid ISBN-13.
     * Or    If a record has an invalid ISBN-10.
     * Or    If a record has an invalid price.
     * Or    If a record has an invalid publication year.
     */
    public static void do_part1() {
        Scanner sc = null;
        Scanner se = null;
        PrintWriter cc = null;
        PrintWriter hc = null;
        PrintWriter mtv = null;
        PrintWriter mrb = null;
        PrintWriter ne = null;
        PrintWriter ot = null;
        PrintWriter ss = null;
        PrintWriter tp = null;
        PrintWriter sef = null;

        try {
            // Create PrintWriter instances for each genre and syntax error file
            cc = new PrintWriter(new FileOutputStream("Cartoons_Comics.csv.txt"));
            hc = new PrintWriter(new FileOutputStream("Hobbies_Collectibles.csv.txt"));
            mtv = new PrintWriter(new FileOutputStream("Movies_TV_Books.csv.txt"));
            mrb = new PrintWriter(new FileOutputStream("Music_Radio_Books.csv.txt"));
            ne = new PrintWriter(new FileOutputStream("Nostalgia_Eclectic_Books.csv"));
            ot = new PrintWriter(new FileOutputStream("Old_Time_Radio_Books.csv.txt"));
            ss = new PrintWriter(new FileOutputStream("Sports_Sports_Memorabilia.csv.txt"));
            tp = new PrintWriter(new FileOutputStream("Trains_Planes_Automobiles.csv"));
            sef = new PrintWriter(new FileOutputStream("syntax_error_file.txt"));
        } catch (FileNotFoundException fn) {
            System.out.println("File was not found");
        }

        try {
            // Read the number of files and their names from "part1_input_file_names.txt"
            sc = new Scanner(new FileInputStream("part1_input_file_names.txt"));
        } catch (FileNotFoundException fnf) {
            System.out.println("Input file was not found");
            System.exit(0);
        }

        int numFiles = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        String[] arr = new String[numFiles];

        // Process each input file
        for (int i = 0; i < numFiles; i++) {
            arr[i] = sc.nextLine(); // Read the file path

            // Checks if the file exists before attempting to open it
            File file = new File(arr[i]);

            if (file.exists() && file.isFile()) {
                // File exists, so you can open and process it
                try {
                    se = new Scanner(file);
                } catch (FileNotFoundException f) {
                    System.out.println("Input file was not found");
                    System.exit(0);
                }

                // Process each line in the input file
                while (se.hasNextLine()) {
                    String line = se.nextLine();
                    String[] lin = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)|(?<=^,)");

                    // Validate the number of fields in each record
                    if (lin.length < 6) {
                        // Handle records with fewer fields than expected
                        // Write error information to the syntax error file
                        try {
                            throw new TooFewFieldsException();
                        } catch (TooFewFieldsException tffe) {
                            sef.println("Syntax error in file " + arr[i]);
                            sef.println("======================");
                            sef.println("Error: Fewer fields than expected");

                        }
                        try {
                            sef.println("Record: " + line);
                            sef.println();
                        } catch (NullPointerException npe) {
                            System.out.println("Null pointer exception");
                        }
                    } else if (lin.length == 6) {
                        // Extract fields from the record
                        // Validate and create a Book object
                        // Determine the genre and write the book to the corresponding output file
                        String title = lin[0];

                        String author = lin[1].replaceAll("^\"|\"$", "");

                        double price = Double.parseDouble(lin[2]);

                        String ISBN = lin[3];


                        String genre = lin[4];

                        int year = Integer.parseInt(lin[5]);

                        if (title == null) {
                            try {
                                throw new MissingFieldException();
                            } catch (MissingFieldException uge) {
                                sef.println("Syntax error in file " + arr[i]);
                                sef.println("======================");
                                sef.println("Error: missing title");
                                sef.println("Record: " + line);
                                sef.println();
                                continue;

                            }

                        }

                        if (author.isEmpty() || author.contentEquals("") ) {
                            try {
                                throw new MissingFieldException();
                            } catch (MissingFieldException uge) {
                                sef.println("Syntax error in file " + arr[i]);
                                sef.println("======================");
                                sef.println("Error: missing author");
                                sef.println("Record: " + line);
                                sef.println();
                                continue;
                            }

                        }
                        if (ISBN.isEmpty() || ISBN.contentEquals("") ) {
                            try {
                                throw new MissingFieldException();
                            } catch (MissingFieldException uge) {
                                sef.println("Syntax error in file " + arr[i]);
                                sef.println("======================");
                                sef.println("Error: missing author");
                                sef.println("Record: " + line);
                                sef.println();
                                continue;
                            }

                        }

                        if (price==0) {
                            try {
                                throw new MissingFieldException();
                            } catch (MissingFieldException uge) {
                                sef.println("Syntax error in file " + arr[i]);
                                sef.println("======================");
                                sef.println("Error: missing price");
                                sef.println("Record: " + line);
                                sef.println();
                                continue;
                            }

                        }

                        if (genre.isEmpty() || genre.contentEquals("")) {
                            try {
                                throw new MissingFieldException();
                            } catch (MissingFieldException uge) {
                                sef.println("Syntax error in file " + arr[i]);
                                sef.println("======================");
                                sef.println("Error: missing genre");
                                sef.println("Record: " + line);
                                sef.println();
                                continue;
                            }

                        }

                        if (year == 0) {
                            try {
                                throw new MissingFieldException();
                            } catch (MissingFieldException uge) {
                                sef.println("Syntax error in file " + arr[i]);
                                sef.println("======================");
                                sef.println("Error: missing year");
                                sef.println("Record: " + line);
                                sef.println();
                                continue;
                            }

                        }

                        Book book = new Book(title, author, price, ISBN, genre, year);

                        // Now, determine where to write this book record based on the genre
                        if ("CCB".equals(genre)) {
                            cc.println(book);
                        } else if ("HCB".equals(genre)) {
                            hc.println(book);
                        } else if ("MTV".equals(genre)) {
                            mtv.println(book);
                        } else if ("MRB".equals(genre)) {
                            mrb.println(book);
                        } else if ("NEB".equals(genre)) {
                            ne.println(book);
                        } else if ("OTR".equals(genre)) {
                            ot.println(book);
                        } else if ("SSM".equals(genre)) {
                            ss.println(book);
                        } else if ("TPA".equals(genre)) {
                            tp.println(book);
                        } else {
                            try {
                                throw new UnknownGenreException();
                            } catch (UnknownGenreException uge) {
                                sef.println("Syntax error in file " + arr[i]);
                                sef.println("======================");
                                sef.println("Error: Unknown genre");
                                sef.println("Record: " + line);
                                sef.println();
                            }
                        }
                    } else if (lin.length > 6) {
                        // Handle records with more fields than expected
                        // Write error information to the syntax error file
                        try {
                            throw new TooManyFieldsException();
                        } catch (TooManyFieldsException tmf) {
                            sef.println("Syntax error in file " + arr[i]);
                            sef.println("======================");
                            sef.println("Error: Fewer fields than expected ");
                            sef.println("Record: " + line);
                            sef.println();
                        }
                    }
                }
            }
        }
        // Close resources
        sc.close();
        se.close();
        cc.close();
        hc.close();
        mtv.close();
        mrb.close();
        ne.close();
        ot.close();
        ss.close();
        tp.close();
        sef.close();
    }

    /**
     *
     * do_part2() Reads book records from text files generated in part 1, performs semantic validation on each record,
     * and writes valid records to corresponding serialized files. It also generates a semantic error file
     * ("semantic_error_file.txt") for records that fail semantic validation.
     *
     * throws IOException               If an I/O exception occurs while reading or writing files.
     * throws BadIsbn13Exception        If the ISBN-13 of a book record is invalid.
     * throws BadIsbn10Exception        If the ISBN-10 of a book record is invalid.
     * throws BadPriceException         If the price of a book record is negative.
     * throws BadyearException          If the publication year of a book record is outside the range 1995-2010.
     * throws NumberFormatException     If there is an error parsing a numerical value from a record.
     * throws ClassNotFoundException    If the Book class is not found during object serialization.
     * throws IOException               If an I/O exception occurs while writing serialized objects.
     * throws SecurityException         If a security violation occurs.
     */


    public static void do_part2() {
        Scanner cc = null;
        Scanner hc = null;
        Scanner mtv = null;
        Scanner mrb = null;
        Scanner ne = null;
        Scanner ot = null;
        Scanner ss = null;
        Scanner tp = null;
        ObjectOutputStream ccs = null;
        ObjectOutputStream hcs = null;
        ObjectOutputStream mtvs = null;
        ObjectOutputStream mrbs = null;
        ObjectOutputStream nes = null;
        ObjectOutputStream ots = null;
        ObjectOutputStream sss = null;
        ObjectOutputStream tps = null;
        PrintWriter sefs = null;

        try {
            // Create Scanners for reading CSV text files and ObjectOutputStreams for writing serialized files
            cc = new Scanner(new FileInputStream("Cartoons_Comics.csv.txt"));
            hc = new Scanner(new FileInputStream("Hobbies_Collectibles.csv.txt"));
            mtv = new Scanner(new FileInputStream("Movies_TV_Books.csv.txt"));
            mrb = new Scanner(new FileInputStream("Music_Radio_Books.csv.txt"));
            ne = new Scanner(new FileInputStream("Nostalgia_Eclectic_Books.csv"));
            ot = new Scanner(new FileInputStream("Old_Time_Radio_Books.csv.txt"));
            ss = new Scanner(new FileInputStream("Sports_Sports_Memorabilia.csv.txt"));
            tp = new Scanner(new FileInputStream("Trains_Planes_Automobiles.csv"));

            ccs = new ObjectOutputStream(new FileOutputStream("Cartoons_Comics.csv.ser"));
            hcs = new ObjectOutputStream(new FileOutputStream("Hobbies_Collectibles.csv.ser"));
            mtvs = new ObjectOutputStream(new FileOutputStream("Movies_TV_Books.csv.ser"));
            mrbs = new ObjectOutputStream(new FileOutputStream("Music_Radio_Books.csv.ser"));
            nes = new ObjectOutputStream(new FileOutputStream("Nostalgia_Eclectic_Books.csv.ser"));
            ots = new ObjectOutputStream(new FileOutputStream("Old_Time_Radio_Books.csv.ser"));
            sss = new ObjectOutputStream(new FileOutputStream("Sports_Sports_Memorabilia.csv.ser"));
            tps = new ObjectOutputStream(new FileOutputStream("Trains_Planes_Automobiles.csv.ser"));
            sefs = new PrintWriter(new FileOutputStream("semantic_error_file.txt"));
        } catch (IOException fn) {
            System.out.println("IO Exception was thrown");
        }

        // Arrays to store Scanners and ObjectOutputStreams for iteration
        Scanner[] arr = {cc, hc, mtv, mrb, ne, ot, ss, tp};
        ObjectOutputStream[] ar = {ccs, hcs, mtvs, mrbs, nes, ots, sss, tps};

        for (int i = 0; i < arr.length; i++) {
            while (arr[i].hasNextLine()) {
                // Read and process each line in the CSV text file
                String line = arr[i].nextLine();
                String[] lin = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                String title = lin[0];
                String author = lin[1].replaceAll("^\"|\"$", "");
                double price = 0;

                try {
                    // Try to parse the price, handle NumberFormatException if it occurs
                    price = Double.parseDouble(lin[2]);
                } catch (NumberFormatException nff) {
                    System.out.println("number format exception on " + arr[i]);
                }

                String ISBN = lin[3];
                String genre = lin[4];
                int year = 0;

                try {
                    // Try to parse the year, handle NumberFormatException if it occurs
                    year = Integer.parseInt(lin[5]);
                } catch (NumberFormatException nff) {
                    System.out.println("number format exception on " + arr[i]);
                }

                Book book = new Book(title, author, price, ISBN, genre, year);

                // Validate ISBN-13
                if (ISBN.length() == 13) {
                    if (((ISBN.charAt(0)) + (3 * ISBN.charAt(1)) + (ISBN.charAt(2)) + (3 * ISBN.charAt(3)) +
                            (ISBN.charAt(4)) + (3 * ISBN.charAt(5)) + (ISBN.charAt(6)) + (3 * ISBN.charAt(7)) +
                            (ISBN.charAt(8)) + (3 * ISBN.charAt(9)) + (ISBN.charAt(10)) + (3 * ISBN.charAt(11)) +
                            (ISBN.charAt(12))) % 10 != 0) {
                        // Record semantic error for bad ISBN-13
                        sefs.println("Semantic error in file " + arr[i]);
                        sefs.println("======================");
                        sefs.println("Error: Bad Isbn 13");
                        sefs.println("Record: " + line);
                        sefs.println();
                    } else {
                        // Write the book to the serialized file
                        try {
                            ar[i].writeObject(book);
                        } catch (IOException ioo) {
                            System.out.println("Io exception");
                        }
                    }

                }
                // Validate ISBN-10
                if (ISBN.length() == 10) {
                    if (((10 * ISBN.charAt(0)) + (9 * ISBN.charAt(1)) + (8 * ISBN.charAt(2)) + (7 * ISBN.charAt(3)) + (6 * ISBN.charAt(4)) + (5 * ISBN.charAt(5)) + (4 * ISBN.charAt(6)) + (3 * ISBN.charAt(7)) + (2 * ISBN.charAt(8)) + (ISBN.charAt(9))) % 10 != 0) {
                        try {
                            throw new BadIsbn10Exception();
                        } catch (BadIsbn10Exception bi3) {
                            // Record semantic error for bad ISBN-10
                            sefs.println("Semantic error in file " + arr[i]);
                            sefs.println("======================");
                            sefs.println("Error: Bad Isbn 10");
                            sefs.println("Record: " + line);
                            sefs.println();
                        }
                    } else {
                        // Write the book to the serialized file
                        try {
                            ar[i].writeObject(book);
                        } catch (IOException ioo) {
                            System.out.println("Io exception");
                        }
                    }
                }
                    // Validate price
                if (price < 0) {
                    // Record semantic error for bad price
                    try {
                        throw new BadPriceException();
                    } catch (BadPriceException bi3) {
                        sefs.println("Semantic error in file " + arr[i]);
                        sefs.println("======================");
                        sefs.println("Error: Bad Price");
                        sefs.println("Record: " + line);
                        sefs.println();
                    }
                } else {
                    try {
                        ar[i].writeObject(book);
                    } catch (IOException ioo) {
                        System.out.println("Io exception");
                    }
                }

                if (year < 1995 || year > 2010) {
                    try {
                        throw new BadyearException();
                    } catch (BadyearException bi3) {
                        sefs.println("Semantic error in file " + arr[i]);
                        sefs.println("======================");
                        sefs.println("Error: Bad Year");
                        sefs.println("Record: " + line);
                        sefs.println();
                    }
                } else {
                    try {
                        ar[i].writeObject(book);
                    } catch (IOException ioo) {
                        System.out.println("Io exception");
                    }
                }
            }
        }
        // Close all input and output streams
        cc.close();
        hc.close();
        mtv.close();
        mrb.close();
        ne.close();
        ot.close();
        ss.close();
        tp.close();
        sefs.close();

        try {
            // Close ObjectOutputStreams
            ccs.close();
            hcs.close();
            mtvs.close();
            mrbs.close();
            nes.close();
            ots.close();
            sss.close();
            tps.close();
        } catch (IOException ion) {
            System.out.println("IO exception");
        }
    }

    /**
     *
     * Reads serialized book records from files generated in part 2, allows the user to view selected records,
     * and provides a file selection menu. It also displays information about the number of records in each file.
     * The user can exit the program by choosing 'x' from the menu.
     *
     * throws IOException               If an I/O exception occurs while reading files.
     * throws ClassNotFoundException    If the Book class is not found during object deserialization.
     * throws EOFException              If the end of the file is reached during deserialization.
     * throws NumberFormatException     If there is an error parsing a numerical value from a record.
     */

    public static void do_part3() {


        ObjectInputStream ccs = null;
        ObjectInputStream hcs = null;
        ObjectInputStream mtvs = null;
        ObjectInputStream mrbs = null;
        ObjectInputStream nes = null;
        ObjectInputStream ots = null;
        ObjectInputStream sss = null;
        ObjectInputStream tps = null;
        Scanner keyboard = new Scanner(System.in);

       try {
            ccs = new ObjectInputStream(new FileInputStream("Cartoons_Comics.csv.ser"));
            hcs = new ObjectInputStream(new FileInputStream("Hobbies_Collectibles.csv.ser"));
            mtvs = new ObjectInputStream(new FileInputStream("Movies_TV_Books.csv.ser"));
            mrbs = new ObjectInputStream(new FileInputStream("Music_Radio_Books.csv.ser"));
            nes = new ObjectInputStream(new FileInputStream("Nostalgia_Eclectic_Books.csv.ser"));
            ots = new ObjectInputStream(new FileInputStream("Old_Time_Radio_Books.csv.ser"));
            sss = new ObjectInputStream(new FileInputStream("Sports_Sports_Memorabilia.csv.ser"));
            tps = new ObjectInputStream(new FileInputStream("Trains_Planes_Automobiles.csv.ser"));
        } catch (IOException fnf) {
            System.out.println("There was an IO exception bro");
        }

        String selected = "Cartoons_Comics.csv.ser";
        ObjectInputStream awe = ccs;
        boolean value=true;
        char choice = ' ';
        while (value) {
            System.out.println("-------------------------");
            System.out.println("         Main Menu       ");
            System.out.println("-------------------------");
            System.out.println("v View the selected file: " + selected);
            System.out.println("s Select a file to view");
            System.out.println("x Exit");
            System.out.println("-------------------------");
            System.out.println();
            System.out.println();
            System.out.println("Enter your choice: ");
            choice = keyboard.next().charAt(0);
            keyboard.nextLine();


            long[] l = new long[8]; // Create an array to store file lengths

           // Calculate and store file lengths
            l[0] = countLinesInFile("Cartoons_Comics.csv.ser")-1;
            l[1] =countLinesInFile("Hobbies_Collectibles.csv.ser")-1;
            l[2] = countLinesInFile("Movies_TV_Books.csv.ser")-1;
            l[3] = countLinesInFile("Music_Radio_Books.csv.ser")-1;
            l[4] = countLinesInFile("Nostalgia_Eclectic_Books.csv.ser")-1;
            l[5] = countLinesInFile("Old_Time_Radio_Books.csv.ser")-1;
            l[6] = countLinesInFile("Sports_Sports_Memorabilia.csv.ser")-1;
            l[7] = countLinesInFile("Trains_Planes_Automobiles.csv.ser")-1;

            if (choice == 's') {
                int num = 0;
                System.out.println("-------------------------");
                System.out.println("      File Sub-Menu      ");
                System.out.println("-------------------------");
                System.out.println("1 Cartoons_Comics.csv.ser           (" + l[0] + ") records");
                System.out.println("2 Hobbies_Collectibles.csv.ser      (" + l[1] + ") records");
                System.out.println("3 Movies_TV_Books.csv.ser           (" + l[2] + ") records");
                System.out.println("4 Music_Radio_Books.csv.ser         (" + l[3] + ") records");
                System.out.println("5 Nostalgia_Eclectic_Books.csv.ser  (" + l[4] + ") records");
                System.out.println("6 Old_Time_Radio_Books.csv.ser      (" + l[5] + ") records");
                System.out.println("7 Sports_Sports_Memorabilia.csv.ser (" + l[6] + ") records");
                System.out.println("8 Trains_Planes_Automobiles.csv.ser (" + l[7] + ") records");
                System.out.println("9 Exit");
                System.out.println();
                System.out.println();
                System.out.println("Enter your number choice: ");
                num = keyboard.nextInt();

                String[] ar = {"Cartoons_Comics.csv.ser",
                        "Hobbies_Collectibles.csv.ser",
                        "Movies_TV_Books.csv.ser",
                        "Music_Radio_Books.csv.ser",
                        "Nostalgia_Eclectic_Books.csv.ser",
                        "Old_Time_Radio_Books.csv.ser",
                        "Sports_Sports_Memorabilia.csv.ser",
                        "Trains_Planes_Automobiles.csv.ser"
                };

                if(num==1){
                    boolean dataleft = true;
                    selected = ar[(num - 1)];
                    awe = ccs;
                    int count=0;
                    while (dataleft) {
                        try {
                            Book book = (Book) ccs.readObject();
                            count++;
                            System.out.print(book);
                            System.out.println(" " + count);


                        } catch (EOFException eof) {
                            // End of file reached
                            dataleft = false;
                        } catch (IOException ioe) {
                            System.out.println("IO exception");
                        } catch (ClassNotFoundException cnf) {
                            System.out.println("Class was not found");
                        }

                    }
                    try {
                        ccs.close();
                        ccs = new ObjectInputStream(new FileInputStream("Cartoons_Comics.csv.ser"));
                    } catch (IOException e) {
                        System.out.println("There was an IO exception bro");
                    }
                    awe = ccs;
                    continue;
                } else if (num==2) {
                    boolean datalef = true;
                    selected = ar[(num - 1)];

                    awe = hcs;

                    while (datalef) {
                        try {
                            Book books = (Book) hcs.readObject();
                            System.out.println(books);
                            awe=hcs;
                            // Process the deserialized books array as needed
                        } catch (EOFException eof) {
                            // End of file reached
                            datalef = false;
                        } catch (IOException ioe) {
                            System.out.println("IO exception");
                        } catch (ClassNotFoundException cnf) {
                            System.out.println("Class was not found");
                        }
                    }
                    try {
                        hcs.close();
                        hcs = new ObjectInputStream(new FileInputStream("Hobbies_Collectibles.csv.ser"));
                    } catch (IOException e) {
                        System.out.println("There was an IO exception bro");
                    }
                    awe=hcs;
                    continue;
                } else if (num==3) {
                    boolean datale = true;
                    selected = ar[(num - 1)];
                    awe = mtvs;
                    while (datale) {
                        try {
                            Book books = (Book) mtvs.readObject();
                            System.out.println(books);
                            // Process the deserialized books array as needed
                        } catch (EOFException eof) {
                            // End of file reached
                            datale = false;
                        } catch (IOException ioe) {
                            System.out.println("IO exception");
                        } catch (ClassNotFoundException cnf) {
                            System.out.println("Class was not found");
                        }
                    }
                    try {
                        mtvs.close();
                        mtvs = new ObjectInputStream(new FileInputStream("Movies_TV_Books.csv.ser"));
                    } catch (IOException e) {
                        System.out.println("There was an IO exception bro");
                    }
                    awe=mtvs;
                    continue;
                } else if (num==4){
                    boolean datalet = true;
                    selected = ar[(num - 1)];
                    awe = mrbs;
                    while (datalet) {
                        try {
                            Book books = (Book) mrbs.readObject();
                            System.out.println(books);
                            // Process the deserialized books array as needed
                        } catch (EOFException eof) {
                            // End of file reached
                            datalet = false;
                        } catch (IOException ioe) {
                            System.out.println("IO exception");
                        } catch (ClassNotFoundException cnf) {
                            System.out.println("Class was not found");
                        }
                    }
                    try {
                        mrbs.close();
                        mrbs = new ObjectInputStream(new FileInputStream("Music_Radio_Books.csv.ser"));
                    } catch (IOException e) {
                        System.out.println("There was an IO exception bro");
                    }
                    awe = mrbs;
                    continue;

                } else if (num==5){

                    boolean datalft = true;
                    selected = ar[(num - 1)];
                    awe = nes;
                    while (datalft) {
                        try {
                            Book books = (Book) nes.readObject();
                            System.out.println(books);
                            // Process the deserialized books array as needed
                        } catch (EOFException eof) {
                            // End of file reached
                            datalft = false;
                        } catch (IOException ioe) {
                            System.out.println("IO exception");
                        } catch (ClassNotFoundException cnf) {
                            System.out.println("Class was not found");
                        }
                    }
                    try {
                        nes.close();
                        nes = new ObjectInputStream(new FileInputStream("Nostalgia_Eclectic_Books.csv.ser"));
                    } catch (IOException e) {
                        System.out.println("There was an IO exception bro");
                    }
                    awe = nes;
                    continue;
                } else if (num==6){

                    boolean ataleft = true;
                    selected = ar[(num - 1)];
                    awe = ots;
                    while (ataleft) {

                        try {
                            Book books = (Book) ots.readObject();
                            System.out.println(books);
                            // Process the deserialized books array as needed
                        } catch (EOFException eof) {
                            // End of file reached
                            ataleft = false;
                        } catch (IOException ioe) {
                            System.out.println("IO exception");
                        } catch (ClassNotFoundException cnf) {
                            System.out.println("Class was not found");
                        }
                    }
                    try {
                        ots.close();
                        ots = new ObjectInputStream(new FileInputStream("Old_Time_Radio_Books.csv.ser"));
                    } catch (IOException e) {
                        System.out.println("There was an IO exception bro");
                    }
                    awe = ots;
                    continue;
                } else if (num==7){
                    boolean dtaleft = true;
                    selected = ar[(num - 1)];
                    awe = sss;
                    while (dtaleft) {
                        try {
                            Book books = (Book) sss.readObject();
                            System.out.println(books);
                            // Process the deserialized books array as needed
                        } catch (EOFException eof) {
                            // End of file reached
                            dtaleft = false;
                        } catch (IOException ioe) {
                            System.out.println("IO exception");
                        } catch (ClassNotFoundException cnf) {
                            System.out.println("Class was not found");
                        }
                    }
                    try {
                        sss.close();
                        sss = new ObjectInputStream(new FileInputStream("Sports_Sports_Memorabilia.csv.ser"));
                    } catch (IOException e) {
                        System.out.println("There was an IO exception bro");
                    }
                    awe = sss;
                    continue;
                } else if (num==8){

                    boolean datleft = true;
                    selected = ar[(num - 1)];
                    awe = tps;
                    while (datleft) {
                        try {
                            Book books = (Book) tps.readObject();

                            System.out.println(books);
                            // Process the deserialized books array as needed
                        } catch (EOFException eof) {
                            // End of file reached
                            datleft = false;
                        } catch (IOException ioe) {
                            System.out.println("IO exception");
                        } catch (ClassNotFoundException cnf) {
                            System.out.println("Class was not found");
                        }
                    }
                    try {
                        tps.close();
                        tps = new ObjectInputStream(new FileInputStream("Trains_Planes_Automobiles.csv.ser"));
                    } catch (IOException e) {
                        System.out.println("There was an IO exception bro");
                    }
                    awe = tps;
                    continue;
                }


            } else if (choice == 'x') {
                try {
                    ccs.close();
                    hcs.close();
                    mtvs.close();
                    mrbs.close();
                    nes.close();
                    ots.close();
                    sss.close();
                    tps.close();
                } catch (IOException ion) {
                    System.out.println("IO exception");
                }
                System.exit(0);
            } else if (choice == 'v') {
                boolean datleft = true;
                System.out.println("viewing: " + selected);

                while (datleft) {
                    try {
                        Book books = (Book) awe.readObject();
                        System.out.println(books);
                        // Process the deserialized books array as needed
                    } catch (EOFException eof) {
                        // End of file reached
                        datleft = false;
                    } catch (IOException ioe) {
                        System.out.println("IO exception");
                    } catch (ClassNotFoundException cnf) {
                        System.out.println("Class was not found");
                    }
                }
            }
        }

    }

    /**
     * Utility method to count the number of lines in a file.
     *
     * @param fileName The name of the file.
     * @return The number of lines in the file, or -1 if an error occurs.
     */
    public static int countLinesInFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int lineCount = 0;
            while (reader.readLine() != null) {
                lineCount++;
            }
            return lineCount;
        } catch (IOException e) {
            System.out.println("IO exception");
            return -1; // An error occurred
        }
    }
}


