package tema7;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class LecturaFicherosTexto {

    public static void main(String[] args) {
        String fileName = "datosAna.txt";
        String fileName1 = "/Users/anavicianofabregat/Desktop/datosAna.txt";


        try {
            //Lectura de ficheros de texto

            //Files.lines
            try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
                stream.forEach(System.out::println);
            }

            //Files.readString()
            String content=null;
            try {
                content = Files.readString(Paths.get(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(content);

            //Files.readAllBytes
            content = null;
            try {
                //content = readFile(filePath, StandardCharsets.UTF_8);
                byte[] encoded = Files.readAllBytes(Paths.get(fileName));
                content = new String(encoded, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(content);

            //Files.readAllLines()
            try {
                List<String> lines = Files.readAllLines(Paths.get(fileName));
                System.out.println(lines);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //BufferedReader
            try {
                try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                    String line;
                    System.out.println("bufferedReader");
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //LECTURA DE FICHEROS BINARIOS
        //FileInputStream
        try(FileInputStream fis=new FileInputStream("fichero_bin2.ddr")){
            System.out.println("Leyendo fichero binario con FileInputStream");
            int valor=fis.read();
            while(valor!=-1){
                System.out.print((char)valor);
                valor=fis.read();
            }

        }catch(IOException e){

        }

        //DataInputStream
        //OJO, para que se pueda leer bien, el fichero binario debe haber sido creado con DataOutputStream
        try(DataInputStream dis=new DataInputStream(new FileInputStream("fich_binarioDataOutputStream.ddr"))){
            System.out.println("Leyendo fichero binario con DataInputStream");
            //Leemos un numero y lo mostramos
            System.out.println(dis.readInt());

            //Leemos una cadena y lo mostramos
            System.out.println(dis.readUTF());

            //Leemos un numero y lo mostramos
            System.out.println(dis.readInt());

        }catch(IOException e){
            System.out.println("Error E/S");
            System.out.println(e.getMessage());
        }

        //BufferedInputStream
        try{
            // Creates a FileInputStream
            FileInputStream file = new FileInputStream("fich_binario.ddr");
            System.out.println("Leyendo fichero binario con BufferedInputStream");
            // Creates a BufferedInputStream
            BufferedInputStream input = new BufferedInputStream(file);
            // Reads first byte from file
            int i = input .read();

            while (i != -1) {
                System.out.print((char) i);

                // Reads next byte from the file
                i = input.read();
            }
            input.close();

        }catch(IOException e){
            System.out.println("Error E/S");
        }
    }

}

