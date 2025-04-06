public class arrayrev {

    // Method to reverse the array recursively
    public static void reverseArray(int[] arr, int start, int end) {
        // Base case: if start is greater than or equal to end, return
        if (start >= end) {
            return;
        }

        // Swap the elements at start and end
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        // Recursively reverse the remaining array
        reverseArray(arr, start + 1, end - 1);
    }

    // Utility method to print the array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Driver function to test the above methods
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        
        // Print the original array
        System.out.print("Original array: ");
        printArray(arr);

        // Reverse the array
        reverseArray(arr, 0, arr.length - 1);
        
        // Print the reversed array
        System.out.print("Reversed array: ");
        printArray(arr);
    }
}
