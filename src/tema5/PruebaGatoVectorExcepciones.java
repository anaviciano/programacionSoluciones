package tema5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PruebaGatoVectorExcepciones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<GatoExcepciones> gatos = new ArrayList<>();

        int count = 0;
        while (count < 5) {
            try {
                System.out.print("Introduce el nombre del gato: ");
                String nombre = scanner.next();

                System.out.print("Introduce la edad del gato: ");
                int edad = scanner.nextInt();

                GatoExcepciones gato = new GatoExcepciones(nombre, edad);
                gatos.add(gato);
                count++;
            } catch (InputMismatchException e) {
                System.out.println("Error: Valor no válido. Por favor, introduce un número entero para la edad.");
                scanner.next(); // Limpiar el buffer del scanner
            } catch (Exception e) {
                System.out.println("Excepción: " + e.getMessage());
            }
        }

        System.out.println("\nInformación de los gatos:");
        for (GatoExcepciones gato : gatos) {
            gato.imprimir();
        }

        scanner.close();
    }
}
