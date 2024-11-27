package Session3;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TaskFTest {

    @Test
    void findMinRPS() throws IOException {
        assertEquals("([()])", TaskF.findMinRPS(TaskF.readInput("6\n" +
                "()[]\n" +
                "([(\n")));
    }

    @Test
    void findMinRPS1() throws IOException {
        assertEquals("([][])", TaskF.findMinRPS(TaskF.readInput("6\n" +
                "][)(\n" +
                "([\n")));
    }

    @Test
    void findMinRPS2() throws IOException {
        assertEquals("()[]", TaskF.findMinRPS(TaskF.readInput("4\n" +
                "(][)\n" +
                "()[]\n")));
    }

    @Test
    void findMinRPS3() throws IOException {
        assertEquals("([([][])])", TaskF.findMinRPS(TaskF.readInput("10\n" +
                "][)(\n" +
                "([(\n")));
    }

    @Test
    void findMinRPS4() throws IOException {
        assertEquals("([[]()[]](()))", TaskF.findMinRPS(TaskF.readInput("14\n" +
                "]([)\n" +
                "([[]()[]")));
    }

    @Test
    void findMinRPS5() throws IOException {
        assertEquals("((((()))))", TaskF.findMinRPS(TaskF.readInput("10\n" +
                "([])\n" +
                "\n")));
    }

    @Test
    void findMinRPS6() throws IOException {
        assertEquals("()()()", TaskF.findMinRPS(TaskF.readInput("6\n" +
                "])([\n" +
                "\n")));
    }
}