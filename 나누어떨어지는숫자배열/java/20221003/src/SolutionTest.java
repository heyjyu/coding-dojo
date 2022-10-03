import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void isMultiple() {
        Solution solution = new Solution();

        assertTrue(solution.isMultiple(5, 5));
        assertTrue(solution.isMultiple(10, 5));
    }

    @Test
    void multiples() {
        Solution solution = new Solution();

        assertArrayEquals(new int[]{5, 10}, solution.multiples(new int[]{5, 9, 7, 10}, 5));
    }

    @Test
    void noMultiple() {
        Solution solution = new Solution();

        assertArrayEquals(new int[]{-1}, solution.multiples(new int[]{5, 9, 7, 10}, 11));
    }
}
