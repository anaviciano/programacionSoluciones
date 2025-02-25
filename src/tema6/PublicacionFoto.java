package tema6;

public class PublicacionFoto implements IPublicacionConReaccion, IAbrirPublicacion {
    private String foto;

    public PublicacionFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public void publicar() {
        System.out.println("Publicando foto: " + foto);
    }

    @Override
    public void compartir() {
        System.out.println("Compartiendo foto: " + foto);
    }

    @Override
    public void abrir() {
        System.out.println("Abriendo foto: " + foto);
    }

    @Override
    public void comentar(String comentario) {
        System.out.println("Comentario en foto: " + comentario);
    }
}
