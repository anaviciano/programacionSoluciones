package tema5;

public class PersonaPF {
    private String nombre;
    private int edad;

    public PersonaPF(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws Exception{
        if(edad <0){
            throw new Exception("Edad no válida");
        }
            this.edad = edad;
    }
}
