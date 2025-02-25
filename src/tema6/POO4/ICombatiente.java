package tema6.POO4;

public interface ICombatiente {
    Ataque atacar();
    void defender(Ataque ataque);
    boolean estaVivo();
}
