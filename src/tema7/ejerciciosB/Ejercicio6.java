package tema7.ejerciciosB;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce un número para buscar en el primer millón de decimales de pi: ");
        String number = scanner.nextLine();

        //Se puede usar StringBuider, se usa igual que un String pero es más eficiente para concatenar
        //StringBuilder piDecimals = new StringBuilder();
        String piDecimals = "";

        try (BufferedReader br = new BufferedReader(new FileReader("resources/pi-million.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                piDecimals += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean found = buscarEnPi(number, piDecimals);

        if (found) {
            System.out.println("El número " + number + " aparece en el primer millón de decimales de pi.");
        } else {
            System.out.println("El número " + number + " no aparece en el primer millón de decimales de pi.");
        }
    }

    public static boolean buscarEnPi(String number, String piDecimals) {
        int lenNumber = number.length();
        int lenPi = piDecimals.length();

        for (int i = 0; i <= lenPi - lenNumber; i++) {
            if (piDecimals.substring(i, i + lenNumber).equals(number)) {
                return true;
            }
        }
        return false;
    }
}
