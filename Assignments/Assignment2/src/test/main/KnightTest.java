package main;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class KnightTest {

    @Test
    void testValidMove() {
        Knight k = new Knight(4, 4, Color.White);
        assertTrue(k.canMove(2, 3));
        assertTrue(k.canMove(6, 5));
    }

    @Test
    void testInvalidMove() {
        Knight k = new Knight(4, 4, Color.White);
        assertFalse(k.canMove(4, 6));
        assertFalse(k.canMove(7, 6));
    }

    @Test
    void testCanKill() {
        Knight k = new Knight(4, 4, Color.White);
        Bishop enemy = new Bishop(2, 3, Color.Black);
        assertTrue(k.canKill(enemy));
    }
}