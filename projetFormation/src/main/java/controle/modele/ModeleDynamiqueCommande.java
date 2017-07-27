package src.main.java.controle.modele;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import src.main.java.entite.Commande;
import src.main.java.entite.CommandeArticle;

public class ModeleDynamiqueCommande extends AbstractTableModel {

	private List<CommandeArticle> mesCommandesArticle;
	private final String[] entetes = { "Code", "Code Categorie", "Désignation", "Quantité", "Prix unitaire", "Total" };
	
	public ModeleDynamiqueCommande(List<CommandeArticle> commandes) {
		setMesCommandesArticle(commandes);
	}
	
	public void setMesCommandesArticle(List<CommandeArticle> mesCommandesArticle) {
		this.mesCommandesArticle = mesCommandesArticle;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return getMesCommandesArticle().size();
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}
	
	@Override
	public int getColumnCount() {
		return entetes.length;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return getMesCommandesArticle().get(rowIndex).getCodeArticle();
		case 1:
			return getMesCommandesArticle().get(rowIndex).getCodeCategorie();
		case 2:
			return getMesCommandesArticle().get(rowIndex).getDesignation();
		case 3:
			return getMesCommandesArticle().get(rowIndex).getQuantite();
		case 4:
			return getMesCommandesArticle().get(rowIndex).getPrix();
		case 5:
			return getMesCommandesArticle().get(rowIndex).getTotal();
		default:
			return null; 
		}
	}
	public List<CommandeArticle> getMesCommandesArticle() {
		return mesCommandesArticle;
	}
}
