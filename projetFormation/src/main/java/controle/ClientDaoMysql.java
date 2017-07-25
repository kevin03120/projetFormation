package src.main.java.controle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import src.main.java.metier.Client;
import src.main.java.metier.User;

public class ClientDaoMysql {
	Connection conn = null;
	Statement state = null;
	ResultSet result = null;
	
	public ClientDaoMysql(Connection connection){
		this.conn=connection;
	}

	public List<Client> getAllClient() {
		Client client = null;
		List<Client> clients = new ArrayList<Client>();
		try {
			
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM client");

			while (result.next()) {
				client=new Client();
				client.setCode(result.getString("id_client"));
				client.setNom(result.getString("nom_client"));
				client.setPrenom(result.getString("prenom_client"));
				String date = result.getString("date_creation");
			    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			    LocalDate dateTime = LocalDate.parse(date, formatter);
			    client.setDate_creation(dateTime);
				if(result.getString("fidelite").equals("0")){
					client.setFidelite(false);
				}else{
					client.setFidelite(true);
				}
				client.setAdresse(result.getString("adresse"));
				client.setTel_fixe(result.getString("tel_fixe"));
				client.setTel_mobile(result.getString("tel_mobile"));
				client.setEmail(result.getString("email"));
				clients.add(client);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}
}
