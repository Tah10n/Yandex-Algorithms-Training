package Session4;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TaskG {
    public static void main(String[] args) throws IOException {
        System.out.println(calculateCombinations(readInput("input.txt")));
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
        int m = 0;
        int k = 0;
        int[][] pairs = null;

        if (reader != null) {
            String[] s1 = reader.readLine().trim().split(" ");
            n = Integer.parseInt(s1[0]);
            m = Integer.parseInt(s1[1]);
            k = Integer.parseInt(s1[2]);

            pairs = new int[m][2];


            for (int i = 0; i < m; i++) {
                String[] s2 = reader.readLine().trim().split(" ");
                pairs[i][0] = Integer.parseInt(s2[0]);
                pairs[i][1] = Integer.parseInt(s2[1]);
            }

            reader.close();
        } else if (scanner != null) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            k = scanner.nextInt();

            scanner.nextLine();

            pairs = new int[m][2];


            for (int i = 0; i < m; i++) {
                String[] s2 = scanner.nextLine().trim().split(" ");
                pairs[i][0] = Integer.parseInt(s2[0]);
                pairs[i][1] = Integer.parseInt(s2[1]);
            }

            scanner.close();
        }

        return new Input(n, m, k, pairs);
    }

    public static long calculateCombinations(Input input) {
        int n = input.n;
        int m = input.m;
        long k = input.k;
        int[][] pairs = input.pairs;

        Set<Integer> vertexesAll = new TreeSet<>();

        Node[] allGraphs = new Node[n + 1];
        for (int i = 0; i <= n; i++) {
            allGraphs[i] = new Node();
        }

        for (int[] pair : pairs) {
            vertexesAll.add(pair[0]);
            vertexesAll.add(pair[1]);
            allGraphs[pair[0]].neighbors.add(pair[1]);
            allGraphs[pair[1]].neighbors.add(pair[0]);
        }

        boolean[] visited = new boolean[n + 1];
        int[] parent = new int[n + 1];
        long totalGraphCombinations = 1;
        int graphCount = 0;

        for (int v = 1; v <= n; v++) {
            int start = v;
            if (visited[start]) continue;
            Set<Integer> vertexesOfComponent = new HashSet<>();
            vertexesOfComponent.add(start);
            boolean haveZigZag = false;
            Set<Integer> tree1 = new HashSet<>();
            Set<Integer> tree2 = new HashSet<>();
            Queue<Integer> queue = new ArrayDeque<>();

            visited[start] = true;
            queue.add(start);
            tree1.add(start);

            long componentCombinations = 1;

            while (!queue.isEmpty()) {
                int node = queue.poll();
                visited[node] = true;
                vertexesOfComponent.add(node);


                int count = 0;

                if (allGraphs[node].neighbors.size() >= 2) {
                    int innerLeafs = 0;
                    for (int child : allGraphs[node].neighbors) {

                        if (allGraphs[child].neighbors.size() > 1) {
                            count++;
                            haveZigZag = true;

                        } else {
                            innerLeafs++;
                        }

                    }
                    if (count > 2) {
                        return 0;
                    }
                    for (long i = 1; i <= innerLeafs; i++) {

                        componentCombinations = componentCombinations * i % k;
                    }
                }


                for (int child : allGraphs[node].neighbors) {
                    if (!visited[child]) {

                        parent[child] = node;
                        queue.add(child);
                        if (!tree1.contains(child) && !tree2.contains(child)) {
                            if (tree1.contains(node)) {
                                tree2.add(child);

                            } else {
                                tree1.add(child);
                            }
                        }
                    } else if (parent[node] != child) {
                        return 0;
                    }
                }
            }

            if (tree1.size() + tree2.size() == 1) {
                continue;
            }

            componentCombinations = componentCombinations * 2 % k;
            if (haveZigZag) {
                componentCombinations = componentCombinations * 2 % k;
            }


            totalGraphCombinations = (totalGraphCombinations * componentCombinations) % k;
            graphCount++;

        }

        int withoutfrends = n - vertexesAll.size();
        long positions = (vertexesAll.size() + 2);
        long freeCombinations = 1;


        for (long i = positions; i < positions + withoutfrends; i++) {
            freeCombinations = freeCombinations * i % k;
        }

        for (long i = 1; i <= graphCount; i++) {
            totalGraphCombinations = totalGraphCombinations * i % k;
        }


        long result = (totalGraphCombinations * freeCombinations) % k;

        return result;
    }

    public static class Input {
        int n;
        int m;
        int k;
        int[][] pairs;

        public Input(int n, int m, int k, int[][] pairs) {
            this.n = n;
            this.m = m;
            this.k = k;
            this.pairs = pairs;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(n).append(" ").append(m).append(" ").append(k).append("\n");
            for (int i = 0; i < m; i++) {
                sb.append(pairs[i][0]).append(" ").append(pairs[i][1]).append("\n");
            }
            return sb.toString();
        }
    }

    static class Node {

        List<Integer> neighbors = new ArrayList<>();
    }

}
