package tema6;

public class Revista extends Ficha {
    private int numeroPublicacion;
    private int anio;

    public Revista(int numero, String titulo, int numeroPublicacion, int anio) {
        super(numero, titulo);
        this.numeroPublicacion = numeroPublicacion;
        this.numeroPublicacion = numeroPublicacion;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return super.toString() + ", Número de Publicación: " + numeroPublicacion + ", Año: " + anio;
    }
}
