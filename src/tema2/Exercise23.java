package tema2;

import java.util.Scanner;

public class Exercise23 {
    public static void main(String[] args) {
        System.out.println("Calculadora de medias de números positivos.");
        Scanner scanner = new Scanner(System.in);
        double sumatory=0;
        double number = 0;
        int count = -1;
        do {
            sumatory += number;
            count++;
            System.out.print("Introduce número (-1 para terminar): ");
            number = scanner.nextDouble();

        } while (number >= 0);

        if (count > 0) {
            double mean = sumatory / count;
            System.out.print("La media es:  " + mean);
        } else {
            System.out.print("No has introducido ningún número");
        }

    }
}
