package Tema7.EjerciciosB;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class EjercicioB4 {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        Path names = Paths.get("/users/ericm/desktop/documentos/usa_nombres.txt");

        Path surnames = Paths.get("/users/ericm/desktop/documentos/usa_apellidos.txt");

        File finalFile = new File("usa_personas.txt");

        Random roll = new Random();

        int randomNumber;

        StringBuilder builder = new StringBuilder();

        System.out.println(" ");
        System.out.println("Introduce el número de personas a generar:");

        int timesToRepeat = read.nextInt();

        for (int i = 0; i < timesToRepeat; i++){

            try (Stream<String> streamNames = Files.lines(names)){

                List<String> nameList = streamNames.toList();

                randomNumber = roll.nextInt(0, nameList.size());

                String name = nameList.get(randomNumber);

                try (Stream<String> streamSurnames = Files.lines(surnames)){

                    List<String> surnameList = streamSurnames.toList();

                    randomNumber = roll.nextInt(0, surnameList.size());

                    String surname = surnameList.get(randomNumber);

                    String finalName = String.valueOf(builder.append(name).append(" ").append(surname).append("\n")); //Esto es horrendo

                    BufferedWriter output = new BufferedWriter(new FileWriter(finalFile));

                    output.write(finalName);
//                    output.newLine();

                    output.flush();

                } catch (IOException e) {

                    e.printStackTrace();

                }

            } catch (IOException e) {

                e.printStackTrace();

            }

        }
    }
}