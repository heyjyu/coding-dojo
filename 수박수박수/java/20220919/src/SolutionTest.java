import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void even() {
        Solution solution = new Solution();

        assertEquals(true, solution.isEven(2));
        assertEquals(false, solution.isEven(3));
    }

    @Test
    void print() {
        Solution solution = new Solution();

        assertEquals("수박수", solution.print(3));
        assertEquals("수박수박", solution.print(4));
    }
}
