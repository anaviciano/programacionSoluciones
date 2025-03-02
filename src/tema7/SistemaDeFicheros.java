package tema7;


import java.io.File;
import java.io.IOException;

public class SistemaDeFicheros {

    public static void main(String[] args) {

        //CLASE FILE
        File fichero = new File("datosAnaPrueba.txt");
        //createNewFile
        try {
            // A partir del objeto File creamos el fichero físicamente
            if (fichero.createNewFile())
                System.out.println("El fichero se ha creado correctamente");
            else
                System.out.println("No ha podido ser creado el fichero");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        //MKDIR
        System.out.println(fichero.getAbsolutePath());
        File dir = new File("NuevaCarpeta");
        //fichero = new File("/Users/anavicianofabregat/intelliJ-workspace/ficheros");
        // Chequear si el directorio puede crearse
        if (dir.mkdir()) {
            // si el directorio se ha creado, devuelve true
            System.out.println("Directory is created");
        }
        else {
            // si el directorio no se ha creado, devuelve false
            System.out.println("Directory cannot be created");
        }

        //DELETE
        if(fichero.exists()){
            System.out.println(fichero.getAbsolutePath());
            if(fichero.delete()){
                System.out.println("Fichero eliminado");
            }  else{
                System.out.println("No se ha podido eliminar");
            }
        }  else{
            System.out.println("El fichero " + fichero.getAbsolutePath() + " no existe");
        }

        //LIST. Muestra el contenido del directorio actual
        File directorio = new File(".");  //directorio actual
        String[] lista = directorio.list();
        System.out.println("Contenido del directorio actual:");
        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i]);
        }

        //LISTFILES
        recorrerDirectorios(".");

        //CANREAD, CANWRITE
        File f = new File("datosAna.txt");

        if (f.canRead())
            System.out.println("Can be Read");
        else
            System.out.println("Cannot be Read");
        if (f.canWrite())
            System.out.println("Can be Write");
        else
            System.out.println("Cannot be Write");

    }
    public static void recorrerDirectorios(String ruta) {
        //Se crea un objeto file con la ruta del directorio
        File directorio = new File(ruta);
        //Se comprueba si la ruta existe
        if (!directorio.exists()) {
            System.out.println("La ruta " + directorio.getAbsolutePath() + " no existe.");
            return;
        }
        //Se comprueba si es un directorio
        if (!directorio.isDirectory()) {
            System.out.println("La ruta " + directorio.getAbsolutePath() + " no es un directorio");
            return;
        }
        System.out.println(directorio.getAbsolutePath());
        //obtener todo el contenido del directorio
        File[] lista2 = directorio.listFiles();
        //se recorre el directorio y se muestran primero los archivos
        System.out.println("Archivos del directorio:");
        for (File s : lista2) {
            if (s.isFile())
                System.out.println("Archivo ->  " + s.getName());
        }
        //se recorre de nuevo el directorio y se obtienen los subdirectorios
        for (File s : lista2) {
            //Si es un directorio se vuelve a llamar al método
            if (s.isDirectory()) {
                System.out.println("Subdirectorios del directorio:");
                recorrerDirectorios(s.getAbsolutePath());
            }
        }
    }
}

