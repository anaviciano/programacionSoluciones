package tema2;

import java.util.Scanner;

public class Exercise25 {
    public static void main(String[] args) {
        System.out.println("Calculadora de factoriales.");
        int factorial = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int number = scanner.nextInt();
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        System.out.println("El factorial es " + factorial);
    }
}
