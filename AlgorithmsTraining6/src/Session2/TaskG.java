package Session2;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TaskG {
    public static void main(String[] args) throws IOException {
        System.out.println(findSubstring(readInput("input.txt")));
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
        long c = 0;
        String string = null;

        if (reader != null) {
            String[] s1 = reader.readLine().split(" ");
            n = Integer.parseInt(s1[0]);
            c = Long.parseLong(s1[1]);

            string = reader.readLine().trim();

            reader.close();
        } else if (scanner != null) {
            n = scanner.nextInt();
            c = scanner.nextLong();
            scanner.nextLine();
            string = scanner.nextLine().trim();
            scanner.close();
        }

        return new Input(n, c, string);
    }

    public static class Input {
        private int n;
        private long c;
        private String string;

        public Input(int n, long c, String string) {
            if (string.length() != n) {
                throw new IllegalArgumentException("string.length != n: " + string.length() + " != " + n);
            }
            this.n = n;
            this.c = c;
            this.string = string;
        }
    }

    public static int findSubstring(Input input) {
        int n = input.n;
        long c = input.c;
        String inputString = input.string;

        int left = 0;
        int right = 0;
        int maxLen = 0;
        long aCount = 0;
        long bCount = 0;
        long rudeness = 0;

        while (right < n) {
            if (inputString.charAt(right) == 'a') {
                aCount++;
            } else if (inputString.charAt(right) == 'b') {
                bCount++;
                rudeness += aCount;
            }


            while (rudeness > c && left <= right) {
                if (inputString.charAt(left) == 'a') {
                    aCount--;
                    rudeness -= bCount;
                } else if (inputString.charAt(left) == 'b') {
                    bCount--;
                }
                left++;
            }

            right++;
            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;

    }
}
