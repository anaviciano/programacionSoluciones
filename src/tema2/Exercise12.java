package tema2;

import java.util.Scanner;

public class Exercise12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el primer número: ");
        int number1 = scanner.nextInt();
        System.out.print("Introduce el segundo número: ");
        int number2 = scanner.nextInt();
        System.out.print("Introduce el tercer número: ");
        int number3 = scanner.nextInt();

        int maximum = number1;
        int minimum = number1;
        int middle = number1;

        if (number2 > maximum) maximum = number2;
        if (number3 > maximum) maximum = number3;
        if (number2 < minimum) minimum = number2;
        if (number3 < minimum) minimum = number3;
        middle = number1 + number2 + number3 - minimum - maximum;

        System.out.println(maximum + " > " + middle + " > " + minimum);
    }
}

