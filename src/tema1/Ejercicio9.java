package tema1;

import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Escribe el primer número: ");
        int number1 = scanner.nextInt();
        System.out.print("Escribe el segundo número: ");
        int number2 = scanner.nextInt();
        System.out.println("Suma: " + (number1 + number2));
        System.out.println("Resta: " + (number1 - number2));
        System.out.println("Multiplicación: " + (number1 * number2));

        System.out.println("División: " + (number1 / number2));
    }
}