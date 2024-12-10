package tema2;

import java.util.Scanner;

public class pruebasClase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("dime un número");
        int numero = scanner.nextInt();
        System.out.println("numero" + numero);

        System.out.println("dime una frase");
        String basura = scanner.nextLine();
        System.out.println("frase1" + basura);

        System.out.println("dime otra frase");
        String frase2 = scanner.nextLine();
        System.out.println("frase2" + frase2);

    }
}
