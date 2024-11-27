package Session2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TaskITest {

    @Test
    void findAnswer() throws IOException {
        assertEquals("1 5 2 4 3", TaskI.findAnswer(TaskI.readInput("5\n" +
                "1 2 3 4 5\n" +
                "5 4 3 2 1\n" +
                "1 0 1 0 0\n")));
    }

    @Test
    void findAnswer1() throws IOException {
        assertEquals("2 5 3 6 1 4", TaskI.findAnswer(TaskI.readInput("6\n" +
                "3 10 6 2 10 1\n" +
                "3 5 10 7 5 9\n" +
                "0 0 1 1 0 1\n")));
    }

    @Test
    void findAnswer2() throws IOException {
        assertEquals("3 6 4 2 5 1", TaskI.findAnswer(TaskI.readInput("6\n" +
                "3 10 6 2 10 1\n" +
                "3 5 10 7 5 9\n" +
                "1 1 1 1 1 1\n")));
    }

    @Test
    void findAnswer3() throws IOException {
        assertEquals("2 5 3 1 4 6", TaskI.findAnswer(TaskI.readInput("6\n" +
                "3 10 6 2 10 1\n" +
                "3 5 10 7 5 9\n" +
                "0 0 0 0 0 0\n")));
    }

    @Test
    void findAnswer4() throws IOException {
        assertEquals("1 2 3 4 5 6", TaskI.findAnswer(TaskI.readInput("6\n" +
                "1000000000 999999999 999999998 999999997 999999996 999999995\n" +
                "3 5 10 7 5 9\n" +
                "0 0 0 0 0 0\n")));
    }

    @Disabled
    @Test
    void findAnswer5() throws IOException {
        assertEquals("1 2 3 4 5 6", TaskI.findAnswer(TaskI.readInput("inputI1.txt")));
    }

    @Test
    void findAnswer6() throws IOException {
        assertEquals("3 4 1 5 2", TaskI.findAnswer(TaskI.readInput("5\n" +
                "10 10 20 20 10\n" +
                "20 10 20 10 20\n" +
                "0 0 0 1 1")));
    }

    @Test
    void findAnswer7() throws IOException {
        assertEquals("1 2 3 4 5", TaskI.findAnswer(TaskI.readInput("5\n" +
                "5 5 5 5 5\n" +
                "5 5 5 5 5\n" +
                "1 0 1 0 0")));
    }

    @Test
    void findAnswer8() throws IOException {
        assertEquals("5 1 2 3 4", TaskI.findAnswer(TaskI.readInput("5\n" +
                "1 1 1 1 2\n" +
                "1 1 1 1 1\n" +
                "1 0 1 0 0")));
    }

    @Test
    void findAnswer9() throws IOException {
        assertEquals("1 5 2 4 3", TaskI.findAnswer(TaskI.readInput("5\n" +
                "1 2 3 4 5\n" +
                "5 4 3 2 1\n" +
                "1 0 1 0 0")));
    }
}