package Session3;

import java.util.Scanner;
import java.util.Stack;

public class TaskE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        System.out.println(calculatePostfixExpression(convertToPostfixExpression(input)));
        scanner.close();
    }

    public static String convertToPostfixExpression(String input) {
        Stack<Character> stackOperations = new Stack<>();

        StringBuilder sb = new StringBuilder();
        input = input.replaceAll("\\s+", " ").trim();
        if(String.valueOf(input.charAt(0)).matches("\\D") && input.charAt(0) != '(') {
            return "WRONG";
        }
        for (int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);
            if (String.valueOf(c).matches("\\d+")) {
                sb.append(input.charAt(i));
                while (i < input.length()-1 && String.valueOf(input.charAt(i+1)).matches("\\d+")) {
                    sb.append(input.charAt(i+1));
                    i++;
                }
                sb.append(" ");

            } else if (c == '*') {
                while (!stackOperations.isEmpty() && stackOperations.peek() == '*') {
                    sb.append(stackOperations.pop()).append(" ");
                }
                stackOperations.push(c);
            } else if (c == '+' || c == '-') {
                while (!stackOperations.isEmpty() && (stackOperations.peek() == '+' || stackOperations.peek() == '-' || stackOperations.peek() == '*')) {
                    sb.append(stackOperations.pop()).append(" ");
                }
                stackOperations.push(c);
            } else if (c == '(') {
                stackOperations.push(c);
            } else if (c == ')') {
                while (!stackOperations.isEmpty() && stackOperations.peek() != '(') {
                    sb.append(stackOperations.pop()).append(" ");
                }
                if(stackOperations.isEmpty() || stackOperations.pop() != '(') {
                    return "WRONG";
                }
            } else  if (c == ' ') {
                if(String.valueOf(input.charAt(i-1)).matches("\\d+") && String.valueOf(input.charAt(i+1)).matches("\\d+")) {
                    return "WRONG";
                } else {
                    continue;
                }
            } else {
                return "WRONG";
            }
        }

        while (!stackOperations.isEmpty()) {
            if(stackOperations.peek() == '(') {
                return "WRONG";
            }
            sb.append(stackOperations.pop()).append(" ");
        }

        return sb.toString().trim();

    }

    public static String calculatePostfixExpression(String inputString) {
        if(inputString.equals("WRONG")) {
            return "WRONG";
        }
        try {
            String[] s = inputString.trim().split(" ");
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < s.length; i++) {
                if(s[i].matches("\\d+")) {
                    stack.push(s[i]);
                } else {
                    long a = Long.parseLong(stack.pop());
                    long b = Long.parseLong(stack.pop());
                    if(s[i].equals("+")) {
                        stack.push(String.valueOf(a+b));
                    } else if(s[i].equals("-")) {
                        stack.push(String.valueOf(b-a));
                    } else if(s[i].equals("*")) {
                        stack.push(String.valueOf(a*b));
                    }
                }
            }
            return stack.pop();
        } catch (RuntimeException e) {
            return "WRONG";
        }
    }
}
