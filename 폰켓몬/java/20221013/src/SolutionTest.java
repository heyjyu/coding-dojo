import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void numberOfTypes() {
        Solution solution = new Solution();

        assertEquals(3, solution.numberOfTypes(new int[]{3, 1, 2, 3}));
        assertEquals(3, solution.numberOfTypes(new int[]{3, 3, 3, 2, 2, 4}));
    }

    @Test
    void process() {
        Solution solution = new Solution();

        assertEquals(2, solution.process(new int[]{3, 1, 2, 3}));
        assertEquals(3, solution.process(new int[]{3, 3, 3, 2, 2, 4}));
        assertEquals(2, solution.process(new int[]{3, 3, 3, 2, 2, 2}));
    }
}
