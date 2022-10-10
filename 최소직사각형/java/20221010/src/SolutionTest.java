import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void sort() {
        Solution solution = new Solution();

        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int[][] sortedSizes = {{50, 60}, {30, 70}, {30, 60}, {40, 80}};

        assertArrayEquals(sortedSizes, solution.sort(sizes));
    }

    @Test
    void smallestSize() {
        Solution solution = new Solution();

        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

        assertEquals(4000, solution.smallestSize(sizes));
    }
}
