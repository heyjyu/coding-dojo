import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void sort() {
        Solution solution = new Solution();

        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, solution.sort(new int[]{1, 3, 2, 5, 4}));
    }

    @Test
    void process() {
        Solution solution = new Solution();

        int[] array = {1, 3, 2, 5, 4};

        int budget = 9;

        assertEquals(3, solution.process(array, budget));
    }

    @Test
    void sum() {
        Solution solution = new Solution();

        int[] array = {1, 3, 2, 5, 4};

        int index = 1;

        assertEquals(1 + 3, solution.sumToIndex(array, index));
        assertEquals(1 + 3 + 2, solution.sumToIndex(array, 2));
    }
}
