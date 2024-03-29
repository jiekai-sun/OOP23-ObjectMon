package it.unibo.objectmon.model.item.impl;

import java.util.Objects;

import it.unibo.objectmon.model.item.api.HealEnum;
import it.unibo.objectmon.model.item.api.HealItem;

/**
 * Models a Heal item usable by player.
 */
public final class HealItemImpl implements HealItem {

    private final String name;
    private final int value;
    private final int healPoint;

    /**
     * Creates a Heal item.
     * @param name the heal item
     * @param value the heal value
     * @param healPoint the heal HP value
     */
    public HealItemImpl(final String name, final int value, final int healPoint) {
        this.name = name;
        this.value = value;
        this.healPoint = healPoint;
    }

    /**
     * Constructs a new Heal based on information from HealEnum.
     * @param heal enum name
     */
    public HealItemImpl(final HealEnum heal) {
        this.name = heal.getName();
        this.value = heal.getValue();
        this.healPoint = heal.getHealingAmount();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public int getHealPoints() {
        return this.healPoint;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + value;
        result = prime * result + healPoint;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final HealItemImpl other = (HealItemImpl) obj;
        return healPoint == other.healPoint
            && value == other.value
            && Objects.equals(name, other.name);
    }

    @Override
    public String toString() {
        return "HealItemImpl [name=" + name + ", value=" + value + ", healPoint=" + healPoint + "]";
    }
}
