package Session2;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TaskI {
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

        int[] interests = null, usefulness = null, moods = null;

        if (reader != null) {
            String s1 = reader.readLine().trim();
            n = Integer.parseInt(s1);

            interests = new int[n];
            String[] s2 = reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                interests[i] = Integer.parseInt(s2[i]);
            }

            usefulness = new int[n];
            s2 = reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                usefulness[i] = Integer.parseInt(s2[i]);
            }

            moods = new int[n];
            s2 = reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                moods[i] = Integer.parseInt(s2[i]);
            }
            reader.close();
        } else if (scanner != null) {
            n = scanner.nextInt();

            interests = new int[n];
            for (int i = 0; i < n; i++) {
                interests[i] = scanner.nextInt();
            }

            usefulness = new int[n];
            for (int i = 0; i < n; i++) {
                usefulness[i] = scanner.nextInt();
            }

            moods = new int[n];
            for (int i = 0; i < n; i++) {
                moods[i] = scanner.nextInt();
            }

            scanner.close();
        }

        return new Input(n, interests, usefulness, moods);
    }

    public static class Input {
        private int n;
        private int[] interests;
        private int[] usefulness;
        private int[] moods;

        public Input(int n, int[] interests, int[] usefulness, int[] moods) {
            if (interests.length != n || usefulness.length != n || moods.length != n) {
                throw new IllegalArgumentException("array.length != n");
            }
            this.n = n;
            this.interests = interests;
            this.usefulness = usefulness;
            this.moods = moods;
        }
    }

    public static String findAnswer(Input input) {
        int n = input.n;
        int[] interests = input.interests;
        int[] usefulness = input.usefulness;
        int[] moods = input.moods;

        StringBuilder answer = new StringBuilder();
        Comparator<Triple> interestComparator = (a, b) -> {
            int compare = b.getInterest() - a.getInterest();
            if(compare == 0) {
                compare = b.getUsefulness() - a.getUsefulness();
            }
            if(compare == 0) {
                compare = a.getIndex() - b.getIndex();
            }
            return compare;
        };
        Comparator<Triple> usefulnessComparator = (a, b) -> {
            int compare = b.getUsefulness() - a.getUsefulness();
            if(compare == 0) {
                compare = b.getInterest() - a.getInterest();
            }
            if(compare == 0) {
                compare = a.getIndex() - b.getIndex();
            }
            return compare;
        };
        TreeMap<Triple, Integer> interestsSortedAlgorithms = new TreeMap<>(interestComparator);
        TreeMap<Triple, Integer> usefulnessSortedAlgorithms = new TreeMap<>(usefulnessComparator);

        for (int i = 0; i < n; i++) {
            Triple algorithm = new Triple(interests[i], usefulness[i], i);
            usefulnessSortedAlgorithms.put(algorithm, i);
            interestsSortedAlgorithms.put(algorithm, i);
        }

        for (int i = 0; i < n; i++) {
            if (moods[i] == 1) {
                Triple algorithm = usefulnessSortedAlgorithms.firstKey();
                Integer index = algorithm.index;
                answer.append(index + 1).append(" ");
                usefulnessSortedAlgorithms.remove(algorithm);
                interestsSortedAlgorithms.remove(algorithm);

            } else {
                Triple algorithm = interestsSortedAlgorithms.firstKey();
                Integer index = algorithm.index;
                answer.append(index + 1).append(" ");
                interestsSortedAlgorithms.remove(algorithm);
                usefulnessSortedAlgorithms.remove(algorithm);
            }
        }
        return answer.toString().trim();
    }

    public static class Triple {
        int interest;
        int usefulness;
        int index;

        public Triple(int interest, int usefulness, int index) {
            this.interest = interest;
            this.usefulness = usefulness;
            this.index = index;
        }

        public int getInterest() {
            return interest;
        }

        public void setInterest(int interest) {
            this.interest = interest;
        }

        public int getUsefulness() {
            return usefulness;
        }

        public void setUsefulness(int usefulness) {
            this.usefulness = usefulness;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

    }

}
