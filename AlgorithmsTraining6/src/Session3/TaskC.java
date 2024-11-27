package Session3;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) throws IOException {
        System.out.println(findMinInWindow(readInput("input.txt")));
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
        int k = 0;
        int[] array = null;

        if (reader != null) {
            String[] s1 = reader.readLine().split(" ");
            n = Integer.parseInt(s1[0]);
            k = Integer.parseInt(s1[1]);
            array = new int[n];

            String[] s2 = reader.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(s2[i]);
            }

            reader.close();
        } else if (scanner != null) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            array = new int[n];

            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            scanner.close();
        }

        return new Input(n, k, array);
    }

    public static String findMinInWindow(Input input) {
        StringBuilder answer = new StringBuilder();

        int n = input.n;
        int k = input.k;
        int[] array = input.array;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekLast() > array[i]) {
                deque.pollLast();
            }
            deque.addLast(array[i]);

            if (i >= k - 1) {
                answer.append(deque.peekFirst()).append("\n");
                if(deque.size() >= k || deque.peekFirst() == array[i - k + 1]) {
                    deque.pollFirst();
                }

            }

        }

        return answer.toString().trim();

    }

    public static class Input {
        private int n;
        private int k;
        private int[] array;

        public Input(int n, int k, int[] array) {
            if (array.length != n) {
                throw new IllegalArgumentException("string.length != n: " + array.length + " != " + n);
            }
            this.n = n;
            this.k = k;
            this.array = array;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(n).append(" ").append(k).append("\n");
            for (int i = 0; i < n; i++) {
                stringBuilder.append(array[i]).append(" ");
            }
            return stringBuilder.toString();
        }
    }
}
