package tema6;

public class AtaqueEspadazoEncantado implements IAtaqueAvanzado {
    private int costoMana;
    private int costoEsfuerzo;
    private int danoMagico;
    private int danoFisico;

    public AtaqueEspadazoEncantado(int costoMana, int costoEsfuerzo, int danoMagico, int danoFisico) {
        this.costoMana = costoMana;
        this.costoEsfuerzo = costoEsfuerzo;
        this.danoMagico = danoMagico;
        this.danoFisico = danoFisico;
    }

    @Override
    public void lanzar() {
        System.out.println("Lanzando espadazo encantado.");
    }

    @Override
    public int[] coste() {
        return new int[]{costoMana, costoEsfuerzo}; // Cuesta tanto maná como esfuerzo físico
    }

    @Override
    public int[] danoInfligido() {
        return new int[]{danoMagico, danoFisico}; // Inflige tanto daño mágico como físico
    }
}
