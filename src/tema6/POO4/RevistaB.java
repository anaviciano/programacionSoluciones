package tema6.POO4;

class RevistaB extends ItemBiblioteca {
    private int numeroPublicacion;
    private int anio;

    public RevistaB(int numero, String titulo, int numeroPublicacion, int anio) {
        super(numero, titulo);
        this.numeroPublicacion = numeroPublicacion;
        this.anio = anio;
    }

    @Override
    public String toString() {
        return super.toString() + ", Número de Publicación: " + numeroPublicacion + ", Año: " + anio;
    }
}
