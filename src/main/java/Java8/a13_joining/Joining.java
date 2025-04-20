package Java8.a13_joining;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Joining {

    public static void main(String[] args) {

        // 1. Basic Joining (No Delimiter)
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        String result = names.stream().collect(Collectors.joining());
        System.out.println(result);

        // 2. Joining with a Delimiter
        String result1 = names.stream().collect(Collectors.joining(", "));
        System.out.println(result1);

        // 3. Joining with a Delimiter, Prefix, and Suffix
        String result2 = names.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println(result2); // Output: [Alice, Bob, Charlie]

        // 4. Joining with Non-String Elements
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        String result3 = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" - "));
        System.out.println(result3); // Output: 1 - 2 - 3 - 4

        // 5. Joining with Filtering
        String result4 = names.stream()
                .filter(name -> name.length() > 3)
                .collect(Collectors.joining(", "));
        System.out.println(result4); // Output: Alice, Charlie

        // 6. Joining with map
        String result5 = names.stream().map(String::toUpperCase).collect(Collectors.joining(" | "));
        System.out.println(result5); // Output: ALICE | BOB | CHARLIE

        // 7. with objects

        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35)
        );

        String names6 = people.stream()
                .map(person -> person.name) // Extract only names
                .collect(Collectors.joining(", "));

        System.out.println(names6);

        String nameAge = people.stream()
                .map(person -> person.name + " (" + person.age + ")")
                .collect(Collectors.joining(" | "));

        System.out.println(nameAge);
    }
}
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}