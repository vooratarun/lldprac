package lld.javastreams;

import java.util.*;
import java.util.stream.Collectors;

public class algo {

    class User {
        Long id;
       private final String email;

        // equals & hashCode based on email

        User(Long id, String email) {
            this.id = id;
            this.email = email;
        }

        public String getEmail() {
            return email;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User)) return false;
            User user = (User) o;
            return Objects.equals(email, user.email);
        }

        @Override
        public int hashCode() {
            return Objects.hash(email);
        }
    }

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


        Set<User> seen2 = new HashSet<>();
        List<User> users =  List.of(
                new algo().new User(1L,"tar@gmaill.com"),
                new algo().new User(2L, "ram@gmail.com"),
                new algo().new User(3L, "raj@gmail.com"),
                new algo().new User(3L, "raj@gmail.com")

        );

        Set<User> duplicates2 = users.stream()
                .filter(u -> !seen2.add(u))
                .collect(Collectors.toSet());

        for (User u : duplicates2) {
            System.out.println(u.email);
        }


        Map<String, Long> countByEmail =
                users.stream()
                        .collect(Collectors.groupingBy(
                                User::getEmail,
                                Collectors.counting()
                        ));

        List<String> duplicateEmails =
                countByEmail.entrySet().stream()
                        .filter(e -> e.getValue() > 1)
                        .map(Map.Entry::getKey)
                        .toList();
        System.out.println(duplicateEmails);

    }
}
