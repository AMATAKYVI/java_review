package d2.Array;

import java.util.Arrays;

public class TwoDimensionalArray {

    public static void main(String[] args) {
        int[] unsortedArray = {5, 2, 9, 1, 5, 6};
        System.out.println("Unsorted Array: " + Arrays.toString(unsortedArray));

        // two dimensional array with index and name
        String[][] names = {
            {"1", "Alice"},
            {"2", "Bob"},
            {"3", "Charlie"},
            {"4", "David"},
            {"5", "Eve"}
        };

        // print names
        for (String[] name : names) {
            System.out.println("Index: " + name[0] + ", Name: " + name[1]);
        }
    }

}
