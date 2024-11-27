package Session2;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TaskC {
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
        int r = 0;
        int[] array = null;

        if (reader != null) {
            String[] s1 = reader.readLine().split(" ");
            n = Integer.parseInt(s1[0]);
            r = Integer.parseInt(s1[1]);
            array = new int[n];
            String[] s2 = reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(s2[i]);
            }
        } else if (scanner != null) {
            n = scanner.nextInt();
            r = scanner.nextInt();
            array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            scanner.close();
        }

        return new Input(n, r, array);
    }

    public static class Input {
        public int n;
        public int r;
        public int[] array;

        public Input(int n, int r, int[] array) {
            if(array.length != n) {
                throw new IllegalArgumentException("array.length != n");
            }
            this.n = n;
            this.r = r;
            this.array = array;
        }
    }

    public static long findSets(Input input) {
        int n = input.n;
        int r = input.r;
        int[] array = input.array;
        long answer = 0;

        int left = 0;
        int right = 0;
        while (array[left] < array[n-1] - r) {

            while (right < n) {
                if(array[right] - array[left] > r) {
                    answer += n-right;
                    break;
                }
                right++;
            }
            left++;
        }
        return answer;
    }
}
