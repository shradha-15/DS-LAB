public class ReverseArray {

    // Method to reverse an array using an extra array
    public static void reverseArrayExtraArray(int[] arr) {
        int size = arr.length;
        int[] reversedArr = new int[size];

        // Reverse the elements and store them in the new array
        for (int i = 0; i < size; i++) {
            reversedArr[i] = arr[size - i - 1];
        }

        // Print reversed array
        System.out.print("Reversed Array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(reversedArr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] originalArr = {1, 2, 3, 4, 5};
        reverseArrayExtraArray(originalArr);
    }
}
