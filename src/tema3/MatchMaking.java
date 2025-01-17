package tema3;

import java.util.*;

public class MatchMaking {

    public static void main(String[] args) {
        String[] animals = {"tortuga", "león", "mandril", "suricata", "facóquero", "tigre", "elefante", "jirafa", "hipopótamo", "rinoceronte", "cocodrilo"};
        String[] cards = createCardsPairs(animals);
        shuffle(cards);
        boolean[] visibleCards = new boolean[cards.length]; // Por defecto todos los valores son false
        play(cards, visibleCards);
    }

    public static String[] createCardsPairs(String[] animales) {
        String[] pairs = new String[animales.length * 2];

        for (int i = 0; i < animales.length; i++) {
            pairs[i] = animales[i];
            pairs[i + animales.length] = animales[i];
        }

        return pairs;
    }

    public static void shuffle(String[] cards) {
        final int numShuffles = 100;
        Random random = new Random();
        for (int i = 0; i < numShuffles; i++) {
            int randomIndex1 = random.nextInt(0, cards.length - 1);
            int randomIndex2 = random.nextInt(0, cards.length - 1);
            String temp = cards[randomIndex1];
            cards[randomIndex1] = cards[randomIndex2];
            cards[randomIndex2] = temp;
        }
    }

    public static void play(String[] cards, boolean[] visibleCards) {
        System.out.println("¡Bienvenido al juego de las parejas!");
        int hiddenPairs = cards.length / 2;
        while (hiddenPairs > 0) {
            printVisibleCards(cards, visibleCards);

            System.out.print("Selecciona carta (1-" + cards.length + "): ");
            int card1 = readNumber(1, cards.length) - 1;
            System.out.print("Selecciona la otra carta (1-" + cards.length + "): ");
            int card2 = readNumber(1, cards.length) - 1;

            if (card1 == card2) {
                System.out.println("¡Encontraste una pareja! Espera... ¡Esa es la misma carta!");
            } else if (cards[card1].equals(cards[card2])) {
                System.out.println("¡Encontraste una pareja!");
                visibleCards[card1] = true;
                visibleCards[card2] = true;
                hiddenPairs--;
            } else {
                System.out.println("Las parejas no coinciden. Inténtalo de nuevo.");
                showCards(cards, visibleCards, card1, card2);
            }
        }

        printVisibleCards(cards, visibleCards);
        System.out.println("¡Felicidades! Has encontrado todas las parejas.");

    }

    public static void printVisibleCards(String[] parejas, boolean[] posicionesVisibles) {
        for (int i = 0; i < parejas.length; i++) {
            if (posicionesVisibles[i]) {
                System.out.print(parejas[i] + " ");
            } else {
                System.out.print("X ");
            }
        }
        System.out.println();
    }

    public static void showCards(String[] cards, boolean[] visibleCards, int card1, int card2) {
        visibleCards[card1] = true;
        visibleCards[card2] = true;
        printVisibleCards(cards, visibleCards);
        visibleCards[card1] = false;
        visibleCards[card2] = false;
        System.out.println("Pulsa intro para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println("\r\n".repeat(50));
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
