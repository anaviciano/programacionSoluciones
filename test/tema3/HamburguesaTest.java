package tema3;

import org.junit.jupiter.api.Test;
import tema3.Hamburguesa;

import static org.junit.jupiter.api.Assertions.*;

public class HamburguesaTest {

    @Test
    void testCrearHamburguesa() {
        Hamburguesa hamburguesa = new Hamburguesa("Cheeseburger", 5.99);
        assertEquals("Cheeseburger", hamburguesa.getNombre());
        assertEquals(5.99, hamburguesa.getPrecio());
    }

    @Test
    void testSetPrecio() {
        Hamburguesa hamburguesa = new Hamburguesa("Veggie Burger", 7.99);
        hamburguesa.setPrecio(8.49);
        assertEquals(8.49, hamburguesa.getPrecio());
    }

    @Test
    void testSetPrecioNegativo() {
        Hamburguesa hamburguesa = new Hamburguesa("Double Bacon", 9.99);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            hamburguesa.setPrecio(-1.0);
        });
        assertEquals("El precio no puede ser negativo", exception.getMessage());
    }
}