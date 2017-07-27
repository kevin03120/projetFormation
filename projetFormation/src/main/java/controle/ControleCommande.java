package src.main.java.controle;

import java.util.List;

import src.main.java.controle.connexion.GlobalConnection;
import src.main.java.controle.modele.ModeleDynamiqueClient;
import src.main.java.controle.modele.ModeleDynamiqueCommande;
import src.main.java.entite.Client;
import src.main.java.entite.Commande;
import src.main.java.entite.dao.CommandeDaoMysql;

public class ControleCommande {
	
	private CommandeDaoMysql commandeDao;
	private ModeleDynamiqueCommande modeleCommande;
	private List<Commande> mesCommandes;

	public ControleCommande() {
		commandeDao = new CommandeDaoMysql(GlobalConnection.getInstance());
		mesCommandes = commandeDao.getAllCommandes();
		modeleCommande = new ModeleDynamiqueCommande(mesCommandes);
	}
	

	public ModeleDynamiqueCommande getModeleCommande() {
		return modeleCommande;
	}

	public List<Commande> getMesCommandes() {
		return mesCommandes;
	}
	
	public double getTotalPrixTTC(){
		return commandeDao.getTotalPrixCommandes();
	}
}
