package tema5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NaturalPark {

    public static void main(String[] args) {
        List<Sighting> sightings = new ArrayList<>();
        int option = 0;
        while (option != 8) {
            Scanner sc = new Scanner(System.in);
            option = readOption(sc);
            switch (option) {
                case 1:
                    sightings.add(readSnakeSighting(sc));
                    break;
                case 2:
                    sightings.add(readWolfSighting(sc));
                    break;
                case 3:
                    sightings.add(readBirdSighting(sc));
                    break;
                case 4:
                    showSightingsAfter8(sightings);
                    break;
                case 5:
                    showNightSightings(sightings);
                    break;
                case 6:
                    showSnakeSightings(sightings);
                    break;
                case 7:
                    showWolfSightings(sightings);
                    break;
                case 8:
                    showBirdSightings(sightings);
                    break;
                case 9:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    public static int readOption(Scanner sc) {
        System.out.println("1. Registrar avistamiento de serpiente");
        System.out.println("2. Registrar avistamiento de manada de lobos");
        System.out.println("3. Registrar avistamiento de pájaro");
        System.out.println("4. Mostrar avistamientos a partir de las 8");
        System.out.println("5. Mostrar avistamientos nocturnos (20 - 8)");
        System.out.println("6. Mostrar avistamientos de serpientes");
        System.out.println("7. Mostrar avistamientos de manadas de lobos");
        System.out.println("8. Mostrar avistamientos de pájaros");
        System.out.println("9. Salir");
        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    private static SnakeSighting readSnakeSighting(Scanner sc) {
        System.out.print("Hora: ");
        int hour = sc.nextInt();
        sc.nextLine();
        System.out.print("Longitud: ");
        double length = sc.nextDouble();
        sc.nextLine();
        System.out.print("Especie: ");
        String species = sc.nextLine();
        return new SnakeSighting(hour, length, species);
    }

    private static WolfSighting readWolfSighting(Scanner sc) {
        System.out.print("Hora: ");
        int hour = sc.nextInt();
        sc.nextLine();
        System.out.print("Número de lobos: ");
        int wolves = sc.nextInt();
        sc.nextLine();
        System.out.print("Observaciones: ");
        String observation = sc.nextLine();
        return new WolfSighting(hour, wolves, observation);
    }

    private static BirdSighting readBirdSighting(Scanner sc) {
        System.out.print("Hora: ");
        int hour = sc.nextInt();
        sc.nextLine();
        System.out.println("Peso: ");
        double weight = sc.nextDouble();
        sc.nextLine();
        System.out.print("Especie: ");
        String species = sc.nextLine();
        return new BirdSighting(hour, weight, species);
    }

    private static void showSightingsAfter8(List<Sighting> sightings) {
        sightings.stream().filter(sighting -> sighting.getHour() >= 8).forEach(System.out::println);
    }

    private static void showNightSightings(List<Sighting> sightings) {
        sightings.stream().filter(sighting -> sighting.getHour() >= 20 || sighting.getHour() < 8).forEach(System.out::println);
    }

    private static void showSnakeSightings(List<Sighting> sightings) {
        sightings.stream().filter(sighting -> sighting instanceof SnakeSighting).forEach(System.out::println);
    }

    private static void showWolfSightings(List<Sighting> sightings) {
        sightings.stream().filter(sighting -> sighting instanceof WolfSighting).forEach(System.out::println);
    }

    private static void showBirdSightings(List<Sighting> sightings) {
        sightings.stream().filter(sighting -> sighting instanceof BirdSighting).forEach(System.out::println);
    }
}
