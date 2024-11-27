package Session3;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TaskHTest {

    @Test
    void getAnswer() throws IOException {
        assertEquals("5\n3\n2\n1\n", TaskH.getAnswer(TaskH.readInput("7\n+1\n+2\n+3\n?2\n-\n-\n?1")));
    }

    @Test
    void getAnswer1() throws IOException {
        assertEquals("15\n5\n4\n3\n6\n", TaskH.getAnswer(TaskH.readInput("10\n+1\n+2\n+3\n+4\n+5\n?5\n-\n-\n?1\n?4")));
    }

    @Test
    void getAnswer2() throws IOException {
        assertEquals("", TaskH.getAnswer(TaskH.readInput("1\n+1\n")));
    }

    @Test
    void getAnswer3() throws IOException {
        assertEquals("1\n", TaskH.getAnswer(TaskH.readInput("2\n+1\n-\n")));
    }

    @Test
    void getAnswer4() throws IOException {
        assertEquals("1\n0\n", TaskH.getAnswer(TaskH.readInput("3\n+1\n-\n?1\n")));
    }

    @Test
    void getAnswer5() throws IOException {
        assertEquals("1\n0\n", TaskH.getAnswer(TaskH.readInput("3\n+1\n-\n?0\n")));
    }

}