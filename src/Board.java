import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private String[] board;

    Board(String[] board) {
        this.board = board;
    }

    public String[] getBoard() {
        return board;
    }

    public void setBoard(int i, String value) {
        this.board[i] = value;
    }

    public String getBoardAtIndex(int i) {
        return board[i];
    }
}
