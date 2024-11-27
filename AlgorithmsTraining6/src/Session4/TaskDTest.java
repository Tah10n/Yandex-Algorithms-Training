package Session4;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TaskDTest {

    @Test
    void processRequests() throws IOException {
        assertEquals("DONE\n" +
                "DONE\n" +
                "ALREADY\n" +
                "YES\n" +
                "DONE\n" +
                "2\n" +
                ".3\n" +
                "..5\n" +
                "NO\n", TaskD.processRequests(TaskD.readInput("ADD 2\n" +
                "ADD 3\n" +
                "ADD 2\n" +
                "SEARCH 2\n" +
                "ADD 5\n" +
                "PRINTTREE\n" +
                "SEARCH 7\n")));
    }

    @Test
    void processRequests1() throws IOException {
        assertEquals("DONE\n" +
                "DONE\n" +
                "DONE\n" +
                "DONE\n" +
                "DONE\n" +
                "DONE\n" +
                "DONE\n" +
                "DONE\n" +
                "DONE\n" +
                "...1\n" +
                "..2\n" +
                ".3\n" +
                "...4\n" +
                "..5\n" +
                "...6\n" +
                "7\n" +
                "..8\n" +
                ".9\n", TaskD.processRequests(TaskD.readInput("ADD 7\n" +
                "ADD 3\n" +
                "ADD 9\n" +
                "ADD 2\n" +
                "ADD 1\n" +
                "ADD 5\n" +
                "ADD 4\n" +
                "ADD 6\n" +
                "ADD 8\n" +
                "PRINTTREE\n")));
    }
}