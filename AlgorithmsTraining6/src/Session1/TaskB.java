package Session1;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        System.out.println(findShirtsAndSocks(readInput()));
    }

    public static int[] readInput() {
        Scanner scanner = new Scanner(System.in);
        int blueShirts = scanner.nextInt();
        int redShirts = scanner.nextInt();
        int blueSocks = scanner.nextInt();
        int redSocks = scanner.nextInt();

        scanner.close();
        return new int[]{blueShirts, redShirts, blueSocks, redSocks};
    }

    public static String findShirtsAndSocks(int[] input) {
        int blueShirts = input[0];
        int redShirts = input[1];
        int blueSocks = input[2];
        int redSocks = input[3];

        int sum1 = Math.max(blueShirts, redShirts) + 2;
        int sum2 = Math.max(blueSocks, redSocks) + 2;
        int sum3 = blueShirts + blueSocks + 2;
        int sum4 = redShirts + redSocks + 2;

        if(blueShirts == 0 ) {
            int minBlueSocks = blueSocks + 1;
            return "1 " + minBlueSocks;
        }
        if(redShirts == 0) {
            int minRedSocks = redSocks + 1;
            return "1 " + minRedSocks;
        }
        if(blueSocks == 0) {
            int minBlueShirts = blueShirts + 1;
            return minBlueShirts + " 1";
        }
        if(redSocks == 0) {
            int minRedShirts = redShirts + 1;
            return minRedShirts + " 1";
        }

        if (blueShirts == redShirts) {
            sum3 = blueShirts + 2;
        }

        if (blueSocks == redSocks) {
            sum4 = redSocks + 2;
        }

        int min = findMin(sum1, sum2, sum3, sum4);
        switch (min) {
            case 1:
                int sumShirts = Math.max(blueShirts, redShirts) + 1;
                return sumShirts + " 1";
            case 2:
                int sumSocks = Math.max(blueSocks, redSocks) + 1;
                return "1 " + sumSocks;
            case 3:
                int minRedShirts = blueShirts + 1;
                int minRedSocks = blueSocks + 1;

                if (blueShirts == redShirts) {
                    return minRedShirts + " 1";
                }
                if (blueSocks == redSocks) {
                    return "1 " + minRedSocks;
                }
                return minRedShirts + " " + minRedSocks;

            case 4:
                int minBlueShirts = redShirts + 1;
                int minBlueSocks = redSocks + 1;

                if (blueShirts == redShirts) {
                    return minBlueShirts + " 1";
                }
                if (blueSocks == redSocks) {
                    return "1 " + minBlueSocks;
                }
                return minBlueShirts + " " + minBlueSocks;
        }
        return "";
    }

    private static int findMin(int sum1, int sum2, int sum3, int sum4) {

        if (sum1 <= sum2 && sum1 <= sum3 && sum1 <= sum4) {
            return 1;
        } else if (sum2 <= sum1 && sum2 <= sum3 && sum2 <= sum4) {
            return 2;
        } else if (sum3 <= sum1 && sum3 <= sum2 && sum3 <= sum4) {
            return 3;
        } else if (sum4 <= sum1 && sum4 <= sum2 && sum4 <= sum3) {
            return 4;
        } else {
            return 0;
        }
    }

}
