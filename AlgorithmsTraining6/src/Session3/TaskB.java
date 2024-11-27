package Session3;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class TaskB {
    public static void main(String[] args) throws IOException {
        System.out.println(findMinFromRight(readInput("input.txt")));
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
            String s1 = reader.readLine().trim();
            n = Integer.parseInt(s1);

            array = new int[n];
            String[] s2 = reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(s2[i]);
            }
        } else if (scanner != null) {
            n = scanner.nextInt();

            array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            scanner.close();
        }

        return new Input(n, array);
    }

    public static class Input {
        private int n;
        private int[] array;

        public Input(int n, int[] array) {
            if (array.length != n) {
                throw new IllegalArgumentException("array.length != n");
            }
            this.n = n;

            this.array = array;
        }
    }

    public static String findMinFromRight(Input input) {
        int[] array = input.array;
        int n = input.n;
        int[] minArray = new int[n];

        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek().value > array[i]) {
                Pair popped = stack.pop();
                minArray[popped.index] = i;
            }

            stack.push(new Pair(array[i], i));

        }

        while (!stack.isEmpty()) {
            Pair popped = stack.pop();
            minArray[popped.index] = -1;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            answer.append(minArray[i]).append(" ");
        }
        return answer.toString().trim();
    }

    public static class Pair {
        int value;
        int index;
        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
