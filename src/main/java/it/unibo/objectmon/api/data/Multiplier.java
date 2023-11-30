package it.unibo.objectmon.api.data;

public enum Multiplier {
    E(1,"Effective"),
    S(2,"Supereffective"),
    N(0.5,"Not very effective"),    
    I(0,"Immune");

    private final double value;
    private final String name;

    private Multiplier(final double value, final String name){
        this.value = value;
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
