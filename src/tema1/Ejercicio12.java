package tema1;
import java.util.Scanner;

public class Ejercicio12 {

        public static void main(String[] args) {
            // Crear un objeto Scanner para leer la entrada del usuario
            Scanner scanner = new Scanner(System.in);

            // Solicitar el año al usuario
            System.out.print("Introduce un año: ");
            int anio = scanner.nextInt();

            // Verificar si el año es bisiesto

            if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
                System.out.println(anio + " es un año bisiesto.");
            } else {
                System.out.println(anio + " no es un año bisiesto.");
            }

            // Cerrar el Scanner
            scanner.close();
        }


}
