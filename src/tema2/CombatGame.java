package tema2;

import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.max;

public class CombatGame {
    public static void main(String[] args) {
        final int maxPoints = 500;
        final int randomValues = 10;

        int speed1 = maxPoints;
        int life1 = maxPoints;
        int defense1 = maxPoints;
        int attack1 = maxPoints;

        int speed2 = maxPoints;
        int life2 = maxPoints;
        int defense2 = maxPoints;
        int attack2 = maxPoints;

        Scanner scanner = new Scanner(System.in);

        while (speed1 + life1 + defense1 + attack1 > 500) {
            System.out.println("JUGADOR 1");
            System.out.println("Introduce valores para la velocidad, vida, defensa y ataque. No deben sumar más de 500.");
            System.out.print("Velocidad: ");
            speed1 = scanner.nextInt();
            System.out.print("Vida: ");
            life1 = scanner.nextInt();
            System.out.print("Defensa: ");
            defense1 = scanner.nextInt();
            System.out.print("Ataque: ");
            attack1 = scanner.nextInt();
        }

        while (speed2 + life2 + defense2 + attack2 > 500) {
            System.out.println("JUGADOR 2");
            System.out.println("Introduce valores para la velocidad, vida, defensa y ataque. No deben sumar más de 500.");
            System.out.print("Velocidad: ");
            speed2 = scanner.nextInt();
            System.out.print("Vida: ");
            life2 = scanner.nextInt();
            System.out.print("Defensa: ");
            defense2 = scanner.nextInt();
            System.out.print("Ataque: ");
            attack2 = scanner.nextInt();
        }

        Random random = new Random();
        int i = 1;
        while (life1 > 0 && life2 > 0) {
            System.out.println("*".repeat(200) + "\r\nRONDA " + i++);
            System.out.println("Jugador 1: " + life1 + " " +("-".repeat(max(0, life1))));
            System.out.println("Jugador 2: " + life2 + " " +("-".repeat(max(0, life2))));

            int golpe1 = attack1 - defense2 + random.nextInt(randomValues);
            int golpe2 = attack2 - defense1 + random.nextInt(randomValues);

            if (speed1 > speed2) {
                System.out.println("Jugador 1 golpea primero con " + golpe1 + " de daño");
                life2 -= golpe1;
                if (life2 > 0) {
                    System.out.println("Jugador 2 golpea con " + golpe2 + " de daño");
                    life1 -= golpe2;
                }
            } else {
                System.out.println("Jugador 2 golpea primero con " + golpe2 + " de daño");
                life1 -= golpe2;
                if (life1 > 0) {
                    System.out.println("Jugador 1 golpea con " + golpe1 + " de daño");
                    life2-= golpe1;
                }
            }
            life1 = max(life1, 0);
            life2 = max(life2, 0);
            System.out.println("Jugador 1: " + life1 + " " +("-".repeat(max(0, life1))));
            System.out.println("Jugador 2: " + life2 + " " +("-".repeat(max(0, life2))));
            System.out.println("Introduce cualquier caracter para continuar");
            scanner.next();
        }
        if (life1 <= 0) {
            System.out.println("El jugador 2 ha ganado");
        } else {
            System.out.println("El jugador 1 ha ganado");
        }
    }
}
