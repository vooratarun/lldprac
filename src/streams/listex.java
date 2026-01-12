package streams;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class listex {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(10,20,10,40,50);
        System.out.println("Original List: " + numbers);

        List<Integer> list = numbers.stream().toList();
        System.out.println(list);

        Set<Integer> set = numbers.stream().collect(Collectors.toSet());
        System.out.println(set);
        System.out.println("Set size: " + set.size());


        class User{
            String name;
            int age;
            User(String name, int age){
                this.name = name;
                this.age = age;
            }
        }

        List<User> users = List.of(
                new User("Alice", 25),
                new User("Bob", 30),
                new User("Charlie", 35),
                new User("Alice2", 25)
        );

        Set<User> userSet = users.stream().collect(Collectors.toSet());
        Map<Integer,List<User>> usersByage = users.stream()
                .collect(Collectors.groupingBy(u -> u.age));
        System.out.println(usersByage);

        for (Map.Entry<Integer, List<User>> entry: usersByage.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            for (User u : entry.getValue()) {
                System.out.println(" - " + u.name);
            }
        }

        Map<Integer,Long> countByAge = users.stream().
                collect(
                        Collectors.groupingBy(
                                u -> u.age,
                                Collectors.counting()
                        )
                );

        System.out.println(countByAge);


    }
}
