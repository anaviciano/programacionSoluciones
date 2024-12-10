package tema3;

public class ejercicio6 {

    // Método que muestra la tabla de multiplicar de un número dado
    public static void mostrarTablaMultiplicar(int numero) {
        System.out.println("Tabla de multiplicar del " + numero + ":");
        // Mostrar la multiplicación del número con los números del 1 al 10
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d\n", numero, i, numero * i);
        }
        System.out.println();  // Salto de línea después de cada tabla
    }

    public static void main(String[] args) {
        // Llamar al método para mostrar las tablas de multiplicar del 1 al 10
        for (int numero = 1; numero <= 10; numero++) {
            mostrarTablaMultiplicar(numero);  // Llamada al método
        }
    }
}

