import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Problem18Re {

    private static class Node {

        private Integer value;
        private List<Node> lower;
        private Node upper;

        public Node(int value) {

            this(value, null, Collections.emptyList());
        }

        public Node(int value, List<Node> lower) {

            this(value, null, lower);
        }

        public Node(int value, Node upper, List<Node> lower) {

            this.value = value;
            this.lower = lower;
            this.upper = upper;
        }

        public Node(int value, Node upper, Node... lower) {

            this.value = value;
            this.upper = upper;
            this.lower = Arrays.asList(lower);
        }

        public void resolveLower() {

            if(!this.lower.isEmpty()) lower.forEach(Node::resolveLower);

            this.value = value + Math.max(lower.get(0).value, lower.get(1).value);

            this.deleteLower();
        }

        public void resolveUpper() {

            if(this.upper != null) upper.resolveUpper();
            else return;

            this.upper.value = Math.max(this.upper.lower.get(0).value, this.upper.lower.get(1).value);
        }

        public Node neighbor() {

            return this == this.upper.lower.get(0) ? this.upper.lower.get(1) : this.upper.lower.get(0);
        }

        public void deleteLower() {

            this.lower.clear();
        }

        public static class NodeFactory {

            int[][] nodeData;


        }
    }

    private static class InputReader {

        Scanner input;

        public InputReader(String home) throws FileNotFoundException {

            this.input = new Scanner(new File(home));
        }

        public int[][] deserialize() {

            return
        }
    }
}
