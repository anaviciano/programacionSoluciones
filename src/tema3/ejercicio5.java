package tema3;
import java.util.Scanner;

public class ejercicio5 {

    // Método que muestra la tabla de multiplicar de un número dado
    public static void mostrarTablaMultiplicar(int numero) {
        System.out.println("Tabla de multiplicar del " + numero + ":");
        // Mostrar la multiplicación del número con los números del 1 al 10
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d\n", numero, i, numero * i);
        }
    }

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que ingrese un número entre 1 y 10
        System.out.print("Introduce un número entre 1 y 10: ");
        int numero = scanner.nextInt();

        // Validar que el número esté dentro del rango de 1 a 10
        if (numero >= 1 && numero <= 10) {
            // Llamar al método para mostrar la tabla de multiplicar del número ingresado
            mostrarTablaMultiplicar(numero);
        } else {
            // Si el número no está en el rango, mostrar un mensaje de error
            System.out.println("Número inválido. Debes ingresar un número entre 1 y 10.");
        }

        // Cerrar el scanner
        scanner.close();
    }
}
