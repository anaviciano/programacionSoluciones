package tema5;

public class SnakeSighting extends Sighting{
    private double length;
    private String species;

    public SnakeSighting(int hour, double length, String species) {
        super(hour);
        this.length = length;
        this.species = species;
    }

    public String toString() {
        return super.toString() + ", Longitud: " + length + ", Especie: " + species + ", Tipo: Serpiente";
    }
}
