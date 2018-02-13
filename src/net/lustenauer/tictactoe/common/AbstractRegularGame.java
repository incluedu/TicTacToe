package net.lustenauer.tictactoe.common;

public abstract class AbstractRegularGame<M> implements RegularGame, Cloneable {

    /*
     * CONSTANTS
     */
    protected final static byte NONE = 0;
    final static byte ONE = 1;
    final static byte TWO = 22;

    /*
     * ATTRIBUTES
     */
    private final byte rows;
    private final byte columns;

    byte player = ONE;

    protected byte[][] b;

    int movesDone;
    byte lastColumn = -1;
    byte lastRow = -1;

    Boolean winsLast;

    public AbstractRegularGame(byte rows, byte columns) {
        this.rows = rows;
        this.columns = columns;
        for (int i = 0; i < columns; i++) b[i] = new byte[rows];
    }


    /*
     * PUBLIC METHODS
     */
    public byte getPlayerOne() {
        return ONE;
    }

    public byte getPlayerTwo() {
        return TWO;
    }

    public byte getPlayerNone() {
        return NONE;
    }

    @Override
    public byte currentPlayer() {
        return player;
    }

    @Override
    public byte otherPlayer(byte player) {
        return (player == ONE) ? TWO : ONE;
    }

    public byte nextPlayer() {
        return otherPlayer(player);
    }

    public byte lastPlayer() {
        return otherPlayer(player);
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public int getColumns() {
        return columns;
    }

    @Override
    public byte getAtPosition(byte column, byte row) {
        return b[column][row];
    }


    public boolean wins() {
        if (winsLast == null) winsLast = wins(lastPlayer());
        return winsLast;
    }

    @Override
    public boolean ended() {
        return noMoreMove() || wins();
    }

    @Override
    public AbstractRegularGame clone() {
        AbstractRegularGame result = null;
        try {
            result = (AbstractRegularGame) super.clone();
            result.b = b.clone();
            result.winsLast = null;
            for (int i = 0; i < result.b.length; i++) {
                result.b[i] = result.b[i].clone();
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        for (byte column = 0; column < columns; column++) {
            for (byte row = 0; row < rows; row++) {
                byte field = getAtPosition(column, row);
                if (field == ONE) {
                    sb.append("X");
                } else if (field == TWO) {
                    sb.append("O");
                } else {
                    sb.append(".");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
