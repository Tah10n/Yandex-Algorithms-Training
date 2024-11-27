package Session4;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class TaskFTest {

    @Test
    void calculateCoins() throws IOException {
        assertEquals("5 1 1", TaskF.calculateCoins(TaskF.readInput("3\n" +
                "1 1\n")));
    }

    @Test
    void calculateCoins1() throws IOException {
        assertEquals("13 8 1 3 1", TaskF.calculateCoins(TaskF.readInput("5\n" +
                "1 2 2 4\n")));
    }

    @Test
    void calculateCoins42() throws IOException {
        File file = new File("output4F42.txt");
        String string = new BufferedReader(new FileReader(file)).readLine();
        assertEquals(string, TaskF.calculateCoins(TaskF.readInput("input4F42.txt")).trim());
    }

    @Test
    void calculateCoins44() throws IOException {
        File file = new File("output4F44.txt");
        String string = new BufferedReader(new FileReader(file)).readLine();
        assertEquals(string, TaskF.calculateCoins(TaskF.readInput("input4F44.txt")).trim());
    }
}