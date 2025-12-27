import java.util.Scanner;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        //String[] array = new String[6];
        String[] array = {"-", "-", "-", "-", "-", "-", "-", "-", "-"};
        System.out.println("Hello user=");
        System.out.println("use");
        System.out.println("q w e");
        System.out.println("a s d");
        System.out.println("z x c");
        System.out.println("Player 1 start");
        boolean player1 = true;
        Scanner scanner = new Scanner(System.in);


        /*
        for (int i = 0; i<3; i++)
        {
            System.out.println(array[i*3] + "\t" + array[(3*i)+1] + "\t" + array[(3*i)+2] + "\n");
        }
         */
        int turnCount = 0;
        int breakNum1 = 0;
        while (breakNum1 == 0) {
            int breakNum = 0;
            while (breakNum == 0) {
                String thing = scanner.nextLine();
                switch (thing) {
                    case "q":
                        if (array[0] == "-") {
                            if (player1) {
                                array[0] = "X";
                                player1 = false;
                            } else {
                                array[0] = "O";
                                player1 = true;
                            }
                            breakNum = -1;
                        } else {
                            System.out.println("try again");
                        }
                        break;
                    case "w":
                        if (array[1] == "-") {
                            if (player1) {
                                array[1] = "X";
                                player1 = false;
                            } else {
                                array[1] = "O";
                                player1 = true;
                            }
                            breakNum = -1;
                        } else {
                            System.out.println("try again");
                        }
                        break;
                    case "e":
                        if (array[2] == "-") {
                            if (player1) {
                                array[2] = "X";
                                player1 = false;
                            } else {
                                array[2] = "O";
                                player1 = true;
                            }
                            breakNum = -1;
                        } else {
                            System.out.println("try again");
                        }
                        break;
                    case "a":
                        if (array[3] == "-") {
                            if (player1) {
                                array[3] = "X";
                                player1 = false;
                            } else {
                                array[3] = "O";
                                player1 = true;
                            }
                            breakNum = -1;
                        } else {
                            System.out.println("try again");
                        }
                        break;
                    case "s":
                        if (array[4] == "-") {
                            if (player1) {
                                array[4] = "X";
                                player1 = false;
                            } else {
                                array[4] = "O";
                                player1 = true;
                            }
                            breakNum = -1;
                        } else {
                            System.out.println("try again");
                        }

                        break;
                    case "d":
                        if (array[5] == "-") {
                            if (player1) {
                                array[5] = "X";
                                player1 = false;
                            } else {
                                array[5] = "O";
                                player1 = true;
                            }
                            breakNum = -1;
                        } else {
                            System.out.println("try again");
                        }
                        break;
                    case "z":
                        if (array[6] == "-") {
                            if (player1) {
                                array[6] = "X";
                                player1 = false;
                            } else {
                                array[6] = "O";
                                player1 = true;
                            }
                            breakNum = -1;
                        } else {
                            System.out.println("try again");
                        }
                        break;
                    case "x":
                        if (array[7] == "-") {
                            if (player1) {
                                array[7] = "X";
                                player1 = false;
                            } else {
                                array[7] = "O";
                                player1 = true;
                            }
                            breakNum = -1;
                        } else {
                            System.out.println("try again");
                        }
                        break;
                    case "c":
                        if (array[8] == "-") {
                            if (player1) {
                                array[8] = "X";
                                player1 = false;
                            } else {
                                array[8] = "O";
                                player1 = true;
                            }
                            breakNum = -1;
                        } else {
                            System.out.println("try again");
                        }
                        break;
                    default:
                        System.out.println("Fail");
                }
            }
            turnCount++;
            for (int i = 0; i<3; i++)
            {
                System.out.println(array[i*3] + "\t" + array[(3*i)+1] + "\t" + array[(3*i)+2] + "\n");
            }
            if (turnCount > 4)
            {
                String whoHasWon = checkForWin(array);
                if (whoHasWon == "X")
                {
                    System.out.println("X's Win!");
                    breakNum1 = -1;
                } else if (whoHasWon == "O") {
                    System.out.println("O's Win!");
                    breakNum1 = -1;
                } else if (whoHasWon == "")
                    if (turnCount >= 9) {
                        System.out.println("Tie.");
                        breakNum1 = -1;
                    }
            }

        }
    }

    public static String checkForWin(String[] gameArray) {
        String whoHasWon = "";
        for (int i = 0; i < 3; i++)
        {
            if ((gameArray[i*3] == "X") && (gameArray[(i*3)+1] == "X") && (gameArray[(i*3)+2] == "X"))
            {
                whoHasWon = "X";
            }
            if ((gameArray[i*3] == "O") && (gameArray[(i*3)+1] == "O") && (gameArray[(i*3)+2] == "O"))
            {
                whoHasWon = "O";
            }
        }
        for (int i = 0; i < 3; i++)
        {
            if ((gameArray[i] == "X") && (gameArray[i+3] == "X") && (gameArray[i+6] == "X"))
            {
                whoHasWon = "X";
            }
            if ((gameArray[i] == "O") && (gameArray[i+3] == "O") && (gameArray[i+6] == "O"))
            {
                whoHasWon = "O";
            }
        }

        if ((gameArray[0] == "X") && (gameArray[4] == "X") && (gameArray[8] == "X"))
        {
            whoHasWon = "X";
        }
        if ((gameArray[2] == "O") && (gameArray[4] == "O") && (gameArray[6] == "O"))
        {
            whoHasWon = "O";
        }
        if ((gameArray[2] == "X") && (gameArray[4] == "X") && (gameArray[6] == "X"))
        {
            whoHasWon = "X";
        }
        if ((gameArray[0] == "O") && (gameArray[4] == "O") && (gameArray[8] == "O"))
        {
            whoHasWon = "O";
        }
        return whoHasWon;
    }
}