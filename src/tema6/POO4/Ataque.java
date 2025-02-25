package tema6.POO4;

public class Ataque {
    private int danoFisico;
    private int danoMagico;
    private String tipoAtaque; // "cuerpo a cuerpo" o "a distancia"

    public Ataque(int danoFisico, int danoMagico, String tipoAtaque) {
        this.danoFisico = danoFisico;
        this.danoMagico = danoMagico;
        this.tipoAtaque = tipoAtaque;
    }

    public int getDanoFisico() {
        return danoFisico;
    }

    public int getDanoMagico() {
        return danoMagico;
    }

    public String getTipoAtaque() {
        return tipoAtaque;
    }
}
