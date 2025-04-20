package Java8.a6_sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {


    public static void main(String[] args) {

        //Basic Sorting (Natural Sort)
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 2);
        System.out.println(numbers.stream().sorted().collect(Collectors.toList()));

        List<String> names = Arrays.asList("Charlie", "Alice", "Bob");
        System.out.println(names.stream().sorted().collect(Collectors.toList()));

        //Sorting in Reverse Order
        System.out.println(numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        System.out.println(names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

        //Sorting Objects by a Field
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Xavier", 20),
                new Person("Bob", 25),
                new Person("Charlie", 40),
                new Person("ZenAI", 2)
        );

        System.out.println(people);
        System.out.println(people.stream().sorted(Comparator.comparing(person -> person.age)).collect(Collectors.toList()));
        System.out.println(people.stream().sorted(Comparator.comparing(Person::getAge).reversed()).collect(Collectors.toList()));
        System.out.println(people.stream().sorted(Comparator.comparing(person -> person.age, Comparator.reverseOrder())).collect(Collectors.toList()));

        //Sorting by Multiple Fields (Chained Sorting)

        var multiSortByNameByAge =
                people.stream().sorted(Comparator.comparing(Person::getName).thenComparing(Person::getAge)).collect(Collectors.toList());

        System.out.println(multiSortByNameByAge);

        var multiSortByAgeByName =
                people.stream().sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getName)).collect(Collectors.toList());

        System.out.println(multiSortByAgeByName);

        //Sorting Strings Ignoring Case

        List<String> mixedCaseNames = Arrays.asList("charlie", "Alice", "bob");
        List<String> sortedIgnoreCase = mixedCaseNames.stream()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.toList());

        System.out.println(sortedIgnoreCase);

        // Custom Sorting Using Comparator

        List<String> words = Arrays.asList("elephant", "cat", "tiger", "lion");

        System.out.println(words.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList()));
        System.out.println(words.stream().sorted(Comparator.comparingInt(String::length).reversed()).collect(Collectors.toList()));


        //Parallel Sorting (for Large Lists)
        List<Integer> parallelSorted = numbers.parallelStream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(parallelSorted);
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

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
