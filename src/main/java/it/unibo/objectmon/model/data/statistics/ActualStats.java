package it.unibo.objectmon.model.data.statistics;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import it.unibo.objectmon.model.data.api.statistics.StatId;


/**
 * Extension of the class StatsImpl.
 * <br>This implementation is used to store the change of stats of the Objectmon
 * (through evolution or level up).
 * The changes need to be saved in a new Map of Stats,
 * because leveling should be an action that rarely happens and
 * so creating a new object shouldn't be too taxing on the program.
 */
public class ActualStats extends StatsAbs implements Serializable {

    private static final long serialVersionUID = 2004L;
    private static final double STATGROWTHVARIATION = 0.15;

    /**
     * Constructor of the class.
     *
     * @param stats Map of all the stats.
     */
    public ActualStats(final Map<StatId, Integer> stats) {
        super(stats);
    }

    /**
     * Constuctor of the class with BaseStats.
     *
     * @param stats Stats of the Objectmon.
     */
    public ActualStats(final BaseStats stats) {
        super(stats.getStats());
    }

    /**
     * Calculates all the new stats of an Objectmon after level up.
     * Should only be called when an Objectmon levels up.
     *
     * @return Returns the new Stats of the Objectmon after level up.
     * @param level How many level ups are done in a row.
     */
    public ActualStats calcNewStats(final int level) {
        final Map<StatId, Integer> newStats = new HashMap<>();
            for (final StatId singleStatId : StatId.values()) {

                final int newSingleStat = calcSingleStat(singleStatId, level);
                newStats.put(singleStatId, newSingleStat);
            }
        return new ActualStats(newStats);
    }

     /**
     * Calculates the new single stat.
     * It's an utility method.
     *
     * Should only be called by the method calcNewStat.
     *
     * @param id Id of the statistic to increase.
     * @param level How many level ups are done in a row.
     * @return Returns the new singleStat, which is between 1-5. 1 If the stat is already high, 5 if it's low.
     * This was made for "balancing" reasons.
     */
    private int calcSingleStat(final StatId id, final int level) {
        int newSingleStat = getSingleStat(id);
        final int growthRange = 6;
        final int maxRawGrowth = 10;
        final int minRawGrowth = 1;
        final int ratio = 2;
            for (int i = level; i > 0; i--) {
                int rawGrowth = (int) Math.ceil(newSingleStat * STATGROWTHVARIATION);
                rawGrowth = Math.max(minRawGrowth, Math.min(rawGrowth, maxRawGrowth));

                newSingleStat += growthRange - rawGrowth / ratio;
            }
        return newSingleStat;
    }



}
