package it.unibo.objectmon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import it.unibo.objectmon.api.data.type.*;

public class ElementalTypeTest {

    public final static int NORMALID = 0;
    public final static int GRASSID = 1;
    public final static int FIREID = 2;
    public final static int WATERID = 3;
    public final static int FLYINGID = 4;
    public final static int POISONID = 5;
    public final static int GROUNDID = 6;
    public final static int ROCKID = 7;
    public final static int FIGHTINGID = 8;
    public final static int BUGID = 9;


    /**
     * 
     */
    @Test
    void testElementalTypeGetters(){

        assertEquals(NORMALID, ElementalType.NORMAL.getId());  
        assertEquals("Normal", ElementalType.NORMAL.getName());

        assertEquals(GRASSID, ElementalType.GRASS.getId());  
        assertEquals("Grass", ElementalType.GRASS.getName());
        
        assertEquals(FIREID, ElementalType.FIRE.getId());  
        assertEquals("Fire", ElementalType.FIRE.getName());
        
        assertEquals(WATERID, ElementalType.WATER.getId());  
        assertEquals("Water", ElementalType.WATER.getName());
        
        assertEquals(FLYINGID, ElementalType.FLYING.getId());  
        assertEquals("Flying", ElementalType.FLYING.getName());
        
        assertEquals(POISONID, ElementalType.POISON.getId());  
        assertEquals("Poison", ElementalType.POISON.getName());
        
        assertEquals(GROUNDID, ElementalType.GROUND.getId());  
        assertEquals("Ground", ElementalType.GROUND.getName());
        
        assertEquals(ROCKID, ElementalType.ROCK.getId());  
        assertEquals("Rock", ElementalType.ROCK.getName());
        
        assertEquals(FIGHTINGID, ElementalType.FIGHTING.getId());  
        assertEquals("Fighting", ElementalType.FIGHTING.getName());
        
        assertEquals(BUGID, ElementalType.BUG.getId());  
        assertEquals("Bug", ElementalType.BUG.getName());
    }

    @Test
    void testMultipliers(){
        //a GROUND skill is x2 against ROCK, but FLYING is immune to GROUND, so the result should be 0
        int expectedValue = 0;
        assertEquals(expectedValue,ElementalType.CalcTypeMatchup(
            ElementalType.GROUND,
            new ElementalType[]{
                ElementalType.ROCK,
                ElementalType.FLYING
            }
        ));

        //a FLYING skill is x2 against BUG and GRASS, so the result should be 4
        expectedValue = 4;
        assertEquals(expectedValue,ElementalType.CalcTypeMatchup(
            ElementalType.FLYING,
            new ElementalType[]{
                ElementalType.BUG,
                ElementalType.GRASS
            }
        ));

        //a FIRE skill is x0.5 against WATER, but x2 against GRASS, so the result should be 1
        expectedValue = 1;
        assertEquals(expectedValue,ElementalType.CalcTypeMatchup(
            ElementalType.FIRE,
            new ElementalType[]{
                ElementalType.WATER,
                ElementalType.GRASS
            }
        ));
    }

    /**
     * 
     */
    @Test
    void testIsSameType(){
        for (ElementalType type1 : ElementalType.values()) {
            for (ElementalType type2 : ElementalType.values()) {
                if(type1 == type2){
                    assertEquals(true,ElementalType.isSameElementalType(type1, type2));
                }
                else{
                    assertEquals(false,ElementalType.isSameElementalType(type1, type2));
                }
            }    
        }
    }

    @Test
    void testSameTypeBonus(){
        double sameTypeBonus = 1.5;
        double notSameTypeBonus = 1;
        for (ElementalType type1 : ElementalType.values()) {
            for (ElementalType type2 : ElementalType.values()) {
                if(type1 == type2){
                    assertEquals(sameTypeBonus,ElementalType.CalcSameElementalTypeBonus(type1, type2));
                }
                else{
                    assertEquals(notSameTypeBonus,ElementalType.CalcSameElementalTypeBonus(type1, type2));
                }
            }    
        }
    }

    /**
     * Test if the multipliers are of the expected value for Normal
     */
    @Test
    void testNormalChart(){
        ElementalType skillType = ElementalType.NORMAL;
        for (ElementalType element : ElementalType.values()) {
            //Rock type is the only ElementalType which isn't effective (not very effective)
            if(element.getId() != ROCKID){
                assertEquals(1,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));
            }
            else{
                assertEquals(0.5,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));
            }
        }
    }

    /**
     * Test if the multipliers are of the expected value for Grass
     */
    @Test
    void testGrassChart(){
        ElementalType skillType = ElementalType.GRASS;
        for (ElementalType element : ElementalType.values()) {
            switch (element.getId()) {
                //Should be not effective
                case GRASSID,FIREID,FLYINGID,POISONID,BUGID: 
                    assertEquals(0.5,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));    
                    break;
                //Should be super effective
                case WATERID,GROUNDID,ROCKID:     
                    assertEquals(2,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));
                    break;
                //Should be effective
                default:        
                    assertEquals(1,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));
                    break;
            }
        }
    }

    /**
     * Test if the multipliers are of the expected value for Fire
     */
    @Test
    void testFireChart(){
        ElementalType skillType = ElementalType.FIRE;
        for (ElementalType element : ElementalType.values()) {
            switch (element.getId()) {
                //Should be not effective
                case FIREID,WATERID,ROCKID: 
                    assertEquals(0.5,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));    
                    break;
                //Should be super effective
                case GRASSID,BUGID:     
                    assertEquals(2,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));
                    break;
                //Should be effective
                default:        
                    assertEquals(1,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));
                    break;
            }
        }
    }

    /**
     * Test if the multipliers are of the expected value for Water
     */
    @Test
    void testWaterChart(){
        ElementalType skillType = ElementalType.WATER;
        for (ElementalType element : ElementalType.values()) {
            switch (element.getId()) {
                //Should be not effective
                case GRASSID,WATERID: 
                    assertEquals(0.5,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));    
                    break;
                //Should be super effective
                case FIREID,GROUNDID,ROCKID:     
                    assertEquals(2,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));
                    break;
                //Should be effective
                default:        
                    assertEquals(1,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));
                    break;
            }
        }
    }

    /**
     * Test if the multipliers are of the expected value for Flying
     */
    @Test
    void testFlyingChart(){
        ElementalType skillType = ElementalType.FLYING;
        for (ElementalType element : ElementalType.values()) {
            switch (element.getId()) {
                //Should be not effective
                case ROCKID: 
                    assertEquals(0.5,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));    
                    break;
                //Should be super effective
                case GRASSID,FIGHTINGID,BUGID:     
                    assertEquals(2,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));
                    break;
                //Should be effective
                default:        
                    assertEquals(1,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));
                    break;
            }
        }
    }

    /**
     * Test if the multipliers are of the expected value for Poison
     */
    @Test
    void testPoisonChart(){
        ElementalType skillType = ElementalType.POISON;
        for (ElementalType element : ElementalType.values()) {
            switch (element.getId()) {
                //Should be not effective
                case POISONID,GROUNDID,ROCKID: 
                    assertEquals(0.5,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));    
                    break;
                //Should be super effective
                case GRASSID:     
                    assertEquals(2,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));
                    break;
                //Should be effective
                default:        
                    assertEquals(1,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));
                    break;
            }
        }
    }

    /**
     * Test if the multipliers are of the expected value for Ground
     */
    @Test
    void testGroundChart(){
        ElementalType skillType = ElementalType.GROUND;
        for (ElementalType element : ElementalType.values()) {
            switch (element.getId()) {
                //Should be not effective
                case GRASSID,BUGID: 
                    assertEquals(0.5,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));    
                    break;
                //Should be super effective
                case FIREID,POISONID,ROCKID:     
                    assertEquals(2,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));
                    break;
                case FLYINGID:
                    assertEquals(0,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));
                break;
                //Should be effective
                default:        
                    assertEquals(1,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));
                    break;
            }
        }
    }

    /**
     * Test if the multipliers are of the expected value for Rock
     */
    @Test
    void testRockChart(){
        ElementalType skillType = ElementalType.ROCK;
        for (ElementalType element : ElementalType.values()) {
            switch (element.getId()) {
                //Should be not effective
                case GROUNDID,FIGHTINGID: 
                    assertEquals(0.5,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));    
                    break;
                //Should be super effective
                case FIREID,FLYINGID,BUGID:     
                    assertEquals(2,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));
                    break;
                //Should be effective
                default:        
                    assertEquals(1,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));
                    break;
            }
        }
    }

    /**
     * Test if the multipliers are of the expected value for Fighting
     */
    @Test
    void testFightingChart(){
        ElementalType skillType = ElementalType.FIGHTING;
        for (ElementalType element : ElementalType.values()) {
            switch (element.getId()) {
                //Should be not effective
                case POISONID,FLYINGID,BUGID: 
                    assertEquals(0.5,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));    
                    break;
                //Should be super effective
                case NORMALID,ROCKID:     
                    assertEquals(2,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));
                    break;
                //Should be effective
                default:        
                    assertEquals(1,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));
                    break;
            }
        }
    }

    /**
     * Test if the multipliers are of the expected value for Bug
     */
    @Test
    void testBugChart(){
        ElementalType skillType = ElementalType.BUG;
        for (ElementalType element : ElementalType.values()) {
            switch (element.getId()) {
                //Should be not effective
                case FIREID,FIGHTINGID,POISONID,FLYINGID: 
                    assertEquals(0.5,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));    
                    break;
                //Should be super effective
                case GRASSID:     
                    assertEquals(2,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));
                    break;
                //Should be effective
                default:        
                    assertEquals(1,ElementalType.CalcTypeMatchup(skillType, new ElementalType[]{element}));
                    break;
            }
        }
    }
}
