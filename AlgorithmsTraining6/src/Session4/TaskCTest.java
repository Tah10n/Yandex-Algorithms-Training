package Session4;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskCTest {

    @Test
    void printLCA() throws IOException {
        assertEquals("Paul_I\n" +
                "Peter_I\n" +
                "Anna\n", TaskC.printLCA(TaskC.readInput("9\n" +
                "Alexei Peter_I\n" +
                "Anna Peter_I\n" +
                "Elizabeth Peter_I\n" +
                "Peter_II Alexei\n" +
                "Peter_III Anna\n" +
                "Paul_I Peter_III\n" +
                "Alexander_I Paul_I\n" +
                "Nicholaus_I Paul_I\n" +
                "Alexander_I Nicholaus_I\n" +
                "Peter_II Paul_I\n" +
                "Alexander_I Anna\n")));
    }

    @Test
    void printLCA1() throws IOException {
        assertEquals("A1\n" +
                "A2\n" +
                "A1\n" +
                "A10\n" +
                "A1\n" +
                "A10\n" +
                "A10\n" +
                "A8\n" +
                "A10\n" +
                "A10\n" +
                "A2\n" +
                "A2\n" +
                "A2\n" +
                "A10\n" +
                "A2\n" +
                "A10\n" +
                "A10\n" +
                "A2\n" +
                "A10\n" +
                "A10\n" +
                "A1\n" +
                "A2\n" +
                "A3\n" +
                "A10\n" +
                "A5\n" +
                "A10\n" +
                "A10\n" +
                "A8\n" +
                "A10\n" +
                "A10\n" +
                "A10\n" +
                "A10\n" +
                "A10\n" +
                "A4\n" +
                "A10\n" +
                "A6\n" +
                "A4\n" +
                "A10\n" +
                "A6\n" +
                "A10\n" +
                "A1\n" +
                "A2\n" +
                "A5\n" +
                "A10\n" +
                "A5\n" +
                "A10\n" +
                "A10\n" +
                "A8\n" +
                "A10\n" +
                "A10\n" +
                "A10\n" +
                "A10\n" +
                "A10\n" +
                "A6\n" +
                "A10\n" +
                "A6\n" +
                "A6\n" +
                "A10\n" +
                "A6\n" +
                "A10\n" +
                "A10\n" +
                "A10\n" +
                "A10\n" +
                "A4\n" +
                "A10\n" +
                "A6\n" +
                "A7\n" +
                "A10\n" +
                "A6\n" +
                "A10\n" +
                "A8\n" +
                "A2\n" +
                "A8\n" +
                "A10\n" +
                "A8\n" +
                "A10\n" +
                "A10\n" +
                "A8\n" +
                "A10\n" +
                "A10\n" +
                "A10\n" +
                "A10\n" +
                "A10\n" +
                "A6\n" +
                "A10\n" +
                "A6\n" +
                "A6\n" +
                "A10\n" +
                "A9\n" +
                "A10\n" +
                "A10\n" +
                "A10\n" +
                "A10\n" +
                "A10\n" +
                "A10\n" +
                "A10\n" +
                "A10\n" +
                "A10\n" +
                "A10\n" +
                "A10\n", TaskC.printLCA(TaskC.readInput("10\n" +
                "A1 A8\n" +
                "A2 A10\n" +
                "A3 A5\n" +
                "A4 A6\n" +
                "A5 A1\n" +
                "A6 A10\n" +
                "A7 A4\n" +
                "A8 A2\n" +
                "A9 A6\n" +

                "A1 A1\n" +
                "A1 A2\n" +
                "A1 A3\n" +
                "A1 A4\n" +
                "A1 A5\n" +
                "A1 A6\n" +
                "A1 A7\n" +
                "A1 A8\n" +
                "A1 A9\n" +
                "A1 A10\n" +
                "A2 A1\n" +
                "A2 A2\n" +
                "A2 A3\n" +
                "A2 A4\n" +
                "A2 A5\n" +
                "A2 A6\n" +
                "A2 A7\n" +
                "A2 A8\n" +
                "A2 A9\n" +
                "A2 A10\n" +
                "A3 A1\n" +
                "A3 A2\n" +
                "A3 A3\n" +
                "A3 A4\n" +
                "A3 A5\n" +
                "A3 A6\n" +
                "A3 A7\n" +
                "A3 A8\n" +
                "A3 A9\n" +
                "A3 A10\n" +
                "A4 A1\n" +
                "A4 A2\n" +
                "A4 A3\n" +
                "A4 A4\n" +
                "A4 A5\n" +
                "A4 A6\n" +
                "A4 A7\n" +
                "A4 A8\n" +
                "A4 A9\n" +
                "A4 A10\n" +
                "A5 A1\n" +
                "A5 A2\n" +
                "A5 A3\n" +
                "A5 A4\n" +
                "A5 A5\n" +
                "A5 A6\n" +
                "A5 A7\n" +
                "A5 A8\n" +
                "A5 A9\n" +
                "A5 A10\n" +
                "A6 A1\n" +
                "A6 A2\n" +
                "A6 A3\n" +
                "A6 A4\n" +
                "A6 A5\n" +
                "A6 A6\n" +
                "A6 A7\n" +
                "A6 A8\n" +
                "A6 A9\n" +
                "A6 A10\n" +
                "A7 A1\n" +
                "A7 A2\n" +
                "A7 A3\n" +
                "A7 A4\n" +
                "A7 A5\n" +
                "A7 A6\n" +
                "A7 A7\n" +
                "A7 A8\n" +
                "A7 A9\n" +
                "A7 A10\n" +
                "A8 A1\n" +
                "A8 A2\n" +
                "A8 A3\n" +
                "A8 A4\n" +
                "A8 A5\n" +
                "A8 A6\n" +
                "A8 A7\n" +
                "A8 A8\n" +
                "A8 A9\n" +
                "A8 A10\n" +
                "A9 A1\n" +
                "A9 A2\n" +
                "A9 A3\n" +
                "A9 A4\n" +
                "A9 A5\n" +
                "A9 A6\n" +
                "A9 A7\n" +
                "A9 A8\n" +
                "A9 A9\n" +
                "A9 A10\n" +
                "A10 A1\n" +
                "A10 A2\n" +
                "A10 A3\n" +
                "A10 A4\n" +
                "A10 A5\n" +
                "A10 A6\n" +
                "A10 A7\n" +
                "A10 A8\n" +
                "A10 A9\n" +
                "A10 A10\n")));
    }
}