package tema6;

enum TipoPlanta {
    ARBOL, ARBUSTO, HIERBA
}
public class Planta {
    private class Hoja {
    }

    private String nombre;
    private TipoPlanta tipo;
    private Hoja[] hojas;


    public Planta(String nombre, TipoPlanta tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Planta(TipoPlanta tipo) {
        this.tipo = tipo;
        hojas = new Hoja[100];
        for(int i=0;i<hojas.length;i++){
            hojas[i] = new Hoja();
        }
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

    public static void main(String[] args) {
        Planta p = new Planta("Rosa", TipoPlanta.ARBUSTO);
        System.out.println(p);
        Planta p1 = new Planta(TipoPlanta.ARBOL);
        System.out.println(p1);
    }
}
