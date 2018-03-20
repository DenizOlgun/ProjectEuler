package Problems.Completed;

import Problems.ProblemBase;

import java.util.stream.IntStream;

/**
 * Created by Pat111 on 3/19/2018.
 */
public class Problem39 extends ProblemBase {

    //returns the number of integer-sided right triangles with the given perimeter
    public static int numSols(int perimeter) {

        int result = 0;
        for(int a = 1; a < perimeter/3d; a++) {

            double b = (double) perimeter*(2*a - perimeter)/(2*(a - perimeter));
            if(isWhole(b)) result++;
        }
        
        return result;
    }

    public static void main(String[] args) {

        IntStream intStream = IntStream.range(2, 1000);
        System.out.println(intStream.reduce((a, b) -> numSols(a) > numSols(b) ? a : b));
    }
}
