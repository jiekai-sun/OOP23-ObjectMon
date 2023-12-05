package it.unibo.objectmon.view.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JPanel;

import it.unibo.objectmon.controller.GameController;

public final class SwingMainScreen extends JPanel {
    private static final int PROPORTION = 5;
    private final GameController controller;
    private final Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
    private final KeyHandler keyhandler = new KeyHandler();

    public SwingMainScreen(final GameController controller) {
        this.controller = controller;
        this.setSize((int) screenDimension.getWidth() / PROPORTION, (int) screenDimension.getHeight() / PROPORTION);
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);

        this.addKeyListener(keyhandler);
        this.setFocusable(true);
    }

    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;
        g2.setColor(Color.RED);
        g2.fillRect(controller.getPlayerX(), controller.getPlayerY(), 48, 48);
        g2.dispose();
    }
}
