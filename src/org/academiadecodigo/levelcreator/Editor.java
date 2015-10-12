package org.academiadecodigo.levelcreator;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by jlemos88 on 09/10/15.
 */
public class Editor implements KeyboardHandler {

    Grid g;
    Pointer pointer;




    public Editor() {

        g = new Grid();
        pointer = new Pointer();
        keyboard();

    }

    public void keyboard() {

        Keyboard k = new Keyboard(this);

        KeyboardEvent change = new KeyboardEvent();
        change.setKey(KeyboardEvent.KEY_SPACE);
        change.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(change);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(down);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(right);
    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        switch (e.getKey()) {

            case KeyboardEvent.KEY_UP:

                pointer.move(Direction.UP);
                break;

            case KeyboardEvent.KEY_DOWN:

                pointer.move(Direction.DOWN);
                break;

            case KeyboardEvent.KEY_LEFT:

                pointer.move(Direction.LEFT);
                break;

            case KeyboardEvent.KEY_RIGHT:

                pointer.move(Direction.RIGHT);
                break;

            case KeyboardEvent.KEY_SPACE:
                mark();
        }

    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }

    public void mark() {
        for (int i = 0; i < g.grid.size(); i++) {
           if (g.grid.get(i).pos.x == pointer.pos.x && g.grid.get(i).pos.y == pointer.pos.y) {

               g.grid.get(i).marked = !g.grid.get(i).marked;

               if (g.grid.get(i).marked) {
                   g.grid.get(i).square.setColor(Color.DARK_GRAY);
                   g.grid.get(i).square.fill();
               } else {
                   g.grid.get(i).square.setColor(Color.BLACK);
                   g.grid.get(i).square.draw();
               }

               break;
           }
        }
    }


}
