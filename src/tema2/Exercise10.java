package tema2;

import java.util.Scanner;

public class Exercise10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el primer número: ");
        int number1 = scanner.nextInt();
        System.out.print("Introduce el segundo número: ");
        int number2 = scanner.nextInt();
        System.out.print("Introduce el tercer número: ");
        int number3 = scanner.nextInt();

        if (number1 <= number2) {
            if (number2 <= number3) {
                System.out.println("Están ordenados de menor a mayor.");
            } else {
                System.out.println("No están ordenados de menor a mayor.");
            }
        } else {
            System.out.println("No están ordenados de menor a mayor.");
        }
    }

}
