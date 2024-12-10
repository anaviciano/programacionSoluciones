package tema3;

import java.util.Scanner;

import static tema3.ejercicio1.numberSign;
import static tema3.ejercicio2.isAdult;
import static tema3.ejercicio3.*;
import static tema3.ejercicio4.*;
import static tema3.ejercicio5.mostrarTablaMultiplicar;
import static tema3.ejercicio7.esPrimo;
import static tema3.ejercicio8.esFechaValida;
import static tema3.ejercicio9.mostrarTriangulo;

public class ejercicio10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            // Mostrar menú de opciones
            showMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // a) Muestra el signo de un número introducido por el usuario
                    System.out.print("Introduce un número: ");
                    int numero = scanner.nextInt();
                    int signo = numberSign(numero);
                    if (signo == 0) {
                        System.out.println("El número es 0.");
                    } else if (signo > 0) {
                        System.out.println("El número es positivo.");
                    } else {
                        System.out.println("El número es negativo.");
                    }
                    break;
                case 2:
                    // b) Indica si el usuario es mayor de edad o no
                    System.out.print("Introduce tu edad: ");
                    int edad = scanner.nextInt();
                    if (isAdult(edad)) {
                        System.out.println("Eres mayor de edad.");
                    } else {
                        System.out.println("No eres mayor de edad.");
                    }
                    break;
                case 3:
                    // c) Calcula el área y perímetro de un círculo
                    System.out.print("Introduce el radio del círculo (>0): ");
                    double radio = scanner.nextDouble();
                    if (validRadius(radio)) {
                        double perimetro = calculateCirclePerimeter(radio);
                        double area = calculateCircleArea(radio);
                        System.out.printf("Perímetro: %.2f\nÁrea: %.2f\n", perimetro, area);
                    } else {
                        System.out.println("Radio no válido. Debe ser mayor que 0.");
                    }
                    break;
                case 4:
                    // d) Conversor de euros a dólares y de dólares a euros
                    ejercicio4.showMenu();
                    int choice;

                    do {
                        // Muestra el menú
                        showMenu();
                        System.out.print("Elige una opción (1-3): ");

                        choice = scanner.nextInt();

                        switch (choice) {
                            case 1:
                                // Conversión de euros a dólares
                                System.out.print("Introduce la cantidad en euros: ");
                                double euros = scanner.nextDouble();
                                double dollars = euro2dollar(euros);
                                System.out.printf("%.3f euros son %.2f dólares.\n", euros, dollars);
                                break;
                            case 2:
                                // Conversión de dólares a euros
                                System.out.print("Introduce la cantidad en dólares: ");
                                double usd = scanner.nextDouble();
                                double convertedEuros = dollar2euro(usd);
                                System.out.printf("%.1f dólares son %.2f euros.\n", usd, convertedEuros);
                                break;
                            case 3:
                                // Salir del programa
                                System.out.println("Saliendo del programa...");
                                break;
                            default:
                                System.out.println("Opción no válida. Inténtalo de nuevo.");
                        }
                    } while (choice != 3);

                    break;
                case 5:
                    // e) Mostrar tabla de multiplicar de un número
                    System.out.print("Introduce un número entre 1 y 10: ");
                    int tabla = scanner.nextInt();
                    if (tabla >= 1 && tabla <= 10) {
                        mostrarTablaMultiplicar(tabla);
                    } else {
                        System.out.println("Número fuera de rango.");
                    }
                    break;
                case 6:
                    // f) Mostrar tablas de multiplicar del 1 al 10
                    for (numero = 1; numero <= 10; numero++) {
                        mostrarTablaMultiplicar(numero);  // Llamada al método
                    }
                    break;
                case 7:
                    // g) Comprobador de números primos
                    do {
                        System.out.print("Introduce un número entero positivo (0 para salir): ");
                        numero = scanner.nextInt();

                        if (numero == 0) {
                            break;  // Salir si se introduce 0
                        }

                        // Llamar al método esPrimo y mostrar el resultado
                        if (esPrimo(numero)) {
                            System.out.println(numero + " es un número primo.");
                        } else {
                            System.out.println(numero + " no es un número primo.");
                        }

                    } while (numero != 0);                    break;
                case 8:
                    // h) Comprobador de fechas
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
                    break;
                case 9:
                    // i) Dibujar triángulos
                    System.out.print("Introduce el carácter para el triángulo: ");
                    char caracter = scanner.next().charAt(0);
                    System.out.print("Introduce el número de líneas del triángulo: ");
                    int lineas = scanner.nextInt();
                    mostrarTriangulo(caracter, lineas);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    public static void showMenu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1) Muestra el signo de un número.");
        System.out.println("2) Indica si eres mayor de edad.");
        System.out.println("3) Calcula área y perímetro de un círculo.");
        System.out.println("4) Conversor de euros a dólares y viceversa.");
        System.out.println("5) Mostrar tabla de multiplicar de un número.");
        System.out.println("6) Mostrar tablas de multiplicar del 1 al 10.");
        System.out.println("7) Comprobador de números primos.");
        System.out.println("8) Comprobador de fechas.");
        System.out.println("9) Dibujar triángulos.");
        System.out.println("0) Salir.");
        System.out.print("Elige una opción: ");
    }
}

