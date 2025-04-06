public class TimeTakenExample {

    // A function that calculates the sum of numbers from 0 to n
    public static int findSum(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }

    public static void main(String[] args) {
        // Get the current time before calling the function
        long startTime = System.nanoTime();

        // Call the findSum function with a large value of n
        findSum(10000000);

        // Calculate the time taken in seconds
        long endTime = System.nanoTime();
        double timeTaken = (endTime - startTime) / 1e9; // Convert to seconds

        // Print the time taken
        System.out.println("findSum(int n) took " + timeTaken + " seconds to execute.");
    }
}
