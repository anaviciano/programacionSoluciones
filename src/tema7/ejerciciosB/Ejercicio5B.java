package tema7.ejerciciosB;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Ejercicio5B {
    public static void main(String[] args) {
        String inputFileName = "resources/diccionario.txt";
        String outputDirName = "resources/Diccionario";

        // Crear la carpeta 'Diccionario' si no existe
        File outputDir = new File(outputDirName);
        if (!outputDir.exists()) {
            outputDir.mkdir();
        }

        // Crear un mapa para almacenar las palabras por su letra inicial
        Map<Character, BufferedWriter> writers = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            String word;
            while ((word = br.readLine()) != null) {
                char firstLetter = Character.toUpperCase(word.charAt(0));
                if (!writers.containsKey(firstLetter)) {
                    writers.put(firstLetter, new BufferedWriter(new FileWriter(outputDirName + "/" + firstLetter + ".txt")));
                }
                writers.get(firstLetter).write(word);
                writers.get(firstLetter).newLine();
            }

            // Cerrar todos los BufferedWriter
            for (BufferedWriter writer : writers.values()) {
                writer.close();
            }

            System.out.println("La carpeta 'Diccionario' ha sido creada con los archivos correspondientes.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
