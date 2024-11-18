package tema2;

import java.util.Scanner;

public class Exercise27 {
    public static void main(String[] args) {
        System.out.println("Calculadora de números primos.");
        int primeCount = 0;
        int number = 2;
        while (primeCount < 20) {
            boolean isPrime = true;
            //for (int divisor = number / 2; divisor > 1; divisor--) {
            for (int divisor = number-1; divisor > 1; divisor--) {
                if (number % divisor == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                System.out.println(number);
                primeCount++;
            }
            number++;
        }
    }
}
