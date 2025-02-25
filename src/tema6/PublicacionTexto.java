package tema6;

public class PublicacionTexto implements IPublicacionConReaccion {
    private String texto;

    public PublicacionTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public void publicar() {
        System.out.println("Publicando texto: " + texto);
    }

    @Override
    public void compartir() {
        System.out.println("Compartiendo texto: " + texto);
    }

    @Override
    public void comentar(String comentario) {
        System.out.println("Comentario en texto: " + comentario);
    }
}
