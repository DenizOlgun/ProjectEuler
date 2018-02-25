package Problems.Unfinished;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.HashMap;


public class Problem18 {

    static int[][] rows = {
    {75},
    {95, 64},
    {17, 47, 82},
    {18, 35, 87, 10},
    {20, 4, 82, 47, 65},
    {19, 1, 23, 75, 3, 34},
    {88, 2, 77, 73, 7, 63, 67},
    {99, 65, 4, 28, 6, 16, 70, 92},
    {41, 41, 26, 56, 83, 40, 80, 70, 33},
    {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
    {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
    {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
    {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
    {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
    {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23}};

    public static long navigateTree(String s) {

        String original = s;
        System.out.println("original " + original);
        System.out.println("original length " + original.length());
        long result = 0;
        int horizIndex = 0;
        int vertIndex = 0;
        try {
            while (!s.isEmpty()) {

                if (Math.max(horizIndex, vertIndex) > 15)
                    throw new RuntimeException("why" + horizIndex + " " + vertIndex + " " + s.length());
                if (s.charAt(0) == '0') {

                    int temp = rows[vertIndex++][horizIndex];
                    System.out.println(temp);
                    result += temp; //go to the left
                    //result += rows[vertIndex++][horizIndex]
                } else {

                    int temp = rows[vertIndex++][horizIndex++];
                    System.out.println(temp);
                    result += temp;
                    //result += rows[vertIndex++][horizIndex++]; //go to the right
                }

                s = s.length() > 1 ? s.substring(1) : "";
            }

        } catch (ClassCastException e) {

            System.out.println("Original " + original);
            System.out.println("Now " + s);
            System.out.println("Horizindex " + horizIndex);
            System.out.println("Vertindex " + vertIndex);
        }
        return result;
    }

    public static String toBinaryString(long l) {

        String s = "";
        String zeros = "000000000000000";
        try {
            s = Long.toBinaryString(l);
            s = zeros + s;
            s = s.substring(s.length() - zeros.length());
        } catch (ClassCastException e) {

            System.out.println("s " + s);
            System.out.println("s length " + s.length());
            System.out.println("zeros length " + zeros.length());
            System.out.println("l binary " + Long.toBinaryString(l));
            System.out.println("s.length + 1 " + (s.length() + 1));
        }

        if(s.length() != 14 && s.length() != 15) throw new Error(s + " " + s.length());
        return s;
    }

    public static ArrayDeque<Character> toArrayDeque(long l) {

        String binaryString = Long.toBinaryString(l);
        ArrayDeque<Character> result = new ArrayDeque<>();
        for(int i = 0; i<binaryString.length(); i++) result.add(binaryString.charAt(i));

        return result;
    }

    public static void main(String[] args) {

        long max = 0;
        for(long l = 0; l < Math.pow(2, rows.length - 1); l++) { //rows.length - 1 ?

            long temp = navigateTree(toBinaryString(l));
            if(temp > max) {max = temp; System.out.println(l); System.out.println(toBinaryString(l));}
        }

        System.out.println(navigateTree(toBinaryString(1)));
        System.out.println(navigateTree(toBinaryString(12924)));
        System.out.println(toBinaryString(12924));
        System.out.println(toBinaryString(12924).length());
        System.out.println(navigateTree("110010011111000"));
        System.out.println("The answer: " + max);
    }
}
