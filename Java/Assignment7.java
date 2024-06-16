import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Assignment7 {

    public static void main(String[] args) {

        // ArrayList for storing product names
        ArrayList<String> productNames = new ArrayList<>();
        productNames.add("Laptop");
        productNames.add("Phone");
        productNames.add("Tablet");


        // HashSet for storing unique customer IDs
        HashSet<Integer> customerIds = new HashSet<>();
        customerIds.add(12345);
        customerIds.add(54321);
        customerIds.add(12345); // Duplicates won't be added



        // HashMap for storing student names and their courses (key-value pairs)
        HashMap<String, String> studentCourses = new HashMap<>();
        studentCourses.put("Alice", "Java");
        studentCourses.put("Bob", "Python");
        studentCourses.put("Alice", "C++"); // HashMap overrides existing key



        // Accessing elements:

        String firstProductName = productNames.get(0);


        boolean hasCourse = studentCourses.containsKey("Charlie"); // Check if key exists


        // Sorting ArrayList (assuming comparable elements)
        Collections.sort(productNames);


 
    }
}
