package streams;

import java.util.Arrays;
import java.util.List;

public class reduce {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        int sum = numbers.stream()
                .reduce(0,(a,b)->(a+b));

        int sum2 = numbers.stream()
                .reduce(0,Integer::sum);
        System.out.println("Sum: " + sum);
        System.out.println("Sum: " + sum2);

        int max = numbers.stream().reduce(Integer::max).orElseThrow();
        System.out.println("Max: " + max);

    }
}
