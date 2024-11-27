package Session3;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TaskH {

    public static void main(String[] args) throws IOException {
        System.out.println(getAnswer(readInput("input.txt")));
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

        String[] array = null;

        if (reader != null) {
            String s1 = reader.readLine();
            n = Integer.parseInt(s1);

            array = new String[n];


            for (int i = 0; i < n; i++) {

                array[i] = reader.readLine();
            }

            reader.close();
        } else if (scanner != null) {
            n = scanner.nextInt();
            scanner.nextLine();
            array = new String[n];

            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextLine();
            }
            scanner.close();
        }

        return new Input(n, array);
    }

    public static String getAnswer(Input input) {
        int n = input.n;
        String[] array = input.array;
        SumStack sumStack = new SumStack();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (array[i].startsWith("+")) {
                sumStack.push(Integer.parseInt(array[i].substring(1)));
            } else if (array[i].startsWith("-")) {
                stringBuilder.append(sumStack.pop()).append("\n");
            } else if (array[i].startsWith("?")) {
                stringBuilder.append(sumStack.getSum(Integer.parseInt(array[i].substring(1)))).append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public static class Input {
        int n;
        String[] array;

        public Input(int n, String[] array) {
            this.n = n;
            this.array = array;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(n).append("\n");
            for (int i = 0; i < n; i++) {
                stringBuilder.append(array[i]).append("\n");
            }
            return stringBuilder.toString();
        }
    }

    public static class SumStack {
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Long> prefixSum = new ArrayList<>();

        public void push(int value) {
            stack.push(value);
            if (prefixSum.isEmpty()) {
                prefixSum.add((long) value);
            } else {
                prefixSum.add(prefixSum.getLast() + value);
            }
        }

        public Long getSum(int k) {
            if (k == 0 || stack.isEmpty()) return 0L;
            if (k >= prefixSum.size()) return prefixSum.getLast();
            return prefixSum.getLast() - prefixSum.get(prefixSum.size() - k - 1);
        }

        public Integer pop() {

            prefixSum.removeLast();
            return stack.pop();
        }
    }
}
