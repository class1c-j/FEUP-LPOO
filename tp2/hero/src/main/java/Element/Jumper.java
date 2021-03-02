package Element;

import Game.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Jumper extends Monster {

    public Jumper(int x, int y) {
        super(x, y);
    }

    @Override
    public Position move() {
        Random random = new Random();
        return new Position(getPosition().getX() + 2 * (random.nextInt(3) - 1), getPosition().getY() + 2 * (random.nextInt(3) - 1));
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "J");
    }
}
