package Session2;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class TaskF {
    public static void main(String[] args) throws IOException {
        System.out.println(findSumOfTripleProducts(readInput("input.txt")));
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

    public static long findSumOfTripleProducts(Input input) {
        int n = input.n;
        int[] array = input.array;
        final BigInteger MOD = BigInteger.valueOf(1000000007);
        BigInteger sum = BigInteger.valueOf(0);
        BigInteger sumSquares = BigInteger.valueOf(0);
        BigInteger sumTriples = BigInteger.valueOf(0);

        for (int i = 0; i < n; i++) {
            sum = sum.add(BigInteger.valueOf(array[i]));
            sumSquares = sumSquares.add(BigInteger.valueOf((((long) array[i] * array[i]))));
            sumTriples = sumTriples.add(BigInteger.valueOf((((long) array[i] * array[i]) * array[i])));
        }

        BigInteger s1 = sum.pow(3);
        BigInteger s2 = sum.multiply(sumSquares).multiply(BigInteger.valueOf(3));
        BigInteger s3 = sumTriples.multiply(BigInteger.valueOf(2));

        return s1.subtract(s2).add(s3).divide(BigInteger.valueOf(6)).remainder(MOD).longValue();

    }
}