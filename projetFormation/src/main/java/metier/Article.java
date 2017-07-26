package src.main.java.metier;

public class Article {
	private String code;
	private int categorie;
	private String designation;
	private int quantite;
	private double prixUnitaire;

	
	//Getters and Setters
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getCategorie() {
		return categorie;
	}
	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	
}
