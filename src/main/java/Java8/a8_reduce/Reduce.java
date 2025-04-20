package Java8.a8_reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reduce {

    public static void main(String[] args) {
        // Type 1 :
        // T reduce(T identity, BinaryOperator<T> accumulator)
        // identity → Initial value (starting point).
        // accumulator → A function that combines two elements.

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        var sum = numbers.stream().reduce(0, (a,b) -> a+b);
        System.out.println(sum);

        var product = numbers.stream().reduce(1, (a,b)-> a*b);
        System.out.println(product);

        // Type 2 :
        // 2. reduce(accumulator) (Returns Optional<T>)
        // No identity value is provided.
        // Returns Optional<T>, so it can be empty if the stream is empty.

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        // Find max
        Optional<Integer> max = nums.stream().reduce((a, b) -> a > b ? a : b);
        System.out.println(max.orElse(-1));
        Optional<Integer> min =  nums.stream().reduce((a,b) -> a < b ? a : b);
        System.out.println(min.orElse(-1));

        // Type 3 : reduce(identity, accumulator, combiner) (For Parallel Streams)

        // <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)
        // identity → Initial value.
        //accumulator → Function to accumulate elements.
        //combiner → Used for parallel processing (merges partial results).

        List<Integer> numbers1 = Arrays.asList(10, 20, 30, 40, 50);
        int sumWithParallel = numbers1.parallelStream()
                .reduce(0, (a, b) -> a + b, Integer::sum);

        System.out.println(sumWithParallel); // Output: 150

    }
}
