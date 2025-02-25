package tema6;

public class Pajaro extends Animal {
    @Override
    public void comer() {
        System.out.println("El pájaro está comiendo.");
    }

    @Override
    public void dormir() {
        System.out.println("El pájaro está durmiendo.");
    }

    @Override
    public void hacerRuido() {
        System.out.println("El pájaro canta.");
    }

    public void volar() {
        System.out.println("El pájaro vuela.");
    }
}
