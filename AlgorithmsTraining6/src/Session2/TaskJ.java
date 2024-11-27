package Session2;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TaskJ {
    public static void main(String[] args) throws IOException {
        System.out.println(findAnswer(readInput("input.txt")));
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
        int m = 0;
        int k = 0;

        int[] evidences = null, startNumbers = null;

        if (reader != null) {
            String s1 = reader.readLine().trim();
            n = Integer.parseInt(s1);

            evidences = new int[n];
            String[] s2 = reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                evidences[i] = Integer.parseInt(s2[i]);
            }


            String[] s3 = reader.readLine().split(" ");
            m = Integer.parseInt(s3[0]);
            k = Integer.parseInt(s3[1]);

            startNumbers = new int[m];
            String[] s4 = reader.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                startNumbers[i] = Integer.parseInt(s4[i]);
            }

            reader.close();
        } else if (scanner != null) {
            n = scanner.nextInt();

            evidences = new int[n];
            for (int i = 0; i < n; i++) {
                evidences[i] = scanner.nextInt();
            }

            m = scanner.nextInt();
            k = scanner.nextInt();

            startNumbers = new int[m];
            for (int i = 0; i < m; i++) {
                startNumbers[i] = scanner.nextInt();
            }

            scanner.close();
        }

        return new Input(n, m, k, evidences, startNumbers);
    }

    public static String findAnswer(Input input) {
        int n = input.n;
        int m = input.m;
        int k = input.k;
        int[] evidences = input.evidences;
        int[] startNumbers = input.startNumbers;

        int[] leftLimit = new int[n];
        int counter = 0;
        int left = 0;
        int right = 1;
        for (right = 1; right < n; right++) {
            if (evidences[right - 1] == evidences[right]) {
                if (counter < k) {
                    leftLimit[right] = left;
                    counter++;
                } else {
                    while (counter >= k) {
                        if (evidences[left] == evidences[left + 1]) {
                            counter--;
                        }
                        left++;
                    }
                    leftLimit[right] = left;
                    counter++;
                }
            } else if (evidences[right - 1] > evidences[right]) {
                left = right;
                counter = 0;
            }
            leftLimit[right] = left;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int startIndex = startNumbers[i] - 1;
            result.append(leftLimit[startIndex] + 1).append(" ");
        }

        return result.toString().trim();
    }

    public static class Input {
        private int n;
        private int m;
        private int k;
        private int[] evidences;
        private int[] startNumbers;

        public Input(int n, int m, int k, int[] evidences, int[] startNumbers) {
            if (evidences.length != n || startNumbers.length != m) {
                throw new IllegalArgumentException("array.length != n || array.length != m");
            }
            this.n = n;
            this.m = m;
            this.k = k;
            this.evidences = evidences;
            this.startNumbers = startNumbers;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(n).append("\n");
            for (int i = 0; i < n; i++) {
                sb.append(evidences[i]).append(" ");
            }
            sb.append("\n");
            sb.append(m).append(" ").append(k).append("\n");
            for (int i = 0; i < m; i++) {
                sb.append(startNumbers[i]).append(" ");
            }
            return sb.toString();
        }
    }

}
