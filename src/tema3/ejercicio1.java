package tema3;

import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita un número por consola
        System.out.print("Introduce un número: ");
        int number = scanner.nextInt();

        boolean esAdulto = ejercicio2.isAdult(number);

        // Llama a la función numberSign y almacena el resultado
        int result = numberSign(number);

        // Muestra el resultado en función del valor devuelto
        if (result == 0) {
            System.out.println("El número es 0.");
        } else if (result == 1) {
            System.out.println("El número es positivo.");
        } else if (result == -1) {
            System.out.println("El número es negativo.");
        }
    }

    // Función que determina si el número es 0, positivo o negativo
    public static int numberSign(int num) {
        if (num == 0) {
            return 0;
        } else if (num > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
