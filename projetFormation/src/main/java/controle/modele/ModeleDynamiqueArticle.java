package src.main.java.controle.modele;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import src.main.java.entite.Article;

public class ModeleDynamiqueArticle  extends AbstractTableModel {
	private List<Article> lesArticles ;
	private static final String[] TITRES = { "Code", "Catégorie", "Désignation", "Quantité", "Prix Unitaire" }; 
	
	public ModeleDynamiqueArticle(List<Article> listArticles) {
		setArticles(listArticles);
	}

	public List<Article> getArticles() {
		return lesArticles;
	}

	public void setArticles(List<Article> articles) {
		this.lesArticles = articles;
	}
	
	public Article getArticle(int idArticle) {
		return lesArticles.get(idArticle);
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lesArticles.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return TITRES.length;
	}

	@Override
	public String getColumnName(int columnIdex) {
		// TODO Auto-generated method stub
		return TITRES[columnIdex];
	} 
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch(columnIndex) {
			case 0 : return getArticles().get(rowIndex).getCode();
			case 1 : return getArticles().get(rowIndex).getCategorie();
			case 2 : return getArticles().get(rowIndex).getDesignation();
			case 3 : return getArticles().get(rowIndex).getQuantite();
			case 4 : return getArticles().get(rowIndex).getPrixUnitaire();
			default : return null;
		}
	}


}
