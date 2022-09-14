import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void verySimple() {
        Solution solution = new Solution();

        assertEquals(2, solution.solution(3));
    }

    @Test
    void testCase() {
        Solution solution = new Solution();

        assertEquals(3, solution.solution(10));
        assertEquals(11, solution.solution(12));
    }
}
