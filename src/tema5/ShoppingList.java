package tema5;

public class ShoppingList {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        java.util.Set<String> shoppingList = new java.util.HashSet<>();
        String product;
        do {
            System.out.print("Introduce un producto (FIN para terminar): ");
            product = sc.nextLine();
            if (!product.equalsIgnoreCase("FIN")) {
                if (!shoppingList.add(product)) {
                    System.out.println("El producto ya existe en la lista.");
                }
            }
        } while (!product.equalsIgnoreCase("FIN"));
        System.out.println("Lista de la compra:");
        for (String p : shoppingList) {
            System.out.println(p);
        }
    }
}
