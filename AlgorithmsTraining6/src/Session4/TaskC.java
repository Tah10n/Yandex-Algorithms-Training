package Session4;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TaskC {
    public static void main(String[] args) throws IOException {
        System.out.println(printLCA(readInput("input.txt")));

    }

    public static class Input {
        int n;
        String[][] array;
        List<String> requests;

        public Input(int n, String[][] array, List<String> requests) {
            this.n = n;
            this.array = array;
            this.requests = requests;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(n).append("\n");
            for (int i = 0; i < n-1; i++) {
                stringBuilder.append(array[i][0]).append(" ").append(array[i][1]).append("\n");
            }
            for (int i = 0; i < requests.size(); i++) {
                stringBuilder.append(requests.get(i)).append("\n");
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
        List<String> requests = new ArrayList<>();

        if (reader != null) {
            String s1 = reader.readLine();
            n = Integer.parseInt(s1);

            array = new String[n-1][2];

            for (int i = 0; i < n-1; i++) {
                String[] s2 = reader.readLine().trim().split(" ");
                array[i][0] = s2[0];
                array[i][1] = s2[1];

            }

            requests = new ArrayList<>();
            while (reader.ready()) {
                String s3 = reader.readLine();
                requests.add(s3);
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
            requests = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String s3 = scanner.nextLine();
                requests.add(s3);
            }


            scanner.close();
        }

        return new Input(n, array, requests);
    }

    public static String printLCA(Input input) {
        StringBuilder stringBuilder = new StringBuilder();

        int n = input.n;
        String[][] array = input.array;
        List<String> requests = input.requests;

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

        treeTraverseAndCountDeep(root);

        for (int i = 0; i < requests.size(); i++) {
            String[] s1 = requests.get(i).trim().split(" ");
            Node node1 = map.get(s1[0]);
            Node node2 = map.get(s1[1]);
            stringBuilder.append(findLCA(node1, node2)).append("\n");
        }


        return stringBuilder.toString();
    }

    public static String findLCA(Node node1, Node node2) {

        if(node1.deep == node2.deep) {
            if(node1.equals(node2)) {
                return node1.key;
            }
            Node parent1 = node1.parent;
            Node parent2 = node2.parent;

            while(parent1 != null && parent2 != null) {
                if(parent1 == parent2) {
                    return parent1.key;
                } else {
                    parent1 = parent1.parent;
                    parent2 = parent2.parent;
                }

            }

        } else if(node1.deep > node2.deep) {
            Node parent = node1.parent;
            while(parent.deep != node2.deep) {
                parent = parent.parent;
            }
            if(parent.equals(node2)) {
                return parent.key;
            } else {
                return findLCA(parent, node2);
            }
        } else {
            Node parent = node2.parent;
            while(parent.deep != node1.deep) {
                parent = parent.parent;
            }
            if(parent.equals(node1)) {
                return parent.key;
            } else {
                return findLCA(node1, parent);
            }
        }
        return node1.key;
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

    public static void treeTraverseAndCountDeep(Node root) {

        if(root.childrens.isEmpty()) {
            return;
        }
        for(Node node : root.childrens) {
            node.deep = root.deep + 1;
            treeTraverseAndCountDeep(node);
        }
    }

    public static class Node {
        String key;
        Node parent;
        List<Node> childrens;
        int descendants = 0;
        int deep = 0;

        public Node(String key) {
            this.key = key;
            childrens = new ArrayList<>();

        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Node node)) return false;
            return descendants == node.descendants && deep == node.deep && Objects.equals(key, node.key) && Objects.equals(parent, node.parent) && Objects.equals(childrens, node.childrens);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, parent, childrens, descendants, deep);
        }
    }
}
