package Session3;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class TaskF {
    public static void main(String[] args) throws IOException {
        System.out.println((findMinRPS(readInput("input.txt"))));
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

        String w = null;
        String s = null;

        if (reader != null) {
            String s1 = reader.readLine().trim();
            n = Integer.parseInt(s1);

            w = reader.readLine();
            s = reader.readLine();

        } else if (scanner != null) {
            n = scanner.nextInt();
            scanner.nextLine();
            w = scanner.nextLine();
            s = scanner.nextLine();

            scanner.close();
        }

        return new Input(n, w, s);
    }

    public static String findMinRPS(Input input) {
        int n = input.n;
        String w = input.w;
        String s = input.s;
        StringBuilder result = new StringBuilder(s);
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < w.length(); i++) {
            map.put(w.charAt(i), i);
        }

        if (s.length() == n) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[') {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        while (result.length() < n) {
            if (n - result.length() <= stack.size()) {
                char popped = stack.pop();
                char closeChar = (popped == '(') ? ')' : ']';
                result.append(closeChar);
                continue;
            }

            if (!stack.isEmpty()) {
                char popped = stack.peek();
                char closeCharForStack = (popped == '(') ? ')' : ']';
                char firstOpeningBracket = findFirstOpeningBracket(w);
                if (map.get(closeCharForStack) <= map.get(firstOpeningBracket)) {

                    result.append(closeCharForStack);
                    stack.pop();
                } else {
                    result.append(firstOpeningBracket);
                    stack.push(firstOpeningBracket);
//                    char closeChar = (firstOpeningBracket == '(') ? ')' : ']';
//                    result.append(closeChar);
                }
            } else {
                char firstOpeningBracket = findFirstOpeningBracket(w);
                result.append(firstOpeningBracket);
                stack.push(firstOpeningBracket);
//                char closeChar = (firstOpeningBracket == '(') ? ')' : ']';
//                result.append(closeChar);
            }

        }

        return result.toString();
    }

    public static char findFirstOpeningBracket(String w) {
        for (Character c : w.toCharArray()) {
            if (c == '(' || c == '[') {
                return c;
            }
        }

        return ' ';
    }

    public static class Input {
        private int n;
        private String w;
        private String s;

        public Input(int n, String w, String s) {
            this.n = n;
            this.w = w;
            this.s = s;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(n).append("\n");
            sb.append(w);
            sb.append("\n");
            sb.append(s);

            return sb.toString();
        }
    }
}
