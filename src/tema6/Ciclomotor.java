package tema6;

public class Ciclomotor extends Vehiculo {
    private int cilindrada;

    public Ciclomotor(String tipo, String marca, String modelo, int anio, int cilindrada) {
        super(tipo, marca, modelo, anio);
        this.cilindrada = cilindrada;
    }

    // Getters y setters
    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    // Método para determinar si necesita carnet
    public boolean necesitaCarnet() {
        return cilindrada >= 125;
    }
}