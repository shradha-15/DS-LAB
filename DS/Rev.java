public class Rev {

    // Method to reverse the array iteratively
    public static void reverseArray(int[] arr, int start, int end) {
        int temp;
        while (start < end) {
            // Swap the elements at start and end
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Utility method to print the array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Driver function to test the reverseArray method
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println("Original array:");
        printArray(arr);
        
        // Call the reverseArray method to reverse the array
        reverseArray(arr, 0, arr.length - 1);
        
        System.out.println("Reversed array:");
        printArray(arr);
    }
}
