package Problems.Completed;

import Problems.ProblemBase;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Pat111 on 3/11/2018.
 */
public class Problem29 extends ProblemBase {

    public static void main(String... args) {

        ArrayList<ArrayList<Integer>> vals = new ArrayList<>();
        for(int base = 2; base <= 100; base++) {

            for(int exp = 2; exp <= 100; exp++) {

                vals.add(primeFactorsDup(base, exp));
            }
        }

        vals.forEach(e -> e.sort(Comparator.naturalOrder())); //I have no idea why this is necessary, but the code breaks without it
        System.out.println(vals.stream().distinct().count());
    }
}
