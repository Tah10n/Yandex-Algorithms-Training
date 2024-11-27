package Session3;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TaskG {
    public static void main(String[] args) throws IOException {
        System.out.println(calculateSumTime(readInput("input.txt")));
    }

    public static class Input {
        private int n;
        private int b;
        private int[] array;

        public Input(int n, int b, int[] array) {
            if (array.length != n) {
                throw new IllegalArgumentException("string.length != n: " + array.length + " != " + n);
            }
            this.n = n;
            this.b = b;
            this.array = array;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(n).append(" ").append(b).append("\n");
            for (int i = 0; i < n; i++) {
                stringBuilder.append(array[i]).append(" ");
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
        int b = 0;
        int[] array = null;

        if (reader != null) {
            String[] s1 = reader.readLine().split(" ");
            n = Integer.parseInt(s1[0]);
            b = Integer.parseInt(s1[1]);
            array = new int[n];

            String[] s2 = reader.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(s2[i]);
            }

            reader.close();
        } else if (scanner != null) {
            n = scanner.nextInt();
            b = scanner.nextInt();
            array = new int[n];

            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            scanner.close();
        }

        return new Input(n, b, array);
    }

    public static long calculateSumTime(Input input) {
        long sum = 0;
        int n = input.n;
        int b = input.b;
        int[] array = input.array;
        long  currentAmount = 0;

        for (int i = 0; i < n; i++) {
            currentAmount += array[i];
             sum += currentAmount;

             currentAmount = Math.max(0, currentAmount - b);
        }
        return sum + currentAmount;
    }
}
