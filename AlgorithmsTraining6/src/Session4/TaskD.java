package Session4;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TaskD {
    public static void main(String[] args) throws IOException {
        System.out.println(processRequests(readInput("input.txt")));
    }

    public static class Input {

        List<String> requests;

        public Input(List<String> requests) {

            this.requests = requests;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();

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

        List<String> requests = new ArrayList<>();

        if (reader != null) {

            while (reader.ready()) {
                String s = reader.readLine();
                requests.add(s);
            }

            reader.close();
        } else if (scanner != null) {

            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                if(s.isEmpty()) break;
                requests.add(s);
            }

            scanner.close();
        }

        return new Input(requests);
    }

    public static class MyTree {
        Map<Integer, Node> map = new HashMap<>();
        Node root;

        class Node {
            int key;
            Node parent;
            Node left;
            Node right;
            int deep = 0;

            public Node(int key) {
                this.key = key;
            }
        }

        public String add(int key) {
            if(map.containsKey(key)) {
                return "ALREADY";
            } else {
                if(map.isEmpty()) {
                    root = new Node(key);
                    map.put(key, root);
                } else {
                    Node current = root;
                    while (current != null) {
                        if (current.key > key) {
                            if (current.left == null) {
                                current.left = new Node(key);
                                current.left.parent = current;
                                current.left.deep = current.left.parent.deep + 1;
                                map.put(key, current.left);
                                break;
                            } else {
                                current = current.left;
                            }
                        } else {
                            if (current.right == null) {
                                current.right = new Node(key);
                                current.right.parent = current;
                                current.right.deep = current.right.parent.deep + 1;
                                map.put(key, current.right);
                                break;
                            } else {
                                current = current.right;
                            }
                        }
                    }

                }

                return "DONE";
            }


        }

        public String search(int key) {
            if(map.containsKey(key)) {
                return "YES";
            } else {
                return "NO";
            }
        }

        public String printTree(Node node) {
            StringBuilder stringBuilder = new StringBuilder();
            if(node.left != null) {
                stringBuilder.append(printTree(node.left)).append("\n");
            }
            for(int i = 0; i < node.deep; i++) stringBuilder.append(".");
            stringBuilder.append(node.key).append("\n");

            if(node.right != null) {
                stringBuilder.append(printTree(node.right)).append("\n");
            }
            return stringBuilder.toString().trim();
        }
    }

    public static String processRequests(Input input) {
        MyTree myTree = new MyTree();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < input.requests.size(); i++) {
            String[] split = input.requests.get(i).split(" ");
            switch (split[0]) {
                case "ADD":
                    stringBuilder.append(myTree.add(Integer.parseInt(split[1]))).append("\n");
                    break;
                case "SEARCH":
                    stringBuilder.append(myTree.search(Integer.parseInt(split[1]))).append("\n");
                    break;
                case "PRINTTREE":
                    stringBuilder.append(myTree.printTree(myTree.root)).append("\n");
                    break;
            }
        }

        return stringBuilder.toString();
    }


}
