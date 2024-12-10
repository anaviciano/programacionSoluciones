package tema3;

import java.util.Scanner;

public class ejercicio3
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double radius;

        // Solicita un radio válido (>0) al usuario
        do {
            System.out.print("Introduce un radio válido (mayor que 0): ");
            radius = scanner.nextDouble();
        } while (!validRadius(radius)); // Repite hasta que el radio sea válido

        // Calcula y muestra el perímetro y la superficie del círculo
        double perimeter = calculateCirclePerimeter(radius);
        double area = calculateCircleArea(radius);

        System.out.println("Perímetro del círculo: " + perimeter);
        System.out.println("Superficie del círculo: " + area);
    }

    // Función que valida si el radio es mayor que 0
    public static boolean validRadius(double radius) {
        return radius > 0;
    }

    // Función que calcula el perímetro del círculo
    public static double calculateCirclePerimeter(double radius) {
        return 2 * Math.PI * radius;
    }

    // Función que calcula la superficie del círculo
    public static double calculateCircleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }
}

