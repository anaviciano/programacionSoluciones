package tema2;

import java.util.Scanner;

public class Exercise15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Indica un mes: ");
        int month = scanner.nextInt();
        System.out.print("Indica un año: ");
        int year = scanner.nextInt();

        int days = 0;

        switch (month) {
            case 2:
                days = 28;
                if (((year % 4 == 0) && !(year % 100 == 0)) || year % 400 == 0) {
                    days = 29;
                }
                break;
            case 4, 6, 9, 11:

                days = 30;
                break;
            default:
                days = 31;
                break;
        }
        System.out.println("Tiene " + days + " días");

        /*
        //Esto también funciona
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                days = 28;
                if (((year % 4 == 0) && !(year % 100 == 0)) || year % 400 == 0) {
                    days = 29;
                }
                break;
            default:
                days = 31;
                break;
        }
        System.out.println("Tiene " + days + " días");
        */


    }

}
