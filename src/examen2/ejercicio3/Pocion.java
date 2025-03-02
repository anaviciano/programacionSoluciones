package examen2.ejercicio3;

class Pocion extends Articulo {
    private int nivel;
    private String[] efectos;

    public Pocion(String nombre, boolean gratis, int nivel, String[] efectos) {
        super(nombre, gratis);
        this.nivel = nivel;
        this.efectos = efectos;
    }

    @Override
    public String getTipo() {
        return "Poción";
    }

    @Override
    public double getPrecio() {
        return gratis ? 0 : 5 * nivel;
    }
}
