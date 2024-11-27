package Session2;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) throws IOException {

        System.out.println(findSets(readInput("input.txt")));

    }

    public static Input readInput(String input) throws IOException {
        BufferedReader reader = null;
        Scanner scanner = null;
        if (input.length() > 0) {
            if(input.startsWith("input")) {
                reader = new BufferedReader(new FileReader(input));
            } else {
                System.setIn(new ByteArrayInputStream(input.getBytes()));
                scanner = new Scanner(System.in);
            }

        }
        else {
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
            String[] s2 = reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(s2[i]);
            }
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

    public static class Input {
        private int n;
        private int k;
        private int[] array;

        public Input(int n, int k, int[] array) {
            if(array.length != n) {
                throw new IllegalArgumentException("array.length != n");
            }
            this.n = n;
            this.k = k;
            this.array = array;
        }
    }

    public static int findSets(Input input) {
        int n = input.n;
        int k = input.k;
        int[] array = input.array;
        int answer = 0;

        int[] prefixSumArray = new int[n + 1];
        prefixSumArray[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefixSumArray[i] = prefixSumArray[i - 1] + array[i - 1];
        }

        int left = 1;
        int right = 1;
        while (left <= n && prefixSumArray[left - 1] + k <= prefixSumArray[n]) {

            while (right <= n && prefixSumArray[right] - prefixSumArray[left - 1] <= k) {
                if (prefixSumArray[right] - prefixSumArray[left - 1] == k) {
                    answer++;
                }

                right++;
            }
            left++;
        }

        return answer;
    }
}
