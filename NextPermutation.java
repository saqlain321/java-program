import java.util.Arrays;

public class NextPermutation {
    // Function to swap two elements in an array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Function to reverse the elements from index 'start' to the end of the array
    private static void reverse(int[] arr, int start) {
        int i = start, j = arr.length - 1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    // Function to find the next permutation of the given sequence
    public static void nextPermutation(int[] arr) {
        int i = arr.length - 2;
        // Find the first element from the right which is smaller than its next element
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // Find the first element from the right which is greater than the element found above
            int j = arr.length - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            // Swap the two elements
            swap(arr, i, j);
        }

        // Reverse the elements from index i+1 to the end of the array
        reverse(arr, i + 1);
    }

    // Function to print an array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.print("Original permutation: ");
        printArray(arr);
        nextPermutation(arr);
        System.out.print("Next permutation: ");
        printArray(arr);
    }
}
