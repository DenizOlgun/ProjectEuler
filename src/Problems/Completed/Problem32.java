package Problems.Completed;

import Problems.ProblemBase;

import java.util.stream.IntStream;

/**
 * Created by Pat111 on 3/19/2018.
 */
public class Problem32 extends ProblemBase {

    public static long concat(int... ints) {

        StringBuilder result = new StringBuilder("");
        for(int i : ints) {

            result.append(i);
        }

        return Long.valueOf(result.toString());
    }

    public static boolean isPanProduct(int i) {

        for(int j = 1; j <= Math.sqrt(i); j++) {

            if(divides(i, j)) {

                //is a 1-9 pandigital, b/c the length is > 8, and it's pandigital
                if(isPandigital(concat(j, i / j, i)) && concat(j, i /j, i) > 99999999) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        IntStream intStream = IntStream.range(2, 10000);
        intStream = intStream.filter(Problem32::isPanProduct);
        System.out.println(intStream.sum());
    }
}
