package pruebas;
/**
 *
 * @author Ana
 * @version 1
 */
public class Javadoc1 {
    public static void main(String[] args) {
        int res= suma_enteros(5,-2);
        System.out.println("Hello World! -"+res);
        res= suma_enteros(5,3);
        System.out.println("Hello World! -"+res);
    }
    /**
     * variable publica: Una frase para reflexionar
     */
    public String Frase_del_dia = "Carpe diem";
    /**
     * Constructor de clase
     */
    public Javadoc1(){
        System.out.println( "Te aconsejo '" + this.Frase_del_dia + "'" );
    }
    /**
     * Método que suma dos enteros y devuelve el resultado
     * @param a Número entero
     * @param b Número entero
     * @return int Un entero que es el resultado de a + b
     * @deprecated No se aconseja su uso
     */
    // @see suma_enteros(int,int)
    public static int Suma( int a , int b)
    {
        return a + b;
    }
    /**
    * Método que suma dos enteros positivos y devuelve el resultado
    * @param a Número entero
    * @param b Número entero
    * @return int Un número entero que es el resultado de a+b, si los números son negativos devuelve 0
    */
    public static int suma_enteros( int a, int b)
    {
        int resultado = 0;
        if( a>0 && b>0)
            resultado = a + b;
        return resultado;
    }
}

