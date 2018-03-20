package Problems.Completed;

import Problems.ProblemBase;

import java.util.stream.IntStream;

/**
 * Created by Pat111 on 3/19/2018.
 */
public class Problem23 extends ProblemBase {

    public static boolean isAbundant(int i) {

        return divisors(i).stream().mapToInt(e -> e).sum() > i;
    }

    public static boolean abundantSum(int i) {

        for(int j = 1; j <= i/2; j++) {

            if(isAbundant(j) && isAbundant(i - j)) return true;
        }

        return false;
    }

    public static void main(String[] args) {

        IntStream intStream = IntStream.iterate(1, i -> i + 1).limit(30000);
        System.out.println(abundantSum(24));
        System.out.println(intStream.filter(e -> !abundantSum(e)).sum());
    }
}