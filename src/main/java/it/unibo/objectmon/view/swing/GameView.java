package it.unibo.objectmon.view.swing;

import javax.swing.JFrame;

import it.unibo.objectmon.controller.GameController;

public class GameView {
    private static final String GAME_NAME = "Objectmon";
    private final JFrame frame = new JFrame(GAME_NAME);
    public MainScreen gameMainScreen;
    private GameController controller;

    public GameView(final GameController controller) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        this.controller = controller;
        gameMainScreen = new MainScreen(controller);
        frame.add(gameMainScreen);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return this.frame;
    }
}
