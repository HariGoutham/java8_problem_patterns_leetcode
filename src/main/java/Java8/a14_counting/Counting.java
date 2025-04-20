package Java8.a14_counting;

// In Java 8, Collectors.counting() is used to count the number of elements in a stream.
// It is a reduction operation that returns a Long representing the count of elements.

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Counting {

    public static void main(String[] args) {

        // Basic Usage - Counting Elements in a List
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        long count = names.stream().collect(Collectors.counting());
        System.out.println(count);

        // Counting Elements that Match a Condition
        List<String> names1 = Arrays.asList("Alice", "Bob", "Charlie", "David");
        long count1 = names1.stream()
                .filter(name -> name.length() > 3)
                .collect(Collectors.counting());
        System.out.println(count1); // Output: 3

        // Counting Elements in a Group (Grouping & Counting)
        List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Long> fruitCount = items.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(fruitCount);
        System.out.println(items.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).get("apple"));

        //Counting with Custom Objects
        List<Person> people = Arrays.asList(
                new Person("Alice", "Female"),
                new Person("Bob", "Male"),
                new Person("Charlie", "Male"),
                new Person("Diana", "Female"),
                new Person("Eve", "Female")
        );

        Map<String, Long> genderCount = people.stream()
                .collect(Collectors.groupingBy(person -> person.gender, Collectors.counting()));

        System.out.println(genderCount);
    }
}

class Person {
    String name;
    String gender;

    Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }
}
