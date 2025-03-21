package tema7.ejerciciosB;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el nombre del archivo para lectura: ");
        String inputFileName = scanner.nextLine();

        System.out.print("Introduce el nombre del archivo para escritura: ");
        String outputFileName = scanner.nextLine();

        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("resources/" + inputFileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(lines);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("resources/" + outputFileName))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("El contenido ha sido ordenado y escrito en " + outputFileName);
    }
}
