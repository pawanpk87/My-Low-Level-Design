package org.buildcode;

public class XPiece implements Piece {
    private Character piece = 'X';

    @Override
    public Character getPiece() {
        return this.piece;
    }
}