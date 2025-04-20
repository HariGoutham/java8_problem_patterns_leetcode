package Java8.a7_filter;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filter {

    public static void main(String[] args) {
        // Basic Filtering
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        var evenNumbers = numbers.stream().filter( number -> number % 2 == 0).collect(Collectors.toList());
        System.out.println(evenNumbers);

        // Filtering Objects Based on a Field
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Xavier", 20),
                new Person("Bob", 25),
                new Person("Charlie", 40),
                new Person("ZenAI", 2)
        );
        System.out.println(people.stream().filter(person -> person.age > 2).collect(Collectors.toList()));
        System.out.println(people.stream().filter(person -> !Objects.equals(person.name, "Xavier")).collect(Collectors.toList()));

        // Using Method References
        List<Person> adults = people.stream()
                .filter(Person::isAdult)
                .collect(Collectors.toList());

        System.out.println(adults);

        // Multiple Conditions in filter()
        List<Person> filteredPeople = people.stream()
                .filter(p -> p.getAge() >= 18 && p.getName().startsWith("A"))
                .collect(Collectors.toList());

        System.out.println(filteredPeople);

        // Filtering with Negation (!)

        List<Person> nonAdults = people.stream()
                .filter(p -> !(p.getAge() >= 18))
                .collect(Collectors.toList());

        List<Person> nonAdultsWithNot = people.stream()
                .filter(Predicate.not(p -> p.getAge() >= 18))
                .collect(Collectors.toList());

        System.out.println(nonAdults);
        System.out.println(nonAdultsWithNot);

        // Filtering Null Values

        var nonNullNames = people.stream()
                .filter(Objects::nonNull).toList();

        System.out.println(nonNullNames);


        // Using filter() with findFirst()
        Optional<Person> firstAdult = people.stream()
                .filter(p -> p.getAge() >= 18)
                .findFirst();

        System.out.println(firstAdult.get());

        // Using filter() with findAny()
        Optional<Person> anyAdult = people.stream()
                .filter(p -> p.getAge() >= 18)
                .findAny();

        System.out.println(anyAdult.get());

        // Using filter() with count()
        System.out.println(people.stream()
                .filter(p -> p.getAge() >= 18)
                .count());

        // Using filter() with anyMatch() and allMatch()

        boolean hasAdult = people.stream()
                .anyMatch(p -> p.getAge() >= 18);
        System.out.println(hasAdult);
        boolean areAllAdults = people.stream()
                .allMatch(p -> p.getAge() >= 18);
        System.out.println(areAllAdults);

        // Filtering and Collecting to a Set

        System.out.println(people.stream()
                .filter(p -> p.getAge() >= 18)
                .collect(Collectors.toSet()));

        // Filtering Duplicates (Finding Distinct Elements)

        List<Integer> nums = Arrays.asList(1, 2, 2, 3, 4, 4, 4, 5);
        List<Integer> distinctNumbers = numbers.stream()
                .filter(n -> Collections.frequency(nums, n) > 1) // Find duplicates
                .distinct().toList();

        System.out.println(distinctNumbers);

    }
}

class Person {
    String name;
    int age;

    public boolean isAdult() {
        return this.age >= 18;
    }


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

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
