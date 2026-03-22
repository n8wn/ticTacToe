public class TestRunner {
    private int aiWins = 0;
    private int humanWins = 0;
    private int draws = 0;

    public static void main(String[] args) {
        TestRunner runner = new TestRunner();

        System.out.println("Running AI vs AI...");
        runner.reset();
        runner.runAllGames(new AIPlayer("X"), new AIPlayer("O"));
        runner.printResults("AI vs AI");

        System.out.println("Running AI vs Random...");
        runner.reset();
        runner.runAllGames(new AIPlayer("X"), new RandomPlayer("O"));
        runner.printResults("AI (X) vs Random (O)");

        System.out.println("Running Random vs AI...");
        runner.reset();
        runner.runAllGames(new RandomPlayer("X"), new AIPlayer("O"));
        runner.printResults("Random (X) vs AI (O)");
    }

    private void reset() {
        aiWins = 0;
        humanWins = 0;
        draws = 0;
    }

    private void runAllGames(Player playerX, Player playerO) {
        playAll(new Board(new String[]{"-","-","-","-","-","-","-","-","-"}), playerX, playerO, true);
    }

    private void playAll(Board board, Player playerX, Player playerO, boolean isXTurn) {
        String winner = Main.checkForWin(board.getBoard());
        if (!winner.isEmpty()) {
            if (winner.equals("X")) aiWins++;
            else humanWins++;
            return;
        }
        if (isBoardFull(board)) {
            draws++;
            return;
        }

        Player current = isXTurn ? playerX : playerO;
        String symbol = isXTurn ? "X" : "O";

        if (current instanceof RandomPlayer) {
            for (int i = 0; i < 9; i++) {
                if (board.getBoardAtIndex(i).equals("-")) {
                    Board copy = copyBoard(board);
                    copy.setBoard(i, symbol);
                    playAll(copy, playerX, playerO, !isXTurn);
                }
            }
        } else {
            Board copy = copyBoard(board);
            int move = current.getMove(copy);
            copy.setBoard(move, symbol);
            playAll(copy, playerX, playerO, !isXTurn);
        }
    }

    private void printResults(String label) {
        int total = aiWins + humanWins + draws;
        System.out.println("--- " + label + " ---");
        System.out.println("Games played: " + total);
        System.out.println("X wins:       " + aiWins);
        System.out.println("O wins:       " + humanWins);
        System.out.println("Draws:        " + draws);
        System.out.println();
    }

    private Board copyBoard(Board board) {
        String[] copy = board.getBoard().clone();
        return new Board(copy);
    }

    private boolean isBoardFull(Board board) {
        for (int i = 0; i < 9; i++) {
            if (board.getBoardAtIndex(i).equals("-")) return false;
        }
        return true;
    }
}