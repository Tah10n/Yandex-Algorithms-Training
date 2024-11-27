package Session3;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TaskBTest {

    @Test
    void findMinFromRight() throws IOException {
        assertEquals("-1 4 3 4 -1 6 9 8 9 -1", TaskB.findMinFromRight(TaskB.readInput("10\n" +
                "1 2 3 2 1 4 2 5 3 1\n")));
    }

    @Test
    void findMinFromRight1() throws IOException {
        assertEquals("1 7 4 4 5 7 7 -1 9 -1", TaskB.findMinFromRight(TaskB.readInput("10\n" +
                "7 2 4 5 3 2 5 1 5 4\n")));
    }

    @Test
    void findMinFromRight2() throws IOException {
        assertEquals("-1 -1 -1 -1 -1 -1 -1 -1 -1 -1", TaskB.findMinFromRight(TaskB.readInput("10\n" +
                "0 1 2 3 4 5 6 7 8 9\n")));
    }

    @Test
    void findMinFromRight3() throws IOException {
        assertEquals("1 2 3 4 5 6 7 8 9 -1", TaskB.findMinFromRight(TaskB.readInput("10\n" +
                "9 8 7 6 5 4 3 2 1 0\n")));
    }

    @Test
    void findMinFromRight4() throws IOException {
        assertEquals("6 6 6 6 6 6 -1 -1 -1 -1", TaskB.findMinFromRight(TaskB.readInput("10\n" +
                "1 1 1 1 1 1 0 1 1 1\n")));
    }
}