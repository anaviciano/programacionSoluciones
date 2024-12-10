package tema3;

public class ejercicio9 {

    // Método para mostrar un triángulo
    public static void mostrarTriangulo(char caracter, int numLineas) {
        // Recorremos cada línea
        for (int i = 1; i <= numLineas; i++) {
            // Imprimimos los espacios antes del carácter para centrar el triángulo
            for (int j = 0; j < numLineas - i; j++) {
                System.out.print(" ");
            }

            // Imprimimos los caracteres del triángulo
            for (int k = 0; k < (2 * i - 1); k++) {
                System.out.print(caracter);
            }

            // Pasamos a la siguiente línea
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        char caracter = '*';
        int numLineas = 5;

        // Llamada al método
        mostrarTriangulo(caracter, numLineas);
    }
}

