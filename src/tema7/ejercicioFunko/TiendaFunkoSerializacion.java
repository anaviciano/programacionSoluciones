package tema7.ejercicioFunko;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TiendaFunkoSerializacion {
    private List<FunkoSerializacion> funkos;

    public TiendaFunkoSerializacion() {

        this.funkos = loadFunkos("resources/funkos.dat");
    }

    //@SuppressWarnings("unchecked")
    private List<FunkoSerializacion> loadFunkos(String fileName) {
        List<FunkoSerializacion> funkos = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            funkos = (List<FunkoSerializacion>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, se creará uno nuevo al guardar.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return funkos;
    }

    private void saveFunkos(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(funkos);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void addFunkoSerializacion(FunkoSerializacion funkoS) {
        funkos.add(funkoS);
        saveFunkos("resources/funkos.dat");
    }

    public void deleteFunko(String cod) {
        funkos.removeIf(funko -> funko.getCod().equals(cod));
        saveFunkos("resources/funkos.dat");
    }

    public void showAllFunkos() {
        funkos.forEach(System.out::println);
    }

    public void showMostExpensiveFunko() {
        if (funkos.isEmpty()) {
            System.out.println("No hay funkos en la colección.");
            return;
        }

        FunkoSerializacion mostExpensive = funkos.get(0);
        for (FunkoSerializacion funko : funkos) {
            if (funko.getPrecio() > mostExpensive.getPrecio()) {
                mostExpensive = funko;
            }
        }

        System.out.println("El funko más caro es: " + mostExpensive);
    }

    public void showAveragePrice() {
        if (funkos.isEmpty()) {
            System.out.println("No hay funkos en la colección.");
            return;
        }

        double totalPrecio = 0;
        for (FunkoSerializacion funko : funkos) {
            totalPrecio += funko.getPrecio();
        }

        double averagePrecio = totalPrecio / funkos.size();
        System.out.printf("Precio medio: %.2f\n", averagePrecio);
    }

    public void showFunkosByModel() {
        if (funkos.isEmpty()) {
            System.out.println("No hay funkos en la colección.");
            return;
        }

        Map<String, List<FunkoSerializacion>> funkosPorModelo = new HashMap<>();

        for (FunkoSerializacion funko : funkos) {
            String modelo = funko.getModelo();
            if (!funkosPorModelo.containsKey(modelo)) {
                funkosPorModelo.put(modelo, new ArrayList<>());
            }
            funkosPorModelo.get(modelo).add(funko);
        }

        for (Map.Entry<String, List<FunkoSerializacion>> entry : funkosPorModelo.entrySet()) {
            System.out.println("Modelo: " + entry.getKey());
            for (FunkoSerializacion funko : entry.getValue()) {
                System.out.println(funko);
            }
        }
    }

    public void showFunkosFrom2023() {
        if (funkos.isEmpty()) {
            System.out.println("No hay funkos en la colección.");
            return;
        }

        boolean found = false;
        for (FunkoSerializacion funko : funkos) {
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
