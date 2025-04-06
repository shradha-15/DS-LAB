import java.util.Arrays;

public class ArrayReverse {
    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3, 4, 5};

        // In-place reversal of the array
        int start = 0;
        int end = originalArray.length - 1;

        while (start < end) {
            // Swap elements at start and end
            int temp = originalArray[start];
            originalArray[start] = originalArray[end];
            originalArray[end] = temp;

            start++;
            end--;
        }

        // Print the reversed array
        System.out.println(Arrays.toString(originalArray));
    }
}
