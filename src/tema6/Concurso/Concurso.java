package tema6.Concurso;

import java.util.ArrayList;
import java.util.List;

public class Concurso {
    Celda[][] cuadricula = new Celda[10][10];
    List<String> premiosGanados = new ArrayList<>();

    public Concurso() {
        // Inicializar la cuadricula con preguntas y regalos
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Pregunta pregunta = new Pregunta("multiple", "¿Cuál es la capital de Francia?", new String[]{"París", "Londres", "Roma"}, "París");
                cuadricula[i][j] = new Celda(pregunta, "Regalo " + (i * 10 + j + 1));
            }
        }
    }
    public void mostrarPregunta(int fila, int columna) {
        cuadricula[fila][columna].pregunta.mostrarPregunta();
    }

    public void jugar(int fila, int columna, String respuesta) {
        Celda celda = cuadricula[fila][columna];
        if (!celda.respondida) {
            if (celda.pregunta.esCorrecta(respuesta)) {
                premiosGanados.add(celda.regalo);
                celda.respondida = true;
                System.out.println("¡Correcto! Has ganado: " + celda.regalo);
            } else {
                System.out.println("Incorrecto. Fin del concurso.");
                mostrarPremiosGanados();
            }
        } else {
            System.out.println("Esta celda ya ha sido respondida.");
        }
    }

    public void mostrarPremiosGanados() {
        System.out.println("Premios ganados:");
        for (String premio : premiosGanados) {
            System.out.println(premio);
        }
    }
}
