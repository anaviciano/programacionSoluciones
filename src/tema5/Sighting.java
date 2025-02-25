package tema5;

public class Sighting {
    int hour;

    public Sighting(int hour) {
        this.hour = hour;
    }

    public String toString() {
        return "Avistamiento - Hora: " + hour;
    }

    public int getHour() {
        return hour;
    }
}
