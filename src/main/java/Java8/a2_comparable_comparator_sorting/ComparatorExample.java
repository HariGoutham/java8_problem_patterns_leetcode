package Java8.a2_comparable_comparator_sorting;

import java.util.*;
import java.util.stream.Collectors;

public class ComparatorExample {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public ComparatorExample(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }

    public static void main(String[] args) {
        List<ComparatorExample> people = new ArrayList<>();
        people.add(new ComparatorExample("xAlice", 30));
        people.add(new ComparatorExample("Bob", 25));
        people.add(new ComparatorExample("Charlie", 35));
        people.add(new ComparatorExample("Charlie", 35));
        people.add(new ComparatorExample("Charlie", 35));

        people.sort(new AgeComparator());
        System.out.println(people);

        people.sort(new NameComparator());
        System.out.println(people);

        people.sort(Comparator.comparing(a -> a.getAge()));
        System.out.println(people);

        people.sort(Comparator.comparing(ComparatorExample::getName));
        System.out.println(people);

        Set<String> aComparator = new HashSet<>();
        System.out.println(people.stream().map(ComparatorExample::getName).filter(aName -> !aComparator.add(aName)).distinct().collect(Collectors.toList()));
    }
}

