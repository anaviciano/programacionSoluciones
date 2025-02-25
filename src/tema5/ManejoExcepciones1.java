package tema5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManejoExcepciones1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un valor entero: ");

        try {
            int num = scanner.nextInt();
            System.out.println("Valor introducido: " + num);
        } catch (InputMismatchException e) {
            System.out.println("Valor introducido incorrecto.");
        }
    }
}
