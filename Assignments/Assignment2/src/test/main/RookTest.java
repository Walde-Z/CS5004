package main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RookTest {
    @Test
    void testValidMove() {
        Rook r = new Rook(4, 4, Color.White);
        assertTrue(r.canMove(4, 6));
        assertTrue(r.canMove(7, 4));
    }

    @Test
    void testInvalidMove() {
        Rook r = new Rook(4, 4, Color.White);
        assertFalse(r.canMove(7, 7));
        assertFalse(r.canMove(5, 6));
    }

    @Test
    void testCanKill() {
        Rook r = new Rook(4, 4, Color.White);
        Bishop enemy = new Bishop(4, 6, Color.Black);
        assertTrue(r.canKill(enemy));
    }
}