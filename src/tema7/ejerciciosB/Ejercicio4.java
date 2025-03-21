package tema7.ejerciciosB;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String nombresFileName = "resources/usa_nombres.txt";
        String apellidosFileName = "resources/usa_apellidos.txt";

        System.out.print("¿Cuántos nombres de persona deseas generar? ");
        int numNombres = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.print("Introduce el nombre del archivo para añadir los nombres generados: ");
        String outputFileName = "resources/" + scanner.nextLine();

        List<String> nombres = new ArrayList<>();
        List<String> apellidos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombresFileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                nombres.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(apellidosFileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                apellidos.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName, true))) {
            for (int i = 0; i < numNombres; i++) {
                String nombre = nombres.get(random.nextInt(nombres.size()));
                String apellido = apellidos.get(random.nextInt(apellidos.size()));
                bw.write(nombre + " " + apellido);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Se han generado " + numNombres + " nombres y se han añadido al archivo " + outputFileName);
    }
}
