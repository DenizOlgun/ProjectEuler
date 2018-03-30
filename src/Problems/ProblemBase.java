package Problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.Iterator;
import java.util.*;

/**
 * Created by Pat111 on 2/25/2018.
 */
public class ProblemBase {

    public static boolean divides(double d1, double d2) {

        return isWhole(d1/d2);
    }

    public static HashSet<Integer> properDivisors(double d) {

        HashSet<Integer> temp = new HashSet<>();
        HashSet<Integer> divisors = new HashSet<>();
        divisors.add(1);

        double upper = Math.sqrt(d);
        for(int j = 2; j <= upper; j++) if(divides(d, j)) temp.add(j);

        divisors.addAll(temp); //copying over our main properDivisors
        temp.forEach(e -> divisors.add((int) (d/e))); //adding the less dense half of properDivisors
        return divisors;
    }

    public static HashSet<Integer> divisors(double d) {

        HashSet<Integer> temp = new HashSet<>();
        HashSet<Integer> divisors = new HashSet<>();
        divisors.add(1);

        double upper = Math.sqrt(d);
        for(int j = 2; j <= upper; j++) if(divides(d, j)) temp.add(j);

        divisors.addAll(temp); //copying over our main properDivisors
        temp.forEach(e -> divisors.add((int) (d/e))); //adding the less dense half of properDivisors
        temp.add((int) d);
        return divisors;
    }

    public static BigInteger fib(double d) { //can't do with induction because of StackOverflow

        BigInteger result = new BigInteger("1");
        BigInteger previous = new BigInteger("1");
        BigInteger temp;
        while(d > 2) {

            temp = result;
            result = result.add(previous);
            previous = temp;
            d--;
        }

        return result;
    }

    //Stolen from https://stackoverflow.com/questions/295579/fastest-way-to-determine-if-an-integers-square-root-is-an-integer
    public static boolean isPerfectSquare(long n)
    {
        if (n < 0)
            return false;

        switch((int)(n & 0x3F))
        {
            case 0x00: case 0x01: case 0x04: case 0x09: case 0x10: case 0x11:
            case 0x19: case 0x21: case 0x24: case 0x29: case 0x31: case 0x39:
            long sqrt;
            if(n < 410881L)
            {
                //John Carmack hack, converted to Java.
                // See: http://www.codemaestro.com/reviews/9
                int i;
                float x2, y;

                x2 = n * 0.5F;
                y  = n;
                i  = Float.floatToRawIntBits(y);
                i  = 0x5f3759df - ( i >> 1 );
                y  = Float.intBitsToFloat(i);
                y  = y * ( 1.5F - ( x2 * y * y ) );

                sqrt = (long)(1.0F/y);
            }
            else
            {
                //Carmack hack gives incorrect answer for n >= 410881.
                sqrt = (long)Math.sqrt(n);
            }
            return sqrt*sqrt == n;

            default:
                return false;
        }
    }

    public static IntStream toIntStream(int i) {

        return String.valueOf(i).chars().map(e -> e - '0');
    }

    public static LongStream toLongStream(long l) {

        return String.valueOf(l).chars().mapToLong(e -> e - '0');
    }

    public static int factorial(int i) {

        int result = 1;
        for(int j = 1; j <= i; j++) result *= j;
        return result;
    }

    public static boolean isWhole(double d) {

        return Math.rint(d) == d;
    }

    //TODO: improve complexity using recursion
    public static boolean isPrime(double d) {

        for(double i = 2; i <= Math.sqrt(d); i++) {

            if(isWhole(d/i)) return false;
        }

        return true;
    }

    public static HashSet<Double> primeFactors(double d) {

        return primeFactors(d, new HashSet<>());
    }

    //TODO: improve complexity?
    public static HashSet<Double> primeFactors(double d, HashSet<Double> factors) {

        if(isPrime(d)) {

            factors.add(d);
            return factors;
        }

        double i = !factors.isEmpty() ? Collections.max(factors) : 2;
        for(; i <= Math.sqrt(d); i++) {

            if(isWhole(d/i)) {

                factors.add(i);
                return primeFactors(d/i, factors);
            }
        }

        return null;
    }

    public static ArrayList<Long> primeFactorsDup(long l) {

        return primeFactorsDup(l, new ArrayList<>());
    }

    //TODO: improve complexity?
    public static ArrayList<Long> primeFactorsDup(long l, ArrayList<Long> factors) {

        if(isPrime(l)) {

            factors.add(l);
            return factors;
        }

        for(long j = 2; j <= Math.sqrt(l); j++) {

            if(isWhole(l/j)) {

                factors.add(j);
                return primeFactorsDup(l/j, factors);
            }
        }

        return null;
    }

    //returns the set of prime factors, with duplicity, of a perfect power
    public static ArrayList<Long> primeFactorsDup(long base, long exp) {

        ArrayList<Long> factorization = primeFactorsDup(base);
        ArrayList<Long> result = new ArrayList<>();

        //duplicates 'factorization' 'exp' number of times and adds it to 'result', then returns the value
        IntStream.range(0, (int) exp).forEach(e -> result.addAll(factorization));
        return result;
    }

    public static boolean isPandigital(long l) {

        //ensures that the largest digit is no longer than the length of the number
        if(!(toLongStream(l).max().getAsLong() == String.valueOf(l).length())) return false;

        //ensures that none of the digits are 0
        if(String.valueOf(l).contains("0")) return false;

        //ensures that all digits are distinct
        return equalStreams(toLongStream(l).boxed(), toLongStream(l).distinct().boxed());
    }

    public static boolean equalStreams(Stream<?>...streams) {
        List<Iterator<?>>is = Arrays.stream(streams).map(Stream::iterator).collect(Collectors.toList());
        while(is.stream().allMatch(Iterator::hasNext))
            if(is.stream().map(Iterator::next).distinct().limit(2).count()>1) return false;
        return is.stream().noneMatch(Iterator::hasNext);
    }
}
