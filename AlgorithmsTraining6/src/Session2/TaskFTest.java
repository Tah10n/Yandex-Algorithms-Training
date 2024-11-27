package Session2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TaskFTest {

    @Test
    void findSumOfTripleProducts() throws IOException {
        assertEquals(6, TaskF.findSumOfTripleProducts(TaskF.readInput("3\n" +
                "1 2 3\n")));
    }

    @Test
    void findSumOfTripleProducts1() throws IOException {
        assertEquals(210, TaskF.findSumOfTripleProducts(TaskF.readInput("4\n" +
                "0 5 6 7\n")));
    }

    @Test
    void findSumOfTripleProducts2() throws IOException {
        assertEquals(18150, TaskF.findSumOfTripleProducts(TaskF.readInput("10\n" +
                "1 2 3 4 5 6 7 8 9 10")));
    }

    @Test
    void findSumOfTripleProducts3() throws IOException {
        assertEquals(3346, TaskF.findSumOfTripleProducts(TaskF.readInput("5\n" +
                "10 6 10 3 7")));
    }

    @Test
    void findSumOfTripleProducts4() throws IOException {
        assertEquals(184950771, TaskF.findSumOfTripleProducts(TaskF.readInput("inputF4.txt")));
    }

    @Test
    void findSumOfTripleProducts5() throws IOException {
        assertEquals(200122898, TaskF.findSumOfTripleProducts(TaskF.readInput("10\n" +
                "554786 761671 251576 783746 228900 869195 415433 717481 821644 17214\n")));
    }
    @Test
    void findSumOfTripleProducts6() throws IOException {
        assertEquals(256408778, TaskF.findSumOfTripleProducts(TaskF.readInput("inputF6.txt")));
    }


    @Test
    @Disabled
    void findSumOfTripleProducts7() throws IOException {
        assertEquals(256408778, TaskF.findSumOfTripleProducts(TaskF.readInput("100\n" +
                "545269 697218 263222 274437 292188 659054 196272 395733 375953 605087 822379 111051 397736 209483 692646 79062 600107 381052 543509 352890 928981 781199 149150 173519 613336 217334 218266 345855 947225 588534 142298 920716 657199 580778 507552 327239 983783 532606 890785 295834 825155 394932 705098 882752 75830 892195 807032 418631 684969 485107 798782 236373 311418 502434 68259 63904 868920 965058 829281 449717 756520 252216 408616 154034 184131 811327 170584 54411 613685 569315 845322 935816 199200 10311 92488 445958 981591 408927 519505 46898 440995 591478 710294 607889 555650 971370 852864 371003 618787 548459 394599 896155 387947 298623 703196 382577 571827 849089 732192 400976\n")));
    }

    @Test
    void findSumOfTripleProducts8() throws IOException {
        assertEquals(630987644, TaskF.findSumOfTripleProducts(TaskF.readInput("3\n" +
                "143461 574468 902994\n")));
    }

}