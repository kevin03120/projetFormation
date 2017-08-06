package src.main.java.controle;

import java.util.HashMap;
import java.util.List;

import src.main.java.controle.connexion.GlobalConnection;
import src.main.java.controle.modele.ModeleDynamiqueClient;
import src.main.java.controle.modele.ModeleDynamiqueCommandeExistantes;
import src.main.java.entite.Client;
import src.main.java.entite.Commande;
import src.main.java.entite.dao.CommandeDaoMysql;

public class ControleCommande {
	
	private CommandeDaoMysql commandeDao;
	private ModeleDynamiqueCommandeExistantes modeleCommande;
	private List<Commande> mesCommandes;

	public ControleCommande() {
		commandeDao = new CommandeDaoMysql(GlobalConnection.getInstance());
		mesCommandes = commandeDao.getAllCommandes();
		modeleCommande = new ModeleDynamiqueCommandeExistantes(mesCommandes);
	}
	

	public ModeleDynamiqueCommandeExistantes getModeleCommande() {
		return modeleCommande;
	}

	public List<Commande> getMesCommandes() {
		return mesCommandes;
	}
	
	public double getTotalPrixTTC(){
		return commandeDao.getTotalPrixCommandes();
	}
	
	public void deleteCommande(String code){
		commandeDao.deleteCommande(code);
	}
	
	public void addCommande(Commande c){
		commandeDao.addCommande(c);
	}
	
	public void addLigneCommande(int codeArticle, int quantite){
		commandeDao.addLigneCommande(codeArticle, quantite);
	}
	
	public HashMap<String, Integer> statCommandes(){
		return commandeDao.statCommandes();
	}
	
	public int getTotal(){
		return commandeDao.totalVente();
	}
	
}
