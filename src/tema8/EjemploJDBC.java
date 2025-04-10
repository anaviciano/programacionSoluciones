package tema8;
import java.sql.*;
public class EjemploJDBC {
    public static void main(String[] args){
        try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/anavicianofabregat");) {
            //opción1: Statement (NO RECOMENDADO)
            try(Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM personas")){
                while(rs.next()){
                    String dni = rs.getString("dni");
                    String nombre = rs.getString("nombre");
                    System.out.println("personas: " + dni + ", " + nombre);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Saco la consulta fuera, para poderla usar en el PreparedStatement del try
        String sentenciaSQL = "SELECT * FROM personas";
        //opcion 2: PreparedStatement
        try(Connection con2 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/anavicianofabregat");
            PreparedStatement sentencia = con2.prepareStatement(sentenciaSQL)){

            //no hace falta meterlo en el try, porque se cierra automáticamente al cerrarse el PreparedStatement
            ResultSet resultados = sentencia.executeQuery();

            while(resultados.next()){
                String dni = resultados.getString("dni");
                String nombre = resultados.getString("nombre");
                System.out.println("personas: " + dni + ", " + nombre);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
