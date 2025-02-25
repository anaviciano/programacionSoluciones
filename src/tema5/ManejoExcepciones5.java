package tema5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManejoExcepciones5 {
    public static void imprimePositivo(int p) throws Exception {
        if (p < 0) {
            throw new Exception("El valor no es positivo: " + p);
        }
        System.out.println("Valor positivo: " + p);
    }

    public static void imprimeNegativo(int n) throws Exception {
        if (n >= 0) {
            throw new Exception("El valor no es negativo: " + n);
        }
        System.out.println("Valor negativo: " + n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Introduce un valor entero (0 para salir): ");
                int valor = scanner.nextInt();

                if (valor == 0) {
                    break;
                }

                System.out.print("¿Quieres comprobar si es positivo o negativo? (p/n): ");
                char opcion = scanner.next().charAt(0);

                if (opcion == 'p') {
                    imprimePositivo(valor);
                } else if (opcion == 'n') {
                    imprimeNegativo(valor);
                } else {
                    System.out.println("Opción no válida. Por favor, introduce 'p' o 'n'.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Valor no válido. Por favor, introduce un número entero.");
                scanner.next(); // Limpiar el buffer del scanner
            } catch (Exception e) {
                System.out.println("Excepción: " + e.getMessage());
            }
        }

        System.out.println("Programa terminado.");
    }
}
