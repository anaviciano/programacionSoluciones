package tema6.POO4;

class DVDB extends ItemBiblioteca {
    private String director;
    private int anio;
    private String tipo;

    public DVDB(int numero, String titulo, String director, int anio, String tipo) {
        super(numero, titulo);
        this.director = director;
        this.anio = anio;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + ", Director: " + director + ", Año: " + anio + ", Tipo: " + tipo;
    }
}
