package examen1;
import java.time.Year;
import java.util.Scanner;

public class ExamMain {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {

        char option;
        do {
            System.out.println("(a) Mayores de edad");
            System.out.println("(b) Calculadora de ingresos de canal de Youtube");
            System.out.println("(c) Cálculo horario");
            System.out.println("(d) Salir");
            System.out.print("Introduce una opción: ");
            Scanner scanner = new Scanner(System.in);
            option = scanner.next().charAt(0);
            switch (option) {
                case 'a':
                    System.out.println("Has seleccionado calcular mayores de edad");
                    System.out.print("Introduce los años a leer: ");
                    int years = scanner.nextInt();
                    System.out.println("Hay " + countAdults(years) + " adultos");
                    break;
                case 'b':
                    System.out.println("Has seleccionado la calculadora de ingresos en Youtube");
                    double channelIncome = channelIncome();
                    System.out.println("El canal ha ingresado " + channelIncome + " €");
                    break;
                case 'c':
                    System.out.println("Has seleccionado el cálculo horario");
                    System.out.print("Hora: ");
                    int hour = scanner.nextInt();
                    System.out.print("Minute: ");
                    int minute = scanner.nextInt();
                    System.out.print("AM/PM: ");
                    String dayTime = scanner.next();
                    System.out.print("Huso: ");
                    int timezone = scanner.nextInt();
                    localize(hour, minute, dayTime, timezone);
                    break;
                case 'd':
                    System.out.println("Has seleccionado salir");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (option != 'd');
    }


    public static int countAdults(int totalPeople) {
        int adults = 0;
        int people = 0;
        int currentYear = Year.now().getValue();
        Scanner scanner = new Scanner(System.in);
        while (people < totalPeople) {
            System.out.print("Año de nacimiento " + (people + 1) + ":");
            int year = scanner.nextInt();
            if (year < currentYear) {
                int age = currentYear - year;
                if (age >= 18) {
                    adults++;
                }
                people++;
            } else {
                System.out.println("Año inválido");
            }
        }
        return adults;
    }

    public static double channelIncome() {
        double channelIncome = 0;

        String theme;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Temática del video (asmr, deportes, animales, tecnologia, bebes), fin para salir:");
            theme = scanner.nextLine();
            if (!theme.equals("fin")) {
                System.out.print("Visitas del video:");
                int visits = scanner.nextInt();
                scanner.nextLine(); // Limipar buffer
                channelIncome += videoIncome(theme, visits);
            }
        } while (!theme.equals("fin"));

        return Math.round(channelIncome * 100.0) / 100.0;
    }

    public static double videoIncome(String theme, int visits) {
        double cpm = getCPM(theme);
        return (cpm * visits) / 1000;
    }

    public static double getCPM(String theme) {
        double cpm = 0;
        switch (theme) {
            case "asmr":
                cpm = 0.1;
                break;
            case "deportes":
                cpm = 1.0;
                break;
            case "animales":
                cpm = 0.2;
                break;
            case "tecnologia":
            case "bebes":
                cpm = 0.5;
                break;
        }
        return cpm;
    }

    public static void localize(int hour, int minute, String dayTime, int timezone) {
        if (hour >= 1 && hour <= 12 && minute >= 0 && minute <= 59 && (dayTime.equals("AM") || dayTime.equals("PM")) && timezone >= -11 && timezone <= 12) {
            hour += timezone;
            if (hour > 12) {
                hour = hour % 12;
                dayTime = otherDayTime(dayTime);
            } else if (hour < 1) {
                hour += 12;
                dayTime = otherDayTime(dayTime);
            }
            System.out.println("La hora es: ");
            System.out.println("Hora: " + hour);
            System.out.println("Minutos: " + hour);
            System.out.println(dayTime);
        } else {
            System.out.println("Hay algún valor incorrecto");
        }
    }

    public static String otherDayTime(String dayTime) {
        String otherDayTime = "AM";
        if (dayTime.equals("AM")) {
            otherDayTime = "PM";
        }
        return otherDayTime;
    }

}
