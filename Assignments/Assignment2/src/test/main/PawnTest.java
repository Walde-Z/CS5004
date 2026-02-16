package main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PawnTest {
    @Test
    void testWhiteForwardMove() {
        Pawn p = new Pawn(1, 3, Color.White);
        assertTrue(p.canMove(2, 3));
        assertTrue(p.canMove(3, 3));
    }

    @Test
    void testBlackForwardMove() {
        Pawn p = new Pawn(6, 3, Color.Black);
        assertTrue(p.canMove(5, 3));
        assertTrue(p.canMove(4, 3));
    }

    @Test
    void testInvalidBackwardMove() {
        Pawn p = new Pawn(1, 3, Color.White);
        assertFalse(p.canMove(0, 3));
        assertFalse(p.canMove(1, 2));
    }

    @Test
    void testDiagonalKill() {
        Pawn p = new Pawn(1, 3, Color.White);
        Rook enemy = new Rook(2, 4, Color.Black);
        assertTrue(p.canKill(enemy));
    }

    @Test
    void testInvalidStraightKill() {
        Pawn p = new Pawn(1, 3, Color.White);
        Rook enemy = new Rook(2, 3, Color.Black);
        assertFalse(p.canKill(enemy));
    }

    @Test
    void testInvalidDirection() {
        assertThrows(IllegalArgumentException.class, () -> new Pawn(0, 3, Color.White));
        assertThrows(IllegalArgumentException.class, () -> new Pawn(7, 3, Color.Black));
    }
}