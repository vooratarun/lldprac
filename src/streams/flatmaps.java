package streams;

import java.net.SocketOption;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class flatmaps {

    public static void main(String[] args) {

        List<List<Integer>> list = List.of(
                List.of(1,2,3),
                List.of(4,5,6),
                List.of(7,8,9)
        );

        System.out.println(list);
        List<Integer> flatList = list.stream()
                .flatMap(List::stream)
                .toList();

        System.out.println(flatList);

        List<String> sentences = List.of(
                "Hello World",
                "FlatMap in Java"
        );

        List<String> words = sentences.stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .toList();

        System.out.println(words);
    }
}
