package conectarBd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	public static Connection conectar() {
		
		Connection con = null;
		
		String usuario = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3308/facultad?user=" + usuario
				+ "&password=" + password+"&serverTimezone=UTC";
		try {
			con = DriverManager.getConnection(url);
			if (con != null) {
				System.out.println("Conectado");
			}
		} catch (SQLException e) {
			System.out.println("No se pudo conectar a la base de datos");
			e.printStackTrace();
		}
		return con;
	}
}