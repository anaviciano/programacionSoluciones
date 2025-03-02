package examen2.ejercicio3;

class Pokebola extends Articulo {
    public enum Tipo {
        POKEBALL,
        GREAT_BALL,
        ULTRA_BALL;
    }
    private Tipo tipo;

    public Pokebola(String nombre, boolean gratis, Tipo tipo) {
        super(nombre, gratis);
        this.tipo = tipo;
    }

    @Override
    public String getTipo() {
        return "Pokébola";
    }

    @Override
    public double getPrecio() {
        if (gratis) return 0;
        switch (tipo) {
            case GREAT_BALL:
                return 5;
            case ULTRA_BALL:
                return 10;
            default:
                return 2;
        }
    }
}
