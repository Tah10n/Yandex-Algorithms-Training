package Session2;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TaskCTest {

    @Test
    void findSets() throws IOException {
        TaskC.Input input = TaskC.readInput("4 4\n" +
                "1 3 5 8\n");
        long sets = TaskC.findSets(input);
        assertEquals(2, sets);
    }

    @Test
    void findSets1() throws IOException {

        assertEquals(6, TaskC.findSets(TaskC.readInput("6 4\n" +
                "1 2 3 5 8 9\n")));
    }

    @Test
    void findSets2() throws IOException {

        assertEquals(8, TaskC.findSets(TaskC.readInput("5 2\n" +
                "1 2 5 7 13")));
    }

    @Test
    void findSets3() throws IOException {

        assertEquals(1, TaskC.findSets(TaskC.readInput("2 3\n" +
                "1 5")));
    }

    @Test
    void findSets4() throws IOException {
        long startTime = System.nanoTime();
        assertEquals(11250075000L, TaskC.findSets(TaskC.readInput("input3.txt")));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        assertTrue(duration <= 1000);
    }
}