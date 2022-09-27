import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findKim() {
        Solution solution = new Solution();

        assertEquals(0, solution.findKim(new String[]{"Kim"}));
        assertEquals(1, solution.findKim(new String[]{"K", "Kim"}));
    }

    @Test
    void print() {
        Solution solution = new Solution();

        assertEquals("김서방은 1에 있다.", solution.print(1));
    }
}
