package examen2.ejercicio3;

import java.util.ArrayList;
import java.util.Scanner;

public class TiendaPokemonTPV {
    private ArrayList<Articulo> ticket = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("1. Añadir poción al ticket");
            System.out.println("2. Añadir pokébola al ticket");
            System.out.println("3. Añadir accesorio al ticket");
            System.out.println("4. Borrar el artículo del ticket");
            System.out.println("5. Mostrar todos los artículos del ticket");
            System.out.println("6. Mostrar total");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    anyadirPocion();
                    break;
                case 2:
                    anyadirPokebola();
                    break;
                case 3:
                    anyadirAccesorio();
                    break;
                case 4:
                    borrarArticulo();
                    break;
                case 5:
                    mostrarArticulos();
                    break;
                case 6:
                    mostrarTotal();
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 7);
    }

    private void anyadirPocion() {
        System.out.print("Nombre de la poción: ");
        String nombre = scanner.nextLine();
        System.out.print("¿Es gratis? (true/false): ");
        boolean gratis = scanner.nextBoolean();
        System.out.print("Nivel de la poción: ");
        int nivel = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Efectos (separados por comas): ");
        String[] efectos = scanner.nextLine().split(",");
        ticket.add(new Pocion(nombre, gratis, nivel, efectos));
    }

    private void anyadirPokebola() {
        System.out.print("Nombre de la pokébola: ");
        String nombre = scanner.nextLine();
        System.out.print("¿Es gratis? (true/false): ");
        boolean gratis = scanner.nextBoolean();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.println("Tipo de pokébola:");
        for (Pokebola.Tipo tipo : Pokebola.Tipo.values()) {
            System.out.println(tipo);
        }
        System.out.print("Elige el tipo de pokébola: ");
        String tipoStr = scanner.nextLine();
        Pokebola.Tipo tipo = Pokebola.Tipo.valueOf(tipoStr.toUpperCase());

        ticket.add(new Pokebola(nombre, gratis, tipo));
    }

    private void anyadirAccesorio() {
        System.out.print("Nombre del accesorio: ");
        String nombre = scanner.nextLine();
        System.out.print("¿Es gratis? (true/false): ");
        boolean gratis = scanner.nextBoolean();
        scanner.nextLine(); // Consumir el salto de línea
        ticket.add(new Accesorio(nombre, gratis));
    }

    private void borrarArticulo() {
        System.out.print("Posición del artículo a borrar: ");
        int posicion = scanner.nextInt();
        if (posicion >= 0 && posicion < ticket.size()) {
            ticket.remove(posicion);
        } else {
            System.out.println("Posición no válida");
        }
    }

    private void mostrarArticulos() {
        for (int i = 0; i < ticket.size(); i++) {
            Articulo articulo = ticket.get(i);
            System.out.println(i + ". " + articulo.getTipo() + " - " + articulo.nombre + " - " + articulo.getPrecio() + " €");
        }
    }

    private void mostrarTotal() {
        double total = 0;
        for (Articulo articulo : ticket) {
            total += articulo.getPrecio();
        }
        System.out.println("Total: " + total + " €");
    }

    public static void main(String[] args) {
        TiendaPokemonTPV tpv = new TiendaPokemonTPV();
        tpv.mostrarMenu();
    }
}
