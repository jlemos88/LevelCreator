package org.academiadecodigo.levelcreator;

import org.academiadecodigo.simplegraphics.graphics.Color;

/**
 * Created by jlemos88 on 09/10/15.
 */
public class Pointer extends Square {

    Direction dir;

    public Pointer() {
        super(0,0);
        square.setColor(Color.BLUE);
        square.fill();

    }

    public void move(Direction dir){
        this.dir = dir;

        switch(dir) {

            case UP:
                if (pos.y - 1 >= 0) {
                    pos.y -= Grid.CELL_SIZE;
                    square.translate(0, -Grid.CELL_SIZE);
                }
                break;

            case DOWN:
                if (pos.y + 1 < (Grid.ROWS -1) * Grid.CELL_SIZE ) {
                    pos.y += Grid.CELL_SIZE;
                    square.translate(0, + Grid.CELL_SIZE);
                }
                break;

            case LEFT:
                if (pos.x - 1 >= 0) {
                    pos.x -= Grid.CELL_SIZE;
                    square.translate(-Grid.CELL_SIZE, 0);
                }
                break;

            case RIGHT:
                if (pos.x + 1 < (Grid.COLS -1) * Grid.CELL_SIZE) {
                    pos.x+=Grid.CELL_SIZE;
                    square.translate(+Grid.CELL_SIZE, 0);
                }
                break;
        }
    }



}
