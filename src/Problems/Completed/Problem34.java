package Problems.Completed;

/**
 * Created by Pat111 on 2/25/2018.
 */
import Problems.ProblemBase;

import java.util.stream.IntStream;
import java.util.function.*;

public class Problem34 extends ProblemBase {

    public static int reduceInt(int i, IntBinaryOperator op) {

        return toIntStream(i).reduce(0, op);
    }

    public static int factorial(int i) {

        int result = 1;
        for(int j = 1; j <= i; j++) result *= j;
        return result;
    }

    public static void main(String[] args) {

        IntStream intStream = IntStream.range(3, (int) Math.pow(10, 6))
                .filter(e -> reduceInt(e, (a, b) -> (int) (a + factorial(b))) == e);
        System.out.println(intStream.sum());
    }
}
