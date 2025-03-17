package tema7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


//import com.opencsv.CSVReader;
//import com.opencsv.exceptions.CsvValidationException;

public class FicherosCSV {

    private final static String COMMA_DELIMITER = ",";

    public static void main(String[] args) throws IOException {

        // Lectura de ficheros CSV con Files.lines en java.nio
        try (Stream<String> contenidoFichero = Files.lines(Paths.get("libros.csv"))) {
            System.out.println("leyendo fichero libros.csv con Files.lines");
            //para cada línea "l", se divide por las comas y se convierte en una lista de String
            List<List<String>> libros1 = contenidoFichero.map(l -> Arrays.asList(l.split(COMMA_DELIMITER))).toList();
            System.out.println(libros1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Lectura de ficheros CSV con BufferedReader en java.io
        List<List<String>> libros2 = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("libros.csv"))) {
            System.out.println("leyendo fichero libros.csv con BufferedReader");
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] libro = linea.split(COMMA_DELIMITER);
                libros2.add(Arrays.asList(libro));
            }
            System.out.println(libros2);
        } catch (IOException e) {
            e.printStackTrace();
        }
/*
        // Lectura de ficheros CSV usando la librería OpenCSV
        List<List<String>> libros3 = new ArrayList<>();
        System.out.println("leyendo fichero libros.csv con OpenCSV");
        try (FileReader fr = new FileReader("libros.csv");
             CSVReader csvReader = new CSVReader(fr)) {
            String[] libro;
            while ((libro = csvReader.readNext()) != null) {
                libros3.add(Arrays.asList(libro));
            }
            System.out.println(libros3);
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
*/

    }



}

