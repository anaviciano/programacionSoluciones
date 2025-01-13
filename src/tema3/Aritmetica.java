package tema3;

public class Aritmetica {
    public static void main(String[] args) {
        int a=2, b=3;
        int res= suma(a,b);
        System.out.println("3+2= "+ res);
    }
    public static int suma(int a, int b){
        return a+b;
    }

    public static String nota(int valor){
        if (valor>=0 && valor<=3) {
            return "Muy Deficiente";
        }else if (valor>3 && valor<5) {
            return "Insuficiente";
        }else if (valor>=5 && valor<6) {
            return "Suficiente";
        }else if (valor>=6 && valor<7) {
            return "Bien";
        }else if (valor>=7 && valor<9) {
            return "Notable";
        }else return "SobreSaliente";
    }
}
