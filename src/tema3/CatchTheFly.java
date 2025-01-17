package tema3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CatchTheFly {

    public static final int BOARD_SIZE = 15;

    public static void main(String[] args) {
        System.out.println("Catch the fly!");
        boolean[] board = new boolean[BOARD_SIZE];
        fly(board);
        int play;
        do {
            play = getMove();
        } while (!play(board, play));
    }

    public static void fly(boolean[] board) {
        // Inicializamos el array con valores false también se puede hacer con un bucle
        //for (int i = 0; i < board.length; i++) {
        //    board[i] = false;
        //}
        Arrays.fill(board, false);
        Random random = new Random();
        board[random.nextInt(15) - 1] = true;
    }

    public static int getMove() {
        Scanner scanner = new Scanner(System.in);
        int play = -1;
        do {
            System.out.print("Introduce una posición entre 1 y 15: ");
            play = scanner.nextInt();
        } while (play < 1 || play > 15);

        return play - 1;
    }

    public static boolean play(boolean[] board, int play) {
        boolean hasWon = false;
        int previousPosition = play - 1;
        int nextPosition = play + 1;
        if (board[play]) {
            System.out.println("¡Enhorabuena has cazado la mosca!");
            hasWon = true;
        } else if ((previousPosition >= 0 && board[previousPosition]) || (nextPosition < board.length && board[nextPosition])) {
            System.out.println("¡Casi! La mosca vuelve a volar");
            fly(board);
        } else {
            System.out.println("Estás muy lejos... Vuelve a intentarlo...");
        }
        return hasWon;
    }
}


