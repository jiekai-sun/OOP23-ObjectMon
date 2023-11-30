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
    BUG(9,"Bug"),
    NULL(10,"");
    
    private final int id;
    private final String name;
    private final Multiplier[][] typeChart;
    
    private ElementalType(final int id, final String name){
        this.id = id;
        this.name = name;    
        this.typeChart = new Multiplier[][]{
            new Multiplier[]{Multiplier.E, Multiplier.E, Multiplier.E, Multiplier.E, Multiplier.E, Multiplier.E, Multiplier.E, Multiplier.N, Multiplier.E, Multiplier.E, Multiplier.E},   //Normal
            new Multiplier[]{Multiplier.E, Multiplier.N, Multiplier.N, Multiplier.S, Multiplier.N, Multiplier.N, Multiplier.S, Multiplier.S, Multiplier.E, Multiplier.N, Multiplier.E},   //Grass
            new Multiplier[]{Multiplier.E, Multiplier.S, Multiplier.N, Multiplier.N, Multiplier.E, Multiplier.E, Multiplier.N, Multiplier.N, Multiplier.E, Multiplier.S, Multiplier.E},   //Fire
            new Multiplier[]{Multiplier.E, Multiplier.N, Multiplier.S, Multiplier.N, Multiplier.E, Multiplier.E, Multiplier.S, Multiplier.S, Multiplier.E, Multiplier.E, Multiplier.E},   //Water
            new Multiplier[]{Multiplier.E, Multiplier.S, Multiplier.E, Multiplier.E, Multiplier.E, Multiplier.E, Multiplier.E, Multiplier.N, Multiplier.S, Multiplier.S, Multiplier.E},   //Flying
            new Multiplier[]{Multiplier.E, Multiplier.S, Multiplier.E, Multiplier.E, Multiplier.E, Multiplier.N, Multiplier.N, Multiplier.N, Multiplier.E, Multiplier.E, Multiplier.E},   //Poison
            new Multiplier[]{Multiplier.E, Multiplier.N, Multiplier.S, Multiplier.E, Multiplier.I, Multiplier.S, Multiplier.E, Multiplier.S, Multiplier.E, Multiplier.N, Multiplier.E},   //Ground
            new Multiplier[]{Multiplier.E, Multiplier.N, Multiplier.S, Multiplier.N, Multiplier.S, Multiplier.E, Multiplier.N, Multiplier.E, Multiplier.N, Multiplier.S, Multiplier.E},   //Rock
            new Multiplier[]{Multiplier.S, Multiplier.E, Multiplier.E, Multiplier.E, Multiplier.N, Multiplier.N, Multiplier.E, Multiplier.S, Multiplier.E, Multiplier.N, Multiplier.E},   //Fighting
            new Multiplier[]{Multiplier.E, Multiplier.S, Multiplier.N, Multiplier.E, Multiplier.N, Multiplier.N, Multiplier.E, Multiplier.E, Multiplier.N, Multiplier.E, Multiplier.E},   //Bug
            new Multiplier[]{Multiplier.E, Multiplier.E, Multiplier.E, Multiplier.E, Multiplier.E, Multiplier.E, Multiplier.E, Multiplier.E, Multiplier.E, Multiplier.E, Multiplier.E},   //No Type
        };
        
        
    }
    
    /**
     * 
     * @return Returns the id of the ElementalType
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @return Returns the name of the ElementalType
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param attackerType Id of the ElementalType of the move used by the attacking Objectmon
     * @param defenderType Id of the ElementalType of the defending Objectmon
     * @return Returns the multiplier applied for that type combination
     */
    public double getTypeMultiplier(final int attackerType, final int defenderType){
        return this.typeChart[attackerType][defenderType].getValue();
    }

    /**
     * 
     * @param moveType ElementalType of the attacking Objectmon's Skill
     * @param defenderTypes ElementalTypes of the defending Objetmon
     * @return Returns the effectiveness multiplier of the attacking Skill against the Objectmon's ElementalTypes
     */
    public double CalcMultiplier(ElementalType moveType, ElementalType[] defenderTypes){
        double multiplier = 1;
            for (ElementalType defenderType : defenderTypes) {
                multiplier *= getTypeMultiplier(moveType.getId(), defenderType.getId());
            }
        return multiplier;
    }
}
