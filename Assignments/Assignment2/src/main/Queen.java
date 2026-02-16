package main;

public class Queen extends ChessPiece{

    public Queen(int row, int col, Color color) {
        super(row, col, color);
    }

    @Override
    public boolean canMove(int r, int c) {
        if (!isWithinBounds(r, c)) return false;

        boolean diagonal = Math.abs(r - row) == Math.abs(c - col);
        boolean straight = r == row || c == col;

        return diagonal || straight;
    }
}
