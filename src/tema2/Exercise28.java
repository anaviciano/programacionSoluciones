package tema2;

import java.util.Random;
import java.util.Scanner;

public class Exercise28 {
    public static void main(String[] args) {
        System.out.println("Juega a la lotería.");
        Random lottery = new Random();
        int winnerTicket = lottery.nextInt(99999);

        Scanner scanner = new Scanner(System.in);
        int lotteryTickets = 5;
        boolean winner = false;
        while (lotteryTickets > 0 && !winner) {
            System.out.print("Introduce boleto: ");
            int ticket = scanner.nextInt();
            lotteryTickets--;
            if (ticket == winnerTicket) {
                System.out.println("¡Has ganado la lotería!");
                winner = true;
            }
        }
        if (!winner) {
            System.out.println("¡NO Has ganado la lotería!");
        }
    }
}
