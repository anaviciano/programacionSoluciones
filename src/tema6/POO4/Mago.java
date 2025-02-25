package tema6.POO4;

import java.util.Random;

public class Mago implements ICombatiente {
    private int vida;
    private Random random;

    public Mago(int vida) {
        this.vida = vida;
        this.random = new Random();
    }

    @Override
    public Ataque atacar() {
        int dano = vida / 2; // Más daño cuanto más vida
        String tipoAtaque = random.nextInt(100) < 90 ? "a distancia" : "cuerpo a cuerpo";
        return new Ataque(0, dano, tipoAtaque);
    }

    @Override
    public void defender(Ataque ataque) {
        int danoRecibido = ataque.getTipoAtaque().equals("cuerpo a cuerpo") ? ataque.getDanoFisico() * 2 : ataque.getDanoFisico();
        vida -= danoRecibido;
    }

    @Override
    public boolean estaVivo() {
        return vida > 0;
    }
}
