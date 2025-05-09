package tema8.actividadesHogwarts;

public class Asignatura {
    private int id;
    private String nombre;
    private String aula;
    private Boolean obligatoria;

    public Asignatura(String nombre, String aula, Boolean obligatoria) {
        this.nombre = nombre;
        this.aula = aula;
        this.obligatoria = obligatoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public Boolean getObligatoria() {
        return obligatoria;
    }

    public void setObligatoria(Boolean obligatoria) {
        this.obligatoria = obligatoria;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", aula='" + aula + '\'' +
                ", obligatoria=" + obligatoria +
                '}';
    }
}
