package tema6.POO4;

import java.util.Random;

public class Guerrero implements ICombatiente {
    private int vida;
    private Random random;

    public Guerrero(int vida) {
        this.vida = vida;
        this.random = new Random();
    }

    @Override
    public Ataque atacar() {
        int dano = random.nextInt(10) + 1;
        return new Ataque(dano, 0, "cuerpo a cuerpo");
    }

    @Override
    public void defender(Ataque ataque) {
        int danoRecibido = ataque.getDanoFisico() / 2;
        vida -= danoRecibido;
    }

    @Override
    public boolean estaVivo() {
        return vida > 0;
    }
}
