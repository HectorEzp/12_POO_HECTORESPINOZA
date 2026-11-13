package vallegrande.edu.pe.misistema.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // Cambiamos la base de datos a 'yalpa' y mantenemos el puerto 3308
    private static final String URL = "jdbc:mysql://localhost:3308/yalpa";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";

    public static Connection conectar() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Error: Driver JDBC de MySQL no encontrado.", e);
        }
    }
}