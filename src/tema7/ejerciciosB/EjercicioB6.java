package Tema7.EjerciciosB;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class EjercicioB6 {

    public static void main(String[] args) throws IOException {

        Scanner read = new Scanner(System.in);

        Path piFile = Paths.get("/users/ericm/desktop/documentos/pi-million.txt");

        System.out.println("Introduce un número entero para saber si se encuentra en el primer millón de decimales de pi:");

        String userNum = "";

        try {

            userNum = read.nextLine();

        } catch (Exception e){

            System.out.println(e.getMessage());

        }

        BufferedReader reader = new BufferedReader(new FileReader(piFile.toFile()));

        String piString = String.valueOf(reader.readLine());

        if (piString.contains(userNum)){

            System.out.println("Está dentro.");

        } else System.out.println("No está dentro.");

        reader.close();

    }

}