package Session3;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TaskJ {
    public static void main(String[] args) throws IOException {
        System.out.println(findMinInconvenience(readInput("input.txt")));
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
        int k = 0;
        int[] arrayH = null;
        int[] arrayW = null;

        if (reader != null) {
            String[] s1 = reader.readLine().split(" ");
            n = Integer.parseInt(s1[0]);
            k = Integer.parseInt(s1[1]);
            arrayH = new int[n];

            String[] s2 = reader.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arrayH[i] = Integer.parseInt(s2[i]);
            }

            String[] s3 = reader.readLine().trim().split(" ");
            arrayW = new int[n];
            for (int i = 0; i < n; i++) {
                arrayW[i] = Integer.parseInt(s3[i]);
            }

            reader.close();
        } else if (scanner != null) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            scanner.nextLine();
            arrayH = new int[n];
            arrayW = new int[n];


            for (int i = 0; i < n; i++) {
                arrayH[i] = scanner.nextInt();
            }
            scanner.nextLine();

            for (int i = 0; i < n; i++) {
                arrayW[i] = scanner.nextInt();
            }
            scanner.close();
        }

        return new Input(n, k, arrayH, arrayW);
    }

    public static int findMinInconvenience(Input input) {
        int n = input.n;
        int k = input.k;
        int[] arrayH = input.arrayH;
        int[] arrayW = input.arrayW;
        int minInconvenience = Integer.MAX_VALUE;

        List<Chair> chairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            chairs.add(new Chair(arrayH[i], arrayW[i]));
            if (arrayW[i] >= k) {
                return 0;
            }
        }

        chairs.sort(Comparator.comparing(Chair::getHeight).thenComparing(Chair::getWeight));

        long currentSum = 0;
        int left = 0;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int right = 0; right < n; right++) {
            currentSum += chairs.get(right).getWeight();

            if (right > left) {
                int inconvenience = chairs.get(right).getHeight() - chairs.get(right - 1).getHeight();

                while (!deque.isEmpty() && deque.peekLast() < inconvenience) {
                    deque.pollLast();
                }
                deque.addLast(inconvenience);
            }

            while (currentSum >= k) {
                minInconvenience = Math.min(minInconvenience, deque.peekFirst());

                currentSum -= chairs.get(left).getWeight();

                if (left < right && deque.peekFirst() == (chairs.get(left + 1).getHeight() - chairs.get(left).getHeight())) {
                    deque.pollFirst();
                }
                left++;
            }
        }

        return minInconvenience;
    }

    public static class Input {
        private int n;
        private int k;
        private int[] arrayH;
        private int[] arrayW;

        public Input(int n, int k, int[] arrayH, int[] arrayW) {
            this.n = n;
            this.k = k;
            this.arrayH = arrayH;
            this.arrayW = arrayW;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(n).append(" ").append(k).append("\n");
            for (int i = 0; i < n; i++) {
                stringBuilder.append(arrayH[i]).append(" ");
            }
            stringBuilder.append("\n");
            for (int i = 0; i < n; i++) {
                stringBuilder.append(arrayW[i]).append(" ");
            }
            return stringBuilder.toString();
        }
    }

    public static class Chair implements Comparable<Chair> {
        int height;
        int weight;

        public Chair(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Chair o) {
            int compare = Integer.compare(this.getHeight(), o.getHeight());
            if (compare == 0) {
                return Integer.compare(this.getWeight(), o.getWeight());
            }
            return compare;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }

}
