package tema6;

public class AtaqueFisico implements IAtaque {
    private int coste;
    private int danyo;

    public AtaqueFisico(int coste, int danyo) {
        this.coste = coste;
        this.danyo = danyo;
    }

    @Override
    public void lanzar() {
        System.out.println("Lanzando ataque físico.");
    }

    @Override
    public int coste() {
        return coste;
    }

    @Override
    public int danoInfligido() {
        return danyo;
    }
}
