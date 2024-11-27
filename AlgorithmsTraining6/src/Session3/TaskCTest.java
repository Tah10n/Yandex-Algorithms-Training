package Session3;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TaskCTest {

    @Test
    void findMinInWindow() throws IOException {
        assertEquals("1\n2\n2\n3\n1", TaskC.findMinInWindow(TaskC.readInput("7 3\n" +
                "1 3 2 4 5 3 1\n")));
    }

    @Test
    void findMinInWindow1() throws IOException {
        assertEquals("2\n2\n2\n2\n2\n3", TaskC.findMinInWindow(TaskC.readInput("8 3\n" +
                "3 2 4 6 2 3 5 7\n")));
    }
}