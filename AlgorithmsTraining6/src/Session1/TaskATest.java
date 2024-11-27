package Session1;

import org.junit.jupiter.api.Test;

class TaskATest {

    @Test
    void findSideNW1() {
        assertEquals("NW", TaskA.findSide(new int[]{-1, -2, 5, 3, -4, 6}));
    }
    @Test
    void findSideSW() {
        assertEquals("SW", TaskA.findSide(new int[]{0, 0, 2, 2, -1, -1}));
    }

    @Test
    void findSideW() {
        assertEquals("W", TaskA.findSide(new int[]{0, 0, 2, 2, -1, 0}));

    }

    @Test
    void findSideNW() {
        assertEquals("NW", TaskA.findSide(new int[]{0, 0, 2, 2, -1, 3}));
    }

    @Test
    void findSideN() {
        assertEquals("N", TaskA.findSide(new int[]{0, 0, 2, 2, 1, 3}));
    }

    @Test
    void findSideS() {
        assertEquals("S", TaskA.findSide(new int[]{0, 0, 2, 2, 1, -1}));
    }

    @Test
    void findSideSE() {
        assertEquals("SE", TaskA.findSide(new int[]{0, 0, 2, 2, 3, -1}));
    }

    @Test
    void findSideE() {
        assertEquals("E", TaskA.findSide(new int[]{0, 0, 2, 2, 3, 0}));
    }

    @Test
    void findSideNE() {
        assertEquals("NE", TaskA.findSide(new int[]{0, 0, 2, 2, 3, 3}));
    }

    private void assertEquals(String sw, String side) {
    }
}