package tema2;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Escribe el lado de un cuadrado: ");
        double side = scanner.nextDouble();
        double area = side * side;
        double perimeter = 4 * side;
        System.out.println("El área es " + area);
        System.out.println("El perímetro es " + perimeter);
    }
}