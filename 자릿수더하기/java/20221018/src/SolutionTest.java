import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void addDigits() {
        Solution solution = new Solution();

        assertEquals(6, solution.addDigits(123));
        assertEquals(24, solution.addDigits(987));
    }
}
