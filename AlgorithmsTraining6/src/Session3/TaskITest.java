package Session3;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TaskITest {

    @Test
    void getAnswer() throws IOException {
        assertEquals("1\n1\n2\n3\n", TaskI.getAnswer1(TaskI.readInput("4\n" +
                "1 3\n" +
                "1 1\n" +
                "3 1\n" +
                "2 1\n" +
                "2 2\n")));
    }

    @Test
    void getAnswer1() throws IOException {
        assertEquals("1\n1\n2\n3\n4\n5\n", TaskI.getAnswer1(TaskI.readInput("6\n1 3\n1 1\n3 1\n2 1\n2 2\n2 3\n2 4\n")));
    }

    @Test
    void getAnswer2() throws IOException {
        assertEquals("5\n4\n3\n1\n2\n", TaskI.getAnswer1(TaskI.readInput("5\n" +
                "1 4\n" +
                "1 4\n" +
                "1 3\n" +
                "1 2\n" +
                "4 1\n" +
                "4 2")));
    }

    @Test
    void getAnswer3() throws IOException {
        assertEquals("5\n4\n3\n1\n2\n", TaskI.getAnswer1(TaskI.readInput("5\n" +
                "1 4\n" +
                "1 4\n" +
                "1 3\n" +
                "1 2\n" +
                "4 1\n" +
                "4 2")));
    }

    @Test
    void getAnswer4() throws IOException {
        assertEquals("1\n1\n2\n3\n", TaskI.getAnswer1(TaskI.readInput("4\n" +
                "1 3\n" +
                "1 1\n" +
                "3 1\n" +
                "2 1\n" +
                "2 2")));
    }

    @Test
    void getAnswer5() throws IOException {
        assertEquals("1\n2\n3\n4\n", TaskI.getAnswer1(TaskI.readInput("4\n" +
                "1 2\n" +
                "1 1\n" +
                "2 1\n" +
                "3 1\n" +
                "4 1")));
    }

    @Test
    void getAnswer6() throws IOException {
        assertEquals("1\n", TaskI.getAnswer1(TaskI.readInput("1\n" +
                "1 4\n" +
                "1 1")));
    }

    @Test
    void getAnswer7() throws IOException {
        assertEquals("1\n2\n4\n3\n", TaskI.getAnswer1(TaskI.readInput("4\n" +
                "1 3\n" +
                "3 1\n" +
                "1 2\n" +
                "2 2\n" +
                "2 1")));
    }

    @Test
    void getAnswer8() throws IOException {
        assertEquals("1\n2\n3\n4\n5\n6\n", TaskI.getAnswer1(TaskI.readInput("6\n" +
                "3 4\n" +
                "3 1\n" +
                "3 2\n" +
                "3 3\n" +
                "4 1\n" +
                "4 2\n" +
                "4 3")));
    }

    @Test
    void getAnswer9() throws IOException {
        assertEquals("3\n4\n1\n2\n", TaskI.getAnswer1(TaskI.readInput("4\n" +
                "3 2\n" +
                "1 1\n" +
                "1 2\n" +
                "3 1\n" +
                "3 2")));
    }

    @Test
    void getAnswer10() throws IOException {
        assertEquals("3\n4\n1\n2\n", TaskI.getAnswer1(TaskI.readInput("4\n" +
                "3 4\n" +
                "1 1\n" +
                "1 2\n" +
                "3 1\n" +
                "3 2")));
    }

    @Test
    void getAnswer11() throws IOException {
        assertEquals("1\n2\n3\n4\n", TaskI.getAnswer1(TaskI.readInput("4\n" +
                "1 4\n" +
                "1 1\n" +
                "1 2\n" +
                "3 1\n" +
                "3 2")));
    }

    @Test
    void getAnswer12() throws IOException {
        assertEquals("1\n2\n3\n4\n", TaskI.getAnswer1(TaskI.readInput("4\n" +
                "1 2\n" +
                "1 1\n" +
                "1 2\n" +
                "3 1\n" +
                "3 2")));
    }

    @Test
    void getAnswer13() throws IOException {
        assertEquals("3\n2\n1\n4\n5\n", TaskI.getAnswer1(TaskI.readInput("5\n" +
                "1 4\n" +
                "2 1\n" +
                "1 1\n" +
                "4 1\n" +
                "3 2\n" +
                "3 4")));
    }

    @Test
    void getAnswer14() throws IOException {
        assertEquals("1\n" +
                "3\n" +
                "2\n" +
                "21\n" +
                "22\n" +
                "4\n" +
                "5\n" +
                "23\n" +
                "16\n" +
                "6\n" +
                "24\n" +
                "7\n" +
                "17\n" +
                "11\n" +
                "8\n" +
                "12\n" +
                "9\n" +
                "13\n" +
                "18\n" +
                "10\n" +
                "14\n" +
                "19\n" +
                "25\n" +
                "15\n" +
                "20\n", TaskI.getAnswer1(TaskI.readInput("25\n" +
                "1 2\n" +
                "1 1\n" +
                "4 2\n" +
                "1 2\n" +
                "4 3\n" +
                "4 4\n" +
                "3 4\n" +
                "1 5\n" +
                "4 5\n" +
                "3 5\n" +
                "1 6\n" +
                "4 6\n" +
                "2 6\n" +
                "3 6\n" +
                "2 7\n" +
                "1 8\n" +
                "2 8\n" +
                "1 9\n" +
                "2 9\n" +
                "3 9\n" +
                "1 10\n" +
                "2 10\n" +
                "3 10\n" +
                "4 10\n" +
                "2 11\n" +
                "3 11")));
    }

    @Test
    void getAnswer15() throws IOException {
        assertEquals("3\n" +
                "4\n" +
                "1\n" +
                "2\n" +
                "4\n" +
                "3\n" +
                "5\n" +
                "6\n" +
                "5\n" +
                "6\n", TaskI.getAnswer1(TaskI.readInput("10\n" +
                "1 3\n" +
                "1 3\n" +
                "4 2\n" +
                "1 1\n" +
                "1 2\n" +
                "2 4\n" +
                "3 3\n" +
                "1 5\n" +
                "2 5\n" +
                "3 5\n" +
                "4 5")));
    }

    @Test
    void getAnswer16() throws IOException {
        assertEquals("1\n" +
                "4\n" +
                "1\n" +
                "4\n" +
                "2\n" +
                "9\n" +
                "3\n" +
                "9\n" +
                "5\n" +
                "10\n" +
                "6\n" +
                "10\n" +
                "7\n" +
                "8\n" +
                "11\n", TaskI.getAnswer1(TaskI.readInput("15\n" +
                "1 3\n" +
                "1 1\n" +
                "2 1\n" +
                "3 1\n" +
                "4 1\n" +
                "1 2\n" +
                "2 3\n" +
                "3 3\n" +
                "4 4\n" +
                "1 5\n" +
                "2 5\n" +
                "3 6\n" +
                "4 6\n" +
                "1 7\n" +
                "3 8\n" +
                "4 9")));
    }

    @Test
    void getAnswer17() throws IOException {
        assertEquals("1\n" +
                "2\n" +
                "6\n" +
                "3\n" +
                "4\n" +
                "5\n", TaskI.getAnswer1(TaskI.readInput("6\n" +
                "1 2\n" +
                "1 1\n" +
                "3 2\n" +
                "4 2\n" +
                "2 3\n" +
                "1 4\n" +
                "3 5")));
    }

    @Test
    void getAnswer18() throws IOException {
        assertEquals("2\n1\n5\n4\n3\n", TaskI.getAnswer1(TaskI.readInput("5\n" +
                "1 2\n" +
                "2 1\n" +
                "1 1\n" +
                "4 2\n" +
                "3 2\n" +
                "1 3")));
    }

    @Test
    void getAnswer19() throws IOException {
        assertEquals("1\n4\n5\n2\n3\n2\n3\n4\n", TaskI.getAnswer1(TaskI.readInput("8\n" +
                "1 3\n" +
                "2 1\n" +
                "2 2\n" +
                "2 3\n" +
                "3 2\n" +
                "3 3\n" +
                "1 2\n" +
                "1 3\n" +
                "4 3")));
    }

    @Test
    void getAnswer20() throws IOException {
        assertEquals("4\n1\n4\n2\n3\n5\n3\n", TaskI.getAnswer1(TaskI.readInput("7\n" +
                "1 3\n" +
                "2 1\n" +
                "3 1\n" +
                "4 2\n" +
                "1 2\n" +
                "3 3\n" +
                "2 3\n" +
                "1 3")));
    }

    @Test
    void getAnswer40() throws IOException {
        assertEquals("59\n67\n25\n79\n8\n94\n32\n2\n41\n44\n29\n61\n34\n20\n66\n100\n75\n87\n97\n73\n93\n71\n68\n43\n95\n82\n77\n", TaskI.getAnswer1(TaskI.readInput("27\n" +
                "4 3\n" +
                "4 59\n" +
                "4 66\n" +
                "3 25\n" +
                "3 79\n" +
                "2 8\n" +
                "4 94\n" +
                "2 32\n" +
                "1 2\n" +
                "3 41\n" +
                "1 43\n" +
                "2 29\n" +
                "4 61\n" +
                "4 34\n" +
                "2 20\n" +
                "3 66\n" +
                "3 100\n" +
                "3 75\n" +
                "3 87\n" +
                "2 97\n" +
                "1 73\n" +
                "3 93\n" +
                "1 71\n" +
                "1 67\n" +
                "3 43\n" +
                "2 95\n" +
                "2 82\n" +
                "2 77")));
    }
}