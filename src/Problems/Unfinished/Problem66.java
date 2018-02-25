package Problems.Unfinished;

import Problems.ProblemBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Problem66 extends ProblemBase {

    static ArrayList<Double> squareEndings = new ArrayList<>();
    static {

        squareEndings.add(0d);
        squareEndings.add(1d);
        squareEndings.add(4d);
        squareEndings.add(5d);
        squareEndings.add(6d);
        squareEndings.add(9d);
    }

    static volatile double D = 1;
    static volatile double y = 1;

    static final ExecutorService executor = Executors.newFixedThreadPool(5); // it's just an arbitrary number
    static final List<Future<?>> futures = new ArrayList<>();

    static ArrayList<Double> results = new ArrayList<>();
    public static void main(String[] args) {

        A: for(D = 2; D <= 1000 && !isPerfectSquare((long) D); D++) {

                //double xSquared;
                double temp = D;
                Future<?> future = executor.submit(() -> {

                    for (y = 1;; y++) {

                        double xSquared;
                        xSquared = (temp * y * y) + 1;
                        if (isPerfectSquare((long) xSquared)) {

                            double x = Math.sqrt(xSquared);
                            System.out.println("x: " + x + "\ny: " + y + "\nD: " + temp + "\n");
                            return x;
                        }
                    }
                });
        }


            futures.forEach(f -> {

                try{
                    System.out.println("wat " + f.get());
                }
                catch (Exception e) {}
            });
//        String result = String.format("%.0f", Collections.max(results));
       // System.out.println("The answer: " + result);
    }
}
