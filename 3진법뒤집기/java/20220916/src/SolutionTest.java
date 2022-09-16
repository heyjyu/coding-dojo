import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class iSolutionTest {

    @Test
    void convertTo3reversed() {
        Solution solution = new Solution();

        assertEquals("1", solution.convertTo3reversed(1));
        assertEquals("01", solution.convertTo3reversed(3));
        assertEquals("0021", solution.convertTo3reversed(45));
        assertEquals("22111", solution.convertTo3reversed(125));
    }

    @Test
    void convertTo10() {
        Solution solution = new Solution();

        assertEquals(7, solution.convertTo10("0021"));
        assertEquals(229, solution.convertTo10("22111"));
    }
}
