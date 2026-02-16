package main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ChessPieceTest {
    @Test
    void testValidConstruction() {
        Rook r = new Rook(4, 5, Color.White);

        assertEquals(4, r.getRow());
        assertEquals(5, r.getColumn());
        assertEquals(Color.White, r.getColor());
    }

    @Test
    void testInvalidRow() {
        assertThrows(IllegalArgumentException.class, () -> new Rook(8, 5, Color.White));
    }

    @Test
    void testInvalidColumn() {
        assertThrows(IllegalArgumentException.class, () -> new Rook(4, 8, Color.White));
    }

    @Test
    void testCanKillDifferentColor() {
        Rook r = new Rook(4, 4, Color.White);
        Bishop enemy = new Bishop(4, 7, Color.Black);

        assertTrue(r.canKill(enemy));
    }

    @Test
    void testCannotKillSameColor() {
        Rook r = new Rook(4, 4, Color.White);
        Bishop friend = new Bishop(4, 7, Color.White);

        assertFalse(r.canKill(friend));
    }

    @Test
    void testCannotKillNull() {
        Rook r = new Rook(4, 4, Color.White);

        assertFalse(r.canKill(null));
    }
}