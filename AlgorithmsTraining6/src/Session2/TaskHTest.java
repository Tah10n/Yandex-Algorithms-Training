package Session2;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TaskHTest {

    @Test
    void findMinRelocations() throws IOException {
        assertEquals("10", TaskH.findMinRelocations(TaskH.readInput("4\n" +
                "5 2 3 1\n")));
    }

    @Test
    void findMinRelocations1() throws IOException {
        assertEquals("15", TaskH.findMinRelocations(TaskH.readInput("5\n" +
                "5 4 3 2 1\n")));
    }

    @Test
    void findMinRelocations3() throws IOException {
        assertEquals("6", TaskH.findMinRelocations(TaskH.readInput("4\n" +
                "5 1 1 1\n")));
    }

    @Test
    void findMinRelocations4() throws IOException {
        assertEquals("0", TaskH.findMinRelocations(TaskH.readInput("1\n" +
                "5\n")));
    }

    @Test
    void findMinRelocations5() throws IOException {
        assertEquals("1", TaskH.findMinRelocations(TaskH.readInput("2\n1 1")));
    }

    @Test
    void findMinRelocations6() throws IOException {
        assertEquals("1", TaskH.findMinRelocations(TaskH.readInput("2\n100 1")));
    }

    @Test
    void findMinRelocations7() throws IOException {
        assertEquals("0", TaskH.findMinRelocations(TaskH.readInput("3\n5 0 0")));
    }

    @Test
    void findMinRelocations8() throws IOException {
        assertEquals("8", TaskH.findMinRelocations(TaskH.readInput("5\n1 2 2 2 1")));
    }

    @Test
    void findMinRelocations9() throws IOException {
        assertEquals("12", TaskH.findMinRelocations(TaskH.readInput("4\n3 3 3 3")));
    }

    @Test
    void findMinRelocations10() throws IOException {
        assertEquals("6", TaskH.findMinRelocations(TaskH.readInput("5\n1 1 1 1 1")));
    }

    @Test
    void findMinRelocations11() throws IOException {
        assertEquals("12", TaskH.findMinRelocations(TaskH.readInput("5\n3 1 2 1 2")));
    }

    @Test
    void findMinRelocations12() throws IOException {
        assertEquals("14", TaskH.findMinRelocations(TaskH.readInput("5\n4 1 2 1 2")));
    }

    @Test
    void findMinRelocations13() throws IOException {
        assertEquals("15", TaskH.findMinRelocations(TaskH.readInput("5\n5 1 2 1 2")));
    }

    @Test
    void findMinRelocations14() throws IOException {
        assertEquals("40", TaskH.findMinRelocations(TaskH.readInput("7\n7 6 5 4 3 2 1")));
    }

    @Test
    void findMinRelocations15() throws IOException {
        assertEquals("40", TaskH.findMinRelocations(TaskH.readInput("7\n1 2 3 4 5 6 7")));
    }

    @Test
    void findMinRelocations16() throws IOException {
        assertEquals("25000000000", TaskH.findMinRelocations(TaskH.readInput("10\n" +
                "1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000\n")));
    }
}