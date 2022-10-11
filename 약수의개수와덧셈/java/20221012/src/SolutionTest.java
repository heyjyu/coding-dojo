import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void numberOfDivisor() {
        Solution solution = new Solution();

        assertEquals(3, solution.numberOfDivisor(9));
        assertEquals(4, solution.numberOfDivisor(10));
    }

    @Test
    void process() {
        Solution solution = new Solution();

        assertEquals(43, solution.process(13, 17));
        assertEquals(52, solution.process(24, 27));
    }
}
