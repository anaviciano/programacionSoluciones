package tema5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Gym {
    public static void main(String[] args) {
        Scanner sc = new java.util.Scanner(System.in);
        Map<String, GymUser> gymUsers = new HashMap<>();
        String dni;
        int option = 0;
        while (option != 5) {
            option = readOption(sc);
            switch (option) {
                case 1:
                    createUser(sc, gymUsers);
                    break;
                case 2:
                    deleteUser(sc, gymUsers);
                    break;
                case 3:
                    showUser(sc, gymUsers);
                    break;
                case 4:
                    updateUser(sc, gymUsers);
                    break;
                case 5:
                    System.out.println("Salir.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static int readOption(Scanner sc) {
        System.out.println("1. Alta usuario");
        System.out.println("2. Baja usuario");
        System.out.println("3. Mostrar usuario");
        System.out.println("4. Modificar usuario");
        System.out.println("5. Salir");
        System.out.print("Opción: ");
        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    private static void createUser(Scanner sc, Map<String, GymUser> gymUsers) {
        System.out.print("DNI: ");
        String dni = sc.nextLine();
        if (gymUsers.containsKey(dni)) {
            System.out.println("El usuario ya existe.");
        } else {
            gymUsers.put(dni, readGymUser(sc));
            System.out.println("Usuario dado de alta.");
        }
    }
    private static void updateUser(Scanner sc, Map<String, GymUser> gymUsers) {
        System.out.print("DNI: ");
        String dni = sc.nextLine();
        if (gymUsers.containsKey(dni)) {
            gymUsers.put(dni, readGymUser(sc));
            System.out.println("Usuario modificado.");
        } else {
            System.out.println("El usuario no existe.");
        }
    }

    private static void showUser(Scanner sc, Map<String, GymUser> gymUsers) {
        System.out.print("DNI: ");
        String dni = sc.nextLine();
        if (gymUsers.containsKey(dni)) {
            System.out.println(gymUsers.get(dni));
        } else {
            System.out.println("El usuario no existe.");
        }
    }

    private static void deleteUser(Scanner sc, Map<String, GymUser> gymUsers) {
        System.out.print("DNI: ");
        String dni = sc.nextLine();
        if (gymUsers.containsKey(dni)) {
            gymUsers.remove(dni);
            System.out.println("Usuario dado de baja.");
        } else {
            System.out.println("El usuario no existe.");
        }
    }
    private static GymUser readGymUser(Scanner sc) {
        System.out.print("Nombre: ");
        String name = sc.nextLine();
        System.out.print("Edad: ");
        int age = sc.nextInt();
        sc.nextLine();
        return new GymUser(name, age);
    }
}
