package Session4;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TaskE {
    public static void main(String[] args) throws IOException {
        System.out.println(printTreeSizes(readInput("input.txt")));
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
        int[][] array = null;

        if (reader != null) {
            String s1 = reader.readLine();
            n = Integer.parseInt(s1);

            array = new int[n - 1][2];


            for (int i = 0; i < n - 1; i++) {
                String[] s2 = reader.readLine().trim().split(" ");
                array[i][0] = Integer.parseInt(s2[0]);
                array[i][1] = Integer.parseInt(s2[1]);

            }

            reader.close();
        } else if (scanner != null) {
            n = scanner.nextInt();

            scanner.nextLine();

            array = new int[n - 1][2];


            for (int i = 0; i < n - 1; i++) {
                String[] s2 = scanner.nextLine().trim().split(" ");
                array[i][0] = Integer.parseInt(s2[0]);
                array[i][1] = Integer.parseInt(s2[1]);
            }

            scanner.close();
        }

        return new Input(n, array);
    }

    public static String printTreeSizes(Input input) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = input.n;
        int[][] array = input.array;
        Map<Integer, Node> map = new TreeMap<>();
        List<Pair> list = new ArrayList<>();
        Deque<Pair> queue = new ArrayDeque<>();

        for (int i = 0; i < n - 1; i++) {
            int key1 = array[i][0];
            int key2 = array[i][1];

            list.add(new Pair(key1, key2));
        }

        list.sort(Comparator.comparing(o -> o.key1));

        queue.addAll(list);

        while (!queue.isEmpty()) {
            Pair pair = queue.pollFirst();

//            if(!map.containsKey(pair.key1) && !map.containsKey(pair.key2)) {
//                queue.add(pair);
//            }
            if (pair.key1 == 1) {
                Node node1 = map.containsKey(pair.key1) ? map.get(pair.key1) : new Node(pair.key1);
                Node node2 = map.containsKey(pair.key2) ? map.get(pair.key2) : new Node(pair.key2);

                node1.childrens.add(node2);
                node2.parent = node1;
                map.put(pair.key1, node1);
                map.put(pair.key2, node2);
            } else if (map.containsKey(pair.key1)) {
                Node node1 = map.containsKey(pair.key1) ? map.get(pair.key1) : new Node(pair.key1);
                Node node2 = map.containsKey(pair.key2) ? map.get(pair.key2) : new Node(pair.key2);

                node1.childrens.add(node2);
                node2.parent = node1;
                map.put(pair.key1, node1);
                map.put(pair.key2, node2);

            } else if (map.containsKey(pair.key2)) {
                Node node1 = map.containsKey(pair.key1) ? map.get(pair.key1) : new Node(pair.key1);
                Node node2 = map.get(pair.key2);
                node2.childrens.add(node1);
                node1.parent = node2;
                map.put(pair.key1, node1);
                map.put(pair.key2, node2);
            } else {
                queue.add(pair);
            }

        }

        Node root = map.get(1);
        treeTraverseAndCountDescendants(root);
        for (Node node : map.values()) {
            stringBuilder.append(node.descendants + 1).append(" ");
        }
        return stringBuilder.toString();
    }

    public static int treeTraverseAndCountDescendants(Node root) {

        if (root.childrens.isEmpty() || root == null) {
            return 0;
        }
        root.descendants = root.childrens.size();

        for (Node node : root.childrens) {

            root.descendants += treeTraverseAndCountDescendants(node);
        }
        return root.descendants;
    }

    public static class Input {
        int n;
        int[][] array;

        public Input(int n, int[][] array) {
            this.n = n;
            this.array = array;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(n).append("\n");
            for (int i = 0; i < n - 1; i++) {
                stringBuilder.append(array[i][0]).append(" ").append(array[i][1]).append("\n");
            }
            return stringBuilder.toString();
        }
    }

    public static class Node {
        Integer key;
        Node parent;
        List<Node> childrens;
        int descendants = 0;

        public Node(Integer key) {
            this.key = key;
            childrens = new ArrayList<>();
        }
    }

    public static class Pair {
        int key1;
        int key2;

        public Pair(int key1, int key2) {
            if (key1 > key2) {
                int temp = key1;
                key1 = key2;
                key2 = temp;
            }
            this.key1 = key1;
            this.key2 = key2;
        }
    }
}
