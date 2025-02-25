package tema6;

public class Rectangulo extends Figura2D {
    protected double largo;
    protected double ancho;

    public Rectangulo(double largo, double ancho) {
        this.largo = largo;
        this.ancho = ancho;
    }

    @Override
    public double area() {
        return largo * ancho;
    }

    @Override
    public double perimetro() {
        return 2 * (largo + ancho);
    }
}
