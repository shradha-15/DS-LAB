import java.util.Scanner;

public class Main {

    // A function that terminates when the enter key is pressed
    public static void fun() {
        System.out.println("fun() starts");
        System.out.println("Press enter to stop fun");

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Wait for user input (enter key)
        
        System.out.println("fun() ends");
    }

    public static void main(String[] args) {
        // Record the start time
        long startTime = System.nanoTime();

        // Call the fun() function
        fun();

        // Record the end time
        long endTime = System.nanoTime();

        // Calculate the time taken (in seconds)
        double timeTaken = (endTime - startTime) / 1_000_000_000.0;  // Convert from nanoseconds to seconds

        // Display the time taken
        System.out.printf("fun() took %f seconds to execute\n", timeTaken);
    }
}
