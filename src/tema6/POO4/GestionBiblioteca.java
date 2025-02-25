package tema6.POO4;

import tema6.Libro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionBiblioteca {
    private static List<ItemBiblioteca> biblioteca = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            switch (opcion) {
                case 1:
                    anadirItem();
                    break;
                case 2:
                    buscarItem();
                    break;
                case 3:
                    eliminarItem();
                    break;
                case 4:
                    listarBiblioteca();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("\nMenú de Gestión de Biblioteca:");
        System.out.println("1. Añadir ítem");
        System.out.println("2. Buscar ítem");
        System.out.println("3. Eliminar ítem");
        System.out.println("4. Listado de la biblioteca");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void anadirItem() {
        System.out.println("\nSeleccione el tipo de ítem a añadir:");
        System.out.println("1. Libro");
        System.out.println("2. Revista");
        System.out.println("3. DVD");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Número: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        switch (tipo) {
            case 1:
                System.out.print("Autor: ");
                String autor = scanner.nextLine();
                System.out.print("Editorial: ");
                String editorial = scanner.nextLine();
                biblioteca.add(new LibroB(numero, titulo, autor, editorial));
                break;
            case 2:
                System.out.print("Número de Publicación: ");
                int numeroPublicacion = scanner.nextInt();
                System.out.print("Año: ");
                int anio = scanner.nextInt();
                biblioteca.add(new RevistaB(numero, titulo, numeroPublicacion, anio));
                break;
            case 3:
                System.out.print("Director: ");
                String director = scanner.nextLine();
                System.out.print("Año: ");
                int anioDVD = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                System.out.print("Tipo: ");
                String tipoDVD = scanner.nextLine();
                biblioteca.add(new DVDB(numero, titulo, director, anioDVD, tipoDVD));
                break;
            default:
                System.out.println("Tipo de ítem no válido.");
        }
        System.out.println("Ítem añadido con éxito.");
    }

    private static void buscarItem() {
        System.out.print("\nIngrese el número del ítem a buscar: ");
        int numero = scanner.nextInt();
        for (ItemBiblioteca item : biblioteca) {
            if (item.getNumero() == numero) {
                System.out.println("Ítem encontrado: " + item);
                return;
            }
        }
        System.out.println("Ítem no encontrado.");
    }

    private static void eliminarItem() {
        System.out.print("\nIngrese el número del ítem a eliminar: ");
        int numero = scanner.nextInt();
        for (ItemBiblioteca item : biblioteca) {
            if (item.getNumero() == numero) {
                biblioteca.remove(item);
                System.out.println("Ítem eliminado con éxito.");
                return;
            }
        }
        System.out.println("Ítem no encontrado.");
    }

    private static void listarBiblioteca() {
        System.out.println("\nListado de la biblioteca:");
        for (ItemBiblioteca item : biblioteca) {
            System.out.println(item);
        }
    }
}
