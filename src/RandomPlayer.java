import java.util.Random;

public class RandomPlayer implements Player {
    private final String symbol;
    private final Random random = new Random();

    public RandomPlayer(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public int getMove(Board board) {
        int move;
        do {
            move = random.nextInt(9);
        } while (!board.getBoardAtIndex(move).equals("-"));
        return move;
    }
}