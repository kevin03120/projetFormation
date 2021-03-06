package src.main.java.entite.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import src.main.java.entite.Article;

public class ArticleDaoMysql {
	Connection conn = null;
	Statement state = null;
	ResultSet res = null;
	
	public ArticleDaoMysql(Connection connection) {
		this.conn = connection;
	}
	
	public List<Article> getAllArticles(boolean tri) {
		Article article = null;
		List<Article> listArticles = new ArrayList<Article>();
		String trierPar = "id_article";
		if(tri == true) { trierPar = "nom_categorie"; }
		try {
			state = conn.createStatement();
			res = state.executeQuery("SELECT * FROM article, categorie WHERE categorie.id_categorie = article.id_categorie ORDER BY " + trierPar);

			while(res.next()) {
				article = new Article();
				article.setCode(res.getInt("id_article"));
				article.setDesignation(res.getString("designation"));
				article.setQuantite(res.getInt("quantite"));
				article.setPrixUnitaire(res.getDouble("prix"));	
				article.setCategorie(res.getString("nom_categorie"));	
				listArticles.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listArticles;
	}
	
	public void deleteArticle(int idArticle) {
		try {
			state = conn.createStatement();
			state.executeUpdate("DELETE FROM article WHERE id_article=" + idArticle);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void ajouterArticle(String categorie, String designation, int quantite, double prix) {
		int idCat = 0;
		try {
			state = conn.createStatement();
			res = state.executeQuery("SELECT id_categorie FROM categorie WHERE nom_categorie = '" + categorie+"'");
			res.next();
			idCat = res.getInt("id_categorie");
				
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			state.executeUpdate("INSERT INTO article(designation, quantite, prix, id_categorie) VALUES ('" + designation + "','" 
					+ quantite + "','" + prix + "','" + idCat + "');");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		
	}
	public List<String> lireCategories() {
		List<String> lesCategories = new ArrayList<String>();
		try {
			state = conn.createStatement();
			res = state.executeQuery("SELECT * FROM categorie");
			while(res.next()) {
				lesCategories.add(res.getString("nom_categorie"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lesCategories;
	}
	public void modifierArticle(Article article) {
		int idCat = 0;
		try {
			state = conn.createStatement();
			String nomCat = article.getCategorie();
			res = state.executeQuery("SELECT id_categorie FROM categorie WHERE nom_categorie = '" + nomCat+"'");
			res.next();
			idCat = res.getInt("id_categorie");
				
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			state = conn.createStatement();
			state.executeUpdate("UPDATE article SET id_article=" + article.getCode() + ", designation='" + article.getDesignation() 
					+ "', quantite=" + article.getQuantite() + ", prix=" + article.getPrixUnitaire() + ", id_categorie=" + idCat + " "
							+ "WHERE id_article=" + article.getCode() + ";");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public List<Article> rechercherArticle(String designation) {
		Article article = null;
		List<Article> listArticles = new ArrayList<Article>();
		try {
			state = conn.createStatement();
			res = state.executeQuery("SELECT * FROM article, categorie WHERE categorie.id_categorie = article.id_categorie "
					+ "AND designation LIKE '" + designation + "%'");
			
			while(res.next()) {
				article = new Article();
				article.setCode(res.getInt("id_article"));
				article.setDesignation(res.getString("designation"));
				article.setQuantite(res.getInt("quantite"));
				article.setPrixUnitaire(res.getDouble("prix"));	
				article.setCategorie(res.getString("nom_categorie"));	
				listArticles.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listArticles;
	}
	
	
}
