package d6.Map;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Main {

    private static Map<String, Purchase> purchases = new HashMap<>();

    private static NavigableMap<String, StudentLinkHashMap> students = new TreeMap<>();

    public static void main(String[] args) {
        AdventureGame game = new AdventureGame();

        Course jmc = new Course("jmc101", "Java Master Class", "Java");
        Course python = new Course("py101", "Python Master Class", "Python");
        Course ruby = new Course("rb101", "Ruby Master Class", "Ruby");
        addPurchase("John Doe", jmc, 99.99);
        addPurchase("John Doe", python, 99.99);
        addPurchase("John Doe", ruby, 99.99);

        purchases.forEach((k, v) -> System.out.println(v));

        NavigableMap<LocalDate, List<Purchase>> purchasesByDate = new TreeMap<>();
        for (Purchase purchase : purchases.values()) {
            LocalDate date = purchase.date();
            List<Purchase> purchasesForDate = purchasesByDate.get(date);
            if (purchasesForDate == null) {
                purchasesForDate = new ArrayList<>();
                purchasesByDate.put(date, purchasesForDate);
            }
            purchasesForDate.add(purchase);
        }

        for (LocalDate date : purchasesByDate.keySet()) {
            System.out.println(date);
            for (Purchase purchase : purchasesByDate.get(date)) {
                System.out.println(purchase);
            }
        }

        int currentYear = LocalDate.now().getYear();

        LocalDate firstDay = LocalDate.ofYearDay(currentYear, 1);
        LocalDate week1 = firstDay.plusDays(7);
        Map<LocalDate, List<Purchase>> purchasesByWeek = new HashMap<>();
        for (Purchase purchase : purchases.values()) {
            LocalDate date = purchase.date();
            if (date.isAfter(firstDay) && date.isBefore(week1)) {
                List<Purchase> purchasesForWeek = purchasesByWeek.get(date);
                if (purchasesForWeek == null) {
                    purchasesForWeek = new ArrayList<>();
                    purchasesByWeek.put(date, purchasesForWeek);
                }
                purchasesForWeek.add(purchase);
            }
        }

        System.out.println("Purchases by week: -------");
        for (LocalDate date : purchasesByWeek.keySet()) {
            System.out.println(date);
            for (Purchase purchase : purchasesByWeek.get(date)) {
                System.out.println(purchase);
            }
        }


    }

    private static void addPurchase(String name, Course course, double price) {
        StudentLinkHashMap existingStudent = students.get(name);
        if (existingStudent == null) {
            existingStudent = new StudentLinkHashMap(name, course);
            students.put(name, existingStudent);
        } else {
            existingStudent.addCourse(course);
        }

        int day = purchases.size() + 1;
        String key = course.courseId() + "_" + existingStudent.getId();
        int year = LocalDate.now().getYear();
        Purchase purchase = new Purchase(course.courseId(), existingStudent.getId(), price, year, day);
        purchases.put(key, purchase);
    }
}
