package Problems.Completed;

import Problems.ProblemBase;

public class Problem25 extends ProblemBase{

    public static void main(String[] args) {

        for(int i = 2;; i++) {

            if(fib(i).toString().length() == 1000) {

                System.out.println(i);
                System.out.println(fib(i));
                System.out.println(fib(i).toString().length());
                break;
            }
        }
    }
}
