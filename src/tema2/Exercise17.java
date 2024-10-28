package tema2;

import java.util.Scanner;

public class Exercise17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Calcular área y perímetro de un cuadrado (0), área y perímetro de un rectángulo (1) o área de un triángulo (2): ");
        int option = scanner.nextInt();
        switch (option) {
            case 0 -> {
                System.out.print("Escribe el lado de un cuadrado: ");
                double side = scanner.nextDouble();
                double area = side * side;
                double perimeter = 4 * side;
                System.out.println("El área es " + area);
                System.out.println("El perímetro es " + perimeter);
            }
            case 1 -> {
                System.out.print("Escribe la base de un rectángulo: ");
                double base = scanner.nextDouble();
                System.out.print("Escribe la altura de un rectángulo: ");
                double height = scanner.nextDouble();
                double area = base * height;
                double perimeter = 2 * base + 2 * height;
                System.out.println("El área es " + area);
                System.out.println("El perímetro es " + perimeter);
            }
            case 2 -> {
                System.out.print("Escribe la base de un triángulo: ");
                double base = scanner.nextDouble();
                System.out.print("Escribe la altura de un triángulo: ");
                double height = scanner.nextDouble();
                double area = (base * height) / 2;
                System.out.println("El área es " + area);
            }
            default -> System.out.println("Opción no válida");
        }

    }
}
