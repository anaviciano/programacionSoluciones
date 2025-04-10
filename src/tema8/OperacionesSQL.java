package tema8;

        import java.io.IOException;
        import java.io.InputStream;
        import java.nio.file.Files;
        import java.nio.file.Paths;
        import java.sql.*;
        import java.util.Properties;

public class OperacionesSQL {
    private static String URL;
    private static String USER;
    private static String PASSWORD;

    public static void main(String[] args) {

        // Cargar las propiedades de conexión
        loadDatabaseProperties();

        // Conectar a la base de datos
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            // 1. Mostrar vulnerabilidad de SQL Injection
            mostrarSQLInjection(conn, "admin", "' OR '1'='1");

            // 2. Ejecución segura con PreparedStatement
            System.out.println("Ejecución segura con PreparedStatement contra SQL Injection:");
            mostrarSQLSegura(conn, "admin", "' OR '1'='1");
            System.out.println("Ejecución segura con PreparedStatement:");
            mostrarSQLSegura(conn, "admin", "12345");

            // 3. Ejemplo de Inserción
            int nuevoUsuarioId = insertarUsuario(conn, "un_usuario", "password123", "mail@gmail.com");
            mostrarSQLSegura(conn, "un_usuario", "password123");

            // 4. Ejemplo de Modificación
            modificarUsuario(conn, "un_usuario", "newpassword123");

            // Comprobación de la existencia de usuario
            mostrarSQLSegura(conn, "un_usuario", "newpassword123");

            // 5. Ejemplo de Borrado
            borrarUsuario(conn, nuevoUsuarioId);

            // Comprobación de la NO existencia de usuario
            mostrarSQLSegura(conn, "un_usuario", "newpassword123");

        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    private static void loadDatabaseProperties() {
        Properties properties = new Properties();
        //try (InputStream input = OperacionesSQL.class.getClassLoader().getResourceAsStream("db.properties")) {
        try (InputStream input = Files.newInputStream(Paths.get("resources/db.properties"))) {
            properties.load(input);
            URL = properties.getProperty("db.url");
            USER = properties.getProperty("db.user");
            PASSWORD = properties.getProperty("db.password");
        } catch (IOException ex) {
            System.err.println("Error al cargar el archivo de propiedades: " + ex.getMessage());
        }
    }

    // 1. Ejemplo de SQL Injection
    public static void mostrarSQLInjection(Connection conn, String username, String password) {
        try (Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM usuarios WHERE username = '" + username + "' AND password = '" + password + "';";
            System.out.println("Ejecutando consulta vulnerable: " + sql);

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_usuario") +
                        " - Usuario: " + rs.getString("username") +
                        " - Contraseña: " + rs.getString("password"));
            }

            rs.close();
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta: " + e.getMessage());
        }
    }

    // 2. Ejemplo de SQL Seguro con PreparedStatement
    public static void mostrarSQLSegura(Connection conn, String username, String password) {
        try {
            String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            System.out.println("Ejecutando consulta segura: " + sql);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_usuario") +
                        " - Usuario: " + rs.getString("username") +
                        " - Contraseña: " + rs.getString("password"));
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta: " + e.getMessage());
        }
    }

    // 3. Ejemplo de Inserción
    public static int insertarUsuario(Connection conn, String username, String password, String email) {
        int idGenerado = -1;  // Para almacenar el ID del nuevo usuario
        try {
            String sql = "INSERT INTO usuarios (username, password, email) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, email);

            int filasAfectadas = pstmt.executeUpdate();
            System.out.println("Filas afectadas al insertar: " + filasAfectadas);

            // Obtener el ID generado
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                idGenerado = rs.getInt(1);
            }
            rs.close();
            pstmt.close();
            System.out.println("Usuario insertado con ID: " + idGenerado);
        } catch (SQLException e) {
            System.err.println("Error al insertar el usuario: " + e.getMessage());
            return -1;
        }
        return idGenerado;
    }

    // 4. Ejemplo de Modificación
    public static void modificarUsuario(Connection conn, String username, String nuevaPassword) {
        try {
            String sql = "UPDATE usuarios SET password = ? WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nuevaPassword);
            pstmt.setString(2, username);

            int filasAfectadas = pstmt.executeUpdate();
            System.out.println("Filas afectadas al modificar: " + filasAfectadas);
            pstmt.close();
        } catch (SQLException e) {
            System.err.println("Error al modificar el usuario: " + e.getMessage());
        }
    }

    // 5. Ejemplo de Borrado
    public static void borrarUsuario(Connection conn, int idUsuario) {
        try {
            String sqlBorrarUsuario = "DELETE FROM usuarios WHERE id_usuario = ?";
            PreparedStatement pstmtUsuario = conn.prepareStatement(sqlBorrarUsuario);
            pstmtUsuario.setInt(1, idUsuario);
            pstmtUsuario.executeUpdate();
            pstmtUsuario.close();

            System.out.println("Usuario y cuenta borrados con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al borrar el usuario: " + e.getMessage());
        }
    }
}
