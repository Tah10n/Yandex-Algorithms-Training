package Session2;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TaskBTest {

    @Test
    void findSets() {

        assertEquals(0, TaskB.findSets(new TaskB.Input(0, 0, new int[]{})));
    }

    @Test
    void findSets1() throws IOException {

        assertEquals(4, TaskB.findSets(TaskB.readInput("5 17\n" +
                "17 7 10 7 10\n")));
    }

    @Test
    void findSets2() throws IOException {

        assertEquals(2, TaskB.findSets(TaskB.readInput("5 10\n" +
                "1 2 3 4 1\n")));
    }

    @Test
    void findSets3() throws IOException {

        assertEquals(4, TaskB.findSets(TaskB.readInput("5 2\n" +
                "1 1 1 1 1\n")));
    }

    @Test
    void findSets4() throws IOException {

        assertEquals(1, TaskB.findSets(TaskB.readInput("1 2\n" +
                "2\n")));
    }

    @Test
    void findSets5() throws IOException {

        assertEquals(0, TaskB.findSets(TaskB.readInput("1 1\n" +
                "2\n")));
    }

    @Test
    void findSets6() throws IOException {

        assertEquals(0, TaskB.findSets(TaskB.readInput("5 10\n" +
                "1 1 1 1 1\n")));
    }

    @Test
    void findSets7() throws IOException {

        assertEquals(3, TaskB.findSets(TaskB.readInput("6 5\n" +
                "1 2 3 2 1 2\n")));
    }

    @Test
    void findSets8() throws IOException {
        long startTime = System.nanoTime();
        assertEquals(105, TaskB.findSets(TaskB.readInput("input1.txt")));
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000000);
    }

    @Test
    void findSets9() throws IOException {
        long startTime = System.nanoTime();
        assertEquals(31871, TaskB.findSets(TaskB.readInput("input2.txt")));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        assertTrue(duration <= 1000);
    }

    @Test
    void findSets10() throws IOException {

        assertEquals(4, TaskB.findSets(TaskB.readInput("100 38\n" +
                "5 33 69 66 49 32 32 74 9 81 44 60 12 79 58 57 34 42 33 55 85 26 11 57 79 1 22 37 26 36 22 20 100 10 29 7 53 31 3 70 43 99 26 55 78 81 70 21 3 40 48 60 7 78 62 73 10 57 70 87 98 13 58 94 47 55 25 92 92 67 7 42 12 71 46 82 39 5 44 64 13 48 78 61 52 38 7 38 21 96 3 16 80 94 71 91 38 24 60 12\n")));
    }
}