package tema7.ejerciciosB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el nombre del archivo: ");
        String fileName = scanner.nextLine();

        int numLines = 0;
        int numWords = 0;
        int numChars = 0;
        HashMap<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                numLines++;
                numChars += line.length();
                String[] words = line.toLowerCase().split("\\W+");
                numWords += words.length;
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Número de líneas: " + numLines);
        System.out.println("Número de palabras: " + numWords);
        System.out.println("Número de caracteres: " + numChars);

        // Convertir el HashMap a una lista de entradas
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordCount.entrySet());

        // Ordenar la lista por el valor (frecuencia) en orden descendente
        Collections.sort(wordList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry2.getValue().compareTo(entry1.getValue());
            }
        });

        // Mostrar las 10 palabras más comunes
        System.out.println("Las 10 palabras más comunes:");
        for (int i = 0; i < 10 && i < wordList.size(); i++) {
            Map.Entry<String, Integer> entry = wordList.get(i);
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
