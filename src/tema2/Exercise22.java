package tema2;

import java.util.Scanner;
public class Exercise22 {
    public static void main(String[] args) {
        System.out.println("Calculando el número de cifras de un número.");
        System.out.print("Introduce un número: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int figures = 0;
        while (number != 0) {
            number /= 10;
            figures++;
        }
        System.out.print("Tiene " + figures + " cifras");
    }
}
