package src.main.java.entite.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import src.main.java.entite.User;

public class UserDaoMysql {
	Connection conn = null;
	Statement state = null;
	ResultSet result = null;
	
	public UserDaoMysql(Connection connection){
		this.conn=connection;
	}

	public List<User> getAllUser() {
		User user = null;
		List<User> users = new ArrayList<User>();
		try {
			
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM user");

			while (result.next()) {
				user=new User();
				user.setNom(result.getString("nom_user"));
				user.setMdp(result.getString("mdp_user"));
				users.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	


}
