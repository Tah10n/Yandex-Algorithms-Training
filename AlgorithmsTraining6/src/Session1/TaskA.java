package Session1;

import java.util.Scanner;
/*
https://contest.yandex.ru/contest/66792/problems/
 */


public class TaskA {

    public static void main(String[] args) {
        System.out.println(findSide(readInput()));
    }

    public static int[] readInput() {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        scanner.close();
        return new int[]{x1, y1, x2, y2, x, y};
    }

    public static String findSide(int[] input) {
        int x1 = input[0];
        int y1 = input[1];
        int x2 = input[2];
        int y2 = input[3];
        int x = input[4];
        int y = input[5];

        if (x < x1 && y < y1) {
            return "SW";
        } else if (x < x1 && y1 < y &&  y < y2) {
            return "W";
        } else if (x < x1 && y2 < y) {
            return "NW";
        } else if (x1 < x && x < x2 && y < y1) {
            return "S";
        } else if (x1 < x && x < x2 && y2 < y) {
            return "N";
        } else if (x2 < x && y < y1) {
            return "SE";
        } else if (x2 < x && y1 < y && y < y2) {
            return "E";
        } else {
            return "NE";
        }
    }
}
