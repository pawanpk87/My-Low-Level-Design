package org.buildcode;

public class OPiece implements Piece {
    private Character piece = 'O';

    @Override
    public Character getPiece() {
        return this.piece;
    }
}