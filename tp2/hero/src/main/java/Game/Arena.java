package Game;

import Element.*;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private final int width;
    private final int height;
    private final Hero hero;
    private final List<Wall> walls;
    private final List<Coin> coins;
    private final List<Monster> monsters;
    private final List<Jumper> jumpers;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.hero = new Hero(10, 10);
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
        this.jumpers = createJumpers();
    }

    public void draw(TextGraphics graphics) {

        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(this.width, this.height), ' ');

        graphics.putString(1, 1, String.format("Life: %d", this.hero.getHealth()));

        hero.draw(graphics);

        for (Wall wall : this.walls) {
            wall.draw(graphics);
        }
        for (Coin coin : this.coins) {
            coin.draw(graphics);
        }
        for (Monster monster : this.monsters) {
            monster.draw(graphics);
        }
        for (Jumper jumper : this.jumpers) {
            jumper.draw(graphics);
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
        if (position.getX() > this.width || position.getX() < 0
        || position.getY() > this.height || position.getY() < 0) return false;
        for (Wall w : this.walls) {
            if (w.getPosition().equals(position)) {
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

    private List<Jumper> createJumpers() {
        Random random = new Random();
        ArrayList<Jumper> jumpers = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            jumpers.add(new Jumper(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return jumpers;
    }

    private void moveMonsters() {
        for (Monster monster : this.monsters) {
            Position nextMove = monster.move();
            if (canMove(nextMove)) {
                monster.setPosition(nextMove);
            }
        }

        for (Jumper jumper : this.jumpers) {
            Position nextMove = jumper.move();
            if (canMove(nextMove)) {
                jumper.setPosition(nextMove);
            }
        }

    }

    public boolean verifyMonsterCollisions() {
        for (Monster monster : this.monsters) {
            if (monster.getPosition().equals(this.hero.getPosition())) {
                hero.setHealth(hero.getHealth() - 30);
                System.out.format("Collision! current health %d\n", hero.getHealth());
                return true;
            }
        }
        for (Jumper jumper : this.jumpers) {
            if (jumper.getPosition().equals(this.hero.getPosition())) {
                hero.setHealth(hero.getHealth() - 20);
                return true;
            }
        }

        return false;
    }

    public boolean checkHeroAlive() {
        return this.hero.getHealth() > 0;
    }

    public boolean checkLevelCompleted() {
        return this.coins.isEmpty();
    }

}
