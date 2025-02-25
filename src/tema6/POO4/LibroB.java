package tema6.POO4;

class LibroB extends ItemBiblioteca {
    private String autor;
    private String editorial;

    public LibroB(int numero, String titulo, String autor, String editorial) {
        super(numero, titulo);
        this.autor = autor;
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return super.toString() + ", Autor: " + autor + ", Editorial: " + editorial;
    }
}