package main;

public class Pawn extends ChessPiece{

    public Pawn(int row, int col, Color color) {
        super(row, col, color);

        if (color == Color.White && row == 0) {
            throw new IllegalArgumentException("White pawn cannot start at row 0.");
        }

        if (color == Color.Black && row == 7) {
            throw new IllegalArgumentException("Black pawn cannot start at row 7");
        }
    }

    @Override
    public boolean canMove(int r, int c) {
        if (!isWithinBounds(r, c)) return false;

        int direction = (color == Color.White) ? 1 : -1;

        if (c == col && r == row + direction) {
            return true;
        }

        if (c == col) {
            if (color == Color.White && row == 1 && r == 3) {
                return true;
            }
            if (color == Color.Black && row == 6 && r == 4) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean canKill(ChessPiece piece) {
        if (piece == null) return false;
        if (piece.getColor() == this.color) return false;

        int direction = (color == Color.White) ? 1 : -1;

        int dr = piece.getRow() - row;
        int dc = Math.abs(piece.getColumn() - col);

        return dr == direction && dc == 1;
    }
}
