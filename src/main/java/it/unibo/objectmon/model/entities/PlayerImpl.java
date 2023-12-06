package it.unibo.objectmon.model.entities;

import it.unibo.objectmon.api.Player;

/**
 * This will be the implementation of {@link Player}.
 */
public final class PlayerImpl implements Player {
    private final String name;
    private int x;
    private int y;
    /**
     * Builds a basic player character.
     * 
     * @param name the player's name
     * @param x the player's x position
     * @param y the player's y position
     */
    public PlayerImpl(final String name, final int x, final int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
    @Override
    public int getX() {
        return this.x;
    }
    @Override
    public int getY() {
        return this.y;
    }
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public void moveUp() {
        this.y++;
    }
    @Override
    public void moveDown() {
        this.y--;
    }
    @Override
    public void moveLeft() {
        this.x--;
    }
    @Override
    public void moveRight() {
        this.x++;
    }
}
