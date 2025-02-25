package tema6.POO4;

public class Avion extends Transporte {

        private String modelo;
        private String aerolinea;
        private int capacidad;

    public Avion(String modelo, String aerolinea, int capacidad) {
        super("Avión");
        this.modelo = modelo;
        this.aerolinea = aerolinea;
        this.capacidad = capacidad;
    }

        @Override
        public String toString() {
            return "Avión [Modelo: " + modelo + ", Aerolínea: " + aerolinea + ", Capacidad: " + capacidad + "]";
        }

}
