package Java8.a18_optional;

import java.util.Optional;

public class OptionalExamples {

    public static void main(String[] args) {
        // 1️⃣ empty() - Creates an empty Optional
        Optional<String> emptyOptional = Optional.empty();
        System.out.println("Empty Optional: " + emptyOptional);

        // 2️⃣ of() - Creates an Optional with a non-null value (throws exception if null)
        Optional<String> name = Optional.of("Java 8");
        System.out.println("Optional.of(): " + name);

        // 3️⃣ ofNullable() - Creates an Optional that allows null values
        Optional<String> nullableOptional = Optional.ofNullable(null);
        System.out.println("Optional.ofNullable(null): " + nullableOptional);

        // 4️⃣ isPresent() - Checks if a value is present
        System.out.println("Is value present? " + name.isPresent());

        // 5️⃣ ifPresent() - Executes the lambda if value is present
        name.ifPresent(n -> System.out.println("Value is present: " + n));

        // 6️⃣ orElse() - Returns value if present, otherwise returns a default value
        String result1 = nullableOptional.orElse("Default Value");
        System.out.println("orElse(): " + result1);

        // 7️⃣ orElseGet() - Returns value if present, otherwise calls a supplier function
        String result2 = nullableOptional.orElseGet(() -> "Computed Default Value");
        System.out.println("orElseGet(): " + result2);

        // 8️⃣ orElseThrow() - Throws an exception if value is not present
        try {
            String result3 = nullableOptional.orElseThrow(() -> new IllegalArgumentException("Value not found"));
            System.out.println("orElseThrow(): " + result3);
        } catch (Exception e) {
            System.out.println("Exception in orElseThrow(): " + e.getMessage());
        }

        // 9️⃣ map() - Transforms value if present, otherwise returns empty Optional
        Optional<Integer> lengthOptional = name.map(String::length);
        System.out.println("map(): " + lengthOptional);

        // 🔟 flatMap() - Similar to map(), but flattens the Optional result
        Optional<Optional<Integer>> nestedOptional = Optional.of(Optional.of(100));
        Optional<Integer> flattened = nestedOptional.flatMap(opt -> opt);
        System.out.println("flatMap(): " + flattened);

        // 1️⃣1️⃣ filter() - Filters the value based on a condition
        Optional<String> filtered = name.filter(n -> n.startsWith("Java"));
        System.out.println("filter(): " + filtered);

        Optional<String> filteredFail = name.filter(n -> n.startsWith("Python"));
        System.out.println("filter() no match: " + filteredFail);
    }
}
