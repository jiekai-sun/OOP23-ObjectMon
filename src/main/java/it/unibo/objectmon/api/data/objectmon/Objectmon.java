package it.unibo.objectmon.api.data.objectmon;

import it.unibo.objectmon.api.data.Skill;
import it.unibo.objectmon.api.data.type.ElementalType;
import java.util.List;
import java.util.Optional;



public class Objectmon {
    private final int id;
    private final String name;
    private final List<ElementalType> types;
    private final List<Skill> learnList;
    private final int expOnDeath;
    private final int maxExp;
    private final Optional<Evolution> canEvolve;

    private  List<Skill> knownSkills;   
    private int currentExp;

    public Objectmon(final int id, final String name, final List<ElementalType> types, final List<Skill> learnList, final int expOnDeath, final int maxExp, final Optional<Evolution> canEvolve, final List<Skill> knownSkills) {
        this.id = id;
        this.name = name;
        this.types = types;
        this.learnList = learnList;
        this.expOnDeath = expOnDeath;
        this.maxExp = maxExp;
        this.canEvolve = canEvolve;
        this.knownSkills = knownSkills;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCurrentExp() {
        return currentExp;
    }

    public int getMaxExp() {
        return maxExp;
    }

    public List<Skill> getKnownSkills() {
        return knownSkills;
    }

    public Optional<Evolution> getCanEvolve() {
        return canEvolve;
    }

    public int getExpOnDeath() {
        return expOnDeath;
    }

    public List<Skill> getLearnList() {
        return learnList;
    }

    public List<ElementalType> getTypes() {
        return types;
    }

    public void evolveObjectmon(){
        if(getCanEvolve().isPresent()){
            if(getCanEvolve().get().canEvolve(currentExp)){
                //evolve objectmon
            }
        }
    }
}
