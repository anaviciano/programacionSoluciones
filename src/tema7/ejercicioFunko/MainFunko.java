package tema7.ejercicioFunko;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MainFunko {
    public static void main(String[] args) {
        //La aplicación, nada más abrirse,
        // cargará todos los funkos en una colección de objetos Funko (deberás crear la clase).
        TiendaFunko store = new TiendaFunko();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("1. Añadir funko");
            System.out.println("2. Borrar funko");
            System.out.println("3. Mostrar todos los funkos");
            System.out.println("4. Mostrar el funko más caro");
            System.out.println("5. Mostrar la media de precio de los funkos");
            System.out.println("6. Mostrar los funkos agrupados por modelos");
            System.out.println("7. Mostrar los funkos de 2023");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (option) {
                case 1:
                    System.out.print("Código: ");
                    String cod = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Fecha de lanzamiento (YYYY-MM-DD): ");
                    try {
                        LocalDate fechaLanzamiento = LocalDate.parse(scanner.next());
                        store.addFunko(new Funko(cod, nombre, modelo, precio, fechaLanzamiento));
                    } catch (DateTimeParseException e) {
                        System.out.println("Fecha no válida.");
                        break;
                    } catch (Exception e) {
                        // Manejo general para otras excepciones
                        System.out.println("Error general: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Código del funko a borrar: ");
                    String codBorrar = scanner.nextLine();
                    store.deleteFunko(codBorrar);
                    break;
                case 3:
                    store.showAllFunkos();
                    break;
                case 4:
                    store.showMostExpensiveFunko();
                    break;
                case 5:
                    store.showAveragePrice();
                    break;
                case 6:
                    store.showFunkosByModel();
                    break;
                case 7:
                    store.showFunkosFrom2023();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (option != 0);

        scanner.close();
    }
}
