package tema3;

import java.util.Scanner;

public class Hangman {
    public static final int MAX_TRIES = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Escoge una palabra: ");
        String word = scanner.nextLine().toUpperCase().trim();
        clear();

        String guessed = "_".repeat(word.length());
        int tries = 0;
        boolean win = false;
        while (tries < MAX_TRIES && !win) {
            System.out.println("Palabra: " + guessed);
            System.out.println("Intentos restantes: " + (MAX_TRIES - tries));
            System.out.print("Ingrese una letra / parabla: ");
            String guess = scanner.nextLine().toUpperCase().trim();
            if (!guess.equals(word)) {
                char letter = guess.charAt(0);
                if (word.indexOf(letter) != -1) {
                    guessed = checkLetter(word, guessed, letter);
                } else {
                    tries++;
                }
            } else {
                System.out.println("¡Felicidades! Has adivinado la palabra: " + word);
                win = true;
            }
            drawHangman(tries);
        }

        if (!win) {
            System.out.println("¡Felicidades! Has adivinado la palabra: " + word);
        }

        scanner.close();
    }

    public static String checkLetter(String word, String guessed, char letter) {
        char[] wordArray = word.toCharArray();
        char[] guessedArray = guessed.toCharArray();

        for (int i = 0; i < wordArray.length; i++) {
            if (wordArray[i] == letter) {
                guessedArray[i] = letter;
            }
        }
        return new String(guessedArray);
    }

    private static void drawHangman(int tries) {
        if (tries >= 1) {
            System.out.println(" o");
        }
        if (tries >= 2) {
            System.out.print("/");
        }
        if (tries >= 3) {
            System.out.print("|");
        }
        if (tries >= 4) {
            System.out.println("\\");
        }
        if (tries >= 5) {
            System.out.print("/ ");
        }
        if (tries >= 6) {
            System.out.println("\\");
        }
        System.out.println();
    }

    private static void clear() {
        System.out.println("\r\n".repeat(50));
    }
}
