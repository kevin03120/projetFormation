package src.main.java.entite.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import src.main.java.entite.Client;
import src.main.java.entite.Commande;

public class CommandeDaoMysql {
	Connection conn = null;
	Statement state = null;
	ResultSet res = null;
	
	public CommandeDaoMysql(Connection conn) {
		this.conn = conn;
	}
	
	
	public double getTotalPrixCommandes() {
		double prixTTC=0.00;
		for (Commande c : getAllCommandes()) {
			prixTTC += Double.parseDouble(c.getTotalTTC());
		}
		return prixTTC;
	}
	
	public void deleteCommande(String code) {
		try {
			state = conn.createStatement();
			int a = state.executeUpdate("DELETE FROM commande WHERE id_commande = " + code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addLigneCommande(int codeArticle, int quantite){
		String codeCommande = "null";
		try {
			ResultSet resultat;
			resultat = state.executeQuery("SELECT MAX(id_commande) AS numCommande FROM `commande` ");
			resultat.next();
			codeCommande = resultat.getString("numCommande");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			int a = state.executeUpdate("INSERT INTO `lignes_commande`(`id_ligne`, `id_commande`, `id_article`, `quantite`) VALUES (null," + codeCommande + ","+ codeArticle +","+quantite+")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addCommande(Commande c){
		try {
			state = conn.createStatement();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			int a = state.executeUpdate("INSERT INTO `commande`(`id_commande`, `date_commande`, `reglement`, `id_client`) VALUES (null,'"+dtf.format(c.getDate())+"','"+c.getMode_paiement()+"',"+c.getClient().getCode()+")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Commande> getAllCommandes() {
		Commande commande = null;
		List<Commande> listCommande = new ArrayList<Commande>();
		try {
			state = conn.createStatement();
			res = state.executeQuery("SELECT commande.*, nom_client FROM commande, client WHERE commande.id_client = client.id_client;");
			
			while(res.next()) {
				commande=new Commande();
				commande.setCode(res.getString("id_commande"));
				String date = res.getString("date_commande");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			    LocalDate dateTime = LocalDate.parse(date, formatter);
				commande.setDate(dateTime);
				commande.setMode_paiement(res.getString("reglement"));
				commande.setNom_client(res.getString("nom_client"));
				listCommande.add(commande);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet resultat;
		for (Commande c : listCommande) {
			try {
				resultat = state.executeQuery("SELECT SUM(prix)*lignes_commande.quantite AS prixTTC FROM lignes_commande, article WHERE lignes_commande.id_article = article.id_article AND id_commande = "+c.getCode()+" GROUP BY (id_commande);");
				resultat.next();
				c.setTotalTTC(resultat.getString("prixTTC"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listCommande;
	}
}
