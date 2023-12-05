package it.unibo.objectmon.controller;

import it.unibo.objectmon.model.GameModel;
import it.unibo.objectmon.view.swing.GameView;

/**
 * The game engine.
 */
public class GameController implements Runnable {
    private static final int FPS = 60;
    private GameModel model;
    private GameView view;
    private Thread gameThread;

    public void setModel(final GameModel model) {
        this.model = model;
    }

    public void setView(final GameView view) {
        this.view = view;
    }

    public void run() {
        double drawInterval = 1_000_000_000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();            
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                view.getFrame().repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1_000_000_000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        if (view.gameMainScreen.getKeyHandler().isUpPressed()) {
            model.getPlayerManager().getPlayer().moveUp();
        }
        if (view.gameMainScreen.getKeyHandler().isDownPressed()) {
            model.getPlayerManager().getPlayer().moveDown();
        }
        if (view.gameMainScreen.getKeyHandler().isLeftPressed()) {
            model.getPlayerManager().getPlayer().moveLeft();
        }
        if (view.gameMainScreen.getKeyHandler().isRightPressed()) {
            model.getPlayerManager().getPlayer().moveRight();
        }
    }

    public int getPlayerX() {
        return this.model.getPlayerManager().getPlayer().getX();
    }

    public int getPlayerY() {
        return this.model.getPlayerManager().getPlayer().getY();
    }

    public void startGame() {
        this.gameThread = new Thread(this);
        gameThread.start();
    }
}
