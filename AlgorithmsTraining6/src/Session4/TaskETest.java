package Session4;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TaskETest {

    @Test
    void printTreeSizes() throws IOException {
        assertEquals("4 1 1 1 ", TaskE.printTreeSizes(TaskE.readInput("4\n" +
                "1 2\n" +
                "1 3\n" +
                "1 4\n")));
    }

    @Test
    void printTreeSizes1() throws IOException {
        assertEquals("7 1 1 1 3 1 1 ", TaskE.printTreeSizes(TaskE.readInput("7\n" +
                "1 2\n" +
                "1 3\n" +
                "1 4\n" +
                "5 1\n" +
                "5 6\n" +
                "5 7\n")));
    }

    @Test
    void printTreeSizes2() throws IOException {
        assertEquals("5 1 1 4 2 ", TaskE.printTreeSizes(TaskE.readInput("5\n" +
                "1 4\n" +
                "3 4\n" +
                "5 2\n" +
                "5 4\n")));
    }
}