package org.academiadecodigo.levelcreator;


import org.academiadecodigo.simplegraphics.graphics.Color;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by jlemos88 on 09/10/15.
 */

public class Grid {

    public static int cols;
    public static int rows;
    public final static int CELL_SIZE = 30;

    public Grid() {

        createGrid();
    }

    LinkedList<Cell> grid = new LinkedList<Cell>();

    private void createGrid() {
        cols = 20;
        rows = 20;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid.add(new Cell(r, c));

            }
        }
    }

    public void createNewGrid(BufferedReader bReader) throws IOException {

        int index = 0;
        int r = 0;
        int i = 0;

        String line = "";

        // using the buffered reader we can read lines
        while((line = bReader.readLine()) != null) {
            for (i = 0; i < line.length(); i++) {
                if(line.charAt(i) == '#') {
                    grid.add(new Cell(i, r));
                    System.out.println("col " + i + " row " + r);
                    grid.get(index).marked = true;
                    grid.get(index).square.setColor(Color.DARK_GRAY);
                    grid.get(index).square.fill();
                } else if (line.charAt(i) == 'o'){
                    grid.add(new Cell(i, r));
                    grid.get(index).square.setColor(Color.BLACK);
                    grid.get(index).square.draw();
                }
                index++;
            }
            r++;
        }

        cols = i;
        rows = r;
    }


}
