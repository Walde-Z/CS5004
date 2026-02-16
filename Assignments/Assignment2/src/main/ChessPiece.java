package main;

public abstract class ChessPiece implements ChessPieceContract {
    protected int row;
    protected int col;
    protected Color color;

    public ChessPiece(int row, int col, Color color) {
        if (row < 0 || row > 7 || col < 0 || col > 7) {
            throw new IllegalArgumentException("Invalid board position.");
        }

        this.row = row;
        this.col = col;
        this.color = color;
    }

    @Override
    public int getColumn() {
        return col;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public Color getColor() {
        return color;
    }

    protected boolean isWithinBounds(int r, int c) {
        return r >= 0 && r <= 7 && c >= 0 && c <= 7;
    }

    @Override
    public boolean canKill(ChessPiece piece) {
        if (piece == null) {
            return false;
        }

        if (piece.getColor() == this.color) {
            return false;
        }

        return canMove(piece.getRow(), piece.getColumn());
    }

    public abstract boolean canMove(int row, int col);
}
