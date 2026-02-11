package main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QueenTest {

    @Test
    void testValidMove() {
        Queen q = new Queen(4, 4, Color.White);
        assertTrue(q.canMove(4, 1));
        assertTrue(q.canMove(6, 6));
    }

    @Test
    void testInvalidMove() {
        Queen q = new Queen(4, 4, Color.White);
        assertFalse(q.canMove(7, 6));
        assertFalse(q.canMove(5, 0));
    }

    @Test
    void testCanKill() {
        Queen q = new Queen(4, 4, Color.White);
        Bishop enemy = new Bishop(7, 7, Color.Black);
        assertTrue(q.canKill(enemy));
    }
}