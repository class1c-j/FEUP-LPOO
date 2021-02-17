import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

public class Arena {
    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.hero = new Hero(0, 0);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(this.width, this.height), ' ');
        hero.draw(graphics);
    }

    private void moveHero(Position position) {
        if (canMove(position)) {
            hero.setPosition(position);
        }
    }

    public void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp -> moveHero(this.hero.moveUp());
            case ArrowDown -> moveHero(this.hero.moveDown());
            case ArrowLeft -> moveHero(this.hero.moveLeft());
            case ArrowRight -> moveHero(this.hero.moveRight());
        }
    }

    private boolean canMove(Position position) {
        return 0 <= position.getX() && position.getX() < this.width
                && 0 <= position.getY() && position.getY() < this.height;
    }

    private final int width;
    private final int height;
    private final Hero hero;
}
