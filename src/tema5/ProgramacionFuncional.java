package tema5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProgramacionFuncional {
    public static void main(String[] args) {
        List<PersonaPF> personas = new ArrayList<>();
        personas.add(new PersonaPF("Juan", 20));
        personas.add(new PersonaPF("Ana", 17));
        personas.add(new PersonaPF("Carlos", 25));
        personas.add(new PersonaPF("Maria", 15));
        personas.add(new PersonaPF("Pedro", 30));
        personas.forEach(p -> System.out.println(p.getNombre()));

        List<PersonaPF> mayoresEdad =
        personas.stream().filter(p -> p.getEdad() >= 18).toList();

        System.out.println("Lista mayores de edad:");
        mayoresEdad.forEach(p -> System.out.println(p.getNombre()));

        boolean hayMayorEdad =
                personas.stream().anyMatch(p -> p.getEdad() >= 18);
        System.out.println("Hay mayores de edad: " + hayMayorEdad);


        int sumaEdades =
        personas.stream().mapToInt(p -> p.getEdad()).sum();
        System.out.println("Suma de edades: " + sumaEdades);

        List<String> nombres =
        personas.stream().map(p -> p.getNombre()).collect(Collectors.toList());
        System.out.println("Nombres: " + nombres);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Operaciones intermedias: filter y map
        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 0) // Filtra números pares
                .map(n -> n * 2)         // Multiplica cada número por 2
                .collect(Collectors.toList()); // Operación terminal: collect

        System.out.println(result); // Salida: [4, 8, 12]
    }
}
