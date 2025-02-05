package tema6;

enum TipoPlanta {
    ARBOL, ARBUSTO, HIERBA
}
public class Planta {
    private String nombre;
    private TipoPlanta tipo;
    public Planta(String nombre, TipoPlanta tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }
    public TipoPlanta getTipo() {
        return tipo;
    }
    @Override
    public String toString() {
        return "Planta{" +
        "nombre='" + nombre + '\'' +
        ", tipo=" + tipo +
        '}';
    }
}
