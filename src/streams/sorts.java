package streams;

import java.util.Comparator;
import java.util.List;

public class sorts {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1,24,39,14,25);

        System.out.println("Original List: " + numbers);
        List<Integer> sortedAsc = numbers.stream()
                .sorted()
                .toList();

        System.out.println("Sorted Ascending: " + sortedAsc);



        List<Integer> sortedDesc = numbers.stream()
                .sorted((a,b) -> b - a)
                .toList();
        System.out.println("Sorted Descending: " + sortedDesc);

        class User{
            int age;
            String name;
            User(int age, String name){
                this.age = age;
                this.name = name;
            }
        }

        List<User> users = List.of(
                new User(30, "Bob"),
                new User(25, "Alice"),
                new User(35, "Charlie")
        );

        List<User> sortedByAge = users.stream()
                .sorted(Comparator.comparingInt(u -> u.age))
                .toList();

        System.out.println("Users sorted by age:");

        for (User u : sortedByAge) {
            System.out.println(u.name + " - " + u.age);
        }
    }

}
