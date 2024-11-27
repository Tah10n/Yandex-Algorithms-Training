package Session3;

import java.util.Scanner;
import java.util.Stack;
/*
https://contest.yandex.ru/contest/66794/problems/
 */
public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(isParanthesesBalanced(scanner.nextLine()));
        scanner.close();
    }

    public static String isParanthesesBalanced(String input) {
        char[] chars = input.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                stack.push(chars[i]);
            } else if(chars[i] == ')' || chars[i] == ']' || chars[i] == '}') {
                if(stack.isEmpty()) {
                    return "no";
                }
                char top = stack.pop();
                if(top == '(' && chars[i] != ')') {
                    return "no";
                } else if(top == '[' && chars[i] != ']') {
                    return "no";
                } else if(top == '{' && chars[i] != '}') {
                    return "no";
                }
            }
        }

        if(!stack.isEmpty()) {
            return "no";
        }

        return "yes";
    }
}
