package Tema7.EjerciciosB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class EjercicioB7 {

    public static void main(String[] args) throws IOException {

        Path bookPath = Paths.get("/users/ericm/desktop/documentos/libros/vida_unamuno.txt");

        BufferedReader reader = new BufferedReader(new FileReader(bookPath.toFile()));

        int lineCount = 0;
        int wordCount = 0;

        HashMap<String, Integer> topWords = new HashMap<>();

        String[] wordArray;
        String line = "";

        while ((line = reader.readLine()) != null){

            lineCount++;

            line = line.replaceAll("áéíóú", "");

            wordArray = line.split(" ");

            wordCount += wordArray.length;

            for (String word : wordArray){

                if (topWords.isEmpty()){

                    topWords.put(word, 1);

                } else {

                    if (topWords.containsKey(word)){

                        int update = topWords.get(word);

                        update++;

                        topWords.put(word, update);

                    } else topWords.put(word, 1);

                }

            }

        }

        System.out.println("Número de líneas: " + lineCount);
        System.out.println("Número de palabras: " + wordCount);

        System.out.println(topWords);

    }

}