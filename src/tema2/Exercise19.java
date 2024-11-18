package tema2;

import java.util.Scanner;

public class Exercise19 {
    public static void main(String[] args) {
        System.out.println("Calculando los números pares entre 1 y 1000");
        for (int number = 1; number <= 1000; number++) {
            if (number % 2 == 0) {
                System.out.print(number + " ");
            }

        }
    }
}
