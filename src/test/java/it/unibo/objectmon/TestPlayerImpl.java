package it.unibo.objectmon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import it.unibo.objectmon.model.entities.PlayerImpl;

class TestPlayerImpl {
    @Test
    void testMovement() {
        final PlayerImpl player = new PlayerImpl("Brendan", 10, 15);
        //CHECKSTYLE: MagicNumber OFF
        assertEquals(10, player.getX());
        assertEquals(15, player.getY());
        player.moveLeft();
        player.moveUp();
        player.moveRight();
        player.moveDown();
        assertEquals(10, player.getX());
        assertEquals(15, player.getY());
        player.moveDown();
        player.moveDown();
        player.moveDown();
        assertEquals(12, player.getY());
        //CHECKSTYLE: MagicNumber ON
    }
}
