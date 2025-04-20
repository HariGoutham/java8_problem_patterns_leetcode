package Java8.a10_match_find;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MatchFind {

    public static void main(String[] args) {
        // 1. Using allMatch()
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);
        boolean allEven = numbers.stream()
                .allMatch(n -> n % 2 == 0);
        System.out.println(allEven); // Output: trued

        // 2. Using anyMatch()
        List<Integer> numbers1 = Arrays.asList(10, 20, 30, 40, 50);
        boolean anyGreaterThan50 = numbers1.stream()
                .anyMatch(n -> n > 50);
        System.out.println(anyGreaterThan50);

        // 3. Using noneMatch()
        List<Integer> numbers2 = Arrays.asList(5, 10, 15, 20);
        boolean noNegativeNumbers = numbers2.stream()
                .noneMatch(n -> n < 0);
        System.out.println(noNegativeNumbers);

        // 4. Using findAny()
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        Optional<String> anyName = names.stream().findAny();
        anyName.ifPresent(System.out::println);

        // 5. Using findFirst()
        List<String> names1 = Arrays.asList("Bob","Alice", "Charlie", "David");
        Optional<String> firstName = names1.stream().findFirst();
        firstName.ifPresent(System.out::println);
    }
}
