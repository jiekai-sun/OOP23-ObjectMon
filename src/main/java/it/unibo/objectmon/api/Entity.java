package it.unibo.objectmon.api;

/**
 * Represents an entity that could be the player or an NPC.
 */
public interface Entity {
    /**
     * @return entity x position.
     */
    int getX();
    /**
     * @return entity y position.
     */
    int getY();

    /**
     * @return entity's name.
     */
    String getName();
}
