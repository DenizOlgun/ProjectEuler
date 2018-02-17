import java.io.File;
import java.util.*;

public class Problem22 {

    public static Map<Character, Integer> characterIntegerMap = new HashMap<>();

    static ArrayList<String> names = new ArrayList<>();
    static Scanner inFile;

    static {
        try {

            inFile = new Scanner(new File("p022_names.txt"));
            inFile.useDelimiter("\",\"");

            while (inFile.hasNext()) {

                names.add(inFile.next());
            }

            names.sort(Comparator.naturalOrder());
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            inFile.close();
        }

        characterIntegerMap.put('A', 1);
        characterIntegerMap.put('B', 2);
        characterIntegerMap.put('C', 3);
        characterIntegerMap.put('D', 4);
        characterIntegerMap.put('E', 5);
        characterIntegerMap.put('F', 6);
        characterIntegerMap.put('G', 7);
        characterIntegerMap.put('H', 8);
        characterIntegerMap.put('I', 9);
        characterIntegerMap.put('J', 10);
        characterIntegerMap.put('K', 11);
        characterIntegerMap.put('L', 12);
        characterIntegerMap.put('M', 13);
        characterIntegerMap.put('N', 14);
        characterIntegerMap.put('O', 15);
        characterIntegerMap.put('P', 16);
        characterIntegerMap.put('Q', 17);
        characterIntegerMap.put('R', 18);
        characterIntegerMap.put('S', 19);
        characterIntegerMap.put('T', 20);
        characterIntegerMap.put('U', 21);
        characterIntegerMap.put('V', 22);
        characterIntegerMap.put('W', 23);
        characterIntegerMap.put('X', 24);
        characterIntegerMap.put('Y', 25);
        characterIntegerMap.put('Z', 26);
    }

    public static int score(String subject, int index) {

        int result = 0;
        for(Character c : subject.toCharArray()) result += characterIntegerMap.get(c);
        return result * index;
    }

    public static void main(String[] args) {

        ArrayList<Integer> scores = new ArrayList<>();
        names.forEach(e -> scores.add(score(e, names.indexOf(e) + 1)));

        System.out.println(scores.stream().mapToLong(Integer::longValue).sum());
    }
}
