package Session3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskDTest {

    @Test
    void calculatePostfixExpression() {
        assertEquals("5", TaskD.calculatePostfixExpression("2 3 +"));
    }

    @Test
    void calculatePostfixExpression1() {
        assertEquals("-102", TaskD.calculatePostfixExpression("8 9 + 1 7 - *\n"));
    }

    @Test
    void calculatePostfixExpression2() {
        assertEquals("132", TaskD.calculatePostfixExpression("6 3 1 4 5 * + * 2 * +\n"));
    }

    @Test
    void calculatePostfixExpression3() {
        assertEquals("2", TaskD.calculatePostfixExpression("1 2 2 3 - * +\n"));
    }
}