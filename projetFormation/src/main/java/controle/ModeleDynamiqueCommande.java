package src.main.java.controle;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import src.main.java.metier.Commande;

public class ModeleDynamiqueCommande  extends AbstractTableModel {

	private List<Commande> mesCommandes;
	private final String[] entetes = { "Code", "Client", "Mode de paiement", "Total TTC", "Date" };

	public ModeleDynamiqueCommande(List<Commande> commandes) {
		setMesCommandes(commandes);
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return getMesCommandes().size();
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
			return getMesCommandes().get(rowIndex).getCode();
		case 1:
			return getMesCommandes().get(rowIndex).getNom_client();
		case 2:
			return getMesCommandes().get(rowIndex).getMode_paiement();
		case 3:
			return getMesCommandes().get(rowIndex).getTotalTTC();
		case 4:
			return getMesCommandes().get(rowIndex).getDate();
		default:
			return null; 
		}
	}

	public List<Commande> getMesCommandes() {
		return mesCommandes;
	}

	public void setMesCommandes(List<Commande> mesCommandes) {
		this.mesCommandes = mesCommandes;
	}

}
