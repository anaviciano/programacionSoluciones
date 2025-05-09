package tema7.proyectoRankingVideojuego;
import java.io.Serializable;
public abstract class Videojuego implements Serializable {
    protected String titulo;
    protected String plataforma;
    protected int nota;

    public Videojuego(String titulo, String plataforma, int nota) throws NotaInvalidaException {
        if (nota < 1 || nota > 10) {
            throw new NotaInvalidaException("La nota debe estar entre 1 y 10.");
        }
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.nota = nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getNota() {
        return nota;
    }

    public abstract String getTipo();
}
