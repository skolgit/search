import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Search {

    public static void main(String[] args) {
        System.out.println("Search Program");
        boolean quit = false;
        Scanner inputScanner = new Scanner(System.in); // Create a Scanner object
        while (!quit) {
            options();
            System.out.println("Enter option:");
            String userInput = inputScanner.nextLine(); // Read user input
            String[] options = userInput.split(" ");
            switch (options[0]) {
                case "quit":
                    quit = true;
                    break;
                case "search":
                    searchAndPrint(options[1], options[2]);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
            if (!quit) {
                System.out.print("\nEnter to continue");
                inputScanner.nextLine();
            }
        }

        inputScanner.close(); // Close scanner
    }

    private static void options() {
        System.out.println();
        System.out.println("Available options:");
        System.out.println("1: search <keyword> <filename>");
        System.out.println("2: quit");
        System.out.println();
    }

    private static void searchAndPrint(String term, String fileName) {
        try {
            File fileObject = new File(fileName);
            Scanner fileScanner = new Scanner(fileObject);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.indexOf(term) != -1) {
                    System.out.println(line);
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

}