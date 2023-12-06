package it.unibo.objectmon.api.data.type;

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
    private static final int NEUTRAL_VALUE = 1;
    
    private static final TypeMultiplier[][] typeChart = new TypeMultiplier[][]{
            //Normal
            new TypeMultiplier[]{   
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.N,
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.E
            },
            //Grass
            new TypeMultiplier[]{
                TypeMultiplier.E,
                TypeMultiplier.N,
                TypeMultiplier.N,
                TypeMultiplier.S,
                TypeMultiplier.N,
                TypeMultiplier.N,
                TypeMultiplier.S,
                TypeMultiplier.S,
                TypeMultiplier.E,
                TypeMultiplier.N,
                TypeMultiplier.E
            },
            //Fire
            new TypeMultiplier[]{
                TypeMultiplier.E,
                TypeMultiplier.S,
                TypeMultiplier.N,
                TypeMultiplier.N,
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.N,
                TypeMultiplier.N,
                TypeMultiplier.E,
                TypeMultiplier.S,
                TypeMultiplier.E
            },
            //Water
            new TypeMultiplier[]{   
                TypeMultiplier.E,
                TypeMultiplier.N,
                TypeMultiplier.S,
                TypeMultiplier.N,
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.S,
                TypeMultiplier.S,
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.E
            },
            //Flying
            new TypeMultiplier[]{   
                TypeMultiplier.E,
                TypeMultiplier.S,
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.N,
                TypeMultiplier.S,
                TypeMultiplier.S,
                TypeMultiplier.E
            },
            //Poison
            new TypeMultiplier[]{
                TypeMultiplier.E,
                TypeMultiplier.S,
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.N,
                TypeMultiplier.N,
                TypeMultiplier.N,
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.E
            },
            //Ground
            new TypeMultiplier[]{
                TypeMultiplier.E,
                TypeMultiplier.N,
                TypeMultiplier.S,
                TypeMultiplier.E,
                TypeMultiplier.I,
                TypeMultiplier.S,
                TypeMultiplier.E,
                TypeMultiplier.S,
                TypeMultiplier.E,
                TypeMultiplier.N,
                TypeMultiplier.E
            },   
            //Rock
            new TypeMultiplier[]{
                TypeMultiplier.E,
                TypeMultiplier.N,
                TypeMultiplier.S,
                TypeMultiplier.N,
                TypeMultiplier.S,
                TypeMultiplier.E,
                TypeMultiplier.N,
                TypeMultiplier.E,
                TypeMultiplier.N,
                TypeMultiplier.S,
                TypeMultiplier.E
            },   
            //Fighting
            new TypeMultiplier[]{
                TypeMultiplier.S,
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.N,
                TypeMultiplier.N,
                TypeMultiplier.E,
                TypeMultiplier.S,
                TypeMultiplier.E,
                TypeMultiplier.N,
                TypeMultiplier.E
            },   
            //Bug
            new TypeMultiplier[]{
                TypeMultiplier.E,
                TypeMultiplier.S,
                TypeMultiplier.N,
                TypeMultiplier.E,
                TypeMultiplier.N,
                TypeMultiplier.N,
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.N,
                TypeMultiplier.E,
                TypeMultiplier.E
            },
            //No Type   
            new TypeMultiplier[]{
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.E,
                TypeMultiplier.E
            },   
        };

    private ElementalType(final int id, final String name){
        this.id = id;
        this.name = name;
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
    private static double getTypeMultiplier(final int attackerType, final int defenderType){
        return typeChart[attackerType][defenderType].getValue();
    }

    /**
     * 
     * @param moveType ElementalType of the attacking Objectmon's Skill
     * @param defTypes ElementalTypes of the defending Objetmon
     * @return Returns the effectiveness multiplier of the attacking Skill against the Objectmon's ElementalTypes
     */
    public static double CalcTypeMatchup(ElementalType moveType, ElementalType[] defenderTypes){
        double multiplier = NEUTRAL_VALUE;
            for (ElementalType defType : defenderTypes) {
                multiplier *= getTypeMultiplier(moveType.id, defType.id);
            }
        return multiplier;
    }

    /**
     * 
     * @param type1 First ElementalType to compare.
     * @param type2 Second ElementalType to compare.
     * @return Returns true if they are the same ElementalType, false otherwise.
     */
    public boolean isSameElementalType(final ElementalType type1, final ElementalType type2){
        return type1.getId() == type2.getId();
    }

    /**
     * 
     * @param attackerElementalType ElementalType of the Objectmon.
     * @param skillElementalType ElementalType of the Skill the Objectmon is using.
     * @return Returns a multiplier for the SETB. If it's the same returns 1.5 . Returns 1 otherwise.
     */
    public double CalcSameElementalTypeBonus(final ElementalType attackerElementalType, final ElementalType skillElementalType){
        if(isSameElementalType(attackerElementalType,skillElementalType)){
            return 1.5;
        }
        else{
            return NEUTRAL_VALUE;
        }
    }
}
