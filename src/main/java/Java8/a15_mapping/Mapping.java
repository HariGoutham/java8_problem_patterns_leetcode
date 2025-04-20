package Java8.a15_mapping;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Mapping {



    public static void main(String[] args) {

        // 1. Basic Usage with Collectors.groupingBy
        // You can use Collectors.mapping() with Collectors.groupingBy() to transform values before collecting them.
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Charlie", "HR"),
                new Employee("David", "IT")
        );
        Map<String, List<String>> departmentToNames = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(a -> a.name, Collectors.toList())));
        System.out.println(departmentToNames);
        Map<String, Long> departmentAndNumberOfEmployees = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(departmentAndNumberOfEmployees);

        // 2. Using mapping() with Collectors.toSet()
        // Instead of collecting to a List, you can collect unique values using Collectors.toSet().
        Map<String, Set<String>> departmentVsUniqueNames = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toSet())));
        System.out.println(departmentVsUniqueNames);

        // 3. Using mapping() with joining()
        // You can collect mapped values as a String using Collectors.joining().
        Map<String, String> departmentToNamesString = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.mapping(Employee::getName, Collectors.joining(", "))));
        System.out.println(departmentToNamesString);

        // 4. Using mapping() with counting()
        // Instead of collecting values, you can count occurrences after applying the mapping.

        Map<String, Long> departmentToEmployeeCount = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.counting())
                ));

        System.out.println(departmentToEmployeeCount);

        // 5. Using mapping() in partitioningBy()
        // You can use Collectors.partitioningBy() along with mapping() to separate values based on a condition.
        var employeesByDepartment =
                employees.stream().collect(Collectors.partitioningBy(employee -> employee.department.equals("IT"), Collectors.mapping(employee -> employee.name, Collectors.counting())));
        System.out.println(employeesByDepartment);

    }

    static class Employee {
        private String name;
        private String department;

        public Employee(String name, String department) {
            this.name = name;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }
    }
}
