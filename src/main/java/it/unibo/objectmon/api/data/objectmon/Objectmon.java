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
        this.types = List.copyOf(types);
        this.learnList = List.copyOf(learnList);
        this.expOnDeath = expOnDeath;
        this.maxExp = maxExp;
        this.canEvolve = canEvolve;
        this.knownSkills = List.copyOf(knownSkills);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getCurrentExp() {
        return this.currentExp;
    }

    public void setCurrentExp(int gainedExp) {
        this.currentExp = this.currentExp+gainedExp >= getMaxExp() ? this.currentExp + gainedExp - getMaxExp() : this.currentExp + gainedExp;
    }

    public int getMaxExp() {
        return this.maxExp;
    }

    public List<Skill> getKnownSkills() {
        return List.copyOf(this.knownSkills);
    }

    public Optional<Evolution> getCanEvolve() {
        return this.canEvolve;
    }

    public int getExpOnDeath() {
        return this.expOnDeath;
    }

    public List<Skill> getLearnList() {
        return List.copyOf(this.learnList);
    }

    public List<ElementalType> getTypes() {
        return List.copyOf(this.types);
    }

    public void evolveObjectmon(){
        Object doNothing;
        if(getCanEvolve().isPresent()){
            if(getCanEvolve().get().canEvolve(currentExp)){
                //THIS IS A TEMPORARY WORKAROUND FOR SPOTBUGS, BECAUSE THE EVOLUTION OF A ONJECTMON HASN'T BEEN IMPLEMENTED YET
                doNothing = null;
                //evolve objectmon
            }
        }
    }
}
