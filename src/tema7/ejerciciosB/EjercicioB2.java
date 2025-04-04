package Tema7.EjerciciosB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class EjercicioB2 {

    public static void main(String[] args) throws IOException {

        Path notas = Paths.get("/users/ericm/desktop/documentos/alumnos_notas.txt");

        BufferedReader buffer = new BufferedReader(new FileReader(String.valueOf(notas)));

        String test;
        String[] alumno;
        double media = 0;
        int counter = 0;
        String finalName;
        HashMap<Double, String> finalMap = new HashMap<>();

        while ((test = buffer.readLine()) != null){

            alumno = test.split(" ");

            for (int i = 0; i < 1; i++){

                for (int j = 2; j < alumno.length; j++){

                    counter++;
                    media += Integer.parseInt(alumno[j]);

                }

                media /= counter;

                StringBuilder builder = new StringBuilder();

                finalName = String.valueOf(builder.append(alumno[0]).append(" ").append(alumno[1]));

                finalMap.put(media, finalName);

                counter = 0;
                media = 0;

            }
        }

        finalMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

    }
}