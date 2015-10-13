package org.academiadecodigo.levelcreator;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

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

        KeyboardEvent save = new KeyboardEvent();
        save.setKey(KeyboardEvent.KEY_S);
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(save);

        KeyboardEvent open = new KeyboardEvent();
        open.setKey(KeyboardEvent.KEY_O);
        open.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(open);

        KeyboardEvent clear = new KeyboardEvent();
        clear.setKey(KeyboardEvent.KEY_C);
        clear.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(clear);
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
                break;

            case KeyboardEvent.KEY_S:

                System.out.println(symbols());
                try {
                    writeFile(symbols(),"doc/text.txt");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                System.out.println("File saved");
                break;

            case KeyboardEvent.KEY_O:
                g.grid.remove();
                try {
                    readFileByLine("doc/text.txt");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                System.out.println("o pressed");
                break;
            
            case KeyboardEvent.KEY_C:
                for (int i = 0; i < g.grid.size(); i++) {
                    g.grid.get(i).square.setColor(Color.BLACK);
                    g.grid.get(i).square.draw();
                    g.grid.get(i).marked = false;
                }
                System.out.println("Grid cleared");
                break;
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

    public String symbols() {

        String line = "";

        for (int i = 0; i < g.grid.size(); i++) {

            if(i % (Grid.rows) == 0 && i != 0) {
                line += "\n";
            }

            if (g.grid.get(i).marked) {
                line += "#";
            } else {
                line += "o";
            }

        }
        return line;
    }

    private static void writeFile(String message, String file) throws IOException {

        // A file output stream is an output stream for writing data to a File
        FileOutputStream writer = new FileOutputStream(file);

        // Writes bytes from the specified byte array to this file output stream.
        writer.write(message.getBytes());
    }

    private void readFileByLine(String file) throws IOException {


        // create a new reader
        FileReader reader = new FileReader(file);

        // wrap the file reader using a buffered reader to add more functionality
        BufferedReader bReader = new BufferedReader(reader);

        g.createNewGrid(bReader);

        reader.close();




    }


}
