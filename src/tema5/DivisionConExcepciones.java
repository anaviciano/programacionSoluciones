package tema5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionConExcepciones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Introduce el primer valor entero (num1): ");
            int num1 = scanner.nextInt();

            System.out.print("Introduce el segundo valor entero (num2): ");
            int num2 = scanner.nextInt();

            int resultado = num1 / num2;
            System.out.println("El resultado de la división es: " + resultado);

        } catch (InputMismatchException e) {
            System.out.println("Error: Se ha introducido un valor no válido. Por favor, introduce un número entero.");
        } catch (ArithmeticException e) {
            System.out.println("Error: No se puede dividir por cero.");
        }
    }
}
