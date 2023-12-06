package it.unibo.objectmon.api;

/**
 * Represents a player with basic movement functions.
 */
public interface Player extends Entity {
    /**
     * Moves the player up.
     */
    void moveUp();
    /**
     * Moves the player down.
     */
    void moveDown();
    /**
     * Moves the player left.
     */
    void moveLeft();
    /**
     * Moves the player right.
     */
    void moveRight();
}
