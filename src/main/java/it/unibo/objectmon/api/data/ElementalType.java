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
    private final TypeMultiplier[][] typeChart;
    
    private ElementalType(final int id, final String name){
        this.id = id;
        this.name = name;    
        this.typeChart = new TypeMultiplier[][]{
            new TypeMultiplier[]{TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.N, TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.E},   //Normal
            new TypeMultiplier[]{TypeMultiplier.E, TypeMultiplier.N, TypeMultiplier.N, TypeMultiplier.S, TypeMultiplier.N, TypeMultiplier.N, TypeMultiplier.S, TypeMultiplier.S, TypeMultiplier.E, TypeMultiplier.N, TypeMultiplier.E},   //Grass
            new TypeMultiplier[]{TypeMultiplier.E, TypeMultiplier.S, TypeMultiplier.N, TypeMultiplier.N, TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.N, TypeMultiplier.N, TypeMultiplier.E, TypeMultiplier.S, TypeMultiplier.E},   //Fire
            new TypeMultiplier[]{TypeMultiplier.E, TypeMultiplier.N, TypeMultiplier.S, TypeMultiplier.N, TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.S, TypeMultiplier.S, TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.E},   //Water
            new TypeMultiplier[]{TypeMultiplier.E, TypeMultiplier.S, TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.N, TypeMultiplier.S, TypeMultiplier.S, TypeMultiplier.E},   //Flying
            new TypeMultiplier[]{TypeMultiplier.E, TypeMultiplier.S, TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.N, TypeMultiplier.N, TypeMultiplier.N, TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.E},   //Poison
            new TypeMultiplier[]{TypeMultiplier.E, TypeMultiplier.N, TypeMultiplier.S, TypeMultiplier.E, TypeMultiplier.I, TypeMultiplier.S, TypeMultiplier.E, TypeMultiplier.S, TypeMultiplier.E, TypeMultiplier.N, TypeMultiplier.E},   //Ground
            new TypeMultiplier[]{TypeMultiplier.E, TypeMultiplier.N, TypeMultiplier.S, TypeMultiplier.N, TypeMultiplier.S, TypeMultiplier.E, TypeMultiplier.N, TypeMultiplier.E, TypeMultiplier.N, TypeMultiplier.S, TypeMultiplier.E},   //Rock
            new TypeMultiplier[]{TypeMultiplier.S, TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.N, TypeMultiplier.N, TypeMultiplier.E, TypeMultiplier.S, TypeMultiplier.E, TypeMultiplier.N, TypeMultiplier.E},   //Fighting
            new TypeMultiplier[]{TypeMultiplier.E, TypeMultiplier.S, TypeMultiplier.N, TypeMultiplier.E, TypeMultiplier.N, TypeMultiplier.N, TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.N, TypeMultiplier.E, TypeMultiplier.E},   //Bug
            new TypeMultiplier[]{TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.E, TypeMultiplier.E},   //No Type
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
