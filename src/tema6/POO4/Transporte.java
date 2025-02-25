package tema6.POO4;

public abstract class Transporte {
    private String tipo;

    public Transporte(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo;
    }
}
