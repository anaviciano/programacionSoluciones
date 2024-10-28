package tema2;

import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int number1 = scanner.nextInt();
        if (number1 > 0) System.out.println("Es positivo.");
        else if (number1 < 0) System.out.println("Es negativo.");
        else System.out.println("Es cero.");
    }
}