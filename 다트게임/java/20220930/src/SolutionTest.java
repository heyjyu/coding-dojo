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
    void process() {
        Solution solution = new Solution();

        assertEquals(37, solution.process("1S2D*3T"));
        assertEquals(59, solution.process("1D2S3T*"));
    }
}
