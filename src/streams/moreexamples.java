package streams;

import java.util.List;
import java.util.Optional;

public class moreexamples {
    public static void main(String[] args) {
        System.out.println("More examples in streams package: sorts, flatmaps, reduce");


        List<Integer> numbers = List.of(10,20,10,40,50);
        Optional<Integer> first = numbers.stream()
                .findFirst();

        System.out.println(first);

        Optional<Integer> any = numbers.stream()
                .findAny();
        System.out.println(any);

        // match examples
        boolean allGreaterThan5 = numbers.stream()
                .allMatch(n -> n > 5);

        boolean allEven = numbers.stream()
                .allMatch(n-> n % 2 == 0);
        System.out.println("All greater than 5: " + allGreaterThan5);
        System.out.println("All even: " + allEven);

        boolean allOdd = numbers.stream()
                .allMatch(n-> n % 2 != 0);
        System.out.println("All odd: " + allOdd);


        boolean nonNegative = numbers.stream()
                .noneMatch(n -> n < 0);
        System.out.println("All non-negative: " + nonNegative);

        numbers.parallelStream()
                .forEach(System.out::println);


    }
}
