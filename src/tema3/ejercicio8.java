package tema3;

import java.util.Scanner;

public class ejercicio8 {

    // Método para comprobar si un año es bisiesto
    public static boolean esAnyoBisiesto(int anyo) {
        // Un año es bisiesto si es divisible por 4, pero no por 100, a menos que también sea divisible por 400
        return (anyo % 4 == 0 && anyo % 100 != 0) || (anyo % 400 == 0);
    }

    // Método para comprobar si la fecha es válida
    public static boolean esFechaValida(int dia, int mes, int anyo) {
        // Array con la cantidad de días de cada mes
        int[] diasPorMes = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        // Comprobar si el mes está en el rango válido
        if (mes < 1 || mes > 12) {
            return false;
        }

        // Ajustar febrero en caso de año bisiesto
        if (esAnyoBisiesto(anyo)) {
            diasPorMes[1] = 29;  // Febrero tiene 29 días en un año bisiesto
        }

        // Comprobar si el día está en el rango válido para el mes
        if (dia < 1 || dia > diasPorMes[mes - 1]) {
            return false;
        }

        // Si pasa todas las validaciones, la fecha es válida
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer datos por consola
        System.out.print("Introduce el día (1-31): ");
        int dia = scanner.nextInt();

        System.out.print("Introduce el mes (1-12): ");
        int mes = scanner.nextInt();

        System.out.print("Introduce el año: ");
        int año = scanner.nextInt();

        // Verificar si la fecha es válida
        if (esFechaValida(dia, mes, año)) {
            System.out.println("La fecha es correcta.");
        } else {
            System.out.println("La fecha es incorrecta.");
        }

        scanner.close();
    }
}

