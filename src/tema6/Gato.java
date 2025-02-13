package tema6;

public class Gato extends Animal {
    @Override
    public void comer() {
        System.out.println("El gato está comiendo.");
    }

    @Override
    public void dormir() {
        System.out.println("El gato está durmiendo.");
    }

    @Override
    public void hacerRuido() {
        System.out.println("El gato maúlla.");
    }

    public void ronronear() {
        System.out.println("El gato ronronea.");
    }
}
