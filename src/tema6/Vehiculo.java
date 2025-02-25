package tema6;

import tema6.POO4.Transporte;

public class Vehiculo extends Transporte {
    private String marca;
    private String modelo;
    private int anio;

    /*
    public Vehiculo(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

     */
    //ampliación POO4
    public Vehiculo(String tipo, String marca, String modelo, int anio) {
        super(tipo);
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    // Getters y setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}
