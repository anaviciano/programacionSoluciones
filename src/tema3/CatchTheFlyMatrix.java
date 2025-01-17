
    package tema3;

import java.util.Random;
import java.util.Scanner;

    public class CatchTheFlyMatrix {

        public static final int BOARD_ROWS = 4;
        public static final int BOARD_COLS = 4;

        public static void main(String[] args) {
            System.out.println("Catch the fly!");
            boolean[][] board = new boolean[BOARD_ROWS][BOARD_COLS];
            placeFly(board);
            int[] move;
            do {
                move = getMove();
            } while (!play(board, move));
        }

        public static void placeFly(boolean[][] board) {
            // Inicializamos la matriz con valores false
            for (int i = 0; i < BOARD_ROWS; i++) {
                for (int j = 0; j < BOARD_COLS; j++) {
                    board[i][j] = false;
                }
            }
            // Colocamos la mosca en una posición aleatoria
            Random random = new Random();
            int row = random.nextInt(BOARD_ROWS);
            int col = random.nextInt(BOARD_COLS);
            board[row][col] = true;
        }

        public static int[] getMove() {
            Scanner scanner = new Scanner(System.in);
            int row, col;
            do {
                System.out.print("Introduce la fila (1-4): ");
                row = scanner.nextInt();
                System.out.print("Introduce la columna (1-4): ");
                col = scanner.nextInt();
            } while (row < 1 || row > 4 || col < 1 || col > 4);

            return new int[]{row - 1, col - 1}; // Convertimos a índices base 0
        }

        public static boolean play(boolean[][] board, int[] move) {
            int row = move[0];
            int col = move[1];
            boolean hasWon = false;

            if (board[row][col]) {
                System.out.println("¡Enhorabuena, has cazado la mosca!");
                hasWon = true;
            } else if (isAdjacent(board, row, col)) {
                System.out.println("¡Casi! La mosca ha cambiado de posición...");
                placeFly(board);
            } else {
                System.out.println("Estás muy lejos... Vuelve a intentarlo...");
            }

            return hasWon;
        }

        public static boolean isAdjacent(boolean[][] board, int row, int col) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) continue; // Ignoramos la posición actual

                    int newRow = row + i;
                    int newCol = col + j;

                    if (newRow >= 0 && newRow < BOARD_ROWS && newCol >= 0 && newCol < BOARD_COLS) {
                        if (board[newRow][newCol]) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }


