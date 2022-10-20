import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void process() {
        Solution solution = new Solution();

        assertEquals("TrY HeLlO WoRlD", solution.process("try hello world"));
    }

    @Test
    void lowerCaseAtOdd() {
        Solution solution = new Solution();

        assertEquals("TrY", solution.lowerCaseAtOddIndex("TRY"));
    }
}
