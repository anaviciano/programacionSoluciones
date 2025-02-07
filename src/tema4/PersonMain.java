package tema4;

public class PersonMain {

    public static void main(String[] args) {
        Person person = new Person("12345678Z", "John", "Doe", 20);
        System.out.println(person);
        System.out.println(person.isAdult());
        System.out.println(person.isRetired());
        Person person2 = new Person("12345678Z", "Jane", "Doe", 25);
        System.out.println(person.ageDifference(person2));
        System.out.println(Person.checkDni("12345678A"));
        System.out.println(Person.checkDni("12345678Z"));
    }
}
