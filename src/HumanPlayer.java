import java.util.Scanner;

public class HumanPlayer implements Player {
    private static final String[] KEYS = {"q","w","e","a","s","d","z","x","c"};
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int getMove(Board board) {
        System.out.println("Input your move (q w e / a s d / z x c): ");
        String input = scanner.nextLine().trim().toLowerCase();

        for (int i = 0; i < KEYS.length; i++) {
            if (KEYS[i].equals(input)) return i;
        }

        System.out.println("Invalid input, try again.");
        return -1;
    }
}