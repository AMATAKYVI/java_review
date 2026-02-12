package d4.Comparing;

public class Main {

    public static void main(String[] args) {

        Integer five = Integer.valueOf(5);
        Integer[] othersNumber = new Integer[]{1, 2, 3, 42, 3, 23};

        for (Integer number : othersNumber) {
            int val = five.compareTo(number);
            System.out.printf("%d %s %d: compare to = %d%n", five, (val == 0 ? "==" : (val < 0) ? "<" : ">"), number, val);
        }

        String banana = "banana";
        String[] fruits = new String[]{"apple", "banana", "cherry", "durian", "elderberry", "fig"};

        for (String fruit : fruits) {
            int val = banana.compareTo(fruit);
            System.out.printf("%s %s %s: compare to = %d%n", banana, (val == 0 ? "==" : (val < 0) ? "<" : ">"), fruit, val);
        }

        // student list and do compare
        StudentComparator[] listOfStudentName = new StudentComparator[]{
            new StudentComparator("Alice"),
            new StudentComparator("Bob"),
            new StudentComparator("Charlie"),
            new StudentComparator("David"),
            new StudentComparator("Eve"),
            new StudentComparator("Frank"),};

        for (int i = 0; i < listOfStudentName.length; i++) {
            for (int j = i + 1; j < listOfStudentName.length; j++) {
                int val = listOfStudentName[i].getName().compareTo(listOfStudentName[j].getName());
                System.out.printf("%s %s %s: compare to = %d%n", listOfStudentName[i].getName(), (val == 0 ? "==" : (val < 0) ? "<" : ">"), listOfStudentName[j].getName(), val);
            }
        }
        System.out.println("\n\n");
        // comparable student
        StudentComparable[] listOfComparableStudentName = new StudentComparable[]{
            new StudentComparable("Alice", 20),
            new StudentComparable("Bob", 30),
            new StudentComparable("Charlie", 40),
            new StudentComparable("David", 50),
            new StudentComparable("Eve", 60),
            new StudentComparable("Frank", 70),};

        for (int i = 0; i < listOfComparableStudentName.length; i++) {
            for (int j = i + 1; j < listOfComparableStudentName.length; j++) {
                int val = listOfComparableStudentName[i].compareTo(listOfComparableStudentName[j]);
                System.out.printf("%s %s %s: compare to = %d%n", listOfComparableStudentName[i].getName(), (val == 0 ? "==" : (val < 0) ? "<" : ">"), listOfComparableStudentName[j].getName(), val);
            }
        }
    }
}
