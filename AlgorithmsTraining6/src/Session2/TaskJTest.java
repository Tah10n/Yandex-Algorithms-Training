package Session2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TaskJTest {

    @Test
    void findAnswer() throws IOException {
        assertEquals("1 1 2 2", TaskJ.findAnswer(TaskJ.readInput("6\n" +
                "3 3 3 4 4 5\n" +
                "4 2\n" +
                "3 4 5 6")));
    }

    @Test
    void findAnswer1() throws IOException {
        assertEquals("1 1 1 4 4 6 7", TaskJ.findAnswer(TaskJ.readInput("7\n" +
                "1 5 7 2 10 10 6\n" +
                "7 0\n" +
                "1 2 3 4 5 6 7\n")));
    }

    @Test
    void findAnswer2() throws IOException {
        assertEquals("99990 5 5 5 27", TaskJ.findAnswer(TaskJ.readInput("inputJ1.txt")));
    }

    @Disabled
    @Test
    void findAnswer3() throws IOException {
        assertEquals("99990 5 5 5 27", TaskJ.findAnswer(TaskJ.readInput("inputJ2.txt")));
    }

    @Disabled
    @Test
    void findAnswer3_2() throws IOException {
        assertEquals("99990 5 5 5 27", TaskJ.findAnswer(TaskJ.readInput("inputJ3.txt")));
    }

    @Test
    void findAnswer4() throws IOException {
        assertEquals("9 7 3 1 1", TaskJ.findAnswer(TaskJ.readInput("10\n" +
                "1 2 2 3 3 3 2 2 1 1\n" +
                "5 1\n" +
                "10 7 5 3 1")));
    }

    @Test
    void findAnswer5() throws IOException {
        assertEquals("9 6 4 2 1", TaskJ.findAnswer(TaskJ.readInput("10\n" +
                "1 1 1 1 1 1 1 1 1 1\n" +
                "5 1\n" +
                "10 7 5 3 1")));
    }

    @Test
    void findAnswer6() throws IOException {
        assertEquals("10 10 10 10 10", TaskJ.findAnswer(TaskJ.readInput("10\n" +
                "1 1 1 1 1 1 1 1 5 1\n" +
                "5 1\n" +
                "10 10 10 10 10")));
    }

    @Test
    void findAnswer7() throws IOException {
        assertEquals("6", TaskJ.findAnswer(TaskJ.readInput("9\n" +
                "3 2 2 3 4 2 5 5 2\n" +
                "1 1\n" +
                "8")));
    }

    @Test
    void findAnswer8() throws IOException {
        assertEquals("12", TaskJ.findAnswer(TaskJ.readInput("17\n" +
                "1 1 2 2 3 3 4 4 5 5 6 6 7 7 8 8 9\n" +
                "1 2\n" +
                "17")));
    }

    @Test
    void findAnswer9() throws IOException {
        assertEquals("1 2 4", TaskJ.findAnswer(TaskJ.readInput("5\n" +
                "4 4 4 4 4\n" +
                "3 1\n" +
                "1 3 5")));
    }

    @Test
    void findAnswer10() throws IOException {
        assertEquals("1 3 3", TaskJ.findAnswer(TaskJ.readInput("5\n" +
                "5 4 4 4 5\n" +
                "3 1\n" +
                "1 4 5")));
    }

    @Test
    void findAnswer11() throws IOException {
        assertEquals("3 1 3", TaskJ.findAnswer(TaskJ.readInput("4\n" +
                "1 3 2 3\n" +
                "3 0\n" +
                "4 2 3")));
    }

    @Test
    void findAnswer12() throws IOException {
        assertEquals("1 1 1 1 1 1 7 8 8 8 8 9 10 14", TaskJ.findAnswer(TaskJ.readInput("14\n" +
                "1 1 1 2 3 4 3 2 2 2 5 5 5 1\n" +
                "14 2\n" +
                "1 2 3 4 5 6 7 8 9 10 11 12 13 14")));
    }

}