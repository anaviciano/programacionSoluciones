package tema2;

import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Escribe una cantidad en €:");
        double euros = scanner.nextDouble();
        double dollars = euros * 1.05;
        System.out.println("Son " + dollars + "$");
    }
}
