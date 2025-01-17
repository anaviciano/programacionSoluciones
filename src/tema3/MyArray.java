package tema3;

import java.util.Scanner;

public class MyArray {

    public static void main(String[] args) {
        System.out.println("Operaciones con arrays:");
        System.out.println("Introduce el primer array: ");
        int[] array1 = readArray();
        System.out.println("Introduce el segundo array: ");
        int[] array2 = readArray();

        Scanner scanner = new Scanner(System.in);
        char option = ' ';
        while (option != 'z') {
            showMenu();
            option = readOption();
            switch (option) {
                case 'a':
                    System.out.print("Array 1: ");
                    print(array1);
                    System.out.print("Array 2: ");
                    print(array2);
                    break;
                case 'b':
                    System.out.println("Máximo del array 1: " + max(array1));
                    System.out.println("Máximo del array 2: " + max(array2));
                    break;
                case 'c':
                    System.out.println("Mínimo del array 1: " + min(array1));
                    System.out.println("Mínimo del array 2: " + min(array2));
                    break;
                case 'd':
                    System.out.println("Promedio del array 1: " + average(array1));
                    System.out.println("Promedio del array 2: " + average(array2));
                    break;
                case 'e':
                    System.out.print("Introduce un valor: ");
                    int value = scanner.nextInt();
                    System.out.println("¿Existe " + value + " en el array 1? " + exist(array1, value));
                    System.out.println("¿Existe " + value + " en el array 2? " + exist(array2, value));
                    break;
                case 'f':
                    int[] added = add(array1, array2);
                    if (added != null) {
                        System.out.print("Array 1 + Array 2: ");
                        print(added);
                    } else {
                        System.out.println("Los arrays no son del mismo tamaño");
                    }
                    break;
                case 'g':
                    int[] substracted = substract(array1, array2);
                    if (substracted != null) {
                        System.out.print("Array 1 - Array 2: ");
                        print(substracted);
                    } else {
                        System.out.println("Los arrays no son del mismo tamaño");
                    }
                    break;
                case 'h':
                    int scalarProduct = scalarProduct(array1, array2);
                    if (scalarProduct != -1) {
                        System.out.println("Producto escalar: " + scalarProduct);
                    } else {
                        System.out.println("Los arrays no son del mismo tamaño");
                    }
                    break;
                case 'i':
                    int[] reversed = reverse(array1);
                    System.out.print("Array 1 invertido: ");
                    print(reversed);
                    reversed = reverse(array2);
                    System.out.print("Array 2 invertido: ");
                    print(reversed);
                    break;
                case 'j':
                    int[] reversed1 = new int[array1.length];
                    reverse(array1, reversed1);
                    System.out.print("Array 1 invertido: ");
                    print(reversed1);
                    int[] reversed2 = new int[array2.length];
                    reverse(array2, reversed2);
                    System.out.print("Array 2 invertido: ");
                    print(reversed2);
                    break;
                case 'k':
                    System.out.println("¿Es capicua el array 1? " + palindromic(array1));
                    System.out.println("¿Es capicua el array 2? " + palindromic(array2));
                    break;
                case 'z':
                    System.out.println("Adiós");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }

        }
    }

    public static void showMenu() {
        System.out.println("Operaciones con arrays:");
        System.out.println("a) Imprimir array");
        System.out.println("b) Valor máximo");
        System.out.println("c) Valor mínimo");
        System.out.println("d) Promedio de los elementos");
        System.out.println("e) Verificar si un valor existe");
        System.out.println("f) Sumar dos vectores");
        System.out.println("g) Restar dos vectores");
        System.out.println("h) Producto escalar de dos vectores");
        System.out.println("i) Invertir el array");
        System.out.println("j) Invertir el array (procedimiento)");
        System.out.println("k) Verificar si el array es capicua");
        System.out.println("z) Salir");
    }


    public static char readOption() {
        System.out.print("Elige una opción: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next().charAt(0);
    }

    public static int[] readArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tamaño del array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Valor " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void print(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++)
            System.out.print(array[i] + ", ");
        System.out.println(array[array.length - 1] + "]");
    }

    public static int max(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++)
            if (array[i] > max)
                max = array[i];
        return max;
    }

    public static int min(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++)
            if (array[i] < min)
                min = array[i];
        return min;
    }

    public static int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++)
            sum += array[i];
        return sum;
    }

    public static double average(int[] array) {
        return (double) sum(array) / array.length;
    }

    public static boolean exist(int[] array, int number) {
        boolean exist = false;
        for (int i = 0; i < array.length && !exist; i++)
            if (array[i] == number)
                exist = true;
        return exist;
    }

    public static int[] add(int[] array1, int[] array2) {
        int[] added;
        if (array1.length == array2.length) {
            added = new int[array1.length];
            for (int i = 0; i < array1.length; i++)
                added[i] = array1[i] + array2[i];
        } else {
            added = null;
        }
        return added;
    }

    public static int[] substract(int[] array1, int[] array2) {
        int[] substracted;
        if (array1.length == array2.length) {
            substracted = new int[array1.length];
            for (int i = 0; i < array1.length; i++)
                substracted[i] = array1[i] - array2[i];
        } else {
            substracted = null;
        }
        return substracted;
    }

    public static int scalarProduct(int[] array1, int[] array2) {
        int scalarProduct = 0;
        if (array1.length == array2.length) {
            for (int i = 0; i < array1.length; i++)
                scalarProduct += array1[i] * array2[i];
        } else {
            scalarProduct = -1;
        }
        return scalarProduct;
    }

    public static int[] reverse(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++)
            reversed[i] = array[array.length - 1 - i];
        return reversed;
    }

    public static void reverse(int[] array, int[] reversed) {
        for (int i = 0; i < array.length; i++)
            reversed[i] = array[array.length - 1 - i];
    }

    public static boolean palindromic(int[] array) {
        boolean palindromic = true;
        for (int i = 0; i < array.length / 2 && palindromic; i++)
            if (array[i] != array[array.length - 1 - i])
                palindromic = false;
        return palindromic;
    }

}
