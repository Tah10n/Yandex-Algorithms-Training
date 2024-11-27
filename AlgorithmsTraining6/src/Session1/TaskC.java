package Session1;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        System.out.println(findLetter(readInput("")));
    }

    public static int[][] readInput(String input) {
        if (input.length() > 0) {
            System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        }
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        int[][] array = new int[n][n];
        for (int j = 0; j < n; j++) {
            String line = scanner.nextLine().trim();

            for (int i = 0; i < n; i++) {
                char c = line.charAt(i);
                if (c == '#') {
                    array[i][j] = 1;
                } else {
                    array[i][j] = 0;
                }

            }


        }

        scanner.close();
        return array;
    }

    static class Rectangle {
        int x1;
        int y1;
        int x2;
        int y2;

        public Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    public static String findLetter(int[][] input) {
        int n = input.length;

        int x1 = n;
        int y1 = n;
        int x2 = 0;
        int y2 = 0;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (input[i][j] == 1) {
                    x1 = Math.min(x1, i);
                    y1 = Math.min(y1, j);
                    x2 = Math.max(x2, i);
                    y2 = Math.max(y2, j);
                }
            }
        }

        if (!isRectangle(x1, y1, x2, y2)) {
            return "X";
        }

        if (isLight(input, new Rectangle(x1, y1, x2, y2))) {
            return "I";
        } else {

            int x3 = x2;
            int y3 = y2;
            int x4 = x1;
            int y4 = y1;

            for (int j = y1; j <= y2; j++) {
                for (int i = x1; i <= x2; i++) {
                    if (input[i][j] == 0) {
                        x3 = Math.min(x3, i);
                        y3 = Math.min(y3, j);
                        x4 = Math.max(x4, i);
                        y4 = Math.max(y4, j);
                    }
                }
            }
            if (isDark(input, new Rectangle(x3, y3, x4, y4))) {
                if (x1 < x3 && x3 <= x4 && x4 < x2 && y1 < y3 && y3 <= y4 && y4 < y2) {
                    return "O";
                } else if (x1 < x3 && x3 <= x4 && x4 == x2 && y1 < y3 && y3 <= y4 && y4 < y2) {
                    return "C";
                } else if (x1 < x3 && x3 <= x4 && x4 == x2 && y1 == y3 && y3 <= y4 && y4 < y2) {
                    return "L";
                } else {
                    return "X";
                }
            } else {
                if (x1 < x3 && x3 <= x4 && x4 < x2 && y1 == y3 && y3 < y4 && y4 == y2) {
                    int x5 = x4;
                    int y5 = y4;
                    int x6 = x3;
                    int y6 = y3;

                    for (int j = y3; j <= y4; j++) {
                        for (int i = x3; i <= x4; i++) {
                            if (input[i][j] == 1) {
                                x5 = Math.min(x5, i);
                                y5 = Math.min(y5, j);
                                x6 = Math.max(x6, i);
                                y6 = Math.max(y6, j);
                            }
                        }
                    }
                    if (isLight(input, new Rectangle(x5, y5, x6, y6)) && x5 == x3 && x5 <= x6 && x6 == x4 && y5 != y3 && y5 <= y6 && y6 != y4) {
                        return "H";
                    }
                } else if (x1 < x3 && x3 <= x4 && x4 == x2 && y1 < y3 && y3 < y4 && y4 == y2) {
                    int x5 = x4;
                    int y5 = y4;
                    int x6 = x3;
                    int y6 = y3;

                    for (int j = y3; j <= y4; j++) {
                        for (int i = x3; i <= x4; i++) {
                            if (input[i][j] == 1) {
                                x5 = Math.min(x5, i);
                                y5 = Math.min(y5, j);
                                x6 = Math.max(x6, i);
                                y6 = Math.max(y6, j);
                            }
                        }
                    }

                    if(x5==x3 && x5 < x6 && x6 == x4 && y5 == y3 && y5 < y6 && y6 != y4) {
                        int x7 = x6;
                        int y7 = y6;
                        int x8 = x5;
                        int y8 = y5;
                        for (int j = y5; j <= y6; j++) {
                            for (int i = x5; i <= x6; i++) {
                                if (input[i][j] == 0) {
                                    x7 = Math.min(x7, i);
                                    y7 = Math.min(y7, j);
                                    x8 = Math.max(x8, i);
                                    y8 = Math.max(y8, j);
                                }
                            }
                        }

                        if(isDark(input, new Rectangle(x7, y7, x8, y8)) && x7 == x5 && x7 <= x8 && x8 < x6 && y7 == y5 && y7 <= y8 && y8 < y6) {
                            return "P";
                        }
                    }
                }

            }

        }

        return "X";
    }

    private static boolean isDark(int[][] input, Rectangle rectangle) {

        for (int j = rectangle.y1; j <= rectangle.y2; j++) {
            for (int i = rectangle.x1; i <= rectangle.x2; i++) {
                if (input[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isRectangle(int x1, int y1, int x2, int y2) {
        return x1 <= x2 && y1 <= y2;
    }

    private static boolean isLight(int[][] input, Rectangle rectangle) {
        for (int j = rectangle.y1; j <= rectangle.y2; j++) {
            for (int i = rectangle.x1; i <= rectangle.x2; i++) {
                if (input[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }


}
