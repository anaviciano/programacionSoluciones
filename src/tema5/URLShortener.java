package tema5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class URLShortener {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Map<String, String> urls = new HashMap<>();
        int option = 0;
        while (option != 5) {
            option = readOption(sc);
            switch (option) {
                case 1:
                    addURL(urls);
                    break;
                case 2:
                    resolveURL(urls);
                    break;
                case 3:
                    removeURL(urls);
                    break;
                case 4:
                    showURLs(urls);
                    break;
                case 5:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static int readOption(Scanner sc) {
        System.out.println("1. Añadir URL");
        System.out.println("2. Resolver URL");
        System.out.println("3. Borrar URL");
        System.out.println("4. Mostrar URLs");
        System.out.println("5. Salir");
        System.out.print("Opción: ");
        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    private static void addURL(Map<String, String> urls) {
        Scanner sc = new Scanner(System.in);
        System.out.print("URL: ");
        String url = sc.nextLine();
        String key = UUID.randomUUID().toString();
        urls.put(key, url);
        System.out.println("URL acortada: https://miacortador.es/" + key);
    }

    private static void resolveURL(Map<String, String> urls) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Clave: ");
        String key = sc.nextLine();
        if (urls.containsKey(key)) {
            System.out.println("URL: " + urls.get(key));
        } else {
            System.out.println("URL no encontrada.");
        }
    }

    private static void removeURL(Map<String, String> urls) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Clave: ");
        String key = sc.nextLine();
        if (urls.containsKey(key)) {
            urls.remove(key);
            System.out.println("URL eliminada.");
        } else {
            System.out.println("URL no encontrada.");
        }
    }

    private static void showURLs(Map<String, String> urls) {
        urls.forEach((key, value) -> System.out.println("https://miacortador.es/" + key + " -> " + value));
    }
}
