package Session2;

import java.util.Scanner;
/*
https://contest.yandex.ru/contest/66793/problems/
 */
public class TaskA {
    public static void main(String[] args) {
        int[] prefixSumArray = printPrefixSumArray(readInput());
        for (int i = 1; i < prefixSumArray.length; i++) {
            System.out.printf("%d ", prefixSumArray[i]);
        }
    }

    public static int[] readInput() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        return array;
    }

    public static int[] printPrefixSumArray(int[] array) {
        int n = array.length;

        int[] prefixSumArray = new int[n + 1];
        prefixSumArray[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefixSumArray[i] = prefixSumArray[i - 1] + array[i - 1];
        }

        return prefixSumArray;
    }
}
