import java.util.stream.Stream;

public class Problem28 {

    public static int nextDiagNum(int last) {

        if(last < 9) return last + 2;
        double dif = Math.sqrt(last);
        dif = 2*Math.ceil(dif/2d);
        System.out.println(last + " " + dif);
        return (int) (last + dif);
    }

    public static void main(String[] args) {

        Stream<Integer> integerStream = Stream.iterate(1, Problem28::nextDiagNum)
                .limit(2*5 - 1);
        integerStream.reduce((a, b) -> a+b);
        //integerStream.forEach(System.out::println);

        //System.out.println(integerStream.mapToLong(Integer::longValue).sum());
    }
}
