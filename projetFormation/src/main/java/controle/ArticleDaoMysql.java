package src.main.java.controle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import src.main.java.dialogues.Article;

public class ArticleDaoMysql {
	Connection conn = null;
	Statement state = null;
	ResultSet res = null;
	
	public ArticleDaoMysql(Connection conn) {
		this.conn = conn;
	}
	
	public List<Article> getAllArticles() {
		Article article = new Article();
		List<Article> listArticles = new ArrayList<Article>();
		try {
			state = conn.createStatement();
			res = state.executeQuery("SELECT * FROM Article");
			
			while(res.next()) {
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listArticles;
	}
	
	
	
}
