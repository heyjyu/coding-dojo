import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void smallestDivisor() {
        Solution solution = new Solution();

        assertEquals(3, solution.smallestDivisor(9));
        assertEquals(11, solution.smallestDivisor(11));
    }

    @Test
    void process() {
        Solution solution = new Solution();

        assertEquals(3, solution.process(10));
        assertEquals(11, solution.process(12));
    }
}
