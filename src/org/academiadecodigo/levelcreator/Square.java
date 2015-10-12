package org.academiadecodigo.levelcreator;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by jlemos88 on 09/10/15.
 */
public abstract class Square {

    Position pos;
    Rectangle square;


    public Square(int x, int y) {
        pos = new Position(x, y);
        square = new Rectangle(pos.x, pos.y, Grid.CELL_SIZE, Grid.CELL_SIZE);
    }
}
