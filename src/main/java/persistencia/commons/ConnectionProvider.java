package persistencia.commons;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	private static Connection connection;
	private static String url = "jdbc:sqlite:/home/martin/Proyectos/eclipse/tp3_tierramedia/tierramedia.db";

	public static Connection getConnection() throws SQLException, ClassNotFoundException, SQLException, IOException {

		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}
		if (connection == null) {
			connection = DriverManager.getConnection(url);
		}
		return connection;
	}

}