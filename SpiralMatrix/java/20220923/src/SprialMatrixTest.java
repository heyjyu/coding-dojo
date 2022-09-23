import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SprialMatrixTest {

    @Test
    void matrix() {
        SprialMatrix sprialMatrix = new SprialMatrix();

        int length = 2;

        assertEquals(0, sprialMatrix.matrix(length)[0][0]);
        assertEquals(0, sprialMatrix.matrix(length)[0][1]);
        assertEquals(0, sprialMatrix.matrix(length)[1][0]);
        assertEquals(0, sprialMatrix.matrix(length)[1][1]);
    }

    @Test
    void isBlock() {
        SprialMatrix sprialMatrix = new SprialMatrix();

        int length = 2;

        assertEquals(true, sprialMatrix.isBlock(length, new int[][]{{0, 0}, {0, 0}}, 0, 2));
        assertEquals(true, sprialMatrix.isBlock(length, new int[][]{{0, 0}, {0, 0}}, -1, 0));
        assertEquals(true, sprialMatrix.isBlock(length, new int[][]{{0, 0}, {0, 0}}, 0, -1));
        assertEquals(true, sprialMatrix.isBlock(length, new int[][]{{0, 0}, {0, 0}}, 2, 0));
        assertEquals(true, sprialMatrix.isBlock(length, new int[][]{{1, 2}, {0, 0}}, 1, 0));
        assertEquals(false, sprialMatrix.isBlock(length, new int[][]{{1, 2}, {0, 0}}, 1, 1));
    }
}
