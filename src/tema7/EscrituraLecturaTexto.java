package tema7;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;



public class EscrituraLecturaTexto {
    public static void main(String[] args) {
        String fileName = "datosAna.txt";
        String fileName1 = "/Users/anavicianofabregat/Desktop/datosAna.txt";
        Path filePath = Paths.get("datosAna.txt");


        //Files.writeString
        try {
            //Escribe contenido al fichero, borrando todo lo que haya
            Files.writeString(filePath, "Aquí escribo borrando todo el contendio anterior");
            //Escribe contenido al fichero, añadiendolo al final del mismo
            Files.writeString(filePath, "Aquí escribo añadiendo al final", StandardOpenOption.APPEND);

            //Verify file content
            String content = Files.readString(filePath);

            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Files.write
        try {
            Files.write(Paths.get(fileName), "Aquí el texto".getBytes(), StandardOpenOption.APPEND);
            String content = Files.readString(filePath);

            System.out.println(content);
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //FileWriter.write
        FileWriter fileWriter = null;
        try {
            //Creo los objetos, abro streams
            //De esta manera escribirá en el fichero borrando todo lo que haya
            fileWriter = new FileWriter(fileName);
            //De esta manera le indicamos que queremos que AÑADA al final del fichero sin borrar lo que haya en el fichero
            //fileWriter = new FileWriter(fileName, true);

            //Escribimos en el fichero unos caracteres  (ABC)
            fileWriter.write(65);
            fileWriter.write(66);
            fileWriter.write(67);
            //Guardamos los cambios del fichero
            fileWriter.flush();
            //Leemos el fichero y lo mostramos por pantalla
            FileReader fReader=new FileReader("datosAna.txt");
            int valor=fReader.read();
            while(valor!=-1){
                System.out.print((char)valor);
                valor=fReader.read();
            }
            //String content = Files.readString(filePath);
            //System.out.println(content);

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (fileWriter != null) {
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //BufferedWriter

        try {
            //De esta manera cada vez que escribimos, se machaca toda la info que había dentro del fichero
            FileWriter file = new FileWriter("datosAna.txt");
            //De esta manera, lo estamos AÑADIENDO al final del fichero
            FileWriter fileAppend = new FileWriter("datosAna.txt", true);

            BufferedWriter output = new BufferedWriter(file);
            BufferedWriter outputAppend = new BufferedWriter(fileAppend);
            // Escribimos el String en el fichero
            //Escribimos
            output.write("escribimos con Buffered");
            outputAppend.write("añadimos con Buffered");
            // Cerramos el writer
            output.close();
            outputAppend.close();
            //Leemos

            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        //PrintWriter
        PrintWriter writerObj1 =null;
        try {
            writerObj1 = new PrintWriter(new File("datosAna.txt"));

            writerObj1.write("prueba de escritura");//escribe y machaca lo que había en el fichero

            writerObj1.flush();

            writerObj1.close();

            List<String> lines = Files.readAllLines(Paths.get(fileName));
            System.out.println(lines);
        }
        catch (Exception e) {
            e.getStackTrace();
        }

        //ESCRITURA DE FICHEROS BINARIOS


        //FileOutputStream
        //si no existe, lo crea
        try(FileOutputStream fos=new FileOutputStream("fichero_bin2.ddr")){

            String texto="Esto es una prueba para ficheros binariosssss";

            //Copiamos el texto en un array de bytes
            byte codigos[]=texto.getBytes();

            fos.write(codigos);

        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        //DataOutputStream
        try(DataOutputStream dos=new DataOutputStream(new FileOutputStream("fich_binarioDataOutputStream.ddr"));){
            System.out.println("Escribiendo fichero binario con DataOutputStream");
            //Escribimos un numero
            dos.writeInt(23);

            //Escribimos una cadena
            dos.writeUTF("Fernando");

            //Escribimos un numero
            dos.writeInt(1990);

        }catch(IOException e){
            System.out.println("Error E/S");
        }

        //BufferedOutputStream
        String data = "This is a line of text inside the file";

        try {
            // Creates a FileOutputStream
            FileOutputStream file = new FileOutputStream("fich_binario.ddr");

            // Creates a BufferedOutputStream
            BufferedOutputStream output = new BufferedOutputStream(file);

            byte[] array = data.getBytes();

            // Writes data to the output stream
            output.write(array);
            output.close();
        }

        catch (Exception e) {
            e.getStackTrace();
        }

    }
}
