package main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BishopTest {

    @Test
    void testValidDiagonalMove() {
        Bishop b = new Bishop(4, 4, Color.White);
        assertTrue(b.canMove(6, 6));
        assertTrue(b.canMove(2, 2));
    }

    @Test
    void testInvalidMove() {
        Bishop b = new Bishop(4, 4, Color.White);
        assertFalse(b.canMove(4, 6));
        assertFalse(b.canMove(5, 6));
    }

    @Test
    void testCanKill() {
        Bishop b = new Bishop(4, 4, Color.White);
        Rook enemy = new Rook(6, 6, Color.Black);
        assertTrue(b.canKill(enemy));
    }
}
