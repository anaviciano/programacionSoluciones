package tema6;

public class AtaqueMagicoFisico implements IAtaque {
    private int coste;
    private int danyoMagico;
    private int danyoFisico;

    public AtaqueMagicoFisico(int coste, int danyoMagico, int danyoFisico) {
        this.coste = coste;
        this.danyoMagico = danyoMagico;
        this.danyoFisico = danyoFisico;
    }

    @Override
    public void lanzar() {
        System.out.println("Lanzando ataque mágico y físico.");
    }

    @Override
    public int coste() {
        return coste;
    }

    @Override
    public int danoInfligido() {
        return danyoMagico + danyoFisico;
    }
}
