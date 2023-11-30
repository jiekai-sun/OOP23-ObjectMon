package it.unibo.objectmon.api.data.type;

public enum DamageType {
    PHYS(0,"Physical"),
    SPEC(1,"Special"),
    STUS(2,"Status");
    
    private final int id;
    private final String name;

    /**
     * 
     * @param id Id of the DamageType
     * @param name Name of the DamageType
     */
    private DamageType(final int id, final String name){
        this.id = id;
        this.name = name;
    }
    
    /**
     * 
     * @return Returns the id of the DamageType of the Skill
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @return Returns the name of the DamageType of the Skill
     */
    public String getName() {
        return name;
    }
}