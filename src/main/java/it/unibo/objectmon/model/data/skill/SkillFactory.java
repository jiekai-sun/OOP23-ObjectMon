package it.unibo.objectmon.model.data.skill;

import java.util.LinkedList;
import java.util.List;
import it.unibo.objectmon.model.data.api.aspect.Aspect;
import it.unibo.objectmon.model.data.api.skill.SkillCategory;

/**
 * A factory of Skills.
 */
public final class SkillFactory {
    private static final int BASE_40 = 40;
    private static final int BASE_60 = 60;

    private static final int MAX_25 = 25;
    private static final int MAX_40 = 40;

    private static final int ACC_100 = 100;
    private static final int ACC_90 = 90;

    private SkillFactory() {
    }

    /**
     * Creates the Skills that Objectmon are going to use.
     * 
     * @return Returns the complete list of all the Skills.
     */
    public static List<SkillImpl> createSkills() {
        final List<SkillImpl> skillList = new LinkedList<>();
        int id = 0;
        for (final Aspect aspect : Aspect.values()) {
            String name = aspect.getAspectName() + " Tackle";
            skillList.add(new SkillImpl(name, id, aspect, BASE_40, ACC_100, MAX_40, SkillCategory.PHYS));
            id++;
            name = aspect.getAspectName() + " Kick";
            skillList.add(new SkillImpl(name, id, aspect, BASE_60, ACC_90, MAX_25, SkillCategory.PHYS));
            id++;
            name = aspect.getAspectName() + " Ray";
            skillList.add(new SkillImpl(name, id, aspect, BASE_40, ACC_100, MAX_40, SkillCategory.SPEC));
            id++;
            name = aspect.getAspectName() + " Spirit";
            skillList.add(new SkillImpl(name, id, aspect, BASE_60, ACC_90, MAX_25, SkillCategory.SPEC));
            id++;
        }
        return skillList;
    }
}
