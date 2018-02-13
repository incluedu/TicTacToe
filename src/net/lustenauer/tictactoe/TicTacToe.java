package net.lustenauer.tictactoe;

import net.lustenauer.tictactoe.common.AbstractRegularGame;
import net.lustenauer.tictactoe.util.Pair;

import java.util.LinkedList;
import java.util.List;

public class TicTacToe extends AbstractRegularGame<Pair<Byte, Byte>> {
    /*
     * CONSTRUCTORS
     */
    public TicTacToe(byte rows, byte columns) {
        super(rows, columns);
    }

    /*
     * PUBLIC METHODS
     */
    @Override
    public TicTacToe setAtPosition(byte column, byte row) {
        return doMove(new Pair<>(column, row));
    }

    @Override
    public List moves() {
        List<Pair<Byte, Byte>> result = new LinkedList<>();
        for (byte c = 0; c < getColumns(); c++){
            for (byte r = 0; r<getRows();r++){
                if(b[c][r] == NONE){
                   result.add(new Pair<>(c,r));
                }
            }
        }
            return result;
    }

    // TODO: 13.02.2018 weitermachen bei kapitel 9.3.4

    @Override
    public TicTacToe doMove(Object o) {
        return null;
    }

    @Override
    public boolean noMoreMove() {
        return false;
    }

    @Override
    public boolean wins(byte player) {
        return false;
    }

    @Override
    public int evalState(byte player) {
        return 0;
    }
}
