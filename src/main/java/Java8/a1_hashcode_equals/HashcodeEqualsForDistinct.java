package Java8.a1_hashcode_equals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class HashcodeEqualsForDistinct {
    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Alice", Arrays.asList("Java", "Spring", "Docker")),
                new Person("Bob", Arrays.asList("Java", "Kubernetes", "AWS")),
                new Person("Charlie", Arrays.asList("Python", "Django", "AWS", "Docker")),
                new Person("Charlie", Arrays.asList("Python", "Django", "AWS", "TTT"))
        );

        var uniqueSkills = people.stream().map(Person::getSkills).flatMap(List::stream).distinct().toList();

        System.out.println(people.stream().distinct().collect(Collectors.toList()));

        System.out.println(uniqueSkills);
    }
}


class Person {
    String name;
    List<String> skills;

    Person(String name, List<String> skills) {
        this.name = name;
        this.skills = new ArrayList<>(skills);
    }

    public List<String> getSkills() {
        return skills;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Objects.equals(name, person.name) && Objects.equals(skills, person.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, skills);
    }

    @Override
    public String toString() {
        return name + " -> " + skills;
    }
}
