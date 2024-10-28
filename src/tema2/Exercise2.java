package tema2;

import java.util.Scanner;
public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Escribe la base de un rectángulo: ");
        double base = scanner.nextDouble();
        System.out.print("Escribe la altura de un rectángulo: ");
        double height = scanner.nextDouble();
        double area = base * height;
        double perimeter = 2 * base + 2 * height;
        System.out.println("El área es " + area);
        System.out.println("El perímetro es " + perimeter);
    }
}
