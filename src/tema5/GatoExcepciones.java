package tema5;

public class GatoExcepciones {
    private String nombre;
    private int edad;

    // Constructor con parámetros
    public GatoExcepciones(String nombre, int edad) throws Exception {
        setNombre(nombre);
        setEdad(edad);
    }

    // Getter para nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para nombre
    public void setNombre(String nombre) throws Exception {
        if (nombre.length() < 3) {
            throw new Exception("El nombre debe tener al menos 3 caracteres." + nombre);
        }
        this.nombre = nombre;
    }

    // Getter para edad
    public int getEdad() {
        return edad;
    }

    // Setter para edad
    public void setEdad(int edad) throws Exception {
        if (edad < 0) {
            throw new Exception("La edad no puede ser negativa.");
        }
        this.edad = edad;
    }

    // Método para imprimir los datos del gato
    public void imprimir() {
        System.out.println("Nombre: " + nombre + ", Edad: " + edad);
    }
}
