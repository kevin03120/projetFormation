package src.main.java.entite.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import src.main.java.entite.Client;
import src.main.java.entite.User;

public class ClientDaoMysql {
	Connection conn = null;
	Statement state = null;
	ResultSet result = null;
	
	public ClientDaoMysql(Connection connection){
		this.conn=connection;
	}

	public void deleteClient(String code) {
		try {
			state = conn.createStatement();
			int a = state.executeUpdate("DELETE FROM client WHERE id_client = " + code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addClient(Client c) {
		try {
			state = conn.createStatement();
			String fidelite;
			if(c.isFidelite()){
				fidelite = "TRUE";
			}else{
				fidelite = "FALSE";
			}
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.now();
			int a = state.executeUpdate("INSERT INTO `client`(`id_client`, `nom_client`, `prenom_client`, `date_creation`, `fidelite`, `adresse`, `tel_fixe`, `tel_mobile`, `email`, `remarques`) VALUES ('"+c.getCode() +"','"+c.getNom()+"','" + c.getPrenom() + "','"+dtf.format(localDate)+"',"+ fidelite + ",'"+c.getAdresse() + "','" + c.getTel_fixe() + "','"+c.getTel_mobile() + "','" + c.getEmail() + "','" + c.getRemarques() + "');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Client> getClientParCode(String code){
		Client client = null;
		List<Client> clients = new ArrayList<Client>();
		try {
			
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM client Where `id_client` = " + code);

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
				client.setRemarques(result.getString("remarques"));
				clients.add(client);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}
	
	public List<Client> getClientParNom(String nom){
		Client client = null;
		List<Client> clients = new ArrayList<Client>();
		try {
			
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM client Where `nom_client` = '" + nom + "'");

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
				client.setRemarques(result.getString("remarques"));
				clients.add(client);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}
	
	public List<Client> getClientParPrenom(String prenom){
		Client client = null;
		List<Client> clients = new ArrayList<Client>();
		try {
			
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM client Where `prenom_client` = '" + prenom + "'");

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
				client.setRemarques(result.getString("remarques"));
				clients.add(client);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
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
				client.setRemarques(result.getString("remarques"));
				clients.add(client);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}
}
