package tema3;

public class MyMath {

    public static double squarePerimeter(double side) {
        double perimeter = 0;
        if (side > 0) perimeter = 4 * side;
        return perimeter;
    }

    public static double squareArea(double side) {
        double area = 0;
        if (side > 0) area = side * side;
        return area;
    }

    public static double rectanglePerimeter(double base, double height) {
        double perimeter = 0;
        if (base > 0 && height > 0) perimeter = 2 * base + 2 * height;
        return perimeter;
    }

    public static double rectangleArea(double base, double height) {
        double area = 0;
        if (base > 0 && height > 0) area = base * height;
        return area;
    }

    public static double circlePerimeter(double radius) {
        double perimeter = 0;
        if (radius > 0) perimeter = 2 * Math.PI * radius;
        return perimeter;
    }

    public static double circleArea(double radius) {
        double area = 0;
        if (radius > 0) area = Math.PI * radius * radius;
        return area;
    }

    public static boolean isPrime(int n) {
        boolean isPrime = n >= 2;

        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                isPrime = false;
        }

        return isPrime;
    }

    public static boolean isNotPrime(int number) {
        return !isPrime(number);
    }

    public static int figureCount(int number) {
        int figures = 0;
        if (number != 0) {
            while (number != 0) {
                number /= 10;
                figures++;
            }
        } else {
            figures = 1;
        }
        return figures;
    }

    public static int evenFigureCount(int number) {
        int evenFigures = 0;
        if (number != 0) {
            while (number != 0) {
                if ((number % 10) % 2 == 0) {
                    evenFigures++;
                }
                number /= 10;
            }
        } else {
            evenFigures = 1;
        }
        return evenFigures;
    }

    public static int oddFigureCount(int number) {

        return figureCount(number) - evenFigureCount(number);
    }

    public static int factorial(int number) {
        int fact = 1;
        if (number < 0) fact = 0;
        for (int i = 1; i <= number; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static int factorialRecursive(int number) {
        if (number < 0) return 0;
        if (number == 1 || number == 0) return 1;
        return number * factorial(number - 1);
    }

    public static int quadraticEcuationSolutions(int a, int b, int c) {
        int solutions = 0;
        double discriminant = Math.pow(b, 2) - 4 * a * c;
        if (discriminant > 0) {
            solutions = 2;
        } else if (discriminant == 0) {
            solutions = 1;
        }
        return solutions;
    }

    public static int figuresSumatory(int number) {
        int sum = 0;
        number = Math.abs(number);
        while (number != 0) {
            sum += (number%10);
            number /= 10;
        }
        return sum;
    }
}