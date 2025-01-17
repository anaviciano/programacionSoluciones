package tema3;


    import java.util.Scanner;

    public class WifiCoverageSimulatorMatrix {
        public static final int FLOORS = 12; // Número de plantas
        public static final int ROOMS_PER_FLOOR = 5; // Número de habitaciones por planta

        public static void main(String[] args) {
           String ana = "aAholaAna";
            System.out.println(ana.indexOf("aA", 3));
            System.out.println(ana.substring(4,6));

            int[][] wifiCoverage = new int[FLOORS][ROOMS_PER_FLOOR];
            System.out.println("Simulador de cobertura WiFi en el hotel");

            // Leer las coordenadas del router y la potencia
            System.out.print("Introduce la planta (1-12): ");
            int floor = readNumber(1, FLOORS);
            System.out.print("Introduce la habitación (1-5): ");
            int room = readNumber(1, ROOMS_PER_FLOOR);
            System.out.print("Introduce la potencia del router (1-6): ");
            int power = readNumber(1, 6);

            // Calcular cobertura WiFi
            calculateWifiCoverage(wifiCoverage, floor - 1, room - 1, power);

            // Imprimir el resultado
            printMatrix(wifiCoverage);
        }

        // Leer un número dentro de un rango
        public static int readNumber(int min, int max) {
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            while (number < min || number > max) {
                System.out.println("Valor inválido, debe estar entre " + min + " y " + max + ".");
                number = scanner.nextInt();
            }
            return number;
        }

        // Calcular cobertura WiFi
        public static void calculateWifiCoverage(int[][] wifiCoverage, int floor, int room, int power) {
            // Colocar la potencia inicial en la posición del router
            wifiCoverage[floor][room] = power;

            // Recorrer toda la matriz para calcular la cobertura
            for (int i = 0; i < wifiCoverage.length; i++) {
                for (int j = 0; j < wifiCoverage[i].length; j++) {
                    // Calcular la distancia desde el router
                    int distance = Math.abs(i - floor) + Math.abs(j - room);

                    // Actualizar cobertura si está dentro del alcance
                    if (distance <= power) {
                        int coverageValue = power - distance;
                        wifiCoverage[i][j] = Math.max(wifiCoverage[i][j], coverageValue);
                    }
                }
            }
        }

        // Imprimir la matriz
        public static void printMatrix(int[][] matrix) {
            for (int[] row : matrix) {
                for (int cell : row) {
                    System.out.print(cell + " ");
                }
                System.out.println();
            }
        }
    }


