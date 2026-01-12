package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class mapsarrays {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        System.out.println("Using Lambda Expression:");
        numbers.stream().forEach(n -> System.out.println(n));

        System.out.println("Using Method Reference:");
        numbers.stream().forEach(System.out::println);


        System.out.println("Array to Stream Example:");
        int[] arr= {1,2,3,4};
        Arrays.asList(arr).stream().forEach(System.out::println);


        System.out.println("Stream.of Example:");
        Stream.of("A", "B", "C")
                .forEach(System.out::println);

        System.out.println("Filter Even Numbers Example:");
        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        System.out.println("Filter Odd Numbers Example:");
        List<Integer> odds = numbers.stream()
                .filter(n -> n % 2 != 0)
                .toList();

        class User{
            String name;
            int age;

            User(int age, String name){
                this.age = age;
                this.name = name;
            }

        }

        List<User> users = new ArrayList<>();
        users.add(new User(25, "Alice"));
        users.add(new User(30, "Bob"));
        System.out.println("Filter Users by Age > 18:");

        List<User> adults = users.stream()
                .filter(u -> u.age > 18)
                .toList();
        System.out.println(adults);


        System.out.println("Map to Squares Example:");
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .toList();

        System.out.println("Map Users to Names Example:");
        List<String> names = users.stream()
                .map(u -> u.name)
                .toList();

        //====================//==================//=============

    }
}
