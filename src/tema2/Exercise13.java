package tema2;

import java.util.Scanner;

public class Exercise13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce hora: ");
        int hour = scanner.nextInt();
        System.out.print("Introduce minuto: ");
        int minute = scanner.nextInt();
        System.out.print("Introduce segundo: ");
        int second = scanner.nextInt();

        int updatedSecond = (second + 1);
        int updatedMinute = minute;
        int updatedHour = hour;
        if (updatedSecond > 59) {
            updatedSecond = 0; // updatedSeconds = updatedSeconds % 60;
            updatedMinute++;
        }
        if (updatedMinute > 59) {
            updatedMinute = 0; // updatedMinutes = updatedMinutes % 60;
            updatedHour++;
        }

        if (updatedHour > 23) {
            updatedHour = 0; // updatedHour = updatedHour % 60;
        }

        System.out.println("Hora actualizada: " + updatedHour + ":" + updatedMinute + ":" + updatedSecond);
    }

}
