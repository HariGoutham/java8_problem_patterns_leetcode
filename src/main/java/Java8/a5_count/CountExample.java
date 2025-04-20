package Java8.a5_count;

import java.util.Arrays;
import java.util.List;

public class CountExample {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Alice", "Bob");
        long count = names.stream().count();
        System.out.println(count);

        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35),
                new Person("Alice", 30)
        );

        long uniqueNamesCount = people.stream()
                .map(Person::getName) // Extract names
                .distinct()
                .count();

        System.out.println(uniqueNamesCount);
    }
}

class Person {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
