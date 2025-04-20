package Java8.a4_distinct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DistinctUsages {

    public static void main(String[] args) {
        simpleDistinctForIntegers();

        List<ComparatorExample> people = new ArrayList<>();
        people.add(new ComparatorExample("Alice", 30));
        people.add(new ComparatorExample("Bob", 25));
        people.add(new ComparatorExample("Charlie", 35));
        people.add(new ComparatorExample("Charlie", 35));
        people.add(new ComparatorExample("Charlie", 35));

        Map<String, Long> nameCounts = people.stream()
                .collect(Collectors.groupingBy(ComparatorExample::getName, Collectors.counting()));

        System.out.println(nameCounts);

        List<ComparatorExample> distinctDuplicates = people.stream()
                .filter(p -> nameCounts.get(p.getName()) > 1) // Keep only duplicates
                .distinct().toList();

        System.out.println(distinctDuplicates);// we get duplicates but not distinct, need to override the equals and hashcode methods
    }
    private static void simpleDistinctForIntegers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 3, 2, 5, 1, 5, 5, 3, 2);
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctNumbers);
    }

}

class ComparatorExample {
    String name;
    int age;

    ComparatorExample(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

