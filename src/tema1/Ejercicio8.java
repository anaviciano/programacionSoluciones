package tema1;

import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Escribe el primer número: ");
        int number1 = scanner.nextInt();
        System.out.print("Escribe el segundo número: ");
        int number2 = scanner.nextInt();
        if (number1 > number2)
            System.out.println("El primer número es mayor");
        else if (number1 < number2)
            System.out.println("El segundo número es mayor");
        else
            System.out.println("Los números son iguales");

    }
}