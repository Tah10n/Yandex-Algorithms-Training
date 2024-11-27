package Session4;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskF {
    public static void main(String[] args) throws IOException {
        System.out.println(calculateCoins(readInput("input.txt")));
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
        int[] array = null;

        if (reader != null) {
            String s1 = reader.readLine();
            n = Integer.parseInt(s1);

            array = new int[n - 1];

            String[] s2 = reader.readLine().trim().split(" ");
            for (int i = 0; i < n - 1; i++) {

                array[i] = Integer.parseInt(s2[i]);

            }

            reader.close();
        } else if (scanner != null) {
            n = scanner.nextInt();

            scanner.nextLine();

            array = new int[n - 1];

            String[] s2 = scanner.nextLine().trim().split(" ");
            for (int i = 0; i < n - 1; i++) {

                array[i] = Integer.parseInt(s2[i]);
            }

            scanner.close();
        }

        return new Input(n, array);
    }

    public static String calculateCoins(Input input) {
        int n = input.n;
        int[] bosses = input.array;

        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int boss = bosses[i];
            int employee = i + 2;
            tree.get(boss).add(employee);
        }

        int[] descendants = new int[n + 1];
        for (int i = n; i >= 1; i--) {
            if(tree.get(i).isEmpty()){
                descendants[i] = 0;
            } else {
                for (int child : tree.get(i)) {
                    descendants[i] += descendants[child] + 1;
                }
            }
        }
        long[] coins = new long[n + 1];

        for (int i = n; i >= 1; i--) {
            if (tree.get(i).isEmpty()) {
                coins[i] = 1;
            } else {
                long totalCoins = 0;
                for (int child : tree.get(i)) {

                    totalCoins += coins[child] + descendants[child] + 1;
                }
                coins[i] = totalCoins + 1;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            result.append(coins[i]).append(" ");
        }
        return result.toString().trim();
    }

    public static class Input {
        int n;
        int[] array;

        public Input(int n, int[] array) {
            this.n = n;
            this.array = array;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(n).append("\n");
            for (int i = 0; i < n - 1; i++) {
                stringBuilder.append(array[i]).append(" ");
            }
            return stringBuilder.toString();
        }
    }
}
