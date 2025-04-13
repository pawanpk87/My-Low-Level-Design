package org.buildcode;

public class Cell {
    private final int x;
    private final int y;
    private Piece piece;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.piece = null;
    }

    public Boolean isEmpty() {
        return this.piece == null;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return this.piece;
    }
}