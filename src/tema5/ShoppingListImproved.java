package tema5;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class ShoppingListImproved {
    public static void main(String[] args) {
        Scanner sc = new java.util.Scanner(System.in);
        Set<String> shoppingList = new HashSet<>();
        Set<String> shoppingCart = new HashSet<>();
        int option = 0;
        while (option!=6){
            option = readOption(sc);
            switch (option){
                case 1:
                    System.out.print("Introducte un producto: ");
                    addProduct(shoppingList, sc.nextLine());
                    break;
                case 2:
                    System.out.print("Introducte un producto: ");
                    addProduct(shoppingCart, sc.nextLine());
                    break;
                case 3:
                    showProducts(shoppingList);
                    break;
                case 4:
                    showProducts(shoppingCart);
                    break;
                case 5:
                    showMissingProducts(shoppingList, shoppingCart);
                    break;
                case 6:
                    System.out.println("Salir.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
    private static int readOption(Scanner sc) {
        System.out.println("1. Añadir producto a la lista");
        System.out.println("2. Añadir producto al carro");
        System.out.println("3. Mostrar productos de la lista");
        System.out.println("4. Mostrar productos del carro");
        System.out.println("5. Mostrar productos que faltan por añadir al carro");
        System.out.println("6. Salir");
        System.out.print("Opción: ");
        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }
    private static void addProduct(Set<String> shoppingList, String product) {
        if (!shoppingList.add(product)) {
            System.out.println("El producto ya existe en la lista.");
        }
    }

    private static void showProducts(Set<String> products) {
        for (String p : products) {
            System.out.println(p);
        }
    }
    private static void showMissingProducts(Set<String> shoppingList, Set<String> shoppingCart) {
        Set<String> missingProducts = new HashSet<>(shoppingList);
        missingProducts.removeAll(shoppingCart);
        System.out.println("Productos que faltan por añadir al carro:");
        showProducts(missingProducts);
    }

}
