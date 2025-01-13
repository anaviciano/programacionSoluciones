package tema3;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {
    @BeforeAll
    public static void setUpClass() {
        System.out.println("beforeall");
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("afterall");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("beforeeach");

    }

    @AfterEach
    public void tearDown() {
        System.out.println("aftereach");
    }
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Calculadora.main(args);
    }
    @Test
    public void testSuma() {
        System.out.println("suma");
        int a = 1;
        int b = 2;
        int expResult = 3;
        int result = Calculadora.suma(a, b);
        assertEquals(expResult, result);
    }
    @Test
    public void testSuma_1() {
        System.out.println("suma1");
        int a = -2;
        int b = -5;
        int expResult = -7;
        int result = Calculadora.suma(a, b);
        assertEquals(expResult, result);
    }
    @Test
    public void testResta() {
        System.out.println("resta0");
        int a = 0;
        int b = 0;
        int expResult = 0;
        int result = Calculadora.resta(a, b);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSuma_11() {
        System.out.println("suma11");
        int a = 5;
        int b = 4;
        int expResult = 9;
        int result = Calculadora.suma(a, b);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    @Test
    public void testSuma_2() {
        System.out.println("suma2");
        int a = 3;
        int b = 2;
        int expResult = 5;
        int result = Calculadora.suma(a, b);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testResta_3() {
        System.out.println("resta3");
        int a = 5;
        int b = 2;
        int expResult = 3;
        int result = Calculadora.resta(a, b);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testResta_4() {
        System.out.println("resta4");
        int a = 2;
        int b = -2;
        int expResult = 0;
        int result = Calculadora.resta(a, b);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @ParameterizedTest
    @ValueSource(ints = { 2, 3, 4, 5})
    public void testEsPar(int n) {
        System.out.println("esPar");
        assertTrue(Calculadora.esPar(n));
    }


}