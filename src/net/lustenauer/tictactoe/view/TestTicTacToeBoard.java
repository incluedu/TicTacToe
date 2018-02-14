package net.lustenauer.tictactoe.view;

import net.lustenauer.tictactoe.TicTacToe;
import net.lustenauer.tictactoe.util.Pair;
import net.lustenauer.tictactoe.util.ShowInFrame;

public class TestTicTacToeBoard {

    /*
     * RUN
     */
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();

        ticTacToe = ticTacToe.doMove(new Pair<Byte, Byte>((byte) 1, (byte) 1));
        ticTacToe = ticTacToe.doMove(new Pair<Byte, Byte>((byte) 0, (byte) 0));
        ticTacToe = ticTacToe.doMove(new Pair<Byte, Byte>((byte) 2, (byte) 0));

        RegularBoard<Pair<Byte, Byte>> board = new RegularBoard<>(ticTacToe);

        ShowInFrame.show("Tic Tac Toe ", board);

    }
}
