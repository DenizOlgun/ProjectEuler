package Problems.Unfinished;

import Problems.ProblemBase;

import java.util.stream.IntStream;

/**
 * Created by Pat111 on 2/25/2018.
 */
public class Problem35 extends ProblemBase {

    public static int rotate(int i, int executions) {

        String result = String.valueOf(i);
        result = result.substring(executions) + result.substring(0, executions);
        return Integer.valueOf(result);
    }

    public static boolean isCircularPrime(int i) {

        for(int j = 0; j < String.valueOf(i).length(); j++) {

            if(!isPrime(rotate(i, j))) return false;
        }

        return true;
    }

    public static void main(String[] args) {

        IntStream intStream = IntStream.range(2, 1000000);
        System.out.println(intStream.filter(Problem35::isCircularPrime).count());
    }
}
