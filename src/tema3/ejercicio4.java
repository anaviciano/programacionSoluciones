package tema3;

import java.util.Scanner;

public class ejercicio4 {
    // Constante para la tasa de cambio (puedes modificarla según la tasa actual)
    public static final double EURO_TO_DOLLAR = 1.1;  // Ejemplo: 1 euro = 1.1 dólares
    public static final double DOLLAR_TO_EURO = 0.91; // Ejemplo: 1 dólar = 0.91 euros

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Muestra el menú
            showMenu();
            System.out.print("Elige una opción (1-3): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Conversión de euros a dólares
                    System.out.print("Introduce la cantidad en euros: ");
                    double euros = scanner.nextDouble();
                    double dollars = euro2dollar(euros);
                    System.out.printf("%.3f euros son %.2f dólares.\n", euros, dollars);
                    break;
                case 2:
                    // Conversión de dólares a euros
                    System.out.print("Introduce la cantidad en dólares: ");
                    double usd = scanner.nextDouble();
                    double convertedEuros = dollar2euro(usd);
                    System.out.printf("%.1f dólares son %.2f euros.\n", usd, convertedEuros);
                    break;
                case 3:
                    // Salir del programa
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (choice != 3);
    }

    // Procedimiento que muestra el menú de opciones
    public static void showMenu() {
        System.out.println("\nConversor de divisas:");
        System.out.println("1. Convertir de euros a dólares");
        System.out.println("2. Convertir de dólares a euros");
        System.out.println("3. Salir");
    }

    // Función que convierte euros a dólares
    public static double euro2dollar(double euros) {
        return euros * EURO_TO_DOLLAR;
    }

    // Función que convierte dólares a euros
    public static double dollar2euro(double dollars) {
        return dollars * DOLLAR_TO_EURO;
    }
}

