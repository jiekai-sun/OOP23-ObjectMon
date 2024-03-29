package it.unibo.objectmon.controller.commands;

import it.unibo.objectmon.controller.commands.api.Command;
import it.unibo.objectmon.model.Model;
import it.unibo.objectmon.model.core.GameContext;

/**
 * Calls for an interaction check.
 */
public final class Interact implements Command {

    @Override
    public void execute(final Model model) {
        final GameContext gc = model.getGameContext();
        model.getInteractionManager().triggerInteraction(gc.getNPCs(),
            gc.getPlayer());
    }
}
