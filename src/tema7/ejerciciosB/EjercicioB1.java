package Tema7.EjerciciosB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EjercicioB1 {

    public static void main(String[] args) throws IOException {

        Path numeros = Paths.get("/users/ericm/desktop/documentos/numeros.txt");

        BufferedReader buffer = new BufferedReader(new FileReader(String.valueOf(numeros)));

        String test;
        int num;
        int numBig = Integer.MAX_VALUE;
        int numSmall = Integer.MIN_VALUE;

        while ((test = buffer.readLine()) != null){

            num = Integer.parseInt(test);

            if (numBig > num){
                
                numBig = num;
                
            } else if (numSmall < num) {

                numSmall = num;

            }
            
        }

        System.out.println(numBig);
        System.out.println(numSmall);

        buffer.close();

    }

}