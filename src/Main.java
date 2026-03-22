import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Board board = new Board(new String[]{"-", "-", "-", "-", "-", "-", "-", "-", "-"});
        int turnCount = 0;

        Player playerX = new HumanPlayer();
        //Player playerO = new HumanPlayer();
        Player playerO = new AIPlayer("O");
        //Player playerX = new AIPlayer("X");

        Player currentPlayer = (new Random().nextInt(2) == 0) ? playerX : playerO;

        System.out.println("Tic Tac Toe:");
        printBoard(board.getBoard());

        while (true) {
            String symbol = (currentPlayer == playerX) ? "X" : "O";
            String playerLabel = (currentPlayer == playerX) ? "1 (X)" : "2 (O)";
            System.out.println("Player " + playerLabel + "'s turn:");

            if (playerX instanceof AIPlayer && playerO instanceof AIPlayer) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            int index = currentPlayer.getMove(board);

            if (index == -1) {
                System.out.println("Invalid input, try again.");
                continue;
            }
            if (!board.getBoardAtIndex(index).equals("-")) {
                System.out.println("Cell already taken, try again.");
                continue;
            }

            board.setBoard(index, symbol);
            turnCount++;
            printBoard(board.getBoard());

            String winner = checkForWin(board.getBoard());
            if (!winner.isEmpty()) {
                System.out.println(winner + "'s Win!");
                break;
            }
            if (turnCount == 9) {
                System.out.println("Tie.");
                break;
            }

            currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
        }
    }

    static void printBoard(String[] board) {
        for (int i = 0; i < 3; i++) {
            System.out.println(board[i*3] + " | " + board[i*3+1] + " | " + board[i*3+2]);
        }
        System.out.println();
    }

    static String checkForWin(String[] b) {
        int[][] lines = {
                {0,1,2},{3,4,5},{6,7,8},
                {0,3,6},{1,4,7},{2,5,8},
                {0,4,8},{2,4,6}
        };
        for (int[] line : lines) {
            String s = b[line[0]];
            if (!s.equals("-") && s.equals(b[line[1]]) && s.equals(b[line[2]])) {
                return s;
            }
        }
        return "";
    }
}