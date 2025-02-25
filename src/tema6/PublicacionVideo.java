package tema6;

public class PublicacionVideo implements IPublicacion, IAbrirPublicacion {
    private String video;

    public PublicacionVideo(String video) {
        this.video = video;
    }

    @Override
    public void publicar() {
        System.out.println("Publicando video: " + video);
    }

    @Override
    public void compartir() {
        System.out.println("Compartiendo video: " + video);
    }

    @Override
    public void abrir() {
        System.out.println("Abriendo video: " + video);
    }
}
