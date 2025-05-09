package tema7.ejercicioFunko;

import java.io.Serializable;
import java.time.LocalDate;

public class FunkoSerializacion implements Serializable {
    //el atributo serialVersionUID existe implícitamente aunque no lo declares explícitamente en tu clase
    //Definir un serialVersionUID explícitamente asegura que el identificador único no cambie a menos que tú lo cambies manualmente.
    // Esto ayuda a mantener la compatibilidad entre diferentes versiones de la clase
    //decides agregar un nuevo campo a la clase en una versión futura. Si no defines un serialVersionUID, el compilador generará uno nuevo automáticamente,
    // lo que puede causar problemas de compatibilidad al deserializar objetos antiguos.
    private static final long serialVersionUID = 1L;//tipo long

    private String cod;
    private String nombre;
    private String modelo;
    private double precio;
    private LocalDate fechaLanzamiento;

    public FunkoSerializacion(String cod, String nombre, String modelo, double precio, LocalDate fechaLanzamiento) {
        this.cod = cod;
        this.nombre = nombre;
        this.modelo = modelo;
        this.precio = precio;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    @Override
    public String toString() {
        return "Funko{" +
                "cod='" + cod + '\'' +
                ", nombre='" + nombre + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio +
                ", fechaLanzamiento=" + fechaLanzamiento +
                '}';
    }

}
