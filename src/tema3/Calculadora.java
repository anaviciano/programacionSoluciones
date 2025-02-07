package tema3;

public class Calculadora {

        public static void main(String[] args) {
            int a=2, b=3;
            int res= suma(a,b);
            System.out.println("3+2= "+ res);
        }
        public static int suma(int a, int b){
            return a + b;
        }
        public static int resta(int a, int b){
            return a - b;
        }
    public static boolean esPar(int numero) {

            return numero %2 == 0;
    }


}
