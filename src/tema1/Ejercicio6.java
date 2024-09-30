package tema1;
import java.util.Scanner;


public class Ejercicio6 {


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Escribe el valor del radio: ");
            double radius = scanner.nextDouble();
            double area = 3.14 * radius * radius;
            //Double area = Math.PI * Math.pow(radius, 2);
            System.out.println("El área es " + area);
        }

}
