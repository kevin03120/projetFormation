package src.main.java.controle;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import src.main.java.controle.connexion.GlobalConnection;
import src.main.java.controle.modele.ModeleDynamiqueArticle;
import src.main.java.entite.dao.ArticleDaoMysql;
import src.main.java.entite.Article;

public class ControleArticle {
	public List<Article> listerArticles() {
		List<Article> listArticles = new ArrayList<Article>();
		ArticleDaoMysql listerdao = new ArticleDaoMysql(GlobalConnection.getInstance());	
		listArticles = listerdao.getAllArticles(false);
		return listArticles;
	}
	public void trier(List<Article> listArticles, boolean aTrier, JTable tableau) {
		ArticleDaoMysql trierdao = new ArticleDaoMysql(GlobalConnection.getInstance());	
		listArticles = trierdao.getAllArticles(aTrier);
		tableau.removeAll();
		tableau.setModel(new ModeleDynamiqueArticle(listArticles));
	}
}
