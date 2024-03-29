package it.unibo.objectmon.model.data.objectmon;

import java.util.List;
import java.util.Map;
import it.unibo.objectmon.model.data.api.aspect.Aspect;
import it.unibo.objectmon.model.data.api.skill.Skill;
import it.unibo.objectmon.model.data.api.statistics.StatId;
import it.unibo.objectmon.model.data.statistics.ActualStats;
import it.unibo.objectmon.model.data.statistics.BaseStats;
import it.unibo.objectmon.model.data.skill.SkillFactory;
import it.unibo.objectmon.model.data.skill.SkillImpl;

/**
 * Enum of Objectmon in the game.
 */
public enum ObjectmonEnum {

    /**
     * Information of the Objectmon Zigzagoon.
     */
    ZIGZAGOON(
        "Zigzagoon",
        List.of(Aspect.NORMAL),
        new BaseStats(
            Map.of(
                StatId.HP, 38,
                StatId.ATK, 30,
                StatId.DEF, 41,
                StatId.SPATK, 30,
                StatId.SPDEF, 41,
                StatId.SPD, 60
            )
        )
    ),

    /**
     * Information of the Objectmon Tailow.
     */
    TAILLOW(
        "Taillow",
        List.of(Aspect.NORMAL, Aspect.FLYING),
        new BaseStats(
            Map.of(
                StatId.HP, 40,
                StatId.ATK, 55,
                StatId.DEF, 30,
                StatId.SPATK, 30,
                StatId.SPDEF, 30,
                StatId.SPD, 85
            )
        )
    ),

    /**
     * Information of the Objectmon Oddish.
     */
    ODDISH(
        "Oddish",
        List.of(Aspect.GRASS, Aspect.POISON),
        new BaseStats(
            Map.of(
                StatId.HP, 45,
                StatId.ATK, 50,
                StatId.DEF, 55,
                StatId.SPATK, 75,
                StatId.SPDEF, 65,
                StatId.SPD, 30
            )
        )
    ),

    /**
     * Information of the Objectmon Kecleon.
     */
    KECLEON(
        "Kecleon",
        List.of(Aspect.NORMAL),
        new BaseStats(
            Map.of(
                StatId.HP, 60,
                StatId.ATK, 90,
                StatId.DEF, 70,
                StatId.SPATK, 60,
                StatId.SPDEF, 120,
                StatId.SPD, 40
            )
        )
    ),

    /**
     * Information of the Objectmon Treeko.
     */
    TREECKO(
        "Treecko",
        List.of(Aspect.GRASS),
        new BaseStats(
            Map.of(
            StatId.HP, 40,
            StatId.ATK, 45,
            StatId.DEF, 35,
            StatId.SPATK, 65,
            StatId.SPDEF, 55,
            StatId.SPD, 70
            )
        )
    ),

    /**
     * Information of the Objectmon Shroomish.
     */
    SHROOMISH(
        "Shroomish",
        List.of(Aspect.GRASS),
        new BaseStats(
            Map.of(
                StatId.HP, 60,
                StatId.ATK, 40,
                StatId.DEF, 60,
                StatId.SPATK, 40,
                StatId.SPDEF, 60,
                StatId.SPD, 35
            )
        )
    ),

    /**
     * Information of the Objectmon Volbeat.
     */
    VOLBEAT(
        "Volbeat",
        List.of(Aspect.BUG),
        new BaseStats(
            Map.of(
                StatId.HP, 65,
                StatId.ATK, 73,
                StatId.DEF, 55,
                StatId.SPATK, 47,
                StatId.SPDEF, 75,
                StatId.SPD, 85
            )
        )
    ),

    /**
     * Information of the Objectmon Illumise.
     */
    ILLUMISE(
        "Illumise",
        List.of(Aspect.BUG),
        new BaseStats(
            Map.of(
                StatId.HP, 65,
                StatId.ATK, 47,
                StatId.DEF, 55,
                StatId.SPATK, 73,
                StatId.SPDEF, 75,
                StatId.SPD, 85
            )
        )
    ),

    /**
     * Information of the Objectmon Tropius.
     */
    TROPIUS(
        "Tropius",
        List.of(Aspect.GRASS, Aspect.FLYING),
        new BaseStats(
            Map.of(
                StatId.HP, 99,
                StatId.ATK, 68,
                StatId.DEF, 83,
                StatId.SPATK, 72,
                StatId.SPDEF, 87,
                StatId.SPD, 51
            )
        )
    ),

    /**
     * Information of the Objectmon Mudkip.
     */
    MUDKIP(
        "Mudkip",
        List.of(Aspect.WATER, Aspect.GROUND),
        new BaseStats(
            Map.of(
                StatId.HP, 50,
                StatId.ATK, 70,
                StatId.DEF, 50,
                StatId.SPATK, 50,
                StatId.SPDEF, 50,
                StatId.SPD, 40
            )
        )
    ),

    /**
     * Information of the Objectmon Goldeen.
     */
    GOLDEEN(
        "Goldeen",
        List.of(Aspect.WATER),
        new BaseStats(
            Map.of(
                StatId.HP, 45,
                StatId.ATK, 67,
                StatId.DEF, 60,
                StatId.SPATK, 35,
                StatId.SPDEF, 50,
                StatId.SPD, 63
            )
        )
    ),

    /**
     * Information of the Objectmon Staryu.
     */
    STARYU(
        "Staryu",
        List.of(Aspect.WATER),
        new BaseStats(
            Map.of(
                StatId.HP, 35,
                StatId.ATK, 45,
                StatId.DEF, 55,
                StatId.SPATK, 70,
                StatId.SPDEF, 55,
                StatId.SPD, 85
            )
        )
    ),

    /**
     * Information of the Objectmon Relicant.
     */
    RELICANTH(
        "Relicanth",
        List.of(Aspect.WATER, Aspect.ROCK),
        new BaseStats(
            Map.of(
                StatId.HP, 100,
                StatId.ATK, 90,
                StatId.DEF, 130,
                StatId.SPATK, 45,
                StatId.SPDEF, 65,
                StatId.SPD, 55
            )
        )
    ),

    /**
     * Information of the Objectmon Torchic.
     */
    TORCHIC(
        "Torchic",
        List.of(Aspect.FIRE),
        new BaseStats(
            Map.of(
                StatId.HP, 45,
                StatId.ATK, 60,
                StatId.DEF, 40,
                StatId.SPATK, 70,
                StatId.SPDEF, 50,
                StatId.SPD, 45
            )
        )
    ),

    /**
     * Information of the Objectmon Slugma.
     */
    SLUGMA(
        "Slugma",
        List.of(Aspect.FIRE),
        new BaseStats(
            Map.of(
                StatId.HP, 40,
                StatId.ATK, 40,
                StatId.DEF, 40,
                StatId.SPATK, 70,
                StatId.SPDEF, 40,
                StatId.SPD, 20
            )
        )
    ),

    /**
     * Information of the Objectmon Numel.
     */
    NUMEL(
        "Numel",
        List.of(Aspect.FIRE, Aspect.GROUND),
        new BaseStats(
            Map.of(
                StatId.HP, 60,
                StatId.ATK, 60,
                StatId.DEF, 40,
                StatId.SPATK, 65,
                StatId.SPDEF, 45,
                StatId.SPD, 35
            )
        )
    ),

    /**
     * Information of the Objectmon Torkoal.
     */
    TORKOAL(
        "Torkoal",
        List.of(Aspect.FIRE),
        new BaseStats(
            Map.of(
                StatId.HP, 70,
                StatId.ATK, 85,
                StatId.DEF, 140,
                StatId.SPATK, 85,
                StatId.SPDEF, 70,
                StatId.SPD, 20
            )
        )
    ),

    /**
     * Information of the Objectmon Geodude.
     */
    GEODUDE(
        "Geodude",
        List.of(Aspect.ROCK, Aspect.GROUND),
        new BaseStats(
            Map.of(
                StatId.HP, 40,
                StatId.ATK, 80,
                StatId.DEF, 100,
                StatId.SPATK, 30,
                StatId.SPDEF, 30,
                StatId.SPD, 20
            )
        )
    ),

    /**
     * Information of the Objectmon Lileep.
     */
    LILEEP(
        "Lileep",
        List.of(Aspect.ROCK, Aspect.GRASS),
        new BaseStats(
            Map.of(
                StatId.HP, 66,
                StatId.ATK, 41,
                StatId.DEF, 77,
                StatId.SPATK, 61,
                StatId.SPDEF, 87,
                StatId.SPD, 23
            )
        )
    ),

    /**
     * Information of the Objectmon Anorith.
     */
    ANORITH(
        "Anorith",
        List.of(Aspect.ROCK, Aspect.BUG),
        new BaseStats(
            Map.of(
                StatId.HP, 45,
                StatId.ATK, 95,
                StatId.DEF, 50,
                StatId.SPATK, 40,
                StatId.SPDEF, 50,
                StatId.SPD, 75
            )
        )
    ),

    /**
     * Information of the Objectmon Sandshrew.
     */
    SANDSHREW(
        "Sandshrew",
        List.of(Aspect.GROUND),
        new BaseStats(
            Map.of(
                StatId.HP, 50,
                StatId.ATK, 75,
                StatId.DEF, 85,
                StatId.SPATK, 20,
                StatId.SPDEF, 30,
                StatId.SPD, 40
            )
        )
    ),

    /**
     * Information of the Objectmon Nosepass.
     */
    NOSEPASS(
        "Nosepass",
        List.of(Aspect.ROCK),
        new BaseStats(
            Map.of(
                StatId.HP, 30,
                StatId.ATK, 45,
                StatId.DEF, 135,
                StatId.SPATK, 45,
                StatId.SPDEF, 90,
                StatId.SPD, 30
            )
        )
    );

    private final String name;
    private final List<Aspect> aspects;
    private final List<SkillImpl> skills;
    private final ActualStats stats;

    /**
     * Constructor of ObjectmonEnum.
     * 
     * @param name Name of the Objectmon
     * @param aspects Aspects of the Objectmon.
     * @param stats Stats of the Objectmon.
     */
    ObjectmonEnum(final String name, final List<Aspect> aspects, final BaseStats stats) {
        this.name = name;
        this.aspects = List.copyOf(aspects);

        final List<SkillImpl> skills = SkillFactory.createSkills().stream()
        .filter(skill -> skill.getAspect().sameAspect(aspects))
        .toList();

        if (aspects.size() > 1) {
            final int firstAspectIndex = 2;
            final int lastAspectIndex = 6;
            this.skills = skills.subList(firstAspectIndex, lastAspectIndex);
        } else {
            this.skills = skills;
        }
        this.stats = new ActualStats(stats);
    }

    /**
     * Getter of name.
     * 
     * @return Returns the name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter of Aspects.
     * 
     * @return Returns the Aspects.
     */
    public List<Aspect> getAspects() {
        return List.copyOf(this.aspects);
    }

    /**
     * Getter of Stats.
     * 
     * @return Returns the Stats.
     */
    public ActualStats getStats() {
        return this.stats;
    }

    /**
     * Getter of Skills.
     * 
     * @return Returns the Skills.
     */
    public List<Skill> getSkills() {
        return List.copyOf(this.skills);
    }
}
