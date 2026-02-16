package main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KingTest {

    @Test
    void testValidMove() {
        King k = new King(4, 4, Color.White);
        assertTrue(k.canMove(5, 5));
        assertTrue(k.canMove(4, 5));
    }

    @Test
    void testInvalidMove() {
        King k = new King(4, 4, Color.White);
        assertFalse(k.canMove(0, 1));
        assertFalse(k.canMove(6, 6));
    }
}