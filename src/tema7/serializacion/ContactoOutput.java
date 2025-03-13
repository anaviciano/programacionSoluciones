package tema7.serializacion;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ContactoOutput {//SERIALIZACION
    private FileOutputStream file;
    private ObjectOutputStream output;

    //Abrir fichero
    public void abrir() throws IOException{

        file = new FileOutputStream("clientes.ser");
        output = new ObjectOutputStream(file);
    }

    //Cerrar el fichero
    public void cerrar() throws IOException{
        if(output!=null)
            output.close();
    }

    //Escribir en el fichero
    public void escribir(Contacto contacto) throws IOException{
        if(output!=null) {
            output.writeObject(contacto);
            System.out.println("contacto escrito correctamente");
        }
    }

}
