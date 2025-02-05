package tema3;

import java.util.Scanner;

public class Lingo {
    private static Scanner scanner = new Scanner(System.in);
    private static final int WORD_LENGTH = 5;
    private static final int MAX_ATTEMPTS = 5;

    public static void main(String[] args) {
        System.out.println("Escribe palabras de 5 letras para adivinar la palabra oculta.");

        String secretWord = "HUESO";
        int attempts = 1;
        String userAttempt = "";
        while (attempts <= MAX_ATTEMPTS && !secretWord.equals(userAttempt)) {
            userAttempt = readWord();
            String result = checkAttempt(secretWord, userAttempt);
            System.out.println("HINT: " + result);
            attempts++;
        }
        if (secretWord.equals(userAttempt)) {
            System.out.println("¡Felicidades! Has adivinado la palabra: " + secretWord);
        } else {
            System.out.println("Lo siento, has perdido. La palabra era: " + secretWord);
            ;
        }

    }

    private static String readWord() {
        String word;
        do {
            System.out.print("TRY: ");
            word = scanner.next().trim().toUpperCase();
        } while (word.length() != WORD_LENGTH);
        return word;
    }

    private static String checkAttempt(String secretWord, String userAttempt) {
        String result = "";
        for (int i = 0; i < WORD_LENGTH; i++) {
            char letter = userAttempt.charAt(i);
            if (letter == secretWord.charAt(i)) {
                result += letter;
            } else if (secretWord.contains(String.valueOf(letter))) {
                result += '*';
            } else {
                result += '-';
            }
        }
        return result;
    }
}
