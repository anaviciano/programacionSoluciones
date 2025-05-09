package tema7.ejercicioFunko;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TiendaFunko {
    private List<Funko> funkos;

    public TiendaFunko() {
        //La aplicación, nada más abrirse,
        // cargará todos los funkos en una colección de objetos Funko (deberás crear la clase).
        this.funkos = loadFunkos("funkos.csv");
    }

    private List<Funko> loadFunkos(String fileName) {
        List<Funko> funkos = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get("resources", fileName))) {
            String line;
            br.readLine(); // Saltar la cabecera
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Funko funko = new Funko(data[0], data[1], data[2], Double.parseDouble(data[3]), LocalDate.parse(data[4]));
                funkos.add(funko);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return funkos;
    }

    private void saveFunkos(String fileName) {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(fileName))) {
            bw.write("COD,NOMBRE,MODELO,PRECIO,FECHA_LANZAMIENTO\n");
            for (Funko funko : funkos) {
                bw.write(String.format("%s,%s,%s,%.2f,%s\n", funko.getCod(), funko.getNombre(), funko.getModelo(), funko.getPrecio(), funko.getFechaLanzamiento()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addFunko(Funko funko) {
        //primero lo añado a la lista
        funkos.add(funko);
        //luego guardo la lista en el fichero
        saveFunkos("funkos.csv");
    }

    public void deleteFunko(String cod) {
        //primero lo borro de la lista
        funkos.removeIf(funko -> funko.getCod().equals(cod));
        //luego guardo la lista en el fichero
        saveFunkos("funkos.csv");
        System.out.println("Funko borrado.");
    }

    public void showAllFunkos() {
        funkos.forEach(System.out::println);
    }

    public void showMostExpensiveFunkoFuncional() {
        Funko mostExpensive = Collections.max(funkos, Comparator.comparingDouble(Funko::getPrecio));
        System.out.println(mostExpensive);
    }
    public void showMostExpensiveFunko() {
        if (funkos.isEmpty()) {
            System.out.println("No hay funkos en la colección.");
            return;
        }

        Funko mostExpensive = funkos.get(0);
        for (Funko funko : funkos) {
            if (funko.getPrecio() > mostExpensive.getPrecio()) {
                mostExpensive = funko;
            }
        }

        System.out.println("El funko más caro es: " + mostExpensive);
    }

    public void showAveragePriceFuncional() {
        double average = funkos.stream().mapToDouble(Funko::getPrecio).average().orElse(0);
        System.out.printf("Precio medio: %.2f\n", average);
    }
    public void showAveragePrice() {
        if (funkos.isEmpty()) {
            System.out.println("No hay funkos en la colección.");
            return;
        }

        double totalPrecio = 0;
        for (Funko funko : funkos) {
            totalPrecio += funko.getPrecio();
        }

        double averagePrecio = totalPrecio / funkos.size();
        System.out.printf("Precio medio: %.2f\n", averagePrecio);
    }

    public void showFunkosByModelFuncional() {
        Map<String, List<Funko>> groupedByModel = funkos.stream().collect(Collectors.groupingBy(Funko::getModelo));
        groupedByModel.forEach((model, funkoList) -> {
            System.out.println("Modelo: " + model);
            funkoList.forEach(System.out::println);
        });
    }
    public void showFunkosByModel() {
        if (funkos.isEmpty()) {
            System.out.println("No hay funkos en la colección.");
            return;
        }

        Map<String, List<Funko>> funkosPorModelo = new HashMap<>();

        // Agrupar los funkos por modelo
        for (Funko funko : funkos) {
            String modelo = funko.getModelo();
            if (!funkosPorModelo.containsKey(modelo)) {
                funkosPorModelo.put(modelo, new ArrayList<>());
            }
            funkosPorModelo.get(modelo).add(funko);
        }

        // Mostrar los funkos agrupados por modelo
        for (Map.Entry<String, List<Funko>> entry : funkosPorModelo.entrySet()) {
            System.out.println("Modelo: " + entry.getKey());
            for (Funko funko : entry.getValue()) {
                System.out.println(funko);
            }
        }
    }

    public void showFunkosFrom2023Funcional() {
        funkos.stream().filter(funko -> funko.getFechaLanzamiento().getYear() == 2023).forEach(System.out::println);
    }
    public void showFunkosFrom2023() {
        if (funkos.isEmpty()) {
            System.out.println("No hay funkos en la colección.");
            return;
        }

        boolean found = false;
        for (Funko funko : funkos) {
            if (funko.getFechaLanzamiento().getYear() == 2023) {
                System.out.println(funko);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No hay funkos lanzados en 2023.");
        }
    }
}
