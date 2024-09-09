package org.buildcode;

public class Grid {
    private final Integer ROWS = 3;
    private final Integer COLS = 3;

    private final Cell[][] cells;

    public Grid() {
        cells = new Cell[ROWS][COLS];

        resetGridCells();
    }

    void resetGridCells() {
        for(int x = 0; x < ROWS; x++) {
            for(int y = 0; y < COLS; y++) {
                cells[x][y] = new Cell(x, y);
            }
        }
    }

    Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void displayGrid() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Piece piece = getCell(i, j).getPiece();
                System.out.print((piece != null ? piece.getPiece() : "-") + " ");
            }
            System.out.println();
        }
    }
}