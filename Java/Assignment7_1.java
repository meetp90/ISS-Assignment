import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Assignment7_1 {

    public static void main(String[] args) {

        // 1. Using Comparable (natural ordering):

        // Implement Comparable interface for a Person class
        class Person implements Comparable<Person> {
            private String name;
            private int age;

            public Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            // Natural ordering based on age (ascending)
            @Override
            public int compareTo(Person other) {
                return Integer.compare(this.age, other.age);
            }
        }

        // Create Person objects
        Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Bob", 30);

        // Comparable interface allows natural ordering comparison
        List<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);

        // Sorting based on natural ordering (age)
        Collections.sort(people);

        // (Logic to use the sorted list of people)

        // 2. Using Comparator (custom ordering):

        // Custom Comparator for comparing Person objects by name (ascending)
        Comparator<Person> nameComparator = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.name.compareTo(p2.name);
            }
        };

        // Use the custom comparator to sort by name
        Collections.sort(people, nameComparator);

        // (Logic to use the list sorted by name)
    }
}
