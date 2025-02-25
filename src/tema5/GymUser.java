package tema5;

public class GymUser {
    private String name;
    private int age;

    public GymUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Nombre: " + name + ", Edad: " + age;
    }
}
