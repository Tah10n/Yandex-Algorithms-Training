package Session1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskBTest {

    @Test
    void findShirtsAndSocks() {
        assertEquals("3 4", TaskB.findShirtsAndSocks(new int[]{6, 2, 7, 3}));
    }

    @Test
    void findShirtsAndSocks2() {
        assertEquals("5 1", TaskB.findShirtsAndSocks(new int[]{1, 4, 4, 2}));
    }

    @Test
    void findShirtsAndSocks3() {
        assertEquals("7 1", TaskB.findShirtsAndSocks(new int[]{6, 6, 7, 3}));
    }

    @Test
    void findShirtsAndSocks4() {
        assertEquals("2 1", TaskB.findShirtsAndSocks(new int[]{1,1,1,1}));
    }

    @Test
    void findShirtsAndSocks5() {
        assertEquals("1 3", TaskB.findShirtsAndSocks(new int[]{3,3,1,2}));
    }

    @Test
    void findShirtsAndSocks6() {
        assertEquals("4 1", TaskB.findShirtsAndSocks(new int[]{3,3,1,3}));
    }

    @Test
    void findShirtsAndSocks7() {
        assertEquals("4 1", TaskB.findShirtsAndSocks(new int[]{3,3,1,4}));
    }

    @Test
    void findShirtsAndSocks8() {
        assertEquals("4 1", TaskB.findShirtsAndSocks(new int[]{3,3,1,5}));
    }

    @Test
    void findShirtsAndSocks9() {
        assertEquals("4 1", TaskB.findShirtsAndSocks(new int[]{3,3,1,6}));
    }

    @Test
    void findShirtsAndSocks10() {
        assertEquals("1 5", TaskB.findShirtsAndSocks(new int[]{5,5,3,4}));
    }

    @Test
    void findShirtsAndSocks11() {
        assertEquals("1 6", TaskB.findShirtsAndSocks(new int[]{0,2,5,1}));
    }

    @Test
    void findShirtsAndSocks12() {
        assertEquals("1 1", TaskB.findShirtsAndSocks(new int[]{0,1,0,1}));
    }

    @Test
    void findShirtsAndSocks13() {
        assertEquals("11 1", TaskB.findShirtsAndSocks(new int[]{10,7,0,4}));
    }

    @Test
    void findShirtsAndSocks14() {
        assertEquals("3 4", TaskB.findShirtsAndSocks(new int[]{2,10,3,9}));
    }

    @Test
    void findShirtsAndSocks15() {
        assertEquals("11 1", TaskB.findShirtsAndSocks(new int[]{10,10,10,10}));
    }

    @Test
    void findShirtsAndSocks16() {
        assertEquals("10 1", TaskB.findShirtsAndSocks(new int[]{8,9,5,9}));
    }

    @Test
    void findShirtsAndSocks17() {
        assertEquals("300 1", TaskB.findShirtsAndSocks(new int[]{114,299,921,166}));
    }

    @Test
    void findShirtsAndSocks18() {
        assertEquals("1 508", TaskB.findShirtsAndSocks(new int[]{790,493,507,302}));
    }
}