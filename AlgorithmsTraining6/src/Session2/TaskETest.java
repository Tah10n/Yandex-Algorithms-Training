package Session2;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TaskETest {

    @Test
    void findAnswer() throws IOException {
        assertEquals("8 3 19", TaskE.findAnswer(TaskE.readInput("3\n" +
                "19 3 8\n")));
    }

    @Test
    void findAnswer1() throws IOException {
        assertEquals("2 2 1 4", TaskE.findAnswer(TaskE.readInput("4\n" +
                "1 2 4 2\n")));
    }

    @Test
    void findAnswer2() throws IOException {
        assertEquals("5 4 6 3 7 2 8 1 9", TaskE.findAnswer(TaskE.readInput("9\n" +
                "3 7 2 6 1 5 4 8 9\n")));
    }
}