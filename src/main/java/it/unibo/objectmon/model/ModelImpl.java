package it.unibo.objectmon.model;

import java.util.Optional;
import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.api.BattleManager;
import it.unibo.objectmon.model.battle.moves.type.Move;
import it.unibo.objectmon.model.core.GameContext;
import it.unibo.objectmon.model.gamestate.GameState;
import it.unibo.objectmon.model.gamestate.GameStateManager;
import it.unibo.objectmon.model.misc.collision.api.CollisionManager;
import it.unibo.objectmon.model.misc.interaction.api.InteractionManager;

/**
 * Manages the game model logic, including entities, interactions, collisions, and battles.
 * This class initializes the game model with default settings and provides access to various managers
 * that are responsible for handling different aspects of the game.
 */
public final class ModelImpl implements Model {
    private final GameContext gameContext;
    private final InteractionManager interactionManager;
    private final CollisionManager collisionManager;
    private BattleManager battleManager;
    private GameStateManager gameStateManager;

    /**
     * Constructs a ModelImpl instance with the provided dependencies.
     *
     * @param gameContext       The game context containing information about the game world and entities.
     * @param interactionManager The manager responsible for handling interactions within the game.
     * @param collisionManager  The manager responsible for collision detection.
     * @param battleManager     The manager responsible for handling battles between entities.
     * @param gameStateManager  The manager responsible for managing the game state.
     */
    public ModelImpl(final GameContext gameContext, final InteractionManager interactionManager,
        final CollisionManager collisionManager, final BattleManager battleManager,
        final GameStateManager gameStateManager) {
        this.gameContext = gameContext;
        this.interactionManager = interactionManager;
        this.collisionManager = collisionManager;
        setBattleManager(battleManager);
        setGameStateManager(gameStateManager);
    }

    @Override
    public InteractionManager getInteractionManager() {
        return this.interactionManager;
    }

    @Override
    public CollisionManager getCollisionManager() {
        return this.collisionManager;
    }

    @Override
    public Optional<Battle> getBattleStats() {
        return this.battleManager.getBattleStats();
    }

    @Override
    public GameContext getGameContext() {
        return this.gameContext;
    }

    @Override
    public GameState getGameState() {
        return gameStateManager.getGameState();
    }

    @Override
    public void setGameState(final GameState gameState) {
        gameStateManager.setGameState(gameState);
    }

    @Override
    public void bufferCommand(final Move move, final int index) {
        this.battleManager.bufferCommand(move, index);
    }

    private void setGameStateManager(final GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
    }

    private void setBattleManager(final BattleManager battleManager) {
        this.battleManager = battleManager;
    }
}
