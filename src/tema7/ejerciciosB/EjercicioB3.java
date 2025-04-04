package Tema7.EjerciciosB;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class EjercicioB3 {

    public static void main(String[] args) throws IOException {

        Scanner read = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("Introduce el nombre del archivo a copiar:");

        String filename = read.nextLine().toLowerCase();

        System.out.println(" ");
        System.out.println("Introduce el nombre del archivo donde volcar la información ordenada:");

        String finalFileName = read.nextLine().toLowerCase();

        Path filePath = Paths.get("/users/ericm/desktop/documentos/" + filename + ".txt");

        File finalFile = new File(finalFileName + ".txt");

        // CREAR ARCHIVO

        try {

            if (finalFile.createNewFile()){

                System.out.println("Se ha creado el archivo " + finalFileName + ".txt");

            } else System.out.println("No se ha podido crear el archivo.");

        } catch (IOException ioe) {

            ioe.printStackTrace();

        }

        // COPIAR ARCHIVO

        try (Stream<String> stream = Files.lines(filePath)){

            List<String> ordered = stream.sorted().toList();

            BufferedWriter output = new BufferedWriter(new FileWriter(finalFile));

            for (String s : ordered) {

                output.write(s);
                output.newLine();

            }

            output.flush();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
