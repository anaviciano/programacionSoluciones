package tema3;
import java.util.Scanner;
public class ejercicio7 {



        // Método que verifica si un número es primo
        public static boolean esPrimo(int num) {
            if (num <= 1) {
                return false;  // Los números menores o iguales a 1 no son primos
            }

            // Comprobar si el número tiene divisores entre 2 y su raíz cuadrada
            for (int i = 2; i <= num; i++) {
                if (num % i == 0) {
                    return false;  // Si es divisible por cualquier número, no es primo
                }
            }

            return true;  // Si no tiene divisores, es primo
        }

        public static void main(String[] args) {
            // Crear un objeto Scanner para leer la entrada del usuario
            Scanner scanner = new Scanner(System.in);

            int numero;

            // Pedir números enteros positivos hasta que se ingrese 0
            do {
                System.out.print("Introduce un número entero positivo (0 para salir): ");
                numero = scanner.nextInt();

                if (numero == 0) {
                    break;  // Salir si se introduce 0
                }

                // Llamar al método esPrimo y mostrar el resultado
                if (esPrimo(numero)) {
                    System.out.println(numero + " es un número primo.");
                } else {
                    System.out.println(numero + " no es un número primo.");
                }

            } while (numero != 0);

            // Cerrar el scanner
            scanner.close();
            System.out.println("Programa terminado.");
        }


}
