import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void sortByNthChar() {
        Solution solution = new Solution();

        assertArrayEquals(new String[]{"car", "bed", "sun"}, solution.sortByNthChar(new String[]{"sun", "bed", "car"}, 1));
        assertArrayEquals(new String[]{"abcd", "abce", "cdx"}, solution.sortByNthChar(new String[]{"abce", "abcd", "cdx"}, 2));
    }

    @Test
    void dictionarySort() {
        Solution solution = new Solution();

        assertArrayEquals(new String[]{"abcd", "abce"}, solution.dictionarySort("abce", "abcd"));
    }

    @Test
    void minLength() {
        Solution solution = new Solution();

        assertEquals(3, solution.minLength("abce", "abc"));
    }
}
