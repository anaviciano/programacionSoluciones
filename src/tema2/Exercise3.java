package tema2;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Escribe la base de un triángulo: ");
        double base = scanner.nextDouble();
        System.out.print("Escribe la altura de un triángulo: ");
        double height = scanner.nextDouble();
        double area = (base * height) / 2;
        System.out.println("El área es " + area);
    }

}
