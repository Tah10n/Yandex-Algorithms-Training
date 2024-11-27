package Session4;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TaskB {
    public static void main(String[] args) throws IOException {
        System.out.println(printAllNodesWithDescendants(readInput("input.txt")));
    }

    public static class Input {
        int n;
        String[][] array;

        public Input(int n, String[][] array) {
            this.n = n;
            this.array = array;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(n).append("\n");
            for (int i = 0; i < n-1; i++) {
                stringBuilder.append(array[i][0]).append(" ").append(array[i][1]).append("\n");
            }
            return stringBuilder.toString();
        }
    }

    public static Input readInput(String input) throws IOException {
        BufferedReader reader = null;
        Scanner scanner = null;
        if (input.length() > 0) {
            if (input.startsWith("input")) {
                reader = new BufferedReader(new FileReader(input));
            } else {
                System.setIn(new ByteArrayInputStream(input.getBytes()));
                scanner = new Scanner(System.in);
            }

        } else {
            scanner = new Scanner(System.in);
        }
        int n = 0;
        String[][] array = null;

        if (reader != null) {
            String s1 = reader.readLine();
            n = Integer.parseInt(s1);

            array = new String[n-1][2];


            for (int i = 0; i < n-1; i++) {
                String[] s2 = reader.readLine().trim().split(" ");
                array[i][0] = s2[0];
                array[i][1] = s2[1];

            }

            reader.close();
        } else if (scanner != null) {
            n = scanner.nextInt();

            scanner.nextLine();

            array = new String[n-1][2];


            for (int i = 0; i < n-1; i++) {
                String[] s2 = scanner.nextLine().trim().split(" ");
                array[i][0] = s2[0];
                array[i][1] = s2[1];
            }

            scanner.close();
        }

        return new Input(n, array);
    }

    public static String printAllNodesWithDescendants(Input input) {
        StringBuilder stringBuilder = new StringBuilder();

        int n = input.n;
        String[][] array = input.array;

        Map<String, Node> map = new TreeMap<>();

        for (int i = 0; i < n-1; i++) {
            String keyChild = array[i][0];
            String keyParent = array[i][1];

            Node child = map.get(keyChild);
            if(!map.containsKey(keyChild)) {
                child = new Node(keyChild);
            }

            Node parent = map.get(keyParent);
            if(!map.containsKey(keyParent)) {
                parent = new Node(keyParent);
            }

            child.parent = parent;
            parent.childrens.add(child);

            map.put(keyChild, child);
            map.put(keyParent, parent);
        }

        Node root = null;
        for (Node node : map.values()) {
            if(node.parent == null) {
                root = node;
                break;
            }
        }

        treeTraverseAndCountDescendants(root);

        for (Node node : map.values()) {
            stringBuilder.append(node.key).append(" ").append(node.descendants).append("\n");
        }

        return stringBuilder.toString();
    }

    public static int treeTraverseAndCountDescendants(Node root) {

        if(root.childrens.isEmpty()) {
            return 0;
        }
        root.descendants = root.childrens.size();

        for(Node node : root.childrens) {

            root.descendants += treeTraverseAndCountDescendants(node);
        }
        return root.descendants;
    }

    public static class Node {
        String key;
        Node parent;
        List<Node> childrens;
        int descendants = 0;

        public Node(String key) {
            this.key = key;
            childrens = new ArrayList<>();

        }
    }
}
