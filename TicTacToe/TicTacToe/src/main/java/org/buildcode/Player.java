package org.buildcode;

public class Player {
    private final String name;
    private final Piece piece;

    public Player(String name, Piece piece) {
        this.name = name;
        this.piece = piece;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public String getName() {
        return this.name;
    }
}