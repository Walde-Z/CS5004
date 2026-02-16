package main;

public class Bishop extends ChessPiece {

    public Bishop(int row, int col, Color color) {
        super(row, col, color);
    }

    @Override
    public boolean canMove(int r, int c) {
        if (!isWithinBounds(r, c)) {
            return false;
        }

        return Math.abs(r - row) == Math.abs(c - col);
    }
}
