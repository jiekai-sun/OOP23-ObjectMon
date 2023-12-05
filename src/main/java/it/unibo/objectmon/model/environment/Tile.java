package it.unibo.objectmon.model.environment;

public enum Tile {
    GRASS("grass"),
    WATER("water"),
    STONE("stone");

    private final String name;

    Tile(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
