package Session4;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TaskHTest {

    @Test
    void calculateMinPrice1() throws IOException {

        assertEquals("26 3\n" +
                "1 3 4", TaskH.calculateMinPrice(TaskH.readInput("6\n" +
                "1 2\n" +
                "2 3\n" +
                "1 4\n" +
                "4 5\n" +
                "4 6\n" +
                "22 48 2 2 8 1\n")));
    }

    @Test
    void calculateMinPrice2() throws IOException {
        assertEquals("3 2\n1 3", TaskH.calculateMinPrice(TaskH.readInput("3\n" +
                "1 2\n" +
                "2 3\n" +
                "1 5 2\n")));
    }

    @Test
    void calculateMinPrice3() throws IOException {
        assertEquals("2 1\n2", TaskH.calculateMinPrice(TaskH.readInput("4\n" +
                "2 1\n" +
                "2 3\n" +
                "2 4\n" +
                "5 2 5 5\n")));
    }

    @Test
    void calculateMinPrice4() throws IOException {
        assertEquals("4 2\n2 3", TaskH.calculateMinPrice(TaskH.readInput("7\n" +
                "1 2\n" +
                "1 3\n" +
                "2 4\n" +
                "2 5\n" +
                "3 6\n" +
                "3 7\n" +
                "5 2 2 5 5 5 5\n")));
    }

    @Test
    void calculateMinPrice5() throws IOException {
        assertEquals("3 2\n2 4", TaskH.calculateMinPrice(TaskH.readInput("5\n" +
                "1 2\n" +
                "2 3\n" +
                "3 4\n" +
                "4 5\n" +
                "5 1 5 2 5\n")));
    }

    @Test
    void calculateMinPrice6() throws IOException {
        assertEquals("2 2\n1 3", TaskH.calculateMinPrice(TaskH.readInput("4\n" +
                "1 2\n" +
                "2 3\n" +
                "3 4\n" +
                "1 1 1 1\n")));
    }

    @Test
    void calculateMinPrice7() throws IOException {
        assertEquals("1101 2\n" +
                "1 3", TaskH.calculateMinPrice(TaskH.readInput("4\n" +
                "1 2\n" +
                "2 3\n" +
                "3 4\n" +
                "1000 1000 101 1000\n")));
    }

    @Test
    void calculateMinPrice8() throws IOException {
        assertEquals("1 1\n1", TaskH.calculateMinPrice(TaskH.readInput("2\n" +
                "1 2\n" +
                "1 2\n")));
    }

    @Test
    void calculateMinPrice9() throws IOException {
        File file = new File("output4H9.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();
        String string = bufferedReader.readLine();
        stringBuilder.append(string).append("\n");
        String string2 = bufferedReader.readLine();
        stringBuilder.append(string2);
        assertEquals(stringBuilder.toString(), TaskH.calculateMinPrice(TaskH.readInput("input4H9.txt")));
    }

    @Test
    void calculateMinPrice10() throws IOException {
        assertEquals("48 4\n" +
                "2 5 6 8", TaskH.calculateMinPrice(TaskH.readInput("8\n" +
                "1 2\n" +
                "2 3\n" +
                "2 4\n" +
                "3 5\n" +
                "3 6\n" +
                "5 7\n" +
                "4 8\n" +
                "20 29 10 35 3 4 5 12")));
    }


    @Test
    void calculateMinPrice11() throws IOException {
        assertEquals("100 1\n" +
                "1", TaskH.calculateMinPrice(TaskH.readInput("1\n" +
                "100")));
    }

    @Test
    void calculateMinPrice12() throws IOException {
        assertEquals("4 4\n" +
                "2 4 6 8", TaskH.calculateMinPrice(TaskH.readInput("10\n" +
                "1 2\n" +
                "2 3\n" +
                "2 4\n" +
                "4 5\n" +
                "4 6\n" +
                "6 7\n" +
                "7 8\n" +
                "8 9\n" +
                "8 10\n" +
                "1 1 1 1 1 1 1 1 1 1")));
    }

    @Test
    void calculateMinPrice13() throws IOException {
        assertEquals("29 5\n" +
                "1 2 4 8 9", TaskH.calculateMinPrice(TaskH.readInput("12\n" +
                "1 2\n" +
                "1 7\n" +
                "2 3\n" +
                "2 4\n" +
                "5 4\n" +
                "6 4\n" +
                "8 7\n" +
                "7 9\n" +
                "10 9\n" +
                "11 9\n" +
                "9 12\n" +
                "1 2 10 4 7 7 18 7 15 3 3 3")));
    }

    @Test
    void calculateMinPrice14() throws IOException {
        assertEquals("2 1\n" +
                "2", TaskH.calculateMinPrice(TaskH.readInput("3\n" +
                "1 2\n" +
                "2 3\n" +
                "1 2 3")));
    }

    @Test
    void calculateMinPrice15() throws IOException {
        assertEquals("4 1\n" +
                "1", TaskH.calculateMinPrice(TaskH.readInput("6\n" +
                "1 2\n" +
                "1 3\n" +
                "1 4\n" +
                "1 5\n" +
                "1 6\n" +
                "4 1 1 1 1 1")));
    }

    @Test
    void calculateMinPrice16() throws IOException {
        assertEquals("5 5\n" +
                "2 3 4 5 6", TaskH.calculateMinPrice(TaskH.readInput("6\n" +
                "1 2\n" +
                "1 3\n" +
                "1 4\n" +
                "1 5\n" +
                "1 6\n" +
                "100 1 1 1 1 1")));
    }

    @Test
    void calculateMinPrice17() throws IOException {
        assertEquals("4 4\n" +
                "1 2 4 7", TaskH.calculateMinPrice(TaskH.readInput("8\n" +
                "1 2\n" +
                "1 6\n" +
                "2 3\n" +
                "3 4\n" +
                "4 5\n" +
                "6 7\n" +
                "7 8\n" +
                "1 1 1 1 1 1 1 1")));
    }

    @Test
    void calculateMinPrice18() throws IOException {
        assertEquals("2 2\n" +
                "2 4", TaskH.calculateMinPrice(TaskH.readInput("5\n" +
                "1 2\n" +
                "2 3\n" +
                "3 4\n" +
                "4 5\n" +
                "10 1 10 1 10")));
    }

    @Test
    void calculateMinPrice19() throws IOException {
        assertEquals("180 3\n" +
                "1 3 4", TaskH.calculateMinPrice(TaskH.readInput("5\n" +
                "1 2\n" +
                "2 3\n" +
                "3 4\n" +
                "4 5\n" +
                "101 230 77 2 122")));
    }

    @Test
    void calculateMinPrice20() throws IOException {
        assertEquals("23 1\n" +
                "2", TaskH.calculateMinPrice(TaskH.readInput("2\n" +
                "1 2\n" +
                "129 23")));
    }

    @Test
    void calculateMinPrice21() throws IOException {
        assertEquals("74 10\n" +
                "1 3 5 6 10 11 15 17 18 19", TaskH.calculateMinPrice(TaskH.readInput("19\n" +
                "1 2\n" +
                "1 3\n" +
                "14 10\n" +
                "10 11\n" +
                "15 16\n" +
                "1 4\n" +
                "8 5\n" +
                "5 1\n" +
                "2 6\n" +
                "16 17\n" +
                "18 16\n" +
                "9 3\n" +
                "16 19\n" +
                "11 13\n" +
                "10 9\n" +
                "14 15\n" +
                "5 7\n" +
                "12 11\n" +
                "1 24 1 1 1 16 3 19 30 17 10 3 19 26 25 10 1 1 1")));
    }

    @Test
    void calculateMinPrice22() throws IOException {
        assertEquals("2 2\n" +
                "2 4", TaskH.calculateMinPrice(TaskH.readInput("5\n" +
                "1 2\n" +
                "2 3\n" +
                "3 4\n" +
                "4 5\n" +
                "2 1 2 1 2")));
    }

    @Test
    void calculateMinPrice23() throws IOException {
        assertEquals("5 3\n" +
                "1 3 5", TaskH.calculateMinPrice(TaskH.readInput("6\n" +
                "1 2\n" +
                "2 3\n" +
                "3 4\n" +
                "4 5\n" +
                "5 6\n" +
                "1 2 2 2 2 1")));
    }

}