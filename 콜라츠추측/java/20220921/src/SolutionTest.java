import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void isEven() {
        Solution solution = new Solution();

        assertEquals(true, solution.isEven(2));
        assertEquals(true, solution.isEven(4));
        assertEquals(false, solution.isEven(3));
    }

    @Test
    void process() {
        Solution solution = new Solution();

        assertEquals(3, solution.process(6));
        assertEquals(16, solution.process(5));
    }

    @Test
    void countToOne() {
        Solution solution = new Solution();

        assertEquals(8, solution.countToOne(6));
        assertEquals(4, solution.countToOne(16));
        assertEquals(0, solution.countToOne(1));
        assertEquals(-1, solution.countToOne(626331));
    }
}
