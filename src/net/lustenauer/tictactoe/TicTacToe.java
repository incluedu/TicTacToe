package net.lustenauer.tictactoe;

import net.lustenauer.tictactoe.common.AbstractRegularGame;
import net.lustenauer.tictactoe.util.Pair;

import java.util.LinkedList;
import java.util.List;

public class TicTacToe extends AbstractRegularGame<Pair<Byte, Byte>> {
    /*
     * CONSTRUCTORS
     */
    public TicTacToe() {
        super((byte) 3, (byte) 3);
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
        for (byte c = 0; c < getColumns(); c++) {
            for (byte r = 0; r < getRows(); r++) {
                if (b[c][r] == NONE) {
                    result.add(new Pair<>(c, r));
                }
            }
        }
        return result;
    }


    @Override
    public TicTacToe doMove(Pair<Byte, Byte> m) {
        TicTacToe result = clone();
        result.player = nextPlayer();
        result.b[m.first][m.second] = player;
        result.movesDone = (byte) (movesDone++);
        return result;
    }

    @Override
    public boolean noMoreMove() {
        return rows * columns >= movesDone;
    }

    @Override
    public boolean wins(byte player) {
        return checkRows(player) || checkColumns(player) || checkDiagonal1(player) || checkDiagonal2(player);
    }


    @Override
    public int evalState(byte player) {
        if (wins()) {
            return (lastPlayer() == player) ? Integer.MAX_VALUE : -Integer.MAX_VALUE;
        }
        return 0;
    }

    @Override
    public TicTacToe clone() {
        return (TicTacToe) super.clone();
    }

    /*
     * PRIVATE METHODS
     */
    private boolean checkRows(byte player) {
        for (byte r = 0; r < rows; r++) {
            for (byte c = 0; c < columns; c++) {
                if (b[c][r] != player) break;
                if (c == columns - 1) return true;
            }
        }
        return false;
    }

    private boolean checkColumns(byte player) {
        for (byte c = 0; c < columns; c++) {
            for (byte r = 0; r < rows; r++) {
                if (b[c][r] != player) break;
                if (c == rows - 1) return true;
            }
        }
        return false;
    }

    private boolean checkDiagonal1(byte player) {
        for (byte r = 0; r < rows; r++) {
            if (b[r][r] != player) break;
            if (r == rows - 1) return true;
        }
        return false;
    }

    private boolean checkDiagonal2(byte player) {
        for (byte r = 0; r < rows; r++) {
            if (b[r][rows - r - 1] != player) break;
            if (r == rows - 1) return true;
        }
        return false;
    }

}
