package src.main.java.entite;

public class Commande {
	
	private String code;
	private String nom_client;
	private String mode_paiement;
	private String TotalTTC;
	private String date;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNom_client() {
		return nom_client;
	}
	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}
	public String getMode_paiement() {
		return mode_paiement;
	}
	public void setMode_paiement(String mode_paiement) {
		this.mode_paiement = mode_paiement;
	}
	public String getTotalTTC() {
		return TotalTTC;
	}
	public void setTotalTTC(String totalTTC) {
		TotalTTC = totalTTC;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	

}
