package Session3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskATest {

    @Test
    void isParanthesesBalanced() {
        assertEquals("yes", TaskA.isParanthesesBalanced("()[]{}"));
    }

    @Test
    void isParanthesesBalanced1() {
        assertEquals("no", TaskA.isParanthesesBalanced("([)]"));
    }

    @Test
    void isParanthesesBalanced2() {
        assertEquals("no", TaskA.isParanthesesBalanced("("));
    }

    @Test
    void isParanthesesBalanced3() {
        assertEquals("no", TaskA.isParanthesesBalanced("([){}]"));
    }

    @Test
    void isParanthesesBalanced4() {
        assertEquals("yes", TaskA.isParanthesesBalanced(""));
    }

    @Test
    void isParanthesesBalanced5() {
        assertEquals("yes", TaskA.isParanthesesBalanced("(()()()(()()(()()()))()())"));
    }
}