package Java8.a9_limit_skip;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

public class LimitSkip {
    public static void main(String[] args) {
        // 1. Using limit(n)

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50, 60);
        List<Integer> limitedNumbers = numbers.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(limitedNumbers);

        // 2. Using skip(n)
        List<Integer> skippedNumbers = numbers.stream()
                .skip(3) // Skip first 3 elements
                .collect(Collectors.toList());

        System.out.println(skippedNumbers);

        // 3. Combining limit() and skip() for Pagination
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Edward", "Frank");

        int pageSize = 2;
        int pageNumber = 2; // Page index starts from 0

        List<String> pageData = names.stream()
                .skip(pageNumber * pageSize) // Skip first 4 elements
                .limit(pageSize) // Take next 2 elements
                .collect(Collectors.toList());

        System.out.println(pageData); // Output: [Edward, Frank]

    }
}
