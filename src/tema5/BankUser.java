package tema5;

public class BankUser {
    String name;
    int age;
    String dni;

    public BankUser(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public String toString() {
        return "Nombre: " + name + ", Edad: " + age + ", DNI: " + dni;
    }
}
