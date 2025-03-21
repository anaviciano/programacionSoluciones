package tema7.ejerciciosB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ejercicio2 {
    public static void main(String[] args) {
        String fileName = "resources/alumnos_notas.txt";
        List<String> students = new ArrayList<>();
        List<Double> averages = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0] + " " + parts[1];
                int sum = 0;
                for (int i = 2; i < parts.length; i++) {
                    sum += Integer.parseInt(parts[i]);
                }
                double average = (double) sum / (parts.length - 2);
                students.add(name);
                averages.add(average);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            indices.add(i);
        }

        Collections.sort(indices, Comparator.comparingDouble(i -> -averages.get(i)));

        for (int index : indices) {
            System.out.printf("%s: %.2f%n", students.get(index), averages.get(index));
        }
    }
}
