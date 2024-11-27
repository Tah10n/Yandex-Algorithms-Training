package Session4;

import java.io.*;
import java.util.*;

public class TaskH {
    public static void main(String[] args) throws IOException {
        System.out.println(calculateMinPrice(readInput("input.txt")));

    }

    public static class Input {
        int n;
        int[][] pairs;
        int[] prices;
        
        public Input(int n, int[][] pairs, int[] prices) {
            this.n = n;
            this.pairs = pairs;
            this.prices = prices;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(n).append("\n");
            for (int i = 0; i < n - 1; i++) {
                stringBuilder.append(pairs[i][0]).append(" ").append(pairs[i][1]).append("\n");
            }
            for (int i = 0; i < n; i++) {
                stringBuilder.append(prices[i]).append(" ");
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
        int[][] pairs = null;
        int[] prices = null;

        if (reader != null) {
            String s1 = reader.readLine();
            n = Integer.parseInt(s1);

            pairs = new int[n - 1][2];


            for (int i = 0; i < n - 1; i++) {
                String[] s2 = reader.readLine().trim().split(" ");
                pairs[i][0] = Integer.parseInt(s2[0]);
                pairs[i][1] = Integer.parseInt(s2[1]);
            }

            prices = new int[n];

            String[] s3 = reader.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                prices[i] = Integer.parseInt(s3[i]);
            }

            reader.close();
        } else if (scanner != null) {
            n = scanner.nextInt();

            scanner.nextLine();

            pairs = new int[n - 1][2];


            for (int i = 0; i < n - 1; i++) {
                String[] s2 = scanner.nextLine().trim().split(" ");
                pairs[i][0] = Integer.parseInt(s2[0]);
                pairs[i][1] = Integer.parseInt(s2[1]);
            }

            prices = new int[n];

            String[] s3 = scanner.nextLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                prices[i] = Integer.parseInt(s3[i]);
            }

            scanner.close();
        }

        return new Input(n, pairs, prices);
    }

    static class Node {
        List<Integer> neighbors = new ArrayList<>();
    }

    public static String calculateMinPrice(Input input) {
        int n = input.n;
        int[][] pairs = input.pairs;
        int[] prices = input.prices;

        if(n == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(prices[0]).append(" ").append(1).append("\n").append(1);
            return sb.toString();
        }

        // Создаем список смежности
        Node[] tree = new Node[n + 1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new Node();
        }

        // Заполняем список смежности
        for (int[] v : pairs) {
            tree[v[0]].neighbors.add(v[1]);
            tree[v[1]].neighbors.add(v[0]);
        }

        // dp[v][0] - минимальная стоимость для поддерева с корнем v, если v не помечена и покрыта родителем
        // dp[v][1] - минимальная стоимость для поддерева с корнем v, если v помечена
        // dp[v][2] - минимальная стоимость для поддерева с корнем v, если v не помечена и не покрыта родителем
        long[][] dp = new long[n + 1][3];

        // Инициализируем dp
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }

        // Нерекурсивный DFS для заполнения dp
        boolean[] visited = new boolean[n + 1];
        int[] parent = new int[n + 1];
        Stack<DFSState> stack = new Stack<>();
        stack.push(new DFSState(1, 0, 0));

        while (!stack.isEmpty()) {
            DFSState current = stack.peek();
            int v = current.vertex;

            if (!visited[v]) {
                visited[v] = true;
                dp[v][0] = 0;
                dp[v][1] = prices[v - 1];
                dp[v][2] = 0;
                parent[v] = current.parent;

                // Добавляем соседей в стек
                for (int u : tree[v].neighbors) {
                    if (u != current.parent) {
                        stack.push(new DFSState(u, v, 0));
                    }
                }
            } else if (current.childrenProcessed < tree[v].neighbors.size()) {
                int u = tree[v].neighbors.get(current.childrenProcessed);
                if (u != current.parent) {
                    // Обновляем dp для текущей вершины
                    dp[v][0] += dp[u][1];
                    dp[v][1] += Math.min(Math.min(dp[u][0], dp[u][1]), dp[u][2]);
                    dp[v][2] += dp[u][1];
                }
                current.childrenProcessed++;
            } else {
                if (tree[v].neighbors.size() == 1 && v != 1) { // Лист
                    dp[v][0] = 0;
                    dp[v][2] = Long.MAX_VALUE / 2;
                }
                stack.pop();
            }
        }

        // Восстановление ответа
        Set<Integer> selected = new HashSet<>();
        Stack<RestoreState> restoreStack = new Stack<>();
        visited = new boolean[n + 1];

        long minCost = Math.min(dp[1][1], dp[1][2]);
        int initialState = dp[1][1] <= dp[1][2] ? 1 : 2;
        restoreStack.push(new RestoreState(1, 0, initialState));

        while (!restoreStack.isEmpty()) {
            RestoreState current = restoreStack.pop();
            int v = current.vertex;

            if (!visited[v]) {
                visited[v] = true;
                if (current.state == 1) {
                    selected.add(v);
                }

                for (int u : tree[v].neighbors) {
                    if (u != current.parent) {
                        if (current.state == 1) {
                            long min = Math.min(Math.min(dp[u][0], dp[u][1]), dp[u][2]);
                            int nextState;
                            if (min == dp[u][1]) nextState = 1;
                            else if (min == dp[u][0]) nextState = 0;
                            else nextState = 2;
                            restoreStack.push(new RestoreState(u, v, nextState));
                        } else {
                            restoreStack.push(new RestoreState(u, v, 1));
                        }
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(minCost).append(" ").append(selected.size()).append("\n");

        List<Integer> sortedVertices = new ArrayList<>(selected);
        Collections.sort(sortedVertices);
        for (int v : sortedVertices) {
            result.append(v).append(" ");
        }

        return result.toString().trim();
    }

    // Вспомогательный класс для хранения состояния DFS
    private static class DFSState {
        int vertex;
        int parent;
        int childrenProcessed;

        DFSState(int vertex, int parent, int childrenProcessed) {
            this.vertex = vertex;
            this.parent = parent;
            this.childrenProcessed = childrenProcessed;
        }
    }

    // Вспомогательный класс для хранения состояния восстановления ответа
    private static class RestoreState {
        int vertex;
        int parent;
        int state;

        RestoreState(int vertex, int parent, int state) {
            this.vertex = vertex;
            this.parent = parent;
            this.state = state;
        }
    }

}
