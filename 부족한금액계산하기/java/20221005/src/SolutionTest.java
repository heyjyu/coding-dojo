import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void totalPrice() {
        Solution solution = new Solution();

        long price = 3;
        long count = 4;

        assertEquals(30, solution.totalPrice(price, count));
    }

    @Test
    void process() {
        Solution solution = new Solution();

        long price = 3;
        long money = 20;
        long count = 4;

        assertEquals(10, solution.process(price, money, count));

        money = 40;

        assertEquals(0, solution.process(price, money, count));
    }
}
