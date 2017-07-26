package src.main.java.controle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import src.main.java.metier.Article;

public class ArticleDaoMysql {
	Connection conn = null;
	Statement state = null;
	ResultSet res = null;
	
	public ArticleDaoMysql(Connection connection) {
		this.conn = connection;
	}
	
	public List<Article> getAllArticles() {
		Article article = null;
		List<Article> listArticles = new ArrayList<Article>();
		try {
			state = conn.createStatement();
			res = state.executeQuery("SELECT * FROM article, categorie WHERE categorie.id_categorie = article.id_categorie");
			
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

	public Connection getConn() {
		return conn;
	}

	public Statement getState() {
		return state;
	}

	public ResultSet getRes() {
		return res;
	}
	
	
}
