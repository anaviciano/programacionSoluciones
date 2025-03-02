package examen2.ejercicio3;

class Accesorio extends Articulo {
    public Accesorio(String nombre, boolean gratis) {
        super(nombre, gratis);
    }

    @Override
    public String getTipo() {
        return "Accesorio";
    }

    @Override
    public double getPrecio() {
        return gratis ? 0 : 7;
    }
}
