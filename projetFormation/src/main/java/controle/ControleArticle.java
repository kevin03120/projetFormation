package src.main.java.controle;

import java.awt.TextField;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;

import src.main.java.controle.connexion.GlobalConnection;
import src.main.java.controle.modele.ModeleDynamiqueArticle;
import src.main.java.dialogues.FArticle;
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
	public void majTextBox(JTable tableau, JTextField code, JComboBox categorie, JTextField designation, JSlider slideQuantite, 
											JTextField quantite, JTextField prix, List<Article> lesArticles) {
		
		ArticleDaoMysql majTextBoxdao = new ArticleDaoMysql(GlobalConnection.getInstance());	
		Article article = new Article();
		int idRow = tableau.getSelectedRow();
		article = lesArticles.get(idRow);
		code.setText(Integer.toString(article.getCode()));
		categorie.setSelectedItem(article.getCategorie());
		designation.setText(article.getDesignation());
		quantite.setText(Integer.toString(article.getQuantite()));
		prix.setText(Double.toString(article.getPrixUnitaire()));
		slideQuantite.setValue((article.getQuantite()));	
	}
	public void supprimer(JTable tableau, List<Article> listArticles) {
		Article article = new Article();
		ArticleDaoMysql supprimerdao = new ArticleDaoMysql(GlobalConnection.getInstance());
		int idTab = tableau.getSelectedRow();
		int idArticle = listArticles.get(idTab).getCode();
		supprimerdao.deleteArticle(idArticle);	
		listArticles = supprimerdao.getAllArticles(false);
		tableau.removeAll();
		tableau.setModel(new ModeleDynamiqueArticle(listArticles));
	}
	public void modifierArticle(JTable tableau, JTextField code, JComboBox categorie, JTextField designation, 
										JTextField quantite, JTextField prix, List<Article> lesArticles) {
		
		ArticleDaoMysql modifierdao = new ArticleDaoMysql(GlobalConnection.getInstance());
		Article article = new Article();
		article.setCode(new Integer(code.getText()));
		article.setDesignation(designation.getText());
		article.setCategorie(categorie.getSelectedItem().toString());
		article.setQuantite(new Integer(quantite.getText()));
		article.setPrixUnitaire(new Double(prix.getText()));
		modifierdao.modifierArticle(article);
		lesArticles = modifierdao.getAllArticles(false);
		tableau.removeAll();
		tableau.setModel(new ModeleDynamiqueArticle(lesArticles));
	}
	public void ajouterArticle(JTable tableau, JComboBox categorie, JTextField designation, 
			JTextField quantite, JTextField prix, List<Article> lesArticles) {
		
		String des = designation.getText();
		String cat = categorie.getSelectedItem().toString();
		int quant = new Integer(quantite.getText());
		double prixU = new Double(prix.getText());
		ArticleDaoMysql articleDao = new ArticleDaoMysql(GlobalConnection.getInstance());
		articleDao.ajouterArticle(cat, des, quant, prixU);
		lesArticles = articleDao.getAllArticles(false);
		tableau.removeAll();
		tableau.setModel(new ModeleDynamiqueArticle(lesArticles));	
	}
}
