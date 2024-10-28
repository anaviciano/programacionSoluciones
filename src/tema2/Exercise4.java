package tema2;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el primer número: ");
        double number1 = scanner.nextDouble();
        System.out.print("Introduce el segundo número: ");
        double number2 = scanner.nextDouble();
        System.out.print("Introduce el tercer número: ");
        double number3 = scanner.nextDouble();

        if (number1 > number2) {
            if (number1 > number3) {
                System.out.println("El mayor es " + number1);
            } else {
                System.out.println("El mayor es " + number3);
            }
        } else if (number2 > number3) {
            System.out.println("El mayor es " + number2);
        } else {
            System.out.println("El mayor es " + number3);
        }

        /*
        // Sin corchetes {} también funciona, pruébalo!
        if (number1 > number2)
            if (number1 > number3)
                System.out.println("El mayor es " + number1);
            else
                System.out.println("El mayor es " + number3);

        else if (number2 > number3)
            System.out.println("El mayor es " + number2);
        else
            System.out.println("El mayor es " + number3);
        */

    }
}