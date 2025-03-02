package examen2.ejercicio3;

// Clase abstracta Articulo
abstract class Articulo {
    protected String nombre;
    protected boolean gratis;

    public Articulo(String nombre, boolean gratis) {
        this.nombre = nombre;
        this.gratis = gratis;
    }

    public abstract String getTipo();
    public abstract double getPrecio();
}