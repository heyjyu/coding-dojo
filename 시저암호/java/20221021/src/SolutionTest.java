import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void moveCharacter() {
        Solution solution = new Solution();

        assertEquals("B", solution.moveCharacter("A", 1));
        assertEquals("Z", solution.moveCharacter("A", 25));
        assertEquals("z", solution.moveCharacter("a", 25));
        assertEquals("y", solution.moveCharacter("z", 25));
        assertEquals("x", solution.moveCharacter("y", 25));
    }

    @Test
    void convert() {
        Solution solution = new Solution();

        assertEquals("BC", solution.convert("AB", 1));
        assertEquals("a", solution.convert("z", 1));
        assertEquals("e F d", solution.convert("a B z", 4));
    }
}
