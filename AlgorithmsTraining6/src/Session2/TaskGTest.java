package Session2;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TaskGTest {

    @Test
    void findSubstring() throws IOException {
        assertEquals(2, TaskG.findSubstring(TaskG.readInput("3 1\n" +
                "aab\n")));
    }

    @Test
    void findSubstring1() throws IOException {
        assertEquals(4, TaskG.findSubstring(TaskG.readInput("6 2\n" +
                "aabcbb\n")));
    }

    @Test
    void findSubstring2() throws IOException {
        assertEquals(1, TaskG.findSubstring(TaskG.readInput("1 0\n" +
                "a")));
    }

    @Test
    void findSubstring3() throws IOException {
        assertEquals(39, TaskG.findSubstring(TaskG.readInput("50 159\n" +
                "aaabaababaabaaaabaabbxaazbaaaababaababbbaaaabaabbb")));
    }

    @Test
    void findSubstring4() throws IOException {
        assertEquals(609, TaskG.findSubstring(TaskG.readInput("700 47553\n" +
                "bbbabbabaaabaababaaaabbaabaabaaabbabqabaabbbbaaaabaaabaaabbbaaabaaaaaaaaaaaaaabbaabaababbaabaabbbaaaabaabaaaabaabaabbaaabbbabbbbbaabbbaabaaabbaaaaabbbaabbaabbbabababbabaabaabbabbbbabbbbaarbababbabbaaaaabbbabaaabbaaaaaaaabaabaaababbbaabbbabbabbabaabbabbaabaaaabaabaaabbbbbbababaabababaabbabbbbbbafaabbabaaabaaaababaaabbaabaabbabbababababbaaaabbbbbbabbbabbbabbbbaaaabbaabbabbabbaaabbbbababbaaaabbaabbabbbabaababbabbaabbbababaabbabbbdabaaaabaabbaabaaabbbababbbbabbabbaaabbbaaaabbaabbbbbbbaabababaaaabbbbaaaaabbaabaabaabbababaaaaaababbbbaababbbababaaaabaabaaaabbbbbbbbbbbbbaabbaaabbbbaeaapabbaabbbbbaaababababbbabbaaaaabaababbbaababbbaaabrbaabbbababbaabbaabababbbbabaaaabbaaabbbabbbababbbaabbabbbbbaabaab")));
    }

    @Test
    void findSubstring52() throws IOException {
        assertEquals(572026, TaskG.findSubstring(TaskG.readInput("inputG52.txt")));
    }

    @Test
    void findSubstring5() throws IOException {
        assertEquals(609, TaskG.findSubstring(TaskG.readInput("700 47553\n" +
                "bbbabbabaaabaababaaaabbaabaabaaabbabqabaabbbbaaaabaaabaaabbbaaabaaaaaaaaaaaaaabbaabaababbaabaabbbaaaabaabaaaabaabaabbaaabbbabbbbbaabbbaabaaabbaaaaabbbaabbaabbbabababbabaabaabbabbbbabbbbaarbababbabbaaaaabbbabaaabbaaaaaaaabaabaaababbbaabbbabbabbabaabbabbaabaaaabaabaaabbbbbbababaabababaabbabbbbbbafaabbabaaabaaaababaaabbaabaabbabbababababbaaaabbbbbbabbbabbbabbbbaaaabbaabbabbabbaaabbbbababbaaaabbaabbabbbabaababbabbaabbbababaabbabbbdabaaaabaabbaabaaabbbababbbbabbabbaaabbbaaaabbaabbbbbbbaabababaaaabbbbaaaaabbaabaabaabbababaaaaaababbbbaababbbababaaaabaabaaaabbbbbbbbbbbbbaabbaaabbbbaeaapabbaabbbbbaaababababbbabbaaaaabaababbbaababbbaaabrbaabbbababbaabbaabababbbbabaaaabbaaabbbabbbababbbaabbabbbbbaabaab\n")));
    }
}