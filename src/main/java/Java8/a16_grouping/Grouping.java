package Java8.a16_grouping;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Grouping {

    public static void main(String[] args) {


        // Type 1: Basic Grouping
        // This is the simplest form of groupingBy(), where elements are grouped based on a classifier function.
        // Map<K, List<T>> result = stream.collect(Collectors.groupingBy(ClassifierFunction));

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Charlie", "HR"),
                new Employee("David", "IT"),
                new Employee("Eve", "Finance")
        );

        var employeeMap = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(employeeMap);

        // Type 2: Grouping with a Downstream Collector
        // Here, you specify what to collect instead of just a list.
        // Syntax:
        // Map<K, Collection<V>> result = stream.collect(
        //    Collectors.groupingBy(ClassifierFunction, DownstreamCollector)
        // );

        var employeeNameMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toSet())));
        System.out.println(employeeNameMap);

        // Type 3: Grouping with Custom Map Implementation
        // You can specify a custom Map type, along with a downstream collector.
        // Syntax:
        // Map<K, Collection<V>> result = stream.collect(
        //    Collectors.groupingBy(ClassifierFunction, Supplier<Map<K, List<V>>>, DownstreamCollector)
        //);

        var employeeTreeMap = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, TreeMap::new, Collectors.counting()));
        System.out.println(employeeTreeMap);
    }
}

class Employee {
    String name;
    String department;

    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', department='" + department + "'}";
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }
}