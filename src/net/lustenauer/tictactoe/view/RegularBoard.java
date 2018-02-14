package net.lustenauer.tictactoe.view;

import net.lustenauer.tictactoe.common.RegularGame;

import javax.swing.*;
import java.awt.*;

public class RegularBoard<M> extends JPanel {
    /*
     * ATTRIBUTES
     */
    private RegularGame<M> game;

    public int UNIT = 50;

    /*
     * CONSTRUCTORS
     */
    public RegularBoard(RegularGame<M> game) {
        this.game = game;
    }

    /*
     * PUBLIC METHODS
     */

    public RegularGame<M> getGame() {
        return game;
    }

    public void setGame(RegularGame<M> game) {
        this.game = game;
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(game.getColumns() * UNIT, game.getRows() * UNIT);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (byte c = 0; c < game.getColumns(); c++) {
            for (byte r = 0; r < game.getRows(); r++) {
                if (game.getAtPosition(c, r) != game.getPlayerNone()) {
                    g.setColor(selectColor(game.getAtPosition(c, r)));
                    g.fillOval(c * UNIT, r * UNIT, UNIT, UNIT);
                }
            }
        }
    }

    /*
     * PRIVATE METHODS
     */
    private Color selectColor(byte player) {
        if (player == game.getPlayerOne()) return Color.YELLOW;
        if (player == game.getPlayerTwo()) return Color.BLUE;
        return Color.BLACK;
    }
}
