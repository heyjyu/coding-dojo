import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void square() {
        Solution solution = new Solution();

        assertEquals(true, solution.isSquare(121));
        assertEquals(true, solution.isSquare(9));
        assertEquals(false, solution.isSquare(10));
    }

    @Test
    void process() {
        Solution solution = new Solution();

        assertEquals(144, solution.process(121));
        assertEquals(-1, solution.process(3));
    }
}
