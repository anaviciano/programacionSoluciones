package tema3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Minesweeper {

    public static void main(String[] args) {
        final int numCells = 20;
        final int numMines = 6;

        char[] board = new char[numCells];
        initializeGame(board, numMines);
        playGame(board);
    }

    public static void initializeGame(char[] board, int numMines) {
        Arrays.fill(board, ' ');
        placeMines(board, numMines);
        calculateHints(board);
    }
    public static void placeMines(char[] board, int numMines) {
        Random random = new Random();
        int minesPlaced = 0;
        while (minesPlaced < numMines) {
            int randomIndex = random.nextInt(board.length);
            if (board[randomIndex] != '*') {
                board[randomIndex] = '*';
                minesPlaced++;
            }
        }
    }

    public static void calculateHints(char[] board) {
        for (int i = 0; i < board.length; i++) {
            int previousIndex = i - 1;
            int nextIndex = i + 1;
            int surroundingMines = 0;

            if (board[i] != '*') {
                if (previousIndex >= 0 && board[previousIndex] == '*') {
                    surroundingMines++;
                }
                if (nextIndex < board.length && board[nextIndex] == '*') {
                    surroundingMines++;
                }
                board[i] = Character.forDigit(surroundingMines, 10);
            }

        }
    }

    public static void playGame(char[] board) {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;
        char[] revealedCells = new char[board.length];
        Arrays.fill(revealedCells, '_');

        while (!gameOver) {
            printBoard(revealedCells);

            System.out.print("Introduce una posición (1-20): ");
            int position = readNumber(1, 20) - 1;
            char cellValue = board[position];

            if (cellValue == '*') {
                System.out.println("¡Has perdido! Has encontrado una mina");
                gameOver = true;
            } else {
                revealedCells[position] = cellValue;
                if (isGameWon(revealedCells)) {
                    System.out.println("¡Enhorabuena has ganado!");
                    gameOver = true;
                }
            }
        }
        printBoard(board);
    }

    public static void printBoard(char[] board) {
        for (char cell : board) {
            System.out.print(cell + " ");
        }
        System.out.println();
    }

    public static boolean isGameWon(char[] board) {
        for (char cell : board) {
            if (cell == '_') {
                return false;
            }
        }
        return true;
    }

    public static int readNumber(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        while (number < min || number > max) {
            System.out.println("Valor inválido, debe estar entre " + min + " y " + max + ".");
            number = scanner.nextInt();
        }
        return number;
    }

}
