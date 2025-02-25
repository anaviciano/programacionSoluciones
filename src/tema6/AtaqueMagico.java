package tema6;

public class AtaqueMagico implements IAtaque {
    private int coste;
    private int danyo;

    public AtaqueMagico(int coste, int danyo) {
        this.coste = coste;
        this.danyo = danyo;
    }

    @Override
    public void lanzar() {
        System.out.println("Lanzando ataque mágico.");
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
