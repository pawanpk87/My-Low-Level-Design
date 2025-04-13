package org.buildcode;

public class TicTacToeGame {
    private final Grid grid;
    private final Player player1;
    private final Player player2;
    private Player playerTurn;

    public TicTacToeGame(Player player1, Player player2) {
        grid = new Grid();

        this.player1 = player1;
        this.player2 = player2;

        // select player turn
        if(player1.getPiece().equals('X')) {
            this.playerTurn = player1;
        } else {
            this.playerTurn = player2;
        }
    }

    public void playerMove(Player player, int x, int y) {
        if(playerTurn != player) {
            System.out.println("It's not " + player.getName() + "'s turn!");
            return;
        }

        if(!grid.getCell(x, y).isEmpty()) {
            System.out.println("Cell is already occupied!");
            return;
        }

        Move move = new Move(x, y, player);
        makeMove(move);
    }

    private void makeMove(Move move) {
        // make move
        Cell cell = grid.getCell(move.getX(), move.getY());
        cell.setPiece(move.getPlayer().getPiece());

        grid.displayGrid();

        if(checkGameOver()) {
            System.out.println("Game Over! " + move.getPlayer().getName() + " wins!");
            resetGame();
        } else {
            switchTurn();
        }
    }

    public void resetGame() {
        // reset Game
        grid.resetGridCells();
    }

    private void switchTurn() {
        if(playerTurn == player1) {
            playerTurn = player2;
        } else {
            playerTurn = player1;
        }
    }

    private boolean checkGameOver() {
        // check game over using strategy
        return false;
    }
}