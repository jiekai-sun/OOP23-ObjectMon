package it.unibo.objectmon.model.battle.turn.impl;

import java.util.Optional;

import it.unibo.objectmon.model.ai.ChooseMoveImpl;
import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.turn.api.ExecuteTurn;
import it.unibo.objectmon.model.battle.turn.api.Turn;
import it.unibo.objectmon.model.battle.api.BattleManager;
import it.unibo.objectmon.model.battle.moves.UseMoves;
import it.unibo.objectmon.model.battle.moves.type.Move;
import it.unibo.objectmon.model.battle.turn.StatTurn;
import it.unibo.objectmon.model.battle.turn.TurnImpl;
import it.unibo.objectmon.model.battle.turn.api.TurnManager;
import it.unibo.objectmon.model.misc.battlelog.api.BattleLogger;
/**
 * implementation of a turn manager.
 */
public final class TurnManagerImpl implements TurnManager {

    private final Turn turn;
    private int count;
    private final ChooseMoveImpl aiMove;

    /**
     * constructor of turn manager.
     */
    public TurnManagerImpl() {
        this.turn = new TurnImpl();
        this.count = 0;
        this.aiMove = new ChooseMoveImpl();
    }

    private void endTurnAction(final BattleManager battleManager) {
        final Optional<Battle> battle = battleManager.getBattleStats();
        if (battle.isPresent()) {
            if (battle.get().isWin()) {
                battleManager.setResult(BattleManager.Result.WIN);
                battleManager.endBattleAction();
            } else if (battle.get().isLose()) {
                battleManager.setResult(BattleManager.Result.LOSE);
                battleManager.endBattleAction();
            } else {
                this.turn.setTurn(StatTurn.IS_WAITING_MOVE);
            }
        } 
    }

    @Override
    public void startTurn(
        final Move type, 
        final int index, 
        final BattleManager battleManager, 
        final UseMoves useMoves,
        final BattleLogger logger
    ) {
        final Optional<Battle> battle = battleManager.getBattleStats();
        this.turn.setTurn(StatTurn.TURN_STARTED);
        final int aiIndex = this.aiMove.chooseAiMove(battle.get());
        battle.get().setPlayerMove(type);
        logger.log("turn " + (++this.count) + "started");
        final ExecuteTurn playerTurn = new PlayerTurn(battle.get());
        final ExecuteTurn aiTurn = new AiTurn();
            switch (this.turn.whichFirst(
                battle.get().getEnemyMove(),
                battle.get().getPlayerMove(), 
                battle.get().getCurrentObjectmon(), 
                battle.get().getEnemyObjectmon()
            )) {
                case AI_TURN :
                    aiTurn.execute(type, aiIndex, useMoves, battleManager);
                    if (battle.isPresent()) {
                        playerTurn.execute(type, index, useMoves, battleManager);
                    }
                    break;
                case PLAYER_TURN :
                    playerTurn.execute(type, index, useMoves, battleManager);
                    if (battle.isPresent()) {
                        aiTurn.execute(type, aiIndex, useMoves, battleManager);
                    }
                    break;
                default :
                    throw new IllegalArgumentException();
            }
        this.endTurnAction(battleManager);
    }
}
