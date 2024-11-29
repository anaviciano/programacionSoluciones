package examen1;


import java.util.Scanner;

public class SimulacroExamen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Aprobados y suspendidos");
            System.out.println("2. Billetes a Madrid");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    aprobadosYSuspendidos();
                    break;
                case 2:
                    billetesAMadrid();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 3);

        //scanner.close();

        ejercicio2();
    }

    //Método para el ejercicio2
    public static void ejercicio2(){
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Conversor de Horas entre Japón y España ---");
            System.out.println("1. Convertir hora");
            System.out.println("2. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            System.out.println(opcion);
            scanner.nextLine();  // Consumir nueva línea

            if (opcion == 1) {
                System.out.print("Introduce el país de origen (España o Japón): ");
                String paisOrigen = scanner.nextLine().trim().toLowerCase();

                System.out.print("Introduce la hora (formato 24 horas, HH MM): ");
                int horas = scanner.nextInt();
                int minutos = scanner.nextInt();
                scanner.nextLine();  // Consumir nueva línea

                if (!esHoraValida(horas, minutos)) {
                    System.out.println("Hora no válida. Debe ser entre 00:00 y 23:59.");
                    continue;
                }

                System.out.print("Introduce el día de la semana: ");
                String dia = scanner.nextLine().trim().toLowerCase();

                // Establecer la diferencia horaria
                int diferencia = 0;
                if (paisOrigen.equals("españa")) {
                    diferencia = 8; // Japón tiene 8 horas más que España
                } else if (paisOrigen.equals("japón")) {
                    diferencia = -8; // España tiene 8 horas menos que Japón
                } else {
                    System.out.println("País no válido. Debes introducir 'España' o 'Japón'.");
                    continue;
                }

                // Convertir la hora
                int[] resultado = convertirHora(horas, minutos, diferencia);
                int horasConvertidas = resultado[0];
                int minutosConvertidos = resultado[1];
                int cambioDia = resultado[2];

                // Cambiar el día si es necesario
                String diaConvertido = cambiarDia(dia, cambioDia);

                // Mostrar el resultado
                if (paisOrigen.equals("españa")) {
                    System.out.printf("Hora en Japón: %02d:%02d → %s%n", horasConvertidas, minutosConvertidos, diaConvertido);
                } else {
                    System.out.printf("Hora en España: %02d:%02d → %s%n", horasConvertidas, minutosConvertidos, diaConvertido);
                }
            } else if (opcion != 2) {
                System.out.println("Opción no válida. Inténtalo de nuevo.");
            }

        } while (opcion != 2);

        System.out.println("Programa finalizado.");
        scanner.close();
    }

    // Método para validar que la hora introducida sea válida (formato 24 horas)
    public static boolean esHoraValida(int horas, int minutos) {
        return (horas >= 0 && horas < 24 && minutos >= 0 && minutos < 60);
    }

    // Método para sumar o restar horas entre países
    public static int[] convertirHora(int horas, int minutos, int diferencia) {
        int horasConvertidas = horas + diferencia;
        int diaCambio = 0; // Si hay cambio de día (0: mismo día, 1: día siguiente, -1: día anterior)

        if (horasConvertidas >= 24) {
            horasConvertidas -= 24;
            diaCambio = 1;
        } else if (horasConvertidas < 0) {
            horasConvertidas += 24;
            diaCambio = -1;
        }

        return new int[] {horasConvertidas, minutos, diaCambio};
    }

    // Método para cambiar el día de la semana
    public static String cambiarDia(String dia, int cambioDia) {
        String[] diasSemana = {"lunes", "martes", "miércoles", "jueves", "viernes", "sábado", "domingo"};
        int indiceDia = -1;

        // Buscar el índice del día introducido
        for (int i = 0; i < diasSemana.length; i++) {
            if (diasSemana[i].equalsIgnoreCase(dia)) {
                indiceDia = i;
                break;
            }
        }

        // Si el día no es válido, lo dejamos igual
        if (indiceDia == -1) {
            return dia;
        }

        // Cambiar el día de acuerdo con el cambio de día
        indiceDia = (indiceDia + cambioDia + 7) % 7; // El +7 y %7 asegura que no haya índices negativos

        return diasSemana[indiceDia];
    }


    // Método para la opción A: Aprobados y suspendidos
    public static void aprobadosYSuspendidos() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Cuántas notas vas a introducir?: ");
        int n = scanner.nextInt();

        int aprobados = 0;
        int suspendidos = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Introduce la nota " + i + ": ");
            double nota = scanner.nextDouble();

            if (nota >= 5) {
                aprobados++;
            } else {
                suspendidos++;
            }
        }

        System.out.println("Número de aprobados: " + aprobados);
        System.out.println("Número de suspendidos: " + suspendidos);

        if (aprobados > suspendidos) {
            System.out.println("Hay más aprobados que suspendidos.");
        } else if (suspendidos > aprobados) {
            System.out.println("Hay más suspendidos que aprobados.");
        } else {
            System.out.println("Hay la misma cantidad de aprobados y suspendidos.");
        }
    }

    // Método para la opción B: Billetes a Madrid
    public static void billetesAMadrid() {
        Scanner scanner = new Scanner(System.in);
        final double PRECIO_NORMAL = 32.0;
        double totalCoste = 0.0;

        //esta mi
        System.out.print("¿Cuántos miembros tiene la familia?: ");
        int numMiembros = scanner.nextInt();
        scanner.nextLine();  // Consumir nueva línea después del entero

        for (int i = 1; i <= numMiembros; i++) {
            System.out.print("Introduce el nombre del miembro " + i + ": ");
            String nombre = scanner.nextLine();

            System.out.print("Introduce la edad de " + nombre + ": ");
            int edad = scanner.nextInt();
            scanner.nextLine();  // Consumir nueva línea después del entero

            double precioBillete = PRECIO_NORMAL;

            // Calcular el descuento según la edad
            if (edad >= 65) {
                precioBillete -= PRECIO_NORMAL * 0.10;  // 10% de descuento
            } else if (edad >= 12 && edad <= 15) {
                precioBillete -= PRECIO_NORMAL * 0.08;  // 8% de descuento
            } else if (edad >= 4 && edad <= 11) {
                precioBillete -= PRECIO_NORMAL * 0.35;  // 35% de descuento
            } else if (edad < 4) {
                precioBillete = 0.0;  // Gratis
            }

            System.out.println("El precio del billete para " + nombre + " es: " + precioBillete + " euros.");
            totalCoste += precioBillete;
        }

        System.out.println("El coste total de los billetes para la familia es: " + totalCoste + " euros.");
    }
}



