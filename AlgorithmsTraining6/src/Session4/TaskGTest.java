package Session4;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TaskGTest {

    @Test
    void calculateCombinations0() throws IOException {
        assertEquals(2, TaskG.calculateCombinations(TaskG.readInput("2 1 10\n" +
                "1 2\n")));
    }

    @Test
    void calculateCombinations1() throws IOException {
        assertEquals(4, TaskG.calculateCombinations(TaskG.readInput("3 2 10\n" +
                "1 2\n" +
                "1 3\n")));
    }

    @Test
    void calculateCombinations2() throws IOException {
        assertEquals(0, TaskG.calculateCombinations(TaskG.readInput("4 4 17\n" +
                "1 2\n" +
                "1 3\n" +
                "4 2\n" +
                "3 4\n")));
    }

    @Test
    void calculateCombinations3() throws IOException {
        assertEquals(7, TaskG.calculateCombinations(TaskG.readInput("4 2 13\n" +
                "1 2\n" +
                "2 3\n")));
    }


    @Test
    void calculateCombinations4() throws IOException {
        assertEquals(8, TaskG.calculateCombinations(TaskG.readInput("7 6 100\n" +
                "1 2\n" +
                "2 3\n" +
                "3 4\n" +
                "2 5\n" +
                "2 6\n" +
                "6 7")));
    }

    @Test
    void calculateCombinations5() throws IOException {
        assertEquals(32, TaskG.calculateCombinations(TaskG.readInput("6 4 1000\n" +
                "1 2\n" +
                "1 3\n" +
                "4 5\n" +
                "4 6")));
    }

    @Test
    void calculateCombinations6() throws IOException {
        assertEquals(48, TaskG.calculateCombinations(TaskG.readInput("6 3 100\n" +
                "5 6\n1 2\n3 4" )));
    }

    @Test
    void calculateCombinations7() throws IOException {
        assertEquals(12672, TaskG.calculateCombinations(TaskG.readInput("11 6 1001010\n" +
                "1 2\n" +
                "2 3\n" +
                "3 4\n" +
                "4 5\n" +
                "6 7\n" +
                "8 9")));
    }

    @Test
    void calculateCombinations8() throws IOException {
        assertEquals(48, TaskG.calculateCombinations(TaskG.readInput("5 2 100\n" +
                "1 2\n3 4")));
    }

    @Test
    void calculateCombinations9() throws IOException {
        assertEquals(4, TaskG.calculateCombinations(TaskG.readInput("5 4 1001010\n" +
                "1 2\n" +
                "2 3\n" +
                "3 4\n" +
                "4 5\n")));
    }

    @Test
    void calculateCombinations12() throws IOException {
        assertEquals(864, TaskG.calculateCombinations(TaskG.readInput("8 5 1000000\n" +
                "1 2\n" +
                "1 3\n" +
                "4 5\n" +
                "4 6\n" +
                "4 7")));
    }

    @Test
    void calculateCombinations11() throws IOException {
        assertEquals(256, TaskG.calculateCombinations(TaskG.readInput("7 4 1000000\n" +
                "1 2\n" +
                "1 3\n" +
                "4 5\n" +
                "4 6")));
    }

    @Test
    void calculateCombinations13() throws IOException {
        assertEquals(112, TaskG.calculateCombinations(TaskG.readInput("6 3 1000\n" +
                "2 4\n" +
                "4 3\n" +
                "6 5")));
    }

    @Test
    void calculateCombinations14() throws IOException {
        assertEquals(6144, TaskG.calculateCombinations(TaskG.readInput("18 14 1000000007\n" +
                "1 2\n" +
                "2 3\n" +
                "3 4\n" +
                "4 5\n" +
                "5 6\n" +
                "7 8\n" +
                "8 9\n" +
                "10 11\n" +
                "11 12\n" +
                "12 13\n" +
                "14 15\n" +
                "15 16\n" +
                "16 17\n" +
                "17 18")));
    }

    @Test
    void calculateCombinations15() throws IOException {
        assertEquals(8640, TaskG.calculateCombinations(TaskG.readInput("9 5 1000000\n" +
                "1 2\n" +
                "1 3\n" +
                "4 5\n" +
                "4 6\n" +
                "4 7")));
    }

    @Test
    void calculateCombinations16() throws IOException {
        assertEquals(35, TaskG.calculateCombinations(TaskG.readInput("16 8 37\n" +
                "1 9\n" +
                "1 6\n" +
                "5 6\n" +
                "8 7\n" +
                "11 2\n" +
                "8 16\n" +
                "11 10\n" +
                "11 14")));
    }

    @Test
    void calculateCombinations18() throws IOException {
        assertEquals(9, TaskG.calculateCombinations(TaskG.readInput("7 1 11\n" +
                "3 7")));
    }

    @Test
    void calculateCombinations27() throws IOException {
        assertEquals(40, TaskG.calculateCombinations(TaskG.readInput("4 1 1000\n" +
                "1 2")));
    }

    @Test
    void calculateCombinations22() throws IOException {
        assertEquals(11643, TaskG.calculateCombinations(TaskG.readInput("input4G22.txt")));
    }

    @Test
    void calculateCombinations10() throws IOException {
        assertEquals(0, TaskG.calculateCombinations(TaskG.readInput("input4G10.txt")));
    }

    @Test
    void calculateCombinations17() throws IOException {
        assertEquals(79531, TaskG.calculateCombinations(TaskG.readInput("input4G17.txt")));
    }


    @Test
    void calculateCombinations19() throws IOException {
        assertEquals(448152, TaskG.calculateCombinations(TaskG.readInput("input4G19.txt")));
    }

    @Test
    void calculateCombinations21() throws IOException {
        assertEquals(4224, TaskG.calculateCombinations(TaskG.readInput("11 7 1000000\n" +
                "1 2\n" +
                "2 3\n" +
                "3 4\n" +
                "4 5\n" +
                "5 6\n" +
                "7 8\n" +
                "7 9")));
    }

    @Test
    void calculateCombinations28() throws IOException {
        assertEquals(384, TaskG.calculateCombinations(TaskG.readInput("9 6 1000000\n" +
                "1 2\n" +
                "2 3\n" +
                "4 5\n" +
                "5 6\n" +
                "7 8\n" +
                "8 9")));
    }

    @Test
    void calculateCombinations23() throws IOException {
        assertEquals(4224, TaskG.calculateCombinations(TaskG.readInput("10 6 1000000\n" +
                "1 2\n" +
                "2 3\n" +
                "4 5\n" +
                "5 6\n" +
                "7 8\n" +
                "8 9")));
    }

    @Test
    void calculateCombinations24() throws IOException {
        assertEquals(50688, TaskG.calculateCombinations(TaskG.readInput("11 6 1000000\n" +
                "1 2\n" +
                "2 3\n" +
                "4 5\n" +
                "5 6\n" +
                "7 8\n" +
                "8 9")));
    }

    @Test
    void calculateCombinations25() throws IOException {
        assertEquals(87552, TaskG.calculateCombinations(TaskG.readInput("18 14 1000000\n" +
                "1 3\n" +
                "2 3\n" +
                "4 11\n" +
                "4 8\n" +
                "4 3\n" +
                "5 3\n" +
                "5 9\n" +
                "5 6\n" +
                "5 7\n" +
                "7 10\n" +
                "12 13\n" +
                "12 14\n" +
                "12 15\n" +
                "17 16")));
    }

    @Test
    void calculateCombinations25b() throws IOException {
        assertEquals(32, TaskG.calculateCombinations(TaskG.readInput("11 10 1000000\n" +
                "1 3\n" +
                "2 3\n" +
                "4 11\n" +
                "4 8\n" +
                "4 3\n" +
                "5 3\n" +
                "5 9\n" +
                "5 6\n" +
                "5 7\n" +
                "7 10\n")));
    }

    @Test
    void calculateCombinations26() throws IOException {
        assertEquals(96, TaskG.calculateCombinations(TaskG.readInput("input4G26.txt")));
    }

    @Test
    void calculateCombinations32() throws IOException {
        assertEquals(0, TaskG.calculateCombinations(TaskG.readInput("35 31 75011\n" +
                "1 2\n" +
                "2 3\n" +
                "6 7\n" +
                "6 5\n" +
                "5 4\n" +
                "4 3\n" +
                "8 9\n" +
                "8 10\n" +
                "8 11\n" +
                "8 12\n" +
                "8 13\n" +
                "8 14\n" +
                "8 15\n" +
                "8 16\n" +
                "8 17\n" +
                "8 19\n" +
                "8 20\n" +
                "8 21\n" +
                "8 22\n" +
                "8 23\n" +
                "8 24\n" +
                "8 25\n" +
                "8 26\n" +
                "8 27\n" +
                "8 29\n" +
                "8 30\n" +
                "30 31\n" +
                "31 32\n" +
                "32 33\n" +
                "34 35\n" +
                "31 34")));
    }

    @Test
    void calculateCombinations29() throws IOException {
        assertEquals(3840, TaskG.calculateCombinations(TaskG.readInput("10 5 1000000\n" +
                "1 2\n" +
                "3 4\n" +
                "5 6\n" +
                "7 8\n" +
                "9 10\n")));
    }

    @Test
    void calculateCombinations30() throws IOException {
        assertEquals(2304, TaskG.calculateCombinations(TaskG.readInput("11 8 1000000\n" +
                "1 2\n" +
                "2 3\n" +
                "3 4\n" +
                "3 6\n" +
                "3 7\n" +
                "8 9\n" +
                "10 11\n" +
                "3 5\n")));
    }

    @Test
    void calculateCombinations31() throws IOException {
        assertEquals(7680, TaskG.calculateCombinations(TaskG.readInput("11 6 1000000\n" +
                "1 2\n" +
                "3 4\n" +
                "5 6\n" +
                "7 8\n" +
                "9 10\n" +
                "1 11\n")));
    }


}