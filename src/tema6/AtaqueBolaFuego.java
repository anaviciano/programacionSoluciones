package tema6;

public class AtaqueBolaFuego implements IAtaqueAvanzado {
    private int costoMana;
    private int danoMagico;

    public AtaqueBolaFuego(int costoMana, int danoMagico) {
        this.costoMana = costoMana;
        this.danoMagico = danoMagico;
    }

    @Override
    public void lanzar() {
        System.out.println("Lanzando bola de fuego.");
    }

    @Override
    public int[] coste() {
        return new int[]{costoMana, 0}; // Solo cuesta maná
    }

    @Override
    public int[] danoInfligido() {
        return new int[]{danoMagico, 0}; // Solo inflige daño mágico
    }
}
