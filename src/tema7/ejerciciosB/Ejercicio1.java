package tema7.ejerciciosB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio1 {
    public static void main(String[] args) {
        String fileName = "resources/numeros.txt";
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                int number = Integer.parseInt(line);
                if (number > max) {
                    max = number;
                }
                if (number < min) {
                    min = number;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("El valor máximo es: " + max);
        System.out.println("El valor mínimo es: " + min);
    }
}
