package tema2;

import java.util.Scanner;
public class Exercise24 {
    public static void main(String[] args) {
        System.out.println("Calculadora de aprobados y suspendidos.");
        double grade = 0;
        int passCount = 0;
        int failCount = 0;
        Scanner scanner = new Scanner(System.in);
        while (grade >= 0 && grade <= 10) {
            System.out.print("Introduce nota (-1 para terminar): ");
            grade = scanner.nextDouble();
            if (grade >= 0) {
                if (grade < 5) {
                    failCount++;
                } else {
                    passCount++;
                }
            }
        }
        System.out.println("Han aprobado " + passCount);
        System.out.println("Han supendido " + failCount);
    }
}
