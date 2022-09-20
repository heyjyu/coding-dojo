import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void addDigits() {
        Solution solution = new Solution();

        assertEquals(1, solution.addDigits(1));
        assertEquals(3, solution.addDigits(12));
        assertEquals(6, solution.addDigits(132));
    }
}
