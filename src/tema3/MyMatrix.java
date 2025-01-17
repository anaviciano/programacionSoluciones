package tema3;
public class MyMatrix {

    public static void main(String[] args) {
        // Matriz de ejemplo para las operaciones
        int[][] matrix1 = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        int[][] matrix2 = {
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        };

        System.out.println("Matriz 1:");
        printMatrix(matrix1);

        System.out.println("Máximo de Matriz 1: " + getMax(matrix1));
        System.out.println("Mínimo de Matriz 1: " + getMin(matrix1));
        System.out.println("Media de Matriz 1: " + getMean(matrix1));
        System.out.println("¿Contiene el número 1? " + contains(matrix1, 1));
        System.out.println("Número de ocurrencias del número 1: " + countOccurrences(matrix1, 1));
        System.out.println("¿Es Matriz Identidad? " + isIdentityMatrix(matrix1));

        System.out.println("Suma de Matriz 1 y Matriz 2:");
        printMatrix(addMatrices(matrix1, matrix2));

        System.out.println("Resta de Matriz 2 y Matriz 1:");
        printMatrix(subtractMatrices(matrix2, matrix1));
    }

    // a) Procedimiento que imprime la matriz
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // b) Función que devuelve el máximo de la matriz
    public static int getMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                max = Math.max(max, matrix[i][j]);
            }
        }
        return max;
    }

    // c) Función que devuelve el mínimo de la matriz
    public static int getMin(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                min = Math.min(min, matrix[i][j]);
            }
        }
        return min;
    }

    // d) Función que devuelve la media de la matriz
    public static double getMean(int[][] matrix) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
                count++;
            }
        }
        return (double) sum / count;
    }

    // e) Función que indica si un elemento existe en la matriz
    public static boolean contains(int[][] matrix, int element) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == element) {
                    return true;
                }
            }
        }
        return false;
    }

    // f) Función que devuelve cuántas veces se repite un número en la matriz
    public static int countOccurrences(int[][] matrix, int element) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == element) {
                    count++;
                }
            }
        }
        return count;
    }

    // g) Función que suma dos matrices
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            throw new IllegalArgumentException("Las matrices deben tener el mismo tamaño.");
        }
        int[][] result = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    // h) Función que resta dos matrices
    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            throw new IllegalArgumentException("Las matrices deben tener el mismo tamaño.");
        }
        int[][] result = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    // i) Función que comprueba si una matriz es la matriz identidad
    public static boolean isIdentityMatrix(int[][] matrix) {
        if (matrix.length != matrix[0].length) {
            return false; // No es cuadrada
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j && matrix[i][j] != 1) {
                    return false; // Diagonal principal no contiene 1
                }
                if (i != j && matrix[i][j] != 0) {
                    return false; // Elementos fuera de la diagonal no son 0
                }
            }
        }
        return true;
    }
}
