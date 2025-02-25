package tema6.POO4;

public class Barco extends Transporte {
    private String nombre;
    private String tipoBarco; // Ejemplo: "Carguero", "Crucero"
    private double tonelaje;

    public Barco(String nombre, String tipoBarco, double tonelaje) {
        super("Barco");
        this.nombre = nombre;
        this.tipoBarco = tipoBarco;
        this.tonelaje = tonelaje;
    }

    @Override
    public String toString() {
        return "Barco [Nombre: " + nombre + ", Tipo: " + tipoBarco + ", Tonelaje: " + tonelaje + "]";
    }
}
