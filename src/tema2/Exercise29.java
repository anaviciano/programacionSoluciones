package tema2;

import java.util.Random;
import java.util.Scanner;

public class Exercise29 {
    public static void main(String[] args) {
        System.out.println("El número secreto.");
        Random random = new Random();
        int secretNumber = random.nextInt(100);
        System.out.println(secretNumber);

        Scanner scanner = new Scanner(System.in);
        int myNumber = -1;
        boolean winner = false;
        while (myNumber != secretNumber) {
            System.out.print("Introduce número: ");
            myNumber = scanner.nextInt();
            if (myNumber > secretNumber) {
                System.out.println("El número secreto es menor.");
            } else if (myNumber < secretNumber) {
                System.out.println("El número secreto es mayor.");
            }
        }
        System.out.println("¡Has ganado!");
    }
}
