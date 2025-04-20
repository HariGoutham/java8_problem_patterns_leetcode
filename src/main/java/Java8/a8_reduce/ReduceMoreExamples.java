package Java8.a8_reduce;

import java.util.*;

public class ReduceMoreExamples {
    public static void main(String[] args) {
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(3, 4, 5, 6, 7),
                Arrays.asList(4, 5, 6, 7, 8)
        );
        var finalSet = listOfLists.stream().map(HashSet::new)
                .reduce((set1, set2) -> {
                    set1.retainAll(set2);
                    return set1;
                }).orElse(new HashSet<>());
        var finalList = finalSet.stream().toList();
        System.out.println(finalList);
    }

}
