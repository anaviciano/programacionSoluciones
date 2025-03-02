package examen2.ejercicio2;

public class Bill implements IMoney {
    private int value;

    public Bill(int value) {
        this.value = value;
    }
    @Override
    public double value() {
        return value;
    }
}
