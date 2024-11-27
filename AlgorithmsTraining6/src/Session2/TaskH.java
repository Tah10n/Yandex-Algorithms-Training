package Session2;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class TaskH {
    public static void main(String[] args) throws IOException {
        System.out.println(findMinRelocations(readInput("input.txt")));
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

    public static String findMinRelocations(Input input) {
        int n = input.n;
        int[] array = input.array;

        BigInteger totalEmployees = BigInteger.valueOf(0);
        for (int i = 0; i < n; i++) {
            totalEmployees = totalEmployees.add(BigInteger.valueOf(array[i]));
        }

        BigInteger employeesFromLeft = BigInteger.valueOf(0);

        BigInteger currentMoves = BigInteger.valueOf(0);
        for (int i = 0; i < n; i++) {
            currentMoves = currentMoves.add(BigInteger.valueOf((long) array[i] * i));
        }

        BigInteger minMoves = currentMoves;

        for (int i = 1; i < n; i++) {
            employeesFromLeft = employeesFromLeft.add(BigInteger.valueOf(array[i - 1]));

            currentMoves = currentMoves.add(employeesFromLeft.subtract(totalEmployees.subtract(employeesFromLeft)));

            minMoves = minMoves.compareTo(currentMoves) < 0 ? minMoves : currentMoves;
        }

        return minMoves.toString();
    }

}
