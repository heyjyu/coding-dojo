import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void convertTo3() {
        Solution solution = new Solution();

        assertEquals(10, solution.convertTo3(3));
        assertEquals(1200, solution.convertTo(45));
    }
}
