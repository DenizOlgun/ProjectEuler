import java.math.BigInteger;

public class Problem25 {

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

    public static void main(String[] args) {

        for(int i = 2;; i++) {

            //System.out.println(fib(i));
            if(fib(i).toString().length() == 1000) {

                System.out.println(i);
                System.out.println(fib(i));
                System.out.println(fib(i).toString().length());
                break;
            }
        }
    }
}
