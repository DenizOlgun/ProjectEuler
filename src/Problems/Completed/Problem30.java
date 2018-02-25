package Problems.Completed;

/**
 * Created by Pat111 on 2/25/2018.
 */
import Problems.ProblemBase;

import java.util.stream.IntStream;
import java.util.function.*;

public class Problem30 extends ProblemBase {

    public static int reduceInt(int i, IntBinaryOperator op) {

        return toIntStream(i).reduce(0, op);
    }

    public static void main(String[] args) {

        IntStream intStream = IntStream.range(2, (int) Math.pow(10, 6))
                .filter(e -> reduceInt(e, (a, b) -> (int) (a + Math.pow(b, 5))) == e);

        System.out.println(intStream.sum());
    }
}
