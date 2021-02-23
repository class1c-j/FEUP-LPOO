import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    public Game() throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        this.screen = new TerminalScreen(terminal);
        this.arena = new Arena(terminal.getTerminalSize().getColumns(), terminal.getTerminalSize().getRows());

        this.screen.setCursorPosition(null);   // we don't need a cursor
        this.screen.startScreen();             // screens must be started
        this.screen.doResizeIfNecessary();     // resize screen if necessary

    }

    private void draw() throws IOException {
        screen.clear();
        this.arena.draw(screen.newTextGraphics());
        screen.refresh();
    }

    public void run() throws IOException {
        while (true) {
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
            if (arena.verifyMonsterCollisions()) {
                screen.close();
                break;
            }
            if (key.getKeyType() == KeyType.EOF) {
                break;
            }
            if (arena.verifyMonsterCollisions()) {
                screen.close();
                break;
            }
        }
    }

    private void processKey(KeyStroke key) throws IOException {
        arena.processKey(key);
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
            screen.close();
        }
    }

    private final Screen screen;
    private final Arena arena;
}
