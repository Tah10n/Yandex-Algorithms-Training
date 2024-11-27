package Session4;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TaskBTest {

    @Test
    void printAllNodesWithDescendants() throws IOException {
        assertEquals("Alexander_I 0\n" +
                "Alexei 1\n" +
                "Anna 4\n" +
                "Elizabeth 0\n" +
                "Nicholaus_I 0\n" +
                "Paul_I 2\n" +
                "Peter_I 8\n" +
                "Peter_II 0\n" +
                "Peter_III 3\n", TaskB.printAllNodesWithDescendants(TaskB.readInput("9\n" +
                "Alexei Peter_I\n" +
                "Anna Peter_I\n" +
                "Elizabeth Peter_I\n" +
                "Peter_II Alexei\n" +
                "Peter_III Anna\n" +
                "Paul_I Peter_III\n" +
                "Alexander_I Paul_I\n" +
                "Nicholaus_I Paul_I\n")));
    }
}