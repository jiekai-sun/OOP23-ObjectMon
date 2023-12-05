package it.unibo.objectmon.model.entities;

import it.unibo.objectmon.api.Entity;

public class Player implements Entity {
    private final String name;
    private int x;
    private int y;
        
    public Player(final String name, final int x, final int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String getName() {
        return this.name;
    }
    
    public void moveUp() {
        this.y--;
    }

    public void moveDown() {
        this.y++;
    }

    public void moveLeft() {
        this.x--;
    }

    public void moveRight() {
        this.x++;
    }
}
