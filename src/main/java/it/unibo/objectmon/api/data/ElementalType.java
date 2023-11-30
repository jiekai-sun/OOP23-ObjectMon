package it.unibo.objectmon.api.data;

public enum ElementalType {

    NORMAL(0,"Normal"),
    GRASS(1,"Grass"),
    FIRE(2,"Fire"),
    WATER(3,"Water"),
    FLYING(4,"Flying"),
    POISON(5,"Poison"),
    GROUND(6,"Ground"),
    ROCK(7,"Rock"),
    FIGHTING(8,"Fighting"),
    BUG(9,"Bug");
    
    private final int id;
    private final String name;
    private final Multiplier[][] typeChart;
    
    private ElementalType(final int id, final String name){
        this.id = id;
        this.name = name;    
        this.typeChart = new Multiplier[][]{
            new Multiplier[]{Multiplier.E, Multiplier.E, Multiplier.E, Multiplier.E, Multiplier.E, Multiplier.E, Multiplier.E, Multiplier.N, Multiplier.E, Multiplier.E},   //Normal
            new Multiplier[]{Multiplier.E, Multiplier.N, Multiplier.N, Multiplier.S, Multiplier.N, Multiplier.N, Multiplier.S, Multiplier.S, Multiplier.E, Multiplier.N},   //Grass
            new Multiplier[]{Multiplier.E, Multiplier.S, Multiplier.N, Multiplier.N, Multiplier.E, Multiplier.E, Multiplier.N, Multiplier.N, Multiplier.E, Multiplier.S},   //Fire
            new Multiplier[]{Multiplier.E, Multiplier.N, Multiplier.S, Multiplier.N, Multiplier.E, Multiplier.E, Multiplier.S, Multiplier.S, Multiplier.E, Multiplier.E},   //Water
            new Multiplier[]{Multiplier.E, Multiplier.S, Multiplier.E, Multiplier.E, Multiplier.E, Multiplier.E, Multiplier.E, Multiplier.N, Multiplier.S, Multiplier.S},   //Flying
            new Multiplier[]{Multiplier.E, Multiplier.S, Multiplier.E, Multiplier.E, Multiplier.E, Multiplier.N, Multiplier.N, Multiplier.N, Multiplier.E, Multiplier.E},   //Poison
            new Multiplier[]{Multiplier.E, Multiplier.N, Multiplier.S, Multiplier.E, Multiplier.I, Multiplier.S, Multiplier.E, Multiplier.S, Multiplier.E, Multiplier.N},   //Ground
            new Multiplier[]{Multiplier.E, Multiplier.N, Multiplier.S, Multiplier.N, Multiplier.S, Multiplier.E, Multiplier.N, Multiplier.E, Multiplier.N, Multiplier.S},   //Rock
            new Multiplier[]{Multiplier.S, Multiplier.E, Multiplier.E, Multiplier.E, Multiplier.N, Multiplier.N, Multiplier.E, Multiplier.S, Multiplier.E, Multiplier.N},   //Fighting
            new Multiplier[]{Multiplier.E, Multiplier.S, Multiplier.N, Multiplier.E, Multiplier.N, Multiplier.N, Multiplier.E, Multiplier.E, Multiplier.N, Multiplier.E}    //Bug
        };
        
        
    }
    
    /**
     * 
     * @return the id of the Type
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @return the name of the Type
     */
    public String getName() {
        return name;
    }


    public double typeMultiplier(final int attackerType, final int defenderType){
        return this.typeChart[attackerType][defenderType].getValue();
    }
}
