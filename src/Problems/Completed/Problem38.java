package Problems.Completed;

import Problems.ProblemBase;

import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * Created by Pat111 on 3/19/2018.
 */
public class Problem38 extends ProblemBase {

    public static OptionalInt pandigitalConcatenation(int i) {

        String result = "";

        for(int j = 1; result.length() < 9; j++) {

            result = result.concat(String.valueOf(i * j));
        }

        //if result.length is greater than 9, or if result isn't pandigital, then return OptionalInt.empty()
        if(result.length() > 9) return OptionalInt.empty();
        int resultAsInt = Integer.valueOf(result);
        return result.length() == 9 && isPandigital(resultAsInt) ? OptionalInt.of(resultAsInt) : OptionalInt.empty();
    }

    public static void main(String... args) {

        IntStream intStream = IntStream.range(2, 10000);
        intStream = intStream.map(e -> pandigitalConcatenation(e).orElse(-1));
        System.out.println(intStream.max().getAsInt());
    }
}
