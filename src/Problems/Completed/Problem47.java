package Problems.Completed;

/**
 * Created by Pat111 on 2/25/2018.
 */
import Problems.ProblemBase;

import java.util.stream.*;

public class Problem47 extends ProblemBase {

    public static void main(String[] args) {

        IntStream intStream = IntStream.range(2, 1000000);
        intStream = intStream
                .filter(d -> primeFactors(d).size() == 4)
                .filter(d -> primeFactors(d + 1).size() == 4)
                .filter(d -> primeFactors(d + 2).size() == 4)
                .filter(d -> primeFactors(d + 3).size() == 4);

        intStream.min().ifPresent(System.out::println);
        System.out.println(primeFactors(5));
        System.out.println(primeFactors(234643));
        System.out.println();
    }
}
