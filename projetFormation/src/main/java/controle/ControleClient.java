package src.main.java.controle;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import src.main.java.controle.connexion.GlobalConnection;
import src.main.java.controle.modele.ModeleDynamiqueClient;
import src.main.java.dialogues.FClient;
import src.main.java.dialogues.FClientAjout;
import src.main.java.entite.Client;
import src.main.java.entite.dao.ClientDaoMysql;

public class ControleClient {
	private ClientDaoMysql clientDao;
	private ModeleDynamiqueClient modeleClient;
	private List<Client> mesClients;

	public ControleClient() {
		clientDao = new ClientDaoMysql(GlobalConnection.getInstance());
		mesClients = clientDao.getAllClient();
		modeleClient = new ModeleDynamiqueClient(mesClients);
	}

	public ModeleDynamiqueClient getModeleClient() {
		return modeleClient;
	}

	public List<Client> getMesClients() {
		return mesClients;
	}

	public List<Client> getMesClientsDynamique(List<Client> clients) {
		if (clients == null) {
			return mesClients;
		} else {
			return clients;
		}
	}

	public void deleteClient(int codeClientASupp, List<Client> clients) {
		Client client = clients.get(codeClientASupp);
		clientDao.deleteClient(client.getCode());
	}

	public void addClient(Client cli) {
		clientDao.addClient(cli);
	}

	public List<Client> TriOrdreAlphabetiqueNom(List<Client> clients) {
		List<String> nomClient = new ArrayList<String>();
		List<Client> nouvelleList = new ArrayList<Client>();
		for (Client client : clients) {
			nomClient.add(client.getNom());
		}
		Collections.sort(nomClient);
		for (String nom : nomClient) {
			for (Client client : clients) {
				if (client.getNom().equals(nom)) {
					boolean isExist = false;
					for (Client monClient : nouvelleList) {
						if (client.getCode().equals(monClient.getCode())) {
							isExist = true;
						}
					}
					if (!isExist) {
						nouvelleList.add(client);
					}
				}
			}
		}
		return nouvelleList;
	}

	public List<Client> TriOrdreAlphabetiquePrenom(List<Client> clients) {
		List<String> prenomClient = new ArrayList<String>();
		List<Client> nouvelleList = new ArrayList<Client>();
		for (Client client : clients) {
			prenomClient.add(client.getPrenom());
		}
		Collections.sort(prenomClient);
		for (String prenom : prenomClient) {
			for (Client client : clients) {
				if (client.getPrenom().equals(prenom)) {
					boolean isExist = false;
					for (Client monClient : nouvelleList) {
						if (client.getCode().equals(monClient.getCode())) {
							isExist = true;
						}
					}
					if (!isExist) {
						nouvelleList.add(client);
					}
				}
			}
		}
		return nouvelleList;
	}
	
	public List<Client> getClientParCode(String code){
		return clientDao.getClientParCode(code);
	}

	public List<Client> getClientParNom(String nom){
		return clientDao.getClientParNom(nom);
	}
	
	public List<Client> getClientParPrenom(String prenom){
		return clientDao.getClientParPrenom(prenom);
	}
}
