package tema6;

public class Camion extends Vehiculo {
    private double pesoMaximoAutorizado;
    private boolean mercanciaPeligrosa;

    public Camion(String tipo, String marca, String modelo, int anio, double pesoMaximoAutorizado, boolean mercanciaPeligrosa) {
        super(tipo, marca, modelo, anio);
        this.pesoMaximoAutorizado = pesoMaximoAutorizado;
        this.mercanciaPeligrosa = mercanciaPeligrosa;
    }

    // Getters y setters
    public double getPesoMaximoAutorizado() {
        return pesoMaximoAutorizado;
    }

    public void setPesoMaximoAutorizado(double pesoMaximoAutorizado) {
        this.pesoMaximoAutorizado = pesoMaximoAutorizado;
    }

    public boolean isMercanciaPeligrosa() {
        return mercanciaPeligrosa;
    }

    public void setMercanciaPeligrosa(boolean mercanciaPeligrosa) {
        this.mercanciaPeligrosa = mercanciaPeligrosa;
    }
}
