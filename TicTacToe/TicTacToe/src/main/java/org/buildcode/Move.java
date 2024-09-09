package org.buildcode;

public class Move {
    private final int x;
    private final int y;
    private final Player player;

    public Move(int x, int y, Player player) {
        this.x = x;
        this.y = y;
        this.player = player;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Player getPlayer() {
        return player;
    }
}