package tema6.POO4;

abstract class ItemBiblioteca {
    private int numero;
    private String titulo;

    public ItemBiblioteca(int numero, String titulo) {
        this.numero = numero;
        this.titulo = titulo;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "Número: " + numero + ", Título: " + titulo;
    }
}