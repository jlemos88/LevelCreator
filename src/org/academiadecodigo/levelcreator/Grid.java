package org.academiadecodigo.levelcreator;


import java.util.LinkedList;

/**
 * Created by jlemos88 on 09/10/15.
 */

public class Grid {

    public final static int COLS = 30;
    public final static int ROWS = 30;

    public final static int CELL_SIZE = 20;




    public Grid() {

        createGrid();
    }

    LinkedList<Cell> grid = new LinkedList<Cell>();

    private void createGrid() {

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                grid.add(new Cell(r, c));

            }
        }
    }

}
