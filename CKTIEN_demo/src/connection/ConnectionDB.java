package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

	public static Connection con = null;
	public static ConnectionDB instance = new ConnectionDB();
	public static ConnectionDB getinstance() {
		return instance;
	}
	public void connect() throws SQLException {
		String url="jdbc:sqlserver://localhost:1433;databasename=QLLop";
		con=DriverManager.getConnection(url, "sa", "1");
//		String url = "jbdc:sqlserver://localhost:1433;databasename=QLLop";
//		con = DriverManager.getConnection(url, "sa", "1");
	}
	public void disconnect() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static Connection getConnection() {
		return con;
	}
	
	
}
