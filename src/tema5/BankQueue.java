package tema5;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BankQueue {
    static Queue<BankUser> cola;

    public static void main(String[] args) {
        Scanner sc = new java.util.Scanner(System.in);
        List<BankUser> bankQueue = new LinkedList<>();
        int option = 0;
        while (option != 4) {
            option = readOption(sc);
            switch (option) {
                case 1:
                    addUser(sc, bankQueue);
                    break;
                case 2:
                    removeFirstUser(bankQueue);
                    break;
                case 3:
                    int position = sc.nextInt();
                    sc.nextLine();
                    removeUser(sc, bankQueue, position);
                    break;
                case 4:
                    System.out.println("Salir.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static int readOption(Scanner sc) {
        System.out.println("1. Añadir usuario a la cola");
        System.out.println("2. Quitar al primero de la cola");
        System.out.println("3. Quitar a un usuario de la cola");
        System.out.println("4. Salir");
        System.out.print("Opción: ");
        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    private static void addUser(Scanner sc, List<BankUser> bankQueue) {
        System.out.print("Nombre: ");
        String name = sc.nextLine();
        System.out.print("Edad: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("DNI: ");
        String dni = sc.nextLine();
        bankQueue.add(new BankUser(name, age, dni));
        cola.add(new BankUser(name, age, dni));
        System.out.println("Usuario añadido a la cola.");
    }

    private static void removeFirstUser(List<BankUser> bankQueue) {
        if (bankQueue.isEmpty()) {
            System.out.println("No hay usuarios en la cola.");
        } else {
            BankUser user = bankQueue.remove(0);
            BankUser user2 = cola.poll();
            System.out.println("Usuario atendido: " + user);
        }
    }

    private static void removeUser(Scanner sc, List<BankUser> bankQueue, int position) {
        if (position < 0 || position >= bankQueue.size()) {
            System.out.println("Posición no válida.");
        } else {
            BankUser user = bankQueue.remove(position);
            cola.remove(position);
            System.out.println("Usuario eliminado: " + user);
        }
    }
}