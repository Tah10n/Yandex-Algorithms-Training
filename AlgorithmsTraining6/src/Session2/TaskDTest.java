package Session2;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TaskDTest {

    @Test
    void findSets() throws IOException {
        TaskD.Input input = TaskD.readInput("3 2\n" +
                "4 2 1\n");
        long sets = TaskD.findSets(input);
        assertEquals(2, sets);
    }

    @Test
    void findSets1() throws IOException {
        assertEquals(3, TaskD.findSets(TaskD.readInput("9 2\n" +
                "3 8 5 7 1 2 4 9 6\n")));
    }

    @Test
    void findSets2() throws IOException {
        assertEquals(2, TaskD.findSets(TaskD.readInput("3 0\n" +
                "1 3 1\n")));
    }

    @Test
    void findSets3() throws IOException {
        assertEquals(1, TaskD.findSets(TaskD.readInput("4 4\n" +
                "32 77 1 100\n")));
    }

    @Test
    void findSets4() throws IOException {
        assertEquals(10000, TaskD.findSets(TaskD.readInput("inputD4.txt")));
    }

    @Test
    void findSets5() throws IOException {
        assertEquals(8, TaskD.findSets(TaskD.readInput("10 2\n" +
                "9242 9244 9244 9245 9245 9245 9246 9246 9246 9250")));
    }

    @Test
    void findSets6() throws IOException {
        assertEquals(10, TaskD.findSets(TaskD.readInput("inputD6.txt")));
    }

    @Test
    void findSets7() throws IOException {
        assertEquals(8, TaskD.findSets(TaskD.readInput("inputD7.txt")));
    }

    @Test
    void findSets8() throws IOException {
        assertEquals(4, TaskD.findSets(TaskD.readInput("7 1\n" +
                "1 2 3 4 5 5 5")));
    }

    @Test
    void findSets9() throws IOException {
        assertEquals(4, TaskD.findSets(TaskD.readInput("6 1\n" +
                "1 2 3 4 4 4")));
    }
}