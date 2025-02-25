package tema6;

public class AtaqueEspadazo implements IAtaqueAvanzado {
    private int costoEsfuerzo;
    private int danoFisico;

    public AtaqueEspadazo(int costoEsfuerzo, int danoFisico) {
        this.costoEsfuerzo = costoEsfuerzo;
        this.danoFisico = danoFisico;
    }

    @Override
    public void lanzar() {
        System.out.println("Lanzando espadazo.");
    }

    @Override
    public int[] coste() {
        return new int[]{0, costoEsfuerzo}; // Solo cuesta esfuerzo físico
    }

    @Override
    public int[] danoInfligido() {
        return new int[]{0, danoFisico}; // Solo inflige daño físico
    }
}
