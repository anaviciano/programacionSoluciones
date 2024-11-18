package tema2;

import java.util.Scanner;

public class Exercise20 {
    public static void main(String[] args) {
        System.out.println("Calculando los números pares entre 2 números");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el límite inferior: ");
        int lowerLimit = scanner.nextInt();
        System.out.print("Introduce el límite superior: ");
        int higherLimit = scanner.nextInt();
        if (higherLimit >= lowerLimit) {
            System.out.println("Estos son los números pares entre " + lowerLimit + " y " + higherLimit);
            for (int number = lowerLimit; number <= higherLimit; number++) {
                if (number % 2 == 0) {
                    System.out.print(number + " ");
                }
            }
        } else {
            System.out.println("ERROR. El límite superior " + higherLimit + " es inferior al límite inferior " + lowerLimit);
        }
    }
}
