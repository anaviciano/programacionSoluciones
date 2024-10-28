package tema2;

import java.util.Scanner;

public class Exercise14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double rate = 15;
        System.out.println("Tarifa base de 15€ / noche: ");
        System.out.print("Número de personas: ");
        int people = scanner.nextInt();
        System.out.print("Número de días: ");
        int days = scanner.nextInt();

        double price = days * people * rate;
        if (people > 5 && days >=7) {
            System.out.println("Se aplica un descuento del 25%");
            price *= 0.75;
        }
        System.out.println("El precio final es: " + price);
    }

}
