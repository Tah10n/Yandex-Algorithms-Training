package Session1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskCTest {

    @Test
    void findLetter() {
        assertEquals("X", TaskC.findLetter(TaskC.readInput(
                """
                        4
                        ....
                        ....
                        ....
                        ....
                        """
        )));
    }

    @Test
    void findLetterX1() {
        assertEquals("X", TaskC.findLetter(TaskC.readInput(
                """
                        4
                        #..#
                        ....
                        ....
                        #..#
                        """
        )));
    }

    @Test
    void findLetterX2() {
        assertEquals("X", TaskC.findLetter(TaskC.readInput(
                """
                        4
                        #..#
                        .##.
                        .##.
                        #..#
                        """
        )));
    }

    @Test
    void findLetterX3() {
        assertEquals("X", TaskC.findLetter(TaskC.readInput(
                """
                        1
                        .
                        """
        )));
    }

    @Test
    void findLetterI() {
        assertEquals("I", TaskC.findLetter(TaskC.readInput(
                """
                        4
                        .#..
                        ....
                        ....
                        ....
                        """
        )));
    }

    @Test
    void findLetterI2() {
        assertEquals("I", TaskC.findLetter(TaskC.readInput(
                """
                        1
                        #
                        """
        )));
    }

    @Test
    void findLetterI3() {
        assertEquals("I", TaskC.findLetter(TaskC.readInput(
                """
                        2
                        #.
                        #.
                        """
        )));
    }

    @Test
    void findLetterI4() {
        assertEquals("I", TaskC.findLetter(TaskC.readInput(
                """
                        2
                        ..
                        #.
                        """
        )));
    }

    @Test
    void findLetterI5() {
        assertEquals("I", TaskC.findLetter(TaskC.readInput(
                """
                        2
                        ..
                        ##
                        """
        )));
    }

    @Test
    void findLetterI6() {
        assertEquals("I", TaskC.findLetter(TaskC.readInput(
                """
                         5
                          .....
                          .....
                          #####
                          .....
                          .....
                        """
        )));
    }

    @Test
    void findLetterL() {
        assertEquals("L", TaskC.findLetter(TaskC.readInput(
                """
                        2
                        #.
                        ##
                        """
        )));
    }

    @Test
    void findLetterO() {
        assertEquals("O", TaskC.findLetter(TaskC.readInput(
                """
                        3
                        ###
                        #.#
                        ###
                        """
        )));
    }

    @Test
    void findLetter2() {
        assertEquals("I", TaskC.findLetter(TaskC.readInput(
                """
                        2
                        ##
                        ##
                        """
        )));
    }

    @Test
    void findLetter3() {
        assertEquals("C", TaskC.findLetter(TaskC.readInput(
                """
                        4
                        ####
                        #...
                        #...
                        ####
                        """
        )));
    }

    @Test
    void findLetter4() {
        assertEquals("L", TaskC.findLetter(TaskC.readInput(
                """
                        4
                        #...
                        #...
                        #...
                        ####
                        """
        )));
    }

    @Test
    void findLetter5() {
        assertEquals("H", TaskC.findLetter(TaskC.readInput(
                """
                        4
                        #..#
                        #..#
                        ####
                        #..#
                        """
        )));
    }

    @Test
    void findLetter6() {
        assertEquals("P", TaskC.findLetter(TaskC.readInput(
                """
                        4
                        ####
                        #..#
                        ####
                        #...
                        """
        )));
    }

    @Test
    void findLetter7() {
        assertEquals("P", TaskC.findLetter(TaskC.readInput(
                """
                        4
                        .###
                        .#.#
                        .###
                        .#..
                        """
        )));
    }

    @Test
    void findLetter8() {
        assertEquals("X", TaskC.findLetter(TaskC.readInput(
                """
                        10
                        ..........
                        .#.#....#.
                        .#......#.
                        .#......#.
                        .########.
                        .#......#.
                        .#......#.
                        .#......#.
                        .#......#.
                        ..........
                        """
        )));
    }

    @Test
    void findLetter9() {
        assertEquals("X", TaskC.findLetter(TaskC.readInput(
                """
                        8
                        ........
                        ........
                        ..##....
                        ..##....
                        .####...
                        ..##....
                        ..##....
                        ........
                        """
        )));
    }

    @Test
    void findLetter10() {
        assertEquals("X", TaskC.findLetter(TaskC.readInput(
                """
                        4
                        ...#
                        .#..
                        #..#
                        ##.#
                        """
        )));
    }

    @Test
    void findLetter11() {
        assertEquals("O", TaskC.findLetter(TaskC.readInput(
                """
                        9
                        #########
                        #####.###
                        #########
                        #########
                        #########
                        #########
                        #########
                        #########
                        #########
                        """
        )));
    }

    @Test
    void findLetter12() {
        assertEquals("X", TaskC.findLetter(TaskC.readInput(
                """
                        10
                                 ..........
                                 ..........
                                 ..###.....
                                 ..###.....
                                 ..###.....
                                 ..###.....
                                 ..###.####
                                 ..########
                                 ..########
                                 ..........
                        """
        )));
    }

    @Test
    void findLetter13() {
        assertEquals("X", TaskC.findLetter(TaskC.readInput(
                """
                        7
                                           #######
                                           #.....#
                                           #.....#
                                           #######
                                           ##.....
                                           ##.....
                                           ##.....
                        """
        )));
    }
}