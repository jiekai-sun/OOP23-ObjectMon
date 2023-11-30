package it.unibo.objectmon.api.data;

public enum DamageType {
    PHYS(0,"Physical"),
    SPEC(1,"Special"),
    STUS(2,"Status");

    private final int id;
    private final String name;

    private DamageType(final int id, final String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}