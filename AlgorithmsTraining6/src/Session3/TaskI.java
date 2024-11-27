package Session3;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class TaskI {
    public static void main(String[] args) throws IOException {
        System.out.println(getAnswer1(readInput("input.txt")));
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
        int a = 0;
        int b = 0;
        Rover[] array = null;

        if (reader != null) {
            String s1 = reader.readLine();
            n = Integer.parseInt(s1);
            String s2 = reader.readLine();
            a = Integer.parseInt(s2.split(" ")[0]);
            b = Integer.parseInt(s2.split(" ")[1]);

            array = new Rover[n];


            for (int i = 0; i < n; i++) {
                String s3 = reader.readLine();
                array[i] = new Rover(i, Integer.parseInt(s3.split(" ")[0]), Integer.parseInt(s3.split(" ")[1]));
            }

            reader.close();
        } else if (scanner != null) {
            n = scanner.nextInt();
            a = scanner.nextInt();
            b = scanner.nextInt();
            array = new Rover[n];
            scanner.nextLine();
            for (int i = 0; i < n; i++) {
                String s = scanner.nextLine();
                array[i] = new Rover(i, Integer.parseInt(s.split(" ")[0]), Integer.parseInt(s.split(" ")[1]));
            }
            scanner.close();
        }

        return new Input(n, a, b, array);
    }

    public static String getAnswer1(Input input) {
        int n = input.n;
        int a = input.a;
        int b = input.b;
        StringBuilder answer = new StringBuilder();
        int[] directions = {1, 2, 3, 4};
        List<Rover> rovers = new ArrayList<>(Arrays.asList(input.array));

        rovers.sort(new Comparator<Rover>() {
            @Override
            public int compare(Rover r1, Rover r2) {
                int compare = Integer.compare(r1.getT(), r2.getT());
                if (compare == 0) {
                    return Integer.compare(r1.getId(), r2.getId());
                }
                return compare;
            }
        });

        Deque<Rover> deque = new ArrayDeque<>(rovers);

        List<Rover> passedRovers = new ArrayList<>();
        while (deque.size() >= 1) {
            List<Rover> roversToPass = new ArrayList<>();
            Map<Integer, Rover> mapRoverDirections = new HashMap<>();
            List<Rover> dequeToAdd = new ArrayList<>();
            Rover polledFirst = deque.pollFirst();
            roversToPass.add(polledFirst);
            mapRoverDirections.put(polledFirst.getD(), polledFirst);
            while (deque.peek() != null && deque.peek().getT() == roversToPass.get(0).getT()) {
                Rover rover = deque.poll();
                if (mapRoverDirections.containsKey(rover.getD())) {
                    rover.setT(rover.getT() + 1);
                    dequeToAdd.add(rover);
                } else {
                    roversToPass.add(rover);
                    mapRoverDirections.put(rover.getD(), rover);
                }

            }


            int counter = 0;
            for (Rover r : roversToPass) {

                if (r.getD() == a && (!mapRoverDirections.containsKey(b) || b != directions[(a + 2) % 4]) && counter <= 2) {
                    passedRovers.add(r);
                    counter++;
                } else if (r.getD() == b && (!mapRoverDirections.containsKey(a) || a != directions[(b + 2) % 4]) && counter <= 2) {

                    passedRovers.add(r);
                    counter++;
                } else if (r.getD() != a && r.getD() != b && counter <= 2 && !mapRoverDirections.containsKey(a) && !mapRoverDirections.containsKey(b) && !mapRoverDirections.containsKey(directions[(r.getD() + 2) % 4])) {

                    passedRovers.add(r);
                    counter++;
                } else {

                    r.setT(r.getT() + 1);

                    dequeToAdd.addFirst(r);
                }
            }

            for (int i = dequeToAdd.size() - 1; i >= 0 ; i--) {
                deque.addFirst(dequeToAdd.get(i));
            }

        }

        passedRovers.sort(new Comparator<Rover>() {

            @Override
            public int compare(Rover o1, Rover o2) {
                return o1.getId() - o2.getId();
            }
        });

        for (Rover r : passedRovers) {
            answer.append(r.getT()).append("\n");
        }

        return answer.toString();
    }

    public static class Input {
        int n;
        int a;
        int b;
        Rover[] array;

        public Input(int n, int a, int b, Rover[] array) {
            this.n = n;
            this.a = a;
            this.b = b;
            this.array = array;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(n).append("\n");
            stringBuilder.append(a).append(" ").append(b).append("\n");
            for (int i = 0; i < n; i++) {
                stringBuilder.append(array[i]).append("\n");
            }
            return stringBuilder.toString();
        }
    }

    public static class Rover {
        private int id;
        private int d;
        private int t;

        public Rover(int id, int d, int t) {
            this.id = id;
            this.d = d;
            this.t = t;
        }

        public int getId() {
            return id;
        }

        public int getD() {
            return d;
        }

        public void setD(int d) {
            this.d = d;
        }

        public int getT() {
            return t;
        }

        public void setT(int t) {
            this.t = t;
        }

        @Override
        public String toString() {
            return id + " " + d + " " + t;
        }
    }
}
