public class AIPlayer implements Player {
    private final String aiSymbol;
    private final String humanSymbol;

    public AIPlayer(String aiSymbol) {
        this.aiSymbol = aiSymbol;
        this.humanSymbol = aiSymbol.equals("X") ? "O" : "X";
    }

    @Override
    public int getMove(Board board) {
        int bestScore = Integer.MIN_VALUE;
        int bestMove = -1;

        for (int i = 0; i < 9; i++) {
            if (board.getBoardAtIndex(i).equals("-")) {
                board.setBoard(i, aiSymbol);
                int score;
                if (isGameOver(board)) {
                    score = getScore(board, 1);
                } else {
                    score = minimax(board, false, 1);
                }
                board.setBoard(i, "-");

                if (score > bestScore) {
                    bestScore = score;
                    bestMove = i;
                }
            }
        }

        return bestMove;
    }

    public int minimax(Board board, boolean isAITurn, int depth) {
        if (isAITurn) {
            return scoreAI(board, depth);
        } else {
            return scoreHuman(board, depth);
        }
    }

    private int getScore(Board board, int depth) {
        String winner = Main.checkForWin(board.getBoard());
        if (winner.equals(aiSymbol)) return 10 - depth;
        if (winner.equals(humanSymbol)) return depth - 10;
        return 0;
    }

    private boolean isGameOver(Board board) {
        return !Main.checkForWin(board.getBoard()).isEmpty() || isBoardFull(board);
    }

    private boolean isBoardFull(Board board) {
        for (int i = 0; i < 9; i++) {
            if (board.getBoardAtIndex(i).equals("-")) return false;
        }
        return true;
    }

    private int scoreAI(Board board, int depth) {
        int bestScore = Integer.MIN_VALUE;
        for (int i = 0; i < 9; i++) {
            if (board.getBoardAtIndex(i).equals("-")) {
                board.setBoard(i, aiSymbol);
                int score;
                if (isGameOver(board)) {
                    score = getScore(board, depth);
                } else {
                    score = minimax(board, false, depth + 1) + scorePerLevel(board);
                }
                board.setBoard(i, "-");
                bestScore = Math.max(score, bestScore);
            }
        }
        return bestScore;
    }

    private int scoreHuman(Board board, int depth) {
        int bestScore = Integer.MAX_VALUE;
        for (int i = 0; i < 9; i++) {
            if (board.getBoardAtIndex(i).equals("-")) {
                board.setBoard(i, humanSymbol);
                int score;
                if (isGameOver(board)) {
                    score = getScore(board, depth);
                } else {
                    score = minimax(board, true, depth + 1);
                }
                board.setBoard(i, "-");
                bestScore = Math.min(score, bestScore);
            }
        }
        return bestScore;
    }

    private int scorePerLevel(Board board) {
        int[][] lines = {
                {0,1,2},{3,4,5},{6,7,8},
                {0,3,6},{1,4,7},{2,5,8},
                {0,4,8},{2,4,6}
        };
        int totalScore = 0;
        for (int[] line : lines) {
            int aiCount = 0;
            int humanCount = 0;

            for (int index : line) {
                if (board.getBoardAtIndex(index).equals(aiSymbol)) aiCount++;
                else if (board.getBoardAtIndex(index).equals(humanSymbol)) humanCount++;
            }

            if (aiCount > 0 && humanCount > 0) continue; // line is dead, score 0

            if (aiCount == 2) totalScore += 5;      // two AI pieces + one empty
            else if (aiCount == 1) totalScore += 1;  // one AI piece + two empty
            if (humanCount == 2) totalScore -= 5;    // two human pieces + one empty
            else if (humanCount == 1) totalScore -= 1; // one human piece + two empty
        }
        return totalScore;
    }
}