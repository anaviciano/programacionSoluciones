package tema3;

import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita un número para determinar si es positivo, negativo o 0
        System.out.print("Introduce un número: ");
        int number = scanner.nextInt();
        int result = ejercicio1.numberSign(number);

        // Muestra si el número es positivo, negativo o 0
        if (result == 0) {
            System.out.println("El número es 0.");
        } else if (result == 1) {
            System.out.println("El número es positivo.");
        } else if (result == -1) {
            System.out.println("El número es negativo.");
        }

        // Solicita una edad para determinar si es mayor de edad
        System.out.print("Introduce una edad: ");
        int age = scanner.nextInt();
        boolean isAdult = isAdult(age);

        // Muestra si la persona es mayor de edad o no
        if (isAdult) {
            System.out.println("Es mayor de edad.");
        } else {
            System.out.println("No es mayor de edad.");
        }
    }
/*
    // Función que determina si un número es 0, positivo o negativo
    public static int numberSign(int num) {
        if (num == 0) {
            return 0;
        } else if (num > 0) {
            return 1;
        } else {
            return -1;
        }
    }
*/
    // Función que determina si la edad es de un adulto (mayor o igual a 18)
    public static boolean isAdult(int age) {

        return age >= 18;
    }
}

