import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void totalPlayerNumber() {
        Solution solution = new Solution();

        int stage = 3;
        int[] stages = {4, 4, 4, 4, 4};

        assertEquals(5, solution.totalPlayerNumber(stage, stages));
        assertEquals(5, solution.totalPlayerNumber(1, stages));
        assertEquals(8, solution.totalPlayerNumber(1, new int[]{2, 1, 2, 6, 2, 4, 3, 3}));
        assertEquals(7, solution.totalPlayerNumber(2, new int[]{2, 1, 2, 6, 2, 4, 3, 3}));
        assertEquals(0, solution.totalPlayerNumber(8, new int[]{2, 1, 2, 6, 2, 4, 3, 3}));
    }

    @Test
    void failedPlayerNumber() {
        Solution solution = new Solution();

        int stage = 3;
        int[] stages = {4, 4, 4, 4, 4};

        assertEquals(0, solution.failedPlayerNumber(stage, stages));
        assertEquals(5, solution.failedPlayerNumber(4, stages));
        assertEquals(1, solution.failedPlayerNumber(1, new int[]{2, 1, 2, 6, 2, 4, 3, 3}));
        assertEquals(3, solution.failedPlayerNumber(2, new int[]{2, 1, 2, 6, 2, 4, 3, 3}));
        assertEquals(0, solution.failedPlayerNumber(8, new int[]{2, 1, 2, 6, 2, 4, 3, 3}));
    }

    @Test
    void failure() {
        Solution solution = new Solution();

        int stage = 3;
        int[] stages = {4, 4, 4, 4, 4};

        assertEquals(0.0 / 5, solution.failure(stage, stages));
        assertEquals(5.0 / 5, solution.failure(4, stages));
        assertEquals(1.0 / 8, solution.failure(1, new int[]{2, 1, 2, 6, 2, 4, 3, 3}));
        assertEquals(3.0 / 7, solution.failure(2, new int[]{2, 1, 2, 6, 2, 4, 3, 3}));
        assertEquals(0.0, solution.failure(8, new int[]{2, 1, 2, 6, 2, 4, 3, 3}));
    }

    @Test
    void sort() {
        Solution solution = new Solution();

        int[] stages = {4, 4, 4, 4, 4};
        int numberOfStages = 4;

        assertArrayEquals(new int[]{4, 1, 2, 3}, solution.sort(numberOfStages, stages));
        assertArrayEquals(new int[]{3, 4, 2, 1, 5}, solution.sort(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3}));
    }
}
