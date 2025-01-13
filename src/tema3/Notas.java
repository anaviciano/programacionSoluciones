package tema3;

public class Notas {
    public static void main(String[] args) {

    }

    public String obtenerCalificacion(int nota) {
        if (nota < 0 || nota > 10) {
            return "Nota inválida";
        } else if (nota < 5) {
            return "Insuficiente";
        } else if (nota == 5) {
            return "Suficiente";
        } else if (nota <= 7) {
            return "Bien";
        } else if (nota <= 9) {
            return "Notable";
        } else {
            return "Sobresaliente";
        }
    }
}
