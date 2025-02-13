package tema6;

public class Perro extends Animal {
    @Override
    public void comer() {
        System.out.println("El perro está comiendo.");
    }

    @Override
    public void dormir() {
        System.out.println("El perro está durmiendo.");
    }

    @Override
    public void hacerRuido() {
        System.out.println("El perro ladra.");
    }

    public void moverCola() {
        System.out.println("El perro mueve la cola.");
    }
}
