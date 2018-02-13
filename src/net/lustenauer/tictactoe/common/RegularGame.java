package net.lustenauer.tictactoe.common;

/**
 * Regular games are games with a game board like Tik Tak Toe or 4 in a row
 *
 * @param <M>
 */
public interface RegularGame<M> extends Game<M> {
    int getRows();

    int getColumns();

    byte getPlayerOne();

    byte getPlayerTwo();

    byte getPlayerNone();

    byte getAtPosition(byte column, byte row);

    RegularGame<M> setAtPosition(byte column, byte row);

}
