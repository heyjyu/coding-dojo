import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    void sort() {
        Solution solution = new Solution();

        assertEquals("cba", solution.reverseSort("bac"));
        assertEquals("gfedcbZ", solution.reverseSort("Zbcdefg"));
    }

    @Test
    void swap() {
        Solution solution = new Solution();

        assertEquals("ab", solution.swap("ba", 0, 1));
        assertEquals("abc", solution.swap("bac", 0, 1));
    }
}
