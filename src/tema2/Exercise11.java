package tema2;

import java.util.Scanner;

public class Exercise11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el primer número: ");
        int number1 = scanner.nextInt();
        System.out.print("Introduce el segundo número: ");
        int number2 = scanner.nextInt();
        System.out.print("Introduce el tercer número: ");
        int number3 = scanner.nextInt();

        if (number1 + 1 == number2 && number1 + 2 == number3) {
            System.out.println("Son consecutivos");
        } else {
            System.out.println("No son consecutivos");
        }
    }
}
