package tema2;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el primer número: ");
        int number1 = scanner.nextInt();
        System.out.print("Introduce el segundo número: ");
        int number2 = scanner.nextInt();
        System.out.print("Introduce el tercer número: ");
        int number3 = scanner.nextInt();
        System.out.println("La media sin decimales es " + ((number1 + number2 + number3)/3));
        System.out.println("La media con decimales es " + (((double) number1 + number2 + number3)/3));
    }
}