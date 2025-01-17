package tema3;

import java.util.Arrays;
import java.util.Scanner;

public class WifiCoverageSimulator {
    public static final int NUM_ROOMS = 20;
    public static void main(String[] args) {
        int[] wifiCoverage = new int[NUM_ROOMS];
        System.out.println("Simulador de cobertura WiFi");
        System.out.print("Introduce el número de habitación (1-20): ");
        int roomNumber = readNumber(1, 20);
        System.out.print("Introduce la potencia de transmisión (1-6): ");
        int power = readNumber(1, 6);
        calculateWifiCoverage(wifiCoverage, roomNumber - 1, power);
        System.out.println(Arrays.toString(wifiCoverage));
    }

    public static int readNumber(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        while (number < min || number > max) {
            System.out.println("Valor inválido, debe estar entre " + min + " y " + max + ".");
            number = scanner.nextInt();
        }
        return number;
    }

    public static void calculateWifiCoverage(int[] wifiCoverage, int room, int transmissionPower) {
        wifiCoverage[room] = transmissionPower;

        for (int i = room - 1; i >= 0; i--) {
            if (wifiCoverage[i + 1] > 0) {
                wifiCoverage[i] = wifiCoverage[i + 1] - 1;
            }
        }

        for (int i = room + 1; i < wifiCoverage.length; i++) {
            if (wifiCoverage[i - 1] > 0) {
                wifiCoverage[i] = wifiCoverage[i - 1] - 1;
            }
        }
    }
}
