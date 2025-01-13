package tema3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotasTest {



        @Test
        void testNotaInvalidaMenorQueCero() {
            Notas nota = new Notas();
            assertEquals("Nota inválida", nota.obtenerCalificacion(-1));
        }

        @Test
        void testNotaInvalidaMayorQueDiez() {
            Notas nota = new Notas();
            assertEquals("Nota inválida", nota.obtenerCalificacion(11));
        }

        @Test
        void testNotaInsuficiente() {
            Notas nota = new Notas();
            assertEquals("Insuficiente", nota.obtenerCalificacion(3));
        }

        @Test
        void testNotaSuficiente() {
            Notas nota = new Notas();
            assertEquals("Suficiente", nota.obtenerCalificacion(5));
        }

        @Test
        void testNotaBien() {
            Notas nota = new Notas();
            assertEquals("Bien", nota.obtenerCalificacion(6));
        }

        @Test
        void testNotaNotable() {
            Notas nota = new Notas();
            assertEquals("Notable", nota.obtenerCalificacion(8));
        }

        @Test
        void testNotaSobresaliente() {
            Notas nota = new Notas();
            assertEquals("Sobresaliente", nota.obtenerCalificacion(10));
        }

}