package org.buildcode;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("player1", new XPiece());
        Player player2 = new Player("player2", new OPiece());

        TicTacToeGame ticTacToeGame = new TicTacToeGame(player1, player2);

        // player moves
        ticTacToeGame.playerMove(player1, 0, 2);
        ticTacToeGame.playerMove(player1, 0, 2);
        ticTacToeGame.playerMove(player1, 0, 2);
    }
}