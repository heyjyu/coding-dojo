import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void split() {
        Solution solution = new Solution();

        assertEquals(List.of("1S", "2D*", "3T"), solution.splitRound("1S2D*3T"));
        assertEquals(List.of("1D", "2S#", "10S"), solution.splitRound("1D2S#10S"));
        assertEquals(List.of("1D#", "2S*", "3S"), solution.splitRound("1D#2S*3S"));
        assertEquals(List.of("1D", "2S", "3T*"), solution.splitRound("1D2S3T*"));
    }

    @Test
    void scores() {
        Solution solution = new Solution();

        assertEquals(List.of(1, 2, 10), solution.scores("1D2S#10S"));
        assertEquals(List.of(1, 2, 3), solution.scores("1D2S3T*"));
    }

    @Test
    void bonuses() {
        Solution solution = new Solution();

        assertEquals(List.of("D", "S", "S"), solution.bonuses("1D2S#10S"));
        assertEquals(List.of("D", "S", "T"), solution.bonuses("1D2S3T*"));
    }

    @Test
    void options() {
        Solution solution = new Solution();

        assertEquals(List.of("*", "*", ""), solution.options("1S*2T*3S"));
        assertEquals(List.of("", "", "*"), solution.options("1D2S3T*"));
    }

    @Test
    void processBonus() {
        Solution solution = new Solution();

        assertEquals(List.of(1, (int) Math.pow(2, 2), (int) Math.pow(3, 3)), solution.processBonus("1S2D*3T"));
        assertEquals(List.of((int) Math.pow(1, 2), 2, 10), solution.processBonus("1D2S#10S"));
    }

    @Test
    void process() {
        Solution solution = new Solution();

        assertEquals(37, solution.process("1S2D*3T"));
        assertEquals(59, solution.process("1D2S3T*"));
    }
}
