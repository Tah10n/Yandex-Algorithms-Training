package Session3;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TaskJTest {

    @Test
    void findMinInconvenience0() throws IOException {
        assertEquals(2, TaskJ.findMinInconvenience(TaskJ.readInput("4 7\n" +
                "1 4 1 2\n" +
                "1 4 2 3\n")));
    }

    @Test
    void findMinInconvenience1() throws IOException {
        assertEquals(1, TaskJ.findMinInconvenience(TaskJ.readInput("5 6\n" +
                "1 3 5 4 2\n" +
                "5 4 3 2 1\n")));
    }

    @Test
    void findMinInconvenience2() throws IOException {
        assertEquals(3, TaskJ.findMinInconvenience(TaskJ.readInput("6 15\n" +
                "1 2 5 7 8 11\n" +
                "1 1 4 2 3 6\n")));
    }

    @Test
    void findMinInconvenience21() throws IOException {
        String inputString = "6 15\n1 2 5 7 8 11\n1 1 4 2 3 6\n";
        assertEquals(3, TaskJ.findMinInconvenience(TaskJ.readInput(inputString)));
    }

    @Test
    void findMinInconvenience3() throws IOException {
        assertEquals(5, TaskJ.findMinInconvenience(TaskJ.readInput("6 8\n" +
                "1 7 8 13 14 18\n" +
                "2 2 2 2 2 2")));
    }

    @Test
    void findMinInconvenience4() throws IOException {
        assertEquals(2, TaskJ.findMinInconvenience(TaskJ.readInput("5 9\n" +
                "1 3 6 5 2\n" +
                "3 4 3 2 1")));
    }

    @Test
    void findMinInconvenience5() throws IOException {
        assertEquals(2, TaskJ.findMinInconvenience(TaskJ.readInput("5 9\n" +
                "1 5 8 7 2\n" +
                "1 4 3 2 1")));
    }

    @Test
    void findMinInconvenience6() throws IOException {
        assertEquals(0, TaskJ.findMinInconvenience(TaskJ.readInput("4 6\n" +
                "1 2 3 6 7\n" +
                "6 2 3 5 3")));
    }

    @Test
    void findMinInconvenience7() throws IOException {
        assertEquals(5, TaskJ.findMinInconvenience(TaskJ.readInput("5 10\n" +
                "1 2 3 10 15\n" +
                "1 1 1 5 5")));
    }

    @Test
    void findMinInconvenience8() throws IOException {
        assertEquals(1, TaskJ.findMinInconvenience(TaskJ.readInput("3 10\n" +
                "2 3 5\n" +
                "5 5 5")));
    }

    @Test
    void findMinInconvenience9() throws IOException {
        assertEquals(1, TaskJ.findMinInconvenience(TaskJ.readInput("input3J1.txt")));
    }

    @Test
    void findMinInconvenience10() throws IOException {
        assertEquals(15, TaskJ.findMinInconvenience(TaskJ.readInput("20 50\n" +
                "1 44 88 12 16 80 22 114 26 300 34 54 45 20 31 65 25 40 50 60 \n" +
                "1 2 3 1 2 3 1 2 3 1 2 3 4 5 7 2 2 4 2 5")));
    }

    @Test
    void findMinInconvenience11() throws IOException {
        assertEquals(1, TaskJ.findMinInconvenience(TaskJ.readInput("input3J2.txt")));
    }
}