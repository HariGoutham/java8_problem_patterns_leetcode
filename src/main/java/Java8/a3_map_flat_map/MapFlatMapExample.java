package Java8.a3_map_flat_map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapFlatMapExample {
    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
                "Java is powerful",
                "Powerful Java streams",
                "Streams are useful in Java"
        );

        System.out.println(sentences.stream().map(sentence -> sentence.toLowerCase().split(" "))
                .flatMap(Stream::of)
                .distinct()
                .collect(Collectors.toList()));

        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d"),
                Arrays.asList("e", "f")
        );

        Stream<String> flattenedStream = listOfLists.stream()
                .flatMap(element -> Stream.of(element.get(0)));

        flattenedStream.forEach(System.out::println);
    }
}
