package Java8.a19_practice_problems;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8AllConceptsProblemsPractise {

    public static void main(String[] args) {

    }

    // 1. Get list of squares of distinct even numbers
    public static void problem1(List<Integer> numbers) {

    }

    // 2. Flatten a list of list of strings and return unique elements
    public static void problem2(List<List<String>> nestedList) {

    }

    // 3. Count frequency of words in a list
    public static void problem3(List<String> words) {

    }

    // 4. Find the top 3 highest numbers
    public static void problem4(List<Integer> numbers) {

    }

    // 5. Find second highest salary from list of employees
    public static void problem5(List<Employee> employees) {

    }

    // 6. Filter out null and empty strings and sort by length
    public static void problem6(List<String> strings) {
        // starter code
    }

    // 7. Reduce to calculate total expense from transaction list
    public static void problem7(List<Transaction> transactions) {
        // starter code
    }

    // 8. Skip first 3 and limit next 5 numbers
    public static void problem8(List<Integer> numbers) {
        // starter code
    }

    // 9. Match if all, any or none names start with "A"
    public static void problem9(List<String> names) {
        // starter code
    }

    // 10. Find first even number greater than 100
    public static void problem10(List<Integer> numbers) {
        // starter code
    }

    // 11. Generate a list of 10 random integers
    public static void problem11() {
        // starter code
    }

    // 12. Generate even numbers using iterate
    public static void problem12() {
        // starter code
    }

    // 13. Find average salary department-wise
    public static void problem13(List<Employee> employees) {
        // starter code
    }

    // 14. Group names by first character
    public static void problem14(List<String> names) {
        // starter code
    }

    // 15. Partition list into even and odd
    public static void problem15(List<Integer> numbers) {
        // starter code
    }

    // 16. Remove duplicate characters from string
    public static void problem16(String input) {
        // starter code
    }

    // 17. Find longest word using reduce
    public static void problem17(List<String> words) {
        // starter code
    }

    // 18. Find second longest string
    public static void problem18(List<String> words) {
        // starter code
    }

    // 19. Join all names with comma separator
    public static void problem19(List<String> names) {
        // starter code
    }

    // 20. Convert list of strings to uppercase
    public static void problem20(List<String> strings) {
        // starter code
    }

    // 21. Count character frequency in a string
    public static void problem21(String input) {
        // starter code
    }

    // 22. Group employees by department and then by designation
    public static void problem22(List<Employee> employees) {
        // starter code
    }

    // 23. Collect names of employees older than 30
    public static void problem23(List<Employee> employees) {
        // starter code
    }

    // 24. Sort map by values using streams
    public static void problem24(Map<String, Integer> map) {
        // starter code
    }

    // 25. Remove duplicate elements from array
    public static void problem25(Integer[] array) {
        // starter code
    }

    // 26. Count vowels in a string
    public static void problem26(String input) {
        // starter code
    }

    // 27. Extract domain names from emails
    public static void problem27(List<String> emails) {
        // starter code
    }

    // 28. Generate list of prime numbers
    public static void problem28(int limit) {
        // starter code
    }

    // 29. Find missing number from range
    public static void problem29(List<Integer> numbers, int range) {
        // starter code
    }

    // 30. Create stream from array and collect to set
    public static void problem30(String[] array) {
        // starter code
    }

    // 31. Sort employees by salary and name
    public static void problem31(List<Employee> employees) {
        // starter code
    }

    // 32. Find most repeated word in paragraph
    public static void problem32(String paragraph) {
        // starter code
    }

    // 33. Find all duplicate elements
    public static void problem33(List<Integer> numbers) {
        // starter code
    }

    // 34. Convert list of employees to map of id->name
    public static void problem34(List<Employee> employees) {
        // starter code
    }

    // 35. Extract all even digits from a string
    public static void problem35(String input) {
        // starter code
    }

    // 36. Find median of list
    public static void problem36(List<Integer> numbers) {
        // starter code
    }

    // 37. Get distinct characters across all names
    public static void problem37(List<String> names) {
        // starter code
    }

    // 38. Create a summary statistics from numbers
    public static void problem38(List<Integer> numbers) {
        // starter code
    }

    // 39. Collect to TreeMap sorted by keys
    public static void problem39(Map<String, Integer> map) {
        // starter code
    }

    // 40. Get employees joined after 2015
    public static void problem40(List<Employee> employees) {
        // starter code
    }

    // 41. Convert List<Optional<String>> to List<String>
    public static void problem41(List<Optional<String>> optionalList) {
        // starter code
    }

    // 42. Create infinite stream of Fibonacci and limit to 10
    public static void problem42() {
        // starter code
    }

    // 43. Sum of digits in a list of numbers
    public static void problem43(List<Integer> numbers) {
        // starter code
    }

    // 44. Count palindromes in list
    public static void problem44(List<String> words) {
        // starter code
    }

    // 45. Get initials from full names
    public static void problem45(List<String> fullNames) {
        // starter code
    }

    // 46. Check if two lists are equal ignoring order
    public static void problem46(List<Integer> list1, List<Integer> list2) {
        // starter code
    }

    // 47. Find max occurring digit in list of numbers
    public static void problem47(List<Integer> numbers) {
        // starter code
    }

    // 48. Filter and sort students by grade and name
    public static void problem48(List<Student> students) {
        // starter code
    }

    // 49. Flatten map<String, List<String>> to single list
    public static void problem49(Map<String, List<String>> map) {
        // starter code
    }

    // 50. Convert LocalDate list to formatted strings
    public static void problem50(List<LocalDate> dates) {
        // starter code
    }

    static class Employee {
        int id;
        String name;
        String department;
        String designation;
        double salary;
        int joiningYear;
        int age;

        public Employee(int id, String name, String department, String designation, double salary, int joiningYear, int age) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.designation = designation;
            this.salary = salary;
            this.joiningYear = joiningYear;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public int getJoiningYear() {
            return joiningYear;
        }

        public void setJoiningYear(int joiningYear) {
            this.joiningYear = joiningYear;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    static class Transaction {
        String category;
        double amount;
        // constructor, getters, setters
    }

    static class Student {
        String name;
        double grade;
        // constructor, getters, setters
    }
}

