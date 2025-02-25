package tema5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VectorDoubleExcepciones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] vector = new double[5];
        int count = 0;

        while (count < 5) {
            try {
                System.out.print("Introduce un valor para la posición " + count + ": ");
                vector[count] = scanner.nextDouble();
                count++;
            } catch (InputMismatchException e) {
                System.out.println("Error: Valor no válido. Por favor, introduce un número de tipo double.");
                scanner.next(); // Limpiar el buffer del scanner
            }
        }

        System.out.println("Valores introducidos en el vector:");
        for (double value : vector) {
            System.out.println(value);
        }
    }
}
