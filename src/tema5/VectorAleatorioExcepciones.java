package tema5;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class VectorAleatorioExcepciones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Generar tamaño aleatorio del vector entre 1 y 100
        int n = random.nextInt(100) + 1;
        int[] vector = new int[n];

        // Rellenar el vector con valores aleatorios entre 1 y 10
        for (int i = 0; i < n; i++) {
            vector[i] = random.nextInt(10) + 1;
        }

        while (true) {
            try {
                System.out.print("Introduce la posición del vector que quieres mostrar (valor negativo para salir): ");
                int posicion = scanner.nextInt();

                if (posicion < 0) {
                    break;
                }

                System.out.println("Valor en la posición " + posicion + ": " + vector[posicion]);
            } catch (InputMismatchException e) {
                System.out.println("Error: Valor no válido. Por favor, introduce un número entero.");
                scanner.next(); // Limpiar el buffer del scanner
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Posición fuera de los límites del vector. Introduce un valor entre 0 y " + (n - 1) + ".");
            }
        }

        System.out.println("Programa terminado.");
    }
}
