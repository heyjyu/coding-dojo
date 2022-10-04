import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void removeDuplicates() {
        Solution solution = new Solution();

        assertArrayEquals(new int[]{1}, solution.removeDuplicates(new int[]{1, 1, 1}));
        assertArrayEquals(new int[]{1, 3}, solution.removeDuplicates(new int[]{1, 1, 3}));
        assertArrayEquals(new int[]{1, 3, 0, 1}, solution.removeDuplicates(new int[]{1, 1, 3, 3, 0, 1, 1}));
        assertArrayEquals(new int[]{4, 3}, solution.removeDuplicates(new int[]{4, 4, 4, 3, 3}));
    }
}
