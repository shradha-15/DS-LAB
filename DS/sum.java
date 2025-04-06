public class sum {

    // A method that calculates the sum of the first n integers
    public static int findSum(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        // Record the start time
        long startTime = System.nanoTime();

        // Call the findSum function
        findSum(10000000);

        // Calculate the time taken
        long endTime = System.nanoTime();
        double timeTaken = (endTime - startTime) / 1e9; // Convert nanoseconds to seconds

        // Print the time taken
        System.out.printf("findSum(int n) took %.6f seconds to execute\n", timeTaken);
    }
}
