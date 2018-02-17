import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Stream;

public class Problem21 {

    public static boolean divides(double d1, double d2) {

        double temp = d1/d2;
        return temp == Math.rint(temp);
    }

    public static HashSet<Integer> divisors(double d) {

        HashSet<Integer> temp = new HashSet<>();
        HashSet<Integer> divisors = new HashSet<>();
        divisors.add(1);

        double upper = Math.sqrt(d);
        for(int j = 2; j <= upper; j++) if(divides(d, j)) temp.add(j);

        divisors.addAll(temp); //copying over our main divisors
        temp.forEach(e -> divisors.add((int) (d/e))); //adding the less dense half of divisors
        return divisors;
    }

    public static double divisorsSum(double d) {

        Set<Integer> divisors = divisors(d);
        return divisors.stream().mapToDouble(Integer::longValue).sum(); //converts Set to Stream to DoubleStream, then calls sum()
    }

    public static boolean isAmicable(double d) {

        double divSum = divisorsSum(d);
        if(divSum == d) return false;
        else return divisorsSum(divSum) == d;
    }
    
    public static void main(String[] args) {

        Stream<Integer> integerStream = Stream.iterate(1, i -> i + 1).limit(10000); //range from 1 to 10000
        integerStream = integerStream.filter(Problem21::isAmicable);
        //integerStream.forEach(System.out::println);

        LongAdder longAdder = new LongAdder();
        integerStream.forEach(longAdder::add);
        System.out.println(longAdder.longValue()); //since we add the pairs to each other twice, we divide out the extra
    }
}
