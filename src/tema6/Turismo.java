package tema6;

public class Turismo extends Vehiculo {
        private int numeroPlazas;
        private String tipoUso; // "profesional" o "particular"

        public Turismo(String tipo, String marca, String modelo, int anio, int numeroPlazas, String tipoUso) {
            super(tipo, marca, modelo, anio);
            this.numeroPlazas = numeroPlazas;
            this.tipoUso = tipoUso;
        }

        // Getters y setters
        public int getNumeroPlazas() {
            return numeroPlazas;
        }

        public void setNumeroPlazas(int numeroPlazas) {
            this.numeroPlazas = numeroPlazas;
        }

        public String getTipoUso() {
            return tipoUso;
        }

        public void setTipoUso(String tipoUso) {
            this.tipoUso = tipoUso;
        }
}
