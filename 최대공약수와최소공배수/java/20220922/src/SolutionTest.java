import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void isDivisor() {
        Solution solution = new Solution();

        int number = 10;
        int divisor = 5;

        assertEquals(true, solution.isDivisor(number, divisor));
    }

    @Test
    void greatestCommonFactor() {
        Solution solution = new Solution();

        int number1 = 3;
        int number2 = 12;

        assertEquals(3, solution.greatestCommonFactor(number1, number2));

        number1 = 2;
        number2 = 5;

        assertEquals(1, solution.greatestCommonFactor(number1, number2));

        number1 = 10;
        number2 = 55;

        assertEquals(5, solution.greatestCommonFactor(number1, number2));
    }

    @Test
    void minimum() {
        Solution solution = new Solution();

        int number1 = 2;
        int number2 = 5;

        assertEquals(2, solution.min(number1, number2));
    }

    @Test
    void maximum() {
        Solution solution = new Solution();

        int number1 = 2;
        int number2 = 5;

        assertEquals(5, solution.max(number1, number2));
    }

    @Test
    void factors() {
        Solution solution = new Solution();

        assertEquals(List.of(1, 2), solution.factors(2));
        assertEquals(List.of(1, 2, 3, 6), solution.factors(6));
        assertEquals(List.of(1, 3, 9), solution.factors(9));
    }

    @Test
    void leastCommonMultiple() {
        Solution solution = new Solution();

        assertEquals(12, solution.leastCommonMultiple(3, 12));
        assertEquals(10, solution.leastCommonMultiple(2, 5));
    }
}
