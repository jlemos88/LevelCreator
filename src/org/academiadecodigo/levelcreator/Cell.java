package org.academiadecodigo.levelcreator;

import org.academiadecodigo.simplegraphics.graphics.Color;

/**
 * Created by jlemos88 on 09/10/15.
 */
public class Cell  extends Square {

    boolean marked = false;

    public Cell(int x, int y) {
        super(x, y);
        square.setColor(Color.BLACK);
        square.draw();
    }

    String getSymbol() {
        return marked ? "#" : "o";
    }

}
