package d2.Array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayLogic {

    public int[] descendingShort(int[] ary) {
        if (ary == null) {
            return null;
        }
        int[] sorted = ary.clone();
        Arrays.sort(sorted);
        for (int i = 0, j = sorted.length - 1; i < j; i++, j--) {
            int t = sorted[i];
            sorted[i] = sorted[j];
            sorted[j] = t;
        }
        return sorted;
    }

    public static void main(String[] args) {

        // integet array store 1-10
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //or
        int[] numbers2 = new int[10];
        for (int i = 0; i < numbers2.length; i++) {
            numbers2[i] = i + 1;
        }

        // char array store a-z
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        //or 
        char[] letters2 = new char[26];
        for (int i = 0; i < letters2.length; i++) {
            letters2[i] = (char) ('a' + i);
        }

        // boolean array store true and false
        boolean[] bools = {true, false, true, false, true};

        //or
        boolean[] bools2 = new boolean[5];
        for (int i = 0; i < bools2.length; i++) {
            bools2[i] = i % 2 == 0; // true for even index, false for odd index
        }

        // string array store names
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve"};

        //or
        String[] names2 = new String[5];
        names2[0] = "Alice";
        names2[1] = "Bob";
        names2[2] = "Charlie";
        names2[3] = "David";
        names2[4] = "Eve";

        double[] moneyAlice = {10.5, 20.75, 30.0, 40.25, 50.0};

        //print alice name and money
        System.out.println("Alice's name: " + names[0]);
        for (int i = 0; i < moneyAlice.length; i++) {
            System.out.println("Alice's money " + (i + 1) + ": " + moneyAlice[i]);
        }
        //another format
        int[] firstFivePrimes = new int[]{2, 3, 5, 7, 11};

        //print backward first five primes
        System.out.println("First five primes in reverse order:");
        for (int i = firstFivePrimes.length - 1; i >= 0; i--) {
            System.out.println(firstFivePrimes[i] * 5);
        }

        // enchance for loop
        System.out.println("First five primes multiplied by 5:");
        for (int prime : firstFivePrimes) {
            System.out.println(prime * 5);
        }

        //checking if an instance of
        Object obj = names;
        if (obj instanceof String[]) {
            String[] nameArray = (String[]) obj;
            System.out.println("The object is a String array with length: " + nameArray.length);
        } else {
            System.out.println("The object is not a String array.");
            switch (obj.getClass().getSimpleName()) {
                case "String[]":
                    System.out.println("The object is a String array.");
                    break;
                default:
                    throw new AssertionError();
            }

        }
        Object[] obj2 = new Object[3];
        obj2[0] = "Hello";
        obj2[1] = new StringBuilder("Amatak");
        obj2[2] = 24;

        // run sorted array method
        int[] unsortedArray = {5, 3, 8, 1, 2};
        int[] sortedArray = new ArrayLogic().descendingShort(unsortedArray);
        System.out.println("Sorted Array: ");
        // System.out.println(Arrays.toString(sortedArray));

        Scanner scanner = new Scanner(System.in);
        // get user input to print sorted array
        System.out.println("Press Enter to print the sorted array, or type 'q' to quit.");

        int[] array = new int[10];
        int counter = 0;
        while (true) {
            String line = scanner.nextLine();

            if (line.equalsIgnoreCase("q")) {
                System.out.println("Quitting.");
                int[] desendingSortedArray = new ArrayLogic().descendingShort(array);
                System.out.println(Arrays.toString(desendingSortedArray));
                scanner.close();
                break;
            }
            if (line.isEmpty()) {
                System.out.println(Arrays.toString(sortedArray));
                break;
            }
            try {
                int value = Integer.parseInt(line);
                if (array.length == counter) {
                    int[] desendingSortedArray = new ArrayLogic().descendingShort(array);
                    System.out.println(Arrays.toString(desendingSortedArray));
                    break;
                }
                array[counter++] = value;

                System.out.println("user input here " + value);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number, press Enter to print the sorted array, or 'q' to quit.");
            }
        }
    }

}
