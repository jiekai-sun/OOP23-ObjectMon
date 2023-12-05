package it.unibo.objectmon.api.data.objectmon;

import java.util.Map;
import java.util.Optional;

public class Evolution {
    private final Optional<Map<Integer, Boolean>> isLevel;
    private final Optional<Boolean> isStone;
    private final Optional<Boolean> isTrade;
    
    public Evolution(final Optional<Map<Integer,Boolean>> isLevel, final Optional<Boolean> isStone, final Optional<Boolean> isTrade) {
        this.isLevel = isLevel;
        this.isStone = isStone;
        this.isTrade = isTrade;
    }

    public Optional<Map<Integer, Boolean>> getIsLevel() {
        return isLevel;
    }

    public Optional<Boolean> getIsStone() {
        return isStone;
    }

    public Optional<Boolean> getIsTrade() {
        return isTrade;
    }

    public boolean canEvolve(final int currentLevel){
        if(getIsLevel().get().containsKey(currentLevel) || getIsStone().isPresent() || getIsTrade().isPresent()){
            return true;
        }
        else{
            return false;
        }
    }

} 
