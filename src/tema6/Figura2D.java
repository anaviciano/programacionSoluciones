package tema6;

public abstract class Figura2D {
    public abstract double area();
    public abstract double perimetro();

    @Override
    public String toString() {
        return "Área: " + area() + ", Perímetro: " + perimetro();
    }
}
