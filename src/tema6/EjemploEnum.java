package tema6;

public class EjemploEnum {
    public enum Dia {
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
    }
    public static void main(String[] args) {
        Dia dia = Dia.LUNES;
        System.out.println("El día es: " + dia);
    }
}
