package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    // Pon aquí tu URL real de Turso
    private static final String DB_URL = "libsql://sistemaoptica-nadie-n.aws-us-east-2.turso.io"; 
    // Pon aquí tu NUEVO token (recuerda generar uno nuevo por seguridad)
    private static final String TOKEN = "eyJhbGciOiJFZERTQSIsInR5cCI6IkpXVCJ9.eyJhIjoicnciLCJpYXQiOjE3OTM1MDU5MDcsImlkIjoiMDFhMTk1NDYtM2EwMS03YzI4LTk2MzMtOTUwMjYyOWVmZmRjIiwia2lkIjoiZ3J5T0lHTEswUnpCSHZyd2Y4cVdQLUlGNGtUaDRHb0JkY2RSd3p0R0xlTSIsInJpZCI6ImUwMmJjZTRkLWU5NjYtNDNlOC05MzA1LTRhZWE2OTc0MmU1NSJ9.HlOyB08oh28frO6Yv1Onqs5MoHDRET1z4WthlOmlNtroAxnzRkfQVRiUL_W2l40bMshRIFSCcsIKLrnp7B1yBA"; 

    public static Connection getConexion() throws SQLException {
        try {
            // Aseguramos que el driver de LibSQL esté cargado
            Class.forName("com.dbeaver.jdbc.driver.libsql.LibSqlDriver");
            
            // Retornamos la conexión
            return DriverManager.getConnection("jdbc:dbeaver:libsql:" + DB_URL, null, TOKEN);
            
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontró el driver de LibSQL. Revisa tus librerías.", e);
        }
    }
}