package main;

public class King extends ChessPiece {

    public King(int row, int col, Color color) {
        super(row, col, color);
    }

    @Override
    public boolean canMove(int r, int c) {
        if (!isWithinBounds(r, c)) return false;

        int dc = Math.abs(r - row);
        int dr = Math.abs(c - col);

        return dr <= 1 && dc <= 1 && !(dr == 0 && dc == 0);
    }
}
