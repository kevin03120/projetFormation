package src.main.java.controle.modele;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import src.main.java.entite.Client;

public class ModeleDynamiqueClient extends AbstractTableModel {

	private List<Client> mesClients;
	private final String[] entetes = { "Code", "Nom", "Prénom", "Fidelite", "Date Création" };

	public ModeleDynamiqueClient(List<Client> clients) {
		setMesClients(clients);
	}

	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return getMesClients().get(rowIndex).getCode();
		case 1:
			return getMesClients().get(rowIndex).getNom();
		case 2:
			return getMesClients().get(rowIndex).getPrenom();
		case 3:
			if (getMesClients().get(rowIndex).isFidelite()) {
				return new String("Oui");
			} else {
				return new String("Non");
			}
		case 4:
			return getMesClients().get(rowIndex).getDate_creation();
		default:
			return null; // Ne devrait jamais arriver
		}
	}

	public List<Client> getMesClients() {
		return mesClients;
	}

	public void setMesClients(List<Client> mesClients) {
		this.mesClients = mesClients;
	}

	@Override
	public int getRowCount() {
		return getMesClients().size();
	}

}
