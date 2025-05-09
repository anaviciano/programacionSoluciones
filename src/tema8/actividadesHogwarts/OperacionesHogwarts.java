package tema8.actividadesHogwarts;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
public class OperacionesHogwarts {

        private static String URL;
        private static String USER;
        private static String PASSWORD;

        public static void main(String[] args) {

            // Cargar las propiedades de conexión
            loadDatabaseProperties();

            // Conectar a la base de datos
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

                List<Asignatura> asignaturas = obtenerAsignaturas(conn);
                System.out.println("\nListado de asignaturas:");
                asignaturas.forEach(System.out::println);

                // 1. Consulta de estudiantes por casa
                System.out.println("\nEstudiantes de la casa Gryffindor:");
                mostrarEstudiantesPorCasa(conn, "Gryffindor");

                // 2. Obtener la mascota de un estudiante específico
                System.out.println("\nMascota de Hermione Granger:");
                mostrarMascotaEstudiante(conn, "Hermione", "Granger");

                // 3. Número de estudiantes por casa
                System.out.println("\nNúmero de estudiantes por casa:");
                mostrarNumEstudiantesPorCasa(conn);

                // 4. Insertar una nueva asignatura
                Asignatura asignatura = new Asignatura("Programacion", "Info4", true);
                System.out.println("\nInserción de asignatura:");
                asignatura.setId(insertarAsignatura(conn, asignatura));

                // 5. Modificar el aula de una asignatura
                asignatura.setAula("Info1");
                System.out.println("\nModificación de aula:");
                modificarAula(conn, asignatura);

                // 6. Eliminar una asignatura
                System.out.println("\nEliminación de asignatura:");
                borrarAsignatura(conn, asignatura);

            } catch (SQLException e) {
                System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            }
        }

        private static void loadDatabaseProperties() {
            Properties properties = new Properties();
            //try (InputStream input = OperacionesHogwarts.class.getClassLoader().getResourceAsStream("db.properties")) {
            try (InputStream input = Files.newInputStream(Paths.get("resources/db.properties"))) {
                properties.load(input);
                URL = properties.getProperty("db.url"); //poner URL
                USER = properties.getProperty("db.user"); //poner usuario
                PASSWORD = properties.getProperty("db.password"); //poner contraseña
            } catch (IOException ex) {
                System.err.println("Error al cargar el archivo de propiedades: " + ex.getMessage());
            }
        }

        // 0. Listado Asignaturas
        public static List<Asignatura> obtenerAsignaturas(Connection conn){
            List<Asignatura> asignaturas = new ArrayList<>();
            String sql = "SELECT id_asignatura, nombre, aula, obligatoria FROM Asignatura;";

            try(Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){

                while (rs.next()) {
                    Asignatura asignatura = new Asignatura(
                            //rs.getInt("id_asignatura"),
                            rs.getString("nombre"),
                            rs.getString("aula"),
                            rs.getBoolean("obligatoria")
                    );
                    asignaturas.add(asignatura);
                }
            } catch (SQLException e){
                System.err.println("Error al mostrar asignaturas: " + e.getMessage());
            }
            return asignaturas;
        }

        // 1. Consulta de estudiantes por casa
        public static void mostrarEstudiantesPorCasa(Connection conn, String nombre_casa) {
            String sql = "SELECT e.nombre, e.apellido " +
                    "FROM Estudiante e JOIN Casa c ON c.id_casa = e.id_casa " +
                    "WHERE c.nombre = ? ";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, nombre_casa);

                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        System.out.println(rs.getString("nombre") + " " + rs.getString("apellido"));
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al ejecutar la consulta: " + e.getMessage());
            }
        }

        // 2. Mostrar la mascota de un estudiante específico
        public static void mostrarMascotaEstudiante(Connection conn, String nombre, String apellido) {
            String sql = "SELECT m.nombre, m.especie " +
                    "FROM Mascota m JOIN Estudiante e ON e.id_estudiante = m.id_estudiante " +
                    "WHERE e.nombre = ? AND e.apellido = ? ";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, nombre);
                pstmt.setString(2, apellido);

                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        System.out.println("Mascota: " + rs.getString("nombre") +
                                " - Especie: " + rs.getString("especie"));
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al ejecutar la consulta: " + e.getMessage());
            }
        }

        // 3. Número de estudiantes por casa
        public static void mostrarNumEstudiantesPorCasa(Connection conn) {
            String sql = "SELECT c.nombre, COUNT(e.id_estudiante) AS numEstudiantes " +
                    "FROM Estudiante e JOIN Casa c ON c.id_casa = e.id_casa " +
                    "GROUP BY c.nombre";

            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    System.out.println("Casa: " + rs.getString("nombre") +
                            " - Nº Estudiantes: " + rs.getInt("numEstudiantes"));
                }
            } catch (SQLException e) {
                System.err.println("Error al ejecutar la consulta: " + e.getMessage());
            }
        }

        // 4. Insertar una nueva asignatura
        public static int insertarAsignatura(Connection conn, Asignatura asignatura) {
            int idGenerado = -1;  // Para almacenar el ID de la nueva asignatura
            String sql = "INSERT INTO Asignatura (nombre, aula, obligatoria) VALUES (?, ?, ?)";

            try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstmt.setString(1, asignatura.getNombre());
                pstmt.setString(2, asignatura.getAula());
                pstmt.setBoolean(3, asignatura.getObligatoria());

                int filasAfectadas = pstmt.executeUpdate();
                System.out.println("Filas afectadas al insertar: " + filasAfectadas);

                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        idGenerado = rs.getInt(1);
                    }
                }
                System.out.println("Asignatura insertada con ID: " + idGenerado);
            } catch (SQLException e) {
                System.err.println("Error al insertar la asignatura: " + e.getMessage());
            }
            return idGenerado;
        }

        // 5. Modificar el aula de una asignatura
        public static void modificarAula(Connection conn, Asignatura asignatura) {
            String sql = "UPDATE Asignatura SET aula = ? WHERE id_asignatura = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, asignatura.getAula());
                pstmt.setInt(2, asignatura.getId());

                int filasAfectadas = pstmt.executeUpdate();
                System.out.println("Filas afectadas al modificar: " + filasAfectadas);
            } catch (SQLException e) {
                System.err.println("Error al modificar la asignatura: " + e.getMessage());
            }
        }

        // 6. Eliminar una asignatura
        public static void borrarAsignatura(Connection conn, Asignatura asignatura) {
            String sql = "DELETE FROM Asignatura WHERE id_asignatura = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, asignatura.getId());

                int filasAfectadas = pstmt.executeUpdate();
                System.out.println("Filas borradas: " + filasAfectadas);
            } catch (SQLException e) {
                System.err.println("Error al borrar la asignatura: " + e.getMessage());
            }
        }

}
