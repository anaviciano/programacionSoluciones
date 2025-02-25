package tema5;

public class BirdSighting extends Sighting{
    private double weight;
    private String species;

    public BirdSighting(int hour, double weight, String species) {
        super(hour);
        this.weight = weight;
        this.species = species;
    }

    public String toString() {
        return super.toString() + ", Peso: " + weight + ", Especie: " + species + ", Tipo: Ave";
    }
}
