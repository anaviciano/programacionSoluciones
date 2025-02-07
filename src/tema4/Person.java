package tema4;

public class Person {
    public static final int ADULT_AGE = 18;
    public static final int RETIRED_AGE = 65;
    private final String dni;
    private String name;
    private String surname;
    private int age;

    public Person(String dni, String name, String surname, int age) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean isAdult() {
        return age >= ADULT_AGE;
    }

    public boolean isRetired() {
        return age >= RETIRED_AGE;
    }

    public int ageDifference(Person person) {
        return Math.abs(age - person.age);
    }

    private static char getNIF(int dni) {
        int remainder = dni % 23;
        char letter = ' ';

        switch (remainder) {
            case 0:
                letter = 'T';
                break;
            case 1:
                letter = 'R';
                break;
            case 2:
                letter = 'W';
                break;
            case 3:
                letter = 'A';
                break;
            case 4:
                letter = 'G';
                break;
            case 5:
                letter = 'M';
                break;
            case 6:
                letter = 'Y';
                break;
            case 7:
                letter = 'F';
                break;
            case 8:
                letter = 'P';
                break;
            case 9:
                letter = 'D';
                break;
            case 10:
                letter = 'X';
                break;
            case 11:
                letter = 'B';
                break;
            case 12:
                letter = 'N';
                break;
            case 13:
                letter = 'J';
                break;
            case 14:
                letter = 'Z';
                break;
            case 15:
                letter = 'S';
                break;
            case 16:
                letter = 'Q';
                break;
            case 17:
                letter = 'V';
                break;
            case 18:
                letter = 'H';
                break;
            case 19:
                letter = 'L';
                break;
            case 20:
                letter = 'C';
                break;
            case 21:
                letter = 'K';
                break;
            case 22:
                letter = 'E';
                break;
        }
        return letter;
    }

    private static boolean isValidNIF(int dni, char letter) {
        return getNIF(dni) == Character.toUpperCase(letter);
    }

    public static boolean checkDni(String dni) {
        boolean isValid = false;
        if (dni.length() == 9) {
            char dniLetter = dni.charAt(8);
            String dniNumber = dni.substring(0, 8);
            int dniInt = Integer.parseInt(dniNumber);
            isValid = isValidNIF(dniInt, dniLetter);
        }
        return isValid;
    }

    public void print() {
        System.out.println(this);
    }

    public String toString() {
        return String.format("%s %s, %d años, DNI: %s", name, surname, age, dni);
    }

    public String getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
