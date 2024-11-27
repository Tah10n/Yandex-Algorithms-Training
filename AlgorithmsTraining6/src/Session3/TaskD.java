package Session3;

import java.util.Scanner;
import java.util.Stack;

public class TaskD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        System.out.println(calculatePostfixExpression(inputString));
        scanner.close();
    }

    public static String calculatePostfixExpression(String inputString) {
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
    }
}
