package src.main.java.controle.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GlobalConnection {

	private String url = "jdbc:mysql://localhost:3306/luna";
	private String user = "root";
	private String passwd = "";
	private static Connection connect;

	private GlobalConnection() {
		try {
			connect = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getInstance(){
		if(connect == null){
			new GlobalConnection();
		}
		return connect;
	}
}
