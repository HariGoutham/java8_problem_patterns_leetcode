package Java8.a11_of_iterate_generate;

import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExplore {

    public static void main(String[] args) {


        // 1. Using Stream.of()
        //Example 1: Creating a stream from individual elements
        Stream<String> names = Stream.of("Alice", "Bob", "Charlie");
        names.forEach(System.out::println);

        //Example 2: Creating a stream from an array
        String[] fruits = {"Apple", "Banana", "Cherry"};
        Stream<String> fruitStream = Stream.of(fruits);
        fruitStream.forEach(System.out::println);

        // 2. Using Stream.iterate()
        // The Stream.iterate() method generates a sequential infinite stream based on a seed value and a function.
        // Syntax -> Stream.iterate(seed, function)
        // seed: The initial value.
        // Example 1 : A function that generates the next series of elements.
        var multiplesOfTwo = Stream.iterate(2, n -> n * 2).limit(5).collect(Collectors.toList());
        System.out.println(multiplesOfTwo);
        // Example 2 : Fibonacci  series
        // 0,1,1,2,3,5,8,13.............
        var fibanocciSeries =  Stream.iterate(new int[]{0,1}, fib -> new int[]{fib[1], fib[0]+fib[1]})
                .limit(15)
                .map(number -> number[0])
                .collect(Collectors.toList());
        System.out.println(fibanocciSeries);

        // 3. Using Stream.generate()
        // The Stream.generate() method creates an infinite stream using a Supplier.
        // Syntax : Stream.generate(Supplier<T>)

        // Example 1: Generating random numbers
        var randomNumbers = Stream.generate(() -> 2).limit(5).collect(Collectors.toList());
        System.out.println(randomNumbers);

        var generateHellos = Stream.generate(() -> "Hello").limit(5).collect(Collectors.toList());
        System.out.println(generateHellos);

        Stream.generate(UUID::randomUUID) // Generates random numbers from 0 to 99
                .limit(5)
                .forEach(System.out::println);

    }
}
