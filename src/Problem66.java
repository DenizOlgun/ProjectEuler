import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Problem66 {

    static ArrayList<Double> squareEndings = new ArrayList<>();
    static {

        squareEndings.add(0d);
        squareEndings.add(1d);
        squareEndings.add(4d);
        squareEndings.add(5d);
        squareEndings.add(6d);
        squareEndings.add(9d);
    }

    public static boolean isSquare(double d) {

        if(squareEndings.contains(d % 10)) return false;
        double sqrt = Math.sqrt(d);
        return sqrt == Math.rint(sqrt);
    }
    
    double D = 1;
    double y = 1;

    static ArrayList<Double> results = new ArrayList<>();
    public static void main(String[] args) {

        A: for(double D = 2; D <= 1000 && !isSquare(D); D++) {

                double xSquared;
                for (int y = 1;; y++) {

                    xSquared = (D * y * y) + 1;
                    if (isSquare(xSquared)) {

                        double x = Math.sqrt(xSquared);
                        System.out.println("x: " + x + "\ny: " + y + "\nD: " + D + "\n");
                        results.add(x);
                        continue A;
                    }
                }
        }

        String result = String.format("%.0f", Collections.max(results));
        System.out.println("The answer: " + result);
    }
}
