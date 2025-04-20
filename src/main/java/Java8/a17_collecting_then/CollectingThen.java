package Java8.a17_collecting_then;

import java.util.*;
import java.util.stream.Collectors;

public class CollectingThen {

    public static void main(String[] args) {

//        Collectors.collectingAndThen() is a higher-order collector in Java 8 that wraps another collector and applies a final transformation to its result.
//        It is mainly used to post-process collected results, such as making collections immutable, extracting values, or converting data types.

        // Basic Example: Making a List Immutable
        // Convert a mutable list into an immutable list.
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        var unmodifiableList = names.stream().collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        System.out.println(unmodifiableList);

        // Using collectingAndThen() with Counting
        boolean isEmpty = names.stream().collect(Collectors.collectingAndThen(Collectors.counting(), count -> count == 0));
        System.out.println(isEmpty);

        // Extracting the Maximum/Minimum Element
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 50000),
                new Employee("Bob", 60000),
                new Employee("Charlie", 75000),
                new Employee("David", 55000)
        );

        var highestSalaryEmployee  = employees.stream()
                .collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)), Optional::get));
        System.out.println(highestSalaryEmployee);
    }
}

class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() { return name; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return name + " - $" + salary;
    }
}