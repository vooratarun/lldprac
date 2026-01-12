package streams;

import java.util.*;
import java.util.stream.Collectors;

public class algo {
    public static void main(String[] args) {

        List<Integer> numbers  = List.of(10,20,10,40,50,45);

        Set<Integer> seen = new HashSet<>();

        Set<Integer> duplicates = numbers.stream()
                .filter(n-> !seen.add(n))
                .collect(Collectors.toSet());

        System.out.println(duplicates);

        int secondMax = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow();

        System.out.println(secondMax);


        List<String> words = List.of("apple", "banana", "banana", "apricot", "blueberry", "cherry");
        String longestWord = words.stream()
                .max(Comparator.comparingInt(String::length))
                .orElseThrow();
        System.out.println(longestWord);


        Map<String, Long > freqMap = words.stream()
                .collect(Collectors.groupingBy(
                        w -> w,
                        Collectors.counting()
                ));
        System.out.println(freqMap);

        Map<Boolean, List<Integer>> partitioned =
                numbers.stream()
                        .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(partitioned);

    }
}
