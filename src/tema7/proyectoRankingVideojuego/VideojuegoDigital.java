package tema7.proyectoRankingVideojuego;

public class VideojuegoDigital extends Videojuego implements IJugable {
    private String tiendaOnline;
    private double tamañoGB;

    public VideojuegoDigital(String titulo, String plataforma, int nota, String tiendaOnline, double tamañoGB) throws NotaInvalidaException {
        super(titulo, plataforma, nota);
        this.tiendaOnline = tiendaOnline;
        this.tamañoGB = tamañoGB;
    }

    @Override
    public String getTipo() {
        return "Digital";
    }

    @Override
    public void jugarDemo() {
        System.out.println("Jugando demo del videojuego digital: " + titulo);
    }

    @Override
    public String toString() {
        return "Videojuego Digital [Título: " + titulo + ", Plataforma: " + plataforma + ", Nota: " + nota + ", Tienda Online: " + tiendaOnline + ", Tamaño: " + tamañoGB + "GB]";
    }
}
