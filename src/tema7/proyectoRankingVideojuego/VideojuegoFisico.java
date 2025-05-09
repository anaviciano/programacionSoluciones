package tema7.proyectoRankingVideojuego;

public class VideojuegoFisico extends Videojuego implements IJugable {
    private String tiendaCompra;
    private String estado;

    public VideojuegoFisico(String titulo, String plataforma, int nota, String tiendaCompra, String estado) throws NotaInvalidaException {
        super(titulo, plataforma, nota);
        this.tiendaCompra = tiendaCompra;
        this.estado = estado;
    }

    @Override
    public String getTipo() {
        return "Físico";
    }

    @Override
    public void jugarDemo() {
        System.out.println("Jugando demo del videojuego físico: " + titulo);
    }

    @Override
    public String toString() {
        return "Videojuego Físico [Título: " + titulo + ", Plataforma: " + plataforma + ", Nota: " + nota + ", Tienda: " + tiendaCompra + ", Estado: " + estado + "]";
    }
}
