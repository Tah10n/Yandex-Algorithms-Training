package Session3;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TaskGTest {

    @Test
    void calculateSumTime() throws IOException {
        assertEquals(22, TaskG.calculateSumTime(TaskG.readInput("3 4\n" +
                "1 5 9\n")));
    }

    @Test
    void calculateSumTime1() throws IOException {
        assertEquals(74, TaskG.calculateSumTime(TaskG.readInput("5 3\n" +
                "2 5 7 9 11")));
    }

    @Test
    void calculateSumTime2() throws IOException {
        assertEquals(0, TaskG.calculateSumTime(TaskG.readInput("1 1\n" +
                "0")));
    }

    @Test
    void calculateSumTime3() throws IOException {
        assertEquals(1, TaskG.calculateSumTime(TaskG.readInput("1 1\n" +
                "1")));
    }

    @Test
    void calculateSumTime4() throws IOException {
        assertEquals(5, TaskG.calculateSumTime(TaskG.readInput("5 1\n" +
                "1 1 1 1 1")));
    }

    @Test
    void calculateSumTime5() throws IOException {
        assertEquals(500014994999950000L, TaskG.calculateSumTime(TaskG.readInput("input3G6.txt")));
    }

    @Test
    void calculateSumTime6() throws IOException {
        assertEquals(20, TaskG.calculateSumTime(TaskG.readInput("3 1\n" +
                "3 2 4")));
    }
}