package Java8.a12_numeric_streams;

import java.util.*;
import java.util.stream.*;

public class NumericStreamsDemo {
    public static void main(String[] args) {
        // 1. Using range() (Exclusive End)
        System.out.print("range(1, 5): ");
        IntStream.range(1, 5).forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 2. Using rangeClosed() (Inclusive End)
        System.out.print("rangeClosed(1, 5): ");
        IntStream.rangeClosed(1, 5).forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 3. Count
        long count = IntStream.range(1, 10).count();
        System.out.println("Count: " + count);

        // 4. Sum
        int sum = IntStream.rangeClosed(1, 5).sum();
        System.out.println("Sum: " + sum);

        // 5. Max and Min
        OptionalInt max = IntStream.range(1, 10).max();
        OptionalInt min = IntStream.range(1, 10).min();
        System.out.println("Max: " + max.orElse(-1));
        System.out.println("Min: " + min.orElse(-1));

        // 6. Average
        OptionalDouble avg = IntStream.range(1, 6).average();
        avg.ifPresent(a -> System.out.println("Average: " + a));

        // 7. forEach()
        System.out.print("forEach() output: ");
        IntStream.rangeClosed(1, 5).forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 8. Boxing (Convert int to Integer)
        List<Integer> boxedList = IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList());
        System.out.println("Boxed List: " + boxedList);

        // 9. Unboxing (Convert Integer to int)
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        IntStream unboxedStream = numbers.stream().mapToInt(Integer::intValue);
        System.out.print("Unboxed Stream: ");
        unboxedStream.forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 10. mapToInt() - Convert String to int
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        System.out.print("mapToInt (String lengths): ");
        words.stream().mapToInt(String::length).forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 11. mapToLong() - Convert int to long
        System.out.print("mapToLong (x10 values): ");
        IntStream.range(1, 5).mapToLong(n -> n * 10).forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 12. mapToDouble() - Convert int to double
        System.out.print("mapToDouble (add 0.5): ");
        IntStream.range(1, 5).mapToDouble(n -> n + 0.5).forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 13. mapToObj() - Convert int to String
        List<String> objMapped = IntStream.range(1, 5).mapToObj(n -> "Number " + n).collect(Collectors.toList());
        System.out.println("mapToObj result: " + objMapped);
    }
}
