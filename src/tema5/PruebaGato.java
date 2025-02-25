package tema5;

import java.util.Scanner;

public class PruebaGato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Crear objetos Gato con valores válidos
            GatoExcepciones gato1 = new GatoExcepciones("Milo", 2);
            gato1.imprimir();

            GatoExcepciones gato2 = new GatoExcepciones("Luna", 3);
            gato2.imprimir();

            // Intentar crear un objeto Gato con un nombre inválido
            try {
                GatoExcepciones gato3 = new GatoExcepciones("Li", 1);
                gato3.imprimir();
            } catch (Exception e) {
                System.out.println("Excepción: " + e.getMessage());
            }

            // Intentar crear un objeto Gato con una edad inválida
            try {
                GatoExcepciones gato4 = new GatoExcepciones("Simba", -1);
                gato4.imprimir();
            } catch (Exception e) {
                System.out.println("Excepción: " + e.getMessage());
            }

            // Probar setters con valores inválidos
            try {
                gato1.setNombre("Bo");
            } catch (Exception e) {
                System.out.println("Excepción al establecer nombre: " + e.getMessage());
            }

            try {
                gato2.setEdad(-5);
            } catch (Exception e) {
                System.out.println("Excepción al establecer edad: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Excepción en la creación de objetos Gato: " + e.getMessage());
        }

        scanner.close();
    }
}
