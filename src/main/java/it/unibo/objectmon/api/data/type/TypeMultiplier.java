package it.unibo.objectmon.api.data.type;

public enum TypeMultiplier {
    E(1,"Effective"),
    S(2,"Supereffective"),
    N(0.5,"Not very effective"),    
    I(0,"Immune");

    private final double value;
    private final String name;

    /**
     * 
     * @param value Value of the multiplier used to determine the effectivness of a Skill against a certain Objectmon with a certain Tyoe
     * @param name Name of the multiplier  used to determine the effectivness of a Skill against a certain Objectmon with a certain Tyoe
     */
    private TypeMultiplier(final double value, final String name){
        this.value = value;
        this.name = name;
    }

    /**
     * 
     * @return Returns the multiplier of the Multiplier
     */
    public double getValue() {
        return value;
    }

    /**
     * 
     * @return Returns the name of the Multiplier
     */
    public String getName() {
        return name;
    }
}
