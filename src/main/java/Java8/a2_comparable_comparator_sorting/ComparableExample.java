package Java8.a2_comparable_comparator_sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExample implements Comparable<ComparableExample> {


    private String name;
    private int age;

    public ComparableExample(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(ComparableExample other) {
        return this.age - other.age; // Sort by age
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }

    public static void main(String[] args) {
        List<ComparableExample> people = new ArrayList<>();
        people.add(new ComparableExample("Alice", 30));
        people.add(new ComparableExample("Bob", 25));
        people.add(new ComparableExample("Charlie", 35));

        // Sort using Comparable
        Collections.sort(people);
        System.out.println(people);
    }
}
