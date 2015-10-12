package org.academiadecodigo.levelcreator;

/**
 * Created by jlemos88 on 09/10/15.
 */
public class Position {

    int x;
    int y;

    public Position(int x, int y) {
        this.x = x * Grid.CELL_SIZE;
        this.y = y * Grid.CELL_SIZE;
    }

}
