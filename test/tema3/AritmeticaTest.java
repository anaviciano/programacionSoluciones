package tema3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class AritmeticaTest {
    @Test
    public void testSum() {
        System.out.println("10+10 debe ser 20");
        assertEquals(20, Aritmetica.suma(10,10));
        System.out.println("10+20 debe ser 30");
        assertEquals(30, Aritmetica.suma(10,20));
        System.out.println("20+20 debe ser 40");
        assertEquals(40, Aritmetica.suma(20,20));
    }

    @ParameterizedTest
    @CsvSource({"2,2,4","3,6,9","5,5,10"})
    public void testSum(int a, int b, int esp) {
        System.out.println("csv data "+a+" + "+b+" = "+esp);
        assertEquals(esp, Aritmetica.suma(a,b));
    }

    @ParameterizedTest
    @CsvSource ({"2,Muy Deficiente","4,’insuficiente’","5,’suficiente’"})
    public void NotaTest(int a, String esp) {
        System.out.println("nota "+a+" = "+esp);
        assertEquals(esp, Aritmetica.nota(a));
    }

}