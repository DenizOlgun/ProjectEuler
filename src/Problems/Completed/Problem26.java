package Problems.Completed;

import Problems.ProblemBase;

import java.math.BigInteger;
import java.util.stream.IntStream;

/**
 * Created by Pat111 on 2/26/2018.
 */
public class Problem26 extends ProblemBase {

    public static int reciprocalRepetition(int i) {

        /*
        * here, we don't care about the values divisible by 2 or 5, since they are expressed in their lower-value counterparts
        * technically, it's the wrong value, but we only care about the maximum value, so these are useless
        */

        if(divides(i, 2) || divides(i, 5)) return -1;
        return multiplicativeOrder(i);
    }

    //see: https://en.wikipedia.org/wiki/Multiplicative_order
    //finds the minimum exponent for which 10^exp is congruent to 1 mod i
    public static int multiplicativeOrder(int i) {

        BigInteger input = new BigInteger(String.valueOf(i));
        BigInteger exponent = BigInteger.ONE;
        while(true) {

            if(BigInteger.TEN.modPow(exponent, input).equals(BigInteger.ONE)) break;
            exponent = exponent.add(BigInteger.ONE);
        }

        return exponent.intValue();
    }

    public static void main(String[] args) {

        IntStream intStream = IntStream.range(2, 1000);
        System.out.println(intStream.reduce((a, b) ->

                reciprocalRepetition(a) > reciprocalRepetition(b) ?
                    a
                    :
                    b
        ).getAsInt());
    }
}
