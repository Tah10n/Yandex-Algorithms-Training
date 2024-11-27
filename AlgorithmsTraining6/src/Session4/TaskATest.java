package Session4;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TaskATest {

    @Test
    void printAllNodesWithDeep() throws IOException {
        assertEquals("Alexander_I 4\n" +
                "Alexei 1\n" +
                "Anna 1\n" +
                "Elizabeth 1\n" +
                "Nicholaus_I 4\n" +
                "Paul_I 3\n" +
                "Peter_I 0\n" +
                "Peter_II 2\n" +
                "Peter_III 2\n", TaskA.printAllNodesWithDeep(TaskA.readInput("9\n" +
                "Alexei Peter_I\n" +
                "Anna Peter_I\n" +
                "Elizabeth Peter_I\n" +
                "Peter_II Alexei\n" +
                "Peter_III Anna\n" +
                "Paul_I Peter_III\n" +
                "Alexander_I Paul_I\n" +
                "Nicholaus_I Paul_I\n")));
    }

    @Test
    void printAllNodesWithDeep1() throws IOException {
        assertEquals("AQHFYP 3\n" +
                "AYKOTYQ 2\n" +
                "IWCGKHMFM 1\n" +
                "MJVAURUDN 2\n" +
                "MKFXCLZBT 2\n" +
                "PUTRIPYHNQ 2\n" +
                "QIUKGHWCDC 1\n" +
                "UQNGAXNP 1\n" +
                "WPLHJL 0\n" +
                "YURTPJNR 2\n", TaskA.printAllNodesWithDeep(TaskA.readInput("10\n" +
                "AQHFYP MKFXCLZBT\n" +
                "AYKOTYQ QIUKGHWCDC\n" +
                "IWCGKHMFM WPLHJL\n" +
                "MJVAURUDN QIUKGHWCDC\n" +
                "MKFXCLZBT IWCGKHMFM\n" +
                "PUTRIPYHNQ UQNGAXNP\n" +
                "QIUKGHWCDC WPLHJL\n" +
                "UQNGAXNP WPLHJL\n" +
                "YURTPJNR QIUKGHWCDC\n")));
    }

    @Test
    void printAllNodesWithDeep2() throws IOException {
        assertEquals("BFNRMLH 3\n" +
                "CSZMPFXBZ 2\n" +
                "FMVQTU 9\n" +
                "FUXATQUGIG 8\n" +
                "GNVIZ 6\n" +
                "IHWBQDJ 1\n" +
                "IQGIGUJZ 5\n" +
                "IRVAVMQKN 7\n" +
                "JMUPNYRQD 4\n" +
                "LACXYFQHSQ 0\n", TaskA.printAllNodesWithDeep(TaskA.readInput("10\n" +
                "BFNRMLH CSZMPFXBZ\n" +
                "CSZMPFXBZ IHWBQDJ\n" +
                "FMVQTU FUXATQUGIG\n" +
                "FUXATQUGIG IRVAVMQKN\n" +
                "GNVIZ IQGIGUJZ\n" +
                "IHWBQDJ LACXYFQHSQ\n" +
                "IQGIGUJZ JMUPNYRQD\n" +
                "IRVAVMQKN GNVIZ\n" +
                "JMUPNYRQD BFNRMLH\n")));
    }
}