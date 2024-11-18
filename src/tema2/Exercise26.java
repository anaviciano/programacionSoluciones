package tema2;

import java.util.Scanner;

public class Exercise26 {
    public static void main(String[] args) {
        System.out.println("Comprobador de números primos.");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int number = scanner.nextInt();
        boolean esPrimo = true;
        //for (int divisor = number / 2; divisor > 1; divisor--) {
        for (int divisor = number-1; divisor > 1; divisor--) {
            if (number % divisor == 0) {
                esPrimo = false;
            }
        }
        if (esPrimo) {
            System.out.println("Es primo");
        } else {
            System.out.println("No es primo");
        }
    }
}
