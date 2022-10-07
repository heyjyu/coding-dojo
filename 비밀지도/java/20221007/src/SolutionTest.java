import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void base2() {
        Solution solution = new Solution();

        assertEquals("1001", solution.base2(9));
        assertEquals("10100", solution.base2(20));
        assertEquals("11100", solution.base2(28));
    }

    @Test
    void padding() {
        Solution solution = new Solution();

        int length = 5;

        assertEquals("01001", solution.addZero(length, "1001"));
    }

    @Test
    void processRow() {
        Solution solution = new Solution();

        int length = 5;
        int value1 = 9;
        int value2 = 30;

        assertEquals("11111", solution.processRow(length, value1, value2));
        assertEquals("10101", solution.processRow(5, 20, 1));
    }

    @Test
    void toMapRow() {
        Solution solution = new Solution();

        assertEquals("#####", solution.toMapRow("11111"));
        assertEquals("# # #", solution.toMapRow("10101"));
        assertEquals(" #### ", solution.toMapRow("011110"));
    }

    @Test
    void map() {
        Solution solution = new Solution();

        int length = 5;
        int[] array1 = {9, 20, 28, 18, 11};
        int[] array2 = {30, 1, 21, 17, 28};

        assertArrayEquals(new String[]{"#####", "# # #", "### #", "#  ##", "#####"}, solution.map(length, array1, array2));

        length = 6;
        array1 = new int[]{46, 33, 33, 22, 31, 50};
        array2 = new int[]{27,56,19,14,14,10};

        assertArrayEquals(new String[]{"######", "###  #", "##  ##", " #### ", " #####", "### # "}, solution.map(length, array1, array2));
    }
}
