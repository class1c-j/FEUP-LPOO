package Game;


import com.googlecode.lanterna.SGR;
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
    private final Screen screen;
    private final Arena arena;

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
                if (!arena.checkHeroAlive()) {
                    showGameOver();
                    screen.close();
                    break;
                }
            }
            if (arena.checkLevelCompleted()) {
                showLevelCompletedScreen();
                screen.close();
                break;
            }
            if (key.getKeyType() == KeyType.EOF) {
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

    private void showGameOver() throws IOException {
        this.screen.clear();
        TextGraphics graphics = this.screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#ff0000"));
        graphics.fill(' ');
        graphics.putString(35, 10, "Game Over", SGR.BOLD);
        graphics.putString(29, 12, "Press SPACE to leave", SGR.BOLD);
        this.screen.refresh();

        while (true) {
            KeyStroke keyStroke = screen.readInput();
            if (keyStroke.getKeyType() == KeyType.EOF || (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == ' ')) {
                break;
            }
        }

    }

    private void showLevelCompletedScreen() throws IOException {
        this.screen.clear();
        TextGraphics graphics = this.screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#00ff00"));
        graphics.fill(' ');
        graphics.putString(35, 10, "You Won", SGR.BOLD);
        graphics.putString(29, 12, "Press SPACE to leave", SGR.BOLD);
        this.screen.refresh();

        while (true) {
            KeyStroke keyStroke = screen.readInput();
            if (keyStroke.getKeyType() == KeyType.EOF || (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == ' ')) {
                break;
            }
        }

    }

}
