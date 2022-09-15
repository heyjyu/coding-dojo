import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void simple() {
        Solution solution = new Solution();

        assertEquals("c", solution.solution("c"));
        assertEquals("d", solution.solution("d"));
    }

    @Test
    void odd() {
        Solution solution = new Solution();

        assertEquals("a", solution.solution("bab"));
        assertEquals("c", solution.solution("abcde"));
    }

    @Test
    void even() {
        Solution solution = new Solution();

        assertEquals("we", solution.solution("qwer"));
    }
}
