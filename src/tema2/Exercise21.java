package tema2;

public class Exercise21 {
    public static void main(String[] args) {
        System.out.println("Sumando los números pares entre 1 y 1000");
        int sumatory = 0;
        for (int number = 1; number <= 1000; number++) {
            if (number % 2 == 0) {
                sumatory += number;
            }
        }
        System.out.println("Resultado: " + sumatory);
    }
}
