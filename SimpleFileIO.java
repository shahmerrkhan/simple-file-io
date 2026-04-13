import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class SimpleFileIO {
     // Scanner
    static Scanner s = new Scanner(System.in);
   

    // Add .txt to filename method
    /**
     * Ensures the filename ends with .txt extension.
     *
     * @param filename The filename to check
     * @return The filename with .txt extension
     */
    public static String addTxt(String filename) {
        if (!filename.endsWith(".txt")) {
            filename = filename + ".txt";
        }
        return filename;
    } // end addTxt(String)
    

    // file exists method
    public static String fileExists(String filename) {

    // Check if file exists
    
    System.out.println("Choose one of the options below: ");
    System.out.println("1. Overwrite the file");
    System.out.println("2. Choose another file");
    int choice = validVal(2, 1);
    if (choice == 1) {
        System.out.println("Overwriting file: " + filename);
        return filename;
    } 
    else {
        System.out.print("Enter the filename to write to: ");
        String newFilename = s.nextLine();
        while (true) {
            if (newFilename.isEmpty()) {
                System.out.println("Invalid input. Please enter a filename.");
                System.out.print("Enter the filename to write to: ");
                newFilename = s.nextLine();      
            } // end if
            else {
                break;
            } // end else
        } // end while

        // Add .txt to filename
        newFilename = addTxt(newFilename);
        return newFilename;

    } // end else

    } // end fileExists(String)
    
    /**
     * Prompts the user to press Enter to acknowledge a result, 
     * preventing the console text from scrolling too quickly.
     */

    // method to pause the program and wait for user input
    public static void pause() {
        System.out.print("\nPress Enter to continue: ");
        s.nextLine();
        System.out.println();
    } // end pause



     /**
     * Validates user input to ensure it falls within a specific range.
     *
     * @param max The maximum allowable integer choice
     * @param min The minimum allowable integer choice
     * @return The validated integer choice
     */

    // Valid Val
    public static int validVal(int max, int min) {

        while (true) {
        System.out.print("Enter your choice: ");
        int choice = s.nextInt();
        s.nextLine();

        if (choice >= min && choice <= max) {
            System.out.println("You selected: " + choice);
            System.out.println();
            return choice;

        } // end if
        
        System.out.println("Invalid input. Please enter a number between " + min + " and " + max);
        System.out.println();

        } // end while
    } // validVal (int, int)


    // Write to file method
    public static void writeToFile() throws IOException {

        // title
        System.out.println("=== Write a Text File ===");

        // Writing to a file
        System.out.print("Enter the filename to write to: ");
        String filename = s.nextLine();
        if (filename.isEmpty()) {
            return;
        }
        // Add .txt to filename
        filename = addTxt(filename);

        // Check if file exists and overwrite or choose another file
        File tempFile = new File(filename);
        boolean exists = tempFile.exists();
        if (exists) {
            filename = fileExists(filename);
        }

        PrintWriter f = new PrintWriter(new FileWriter(filename));

        // Asking to write text to the file, loop until user enters 0 to exit
        while (true) {
            System.out.print("Enter the text to write to the file, enter STOP to exit: ");
            String text = s.nextLine();
            if (text.equals("STOP")) {
                break;
            } // end if

        f.println(text);

        } // end while

        // Closing
        f.close();
        System.out.println("File writing complete. File saved as: " + filename);
        
    } // end writeToFile()

    
    // Read from file method
    public static void readFromFile() throws IOException {
        
        // title
        System.out.println("=== Read from a Text File ===");

        int lineCount = 0;

        // Reading from a file
        System.out.print("Enter the filename to read from: ");
        String filename = s.nextLine();
        if (filename.isEmpty()) {
            return;
        }
   
        // Add .txt to filename
        filename = addTxt(filename);
        
        // Check if file exists
        File tempFile = new File(filename);
        boolean exists = tempFile.exists();
        if (!exists) {
            System.out.println("File not found: " + filename);
            return;
        }

        BufferedReader f = new BufferedReader(new FileReader(filename));

        // Read from file
        String text = f.readLine();
        while (text != null) {
            System.out.println(text);
            lineCount += 1;
            text = f.readLine();
            if (lineCount == 20) {
                pause();
                lineCount = 0;
            } // to pause after 20 lines
        } // end while

        // Closing
        f.close();
        System.out.println("\nFile reading complete. File read: " + filename);

    } // end readFromFile()

    // Main
    public static void main(String[] args) throws IOException {

    while (true) {
        System.out.println("\nPlease select one of the below options: ");
        System.out.println("1. Write text to file");
        System.out.println("2. Read text from file");
        System.out.println("3. About the program");
        System.out.println("4. Exit");
        int choice = validVal(4, 1);
        if (choice == 1) {
            writeToFile();
        } 
        else if (choice == 2) {
            readFromFile();
        } 
        else if (choice == 3) {
            System.out.println("About the program: This program allows you to write text to a file and read text from a file. You can specify the filename when writing or reading, and the program will ensure that the file is saved with a .txt extension. When reading from a file, the program will display the contents of the file in the console, pausing after every 20 lines to prevent scrolling too quickly. This program demonstrates basic file input/output operations in Java.");
        }
        else {
            System.out.println("Exiting program. Goodbye!");
            break;
        }

    } // end while

    } // end main

} // end class