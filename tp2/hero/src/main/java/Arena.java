import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.hero = new Hero(10,  10);
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
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
        for (Wall wall : walls) {
            wall.draw(graphics);
        }
        for (Coin coin : coins) {
            coin.draw(graphics);
        }
        for (Monster monster : monsters) {
            monster.draw(graphics);
        }
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
        retrieveCoins();
        moveMonsters();
    }

    private boolean canMove(Position position) {
        for (Wall w : this.walls) {
            if(w.getPosition().equals(position)) {
                return false;
            }
        }
        return true;
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return coins;
    }

    private void retrieveCoins() {
        for (Coin c : this.coins) {
            if (c.getPosition().equals(this.hero.getPosition())) {
                this.coins.remove(c);
                break;
            }
        }
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            monsters.add(new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return monsters;
    }

    private void moveMonsters() {
        for (Monster monster : this.monsters) {
            Position nextMove = monster.move();
            if (canMove(nextMove)) {
                monster.setPosition(nextMove);
            }
        }
    }

    public boolean verifyMonsterCollisions() {
        for (Monster monster : this.monsters) {
            if (monster.getPosition().equals(this.hero.getPosition())) {
                return true;
            }
        }
        return false;
    }

    private final int width;
    private final int height;
    private final Hero hero;
    private final List<Wall> walls;
    private final List<Coin> coins;
    private final List<Monster> monsters;
}
