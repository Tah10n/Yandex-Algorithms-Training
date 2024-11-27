package Session3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskETest {

    @Test
    void convertToPostfixExpression() {
        assertEquals("1 2 2 * 3 - +", TaskE.convertToPostfixExpression("1+(2*2 - 3)"));
    }

    @Test
    void convertToPostfixExpression1() {
        assertEquals("WRONG", TaskE.convertToPostfixExpression("1+a+1\n"));
    }

    @Test
    void convertToPostfixExpression2() {
        assertEquals("WRONG", TaskE.convertToPostfixExpression("1 1 + 2\n"));
    }

    @Test
    void convertToPostfixExpression3() {
        assertEquals("1 2 +", TaskE.convertToPostfixExpression("1 +    2\n"));
    }

    @Test
    void convertToPostfixExpression4() {
        assertEquals("WRONG", TaskE.convertToPostfixExpression("1 + (   2\n"));
    }

    @Test
    void convertToPostfixExpression5() {
        assertEquals("WRONG", TaskE.convertToPostfixExpression("1 + )   2\n"));
    }

    @Test
    void convertToPostfixExpression6() {
        assertEquals("WRONG", TaskE.convertToPostfixExpression("1 + ) (  2\n"));
    }

    @Test
    void convertToPostfixExpression7() {
        assertEquals("1 2 +", TaskE.convertToPostfixExpression("1 + ()  2\n"));
    }

    @Test
    void convertToPostfixExpression8() {
        assertEquals("WRONG", TaskE.convertToPostfixExpression("+ 1 + 2 \n"));
    }

    @Test
    void convertToPostfixExpression9() {
        assertEquals("WRONG", TaskE.convertToPostfixExpression("1-2)\n"));
    }

    @Test
    void convertToPostfixExpression10() {
        assertEquals("5 10 9 - *",  TaskE.convertToPostfixExpression("5*(10-9)"));
    }

    @Test
    void convertToPostfixExpression11() {
        assertEquals("WRONG",  TaskE.convertToPostfixExpression("-1*2*3+(*4*5*6*7+8*9)"));
    }
}