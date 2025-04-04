package Tema7.EjerciciosB;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EjercicioB5 {

    public static void main(String[] args) throws IOException {

        File dictionary = new File("Diccionario");

        Path dictionaryPath = Paths.get("/users/ericm/desktop/documentos/diccionario.txt");

        if (dictionary.mkdir()) {

            System.out.println(" ");
            System.out.println("Se ha creado el directorio.");

        }

        File letterFile = new File("/Users/ericm/IdeaProjects/Programacion/Diccionario/A.txt");

        for (char c = 'a'; c <= 'z'; c++){

            letterFile = new File("/Users/ericm/IdeaProjects/Programacion/Diccionario/" + c + ".txt");

            try {

                String character = String.valueOf(c);

                letterFile.createNewFile();

                BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(dictionaryPath)));

                BufferedWriter output = new BufferedWriter(new FileWriter(letterFile));

                while (reader.readLine() != null){

                    String line = reader.readLine();

                    if (line != null){

                        if (line.startsWith(character)){

                            output.write(line);
                            output.newLine();

                        }

                        output.flush();

                    }

                }

                if (c == 'n'){

                    letterFile = new File("/Users/ericm/IdeaProjects/Programacion/Diccionario/Ñ.txt");

                    letterFile.createNewFile();

                }

                System.out.println("Se ha rellenado el archivo " + character + ".");

            } catch (IOException e){

                e.printStackTrace();

            }

        }

        // PARA LA Ñ

        letterFile = new File("/Users/ericm/IdeaProjects/Programacion/Diccionario/ñ.txt");

        BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(dictionaryPath)));

        BufferedWriter output = new BufferedWriter(new FileWriter(letterFile));

        while (reader.readLine() != null){

            String line = reader.readLine();

            if (line != null){

                if (line.startsWith("ñ")){

                    output.write(line);
                    output.newLine();

                }

                output.flush();

            }

        }

        System.out.println("(Y también se ha rellenado la ñ)");

        reader.close();
        output.close();

    }

}