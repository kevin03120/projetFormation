package src.main.java.metier;

import java.time.LocalDate;

public class Client {
	
	private String code;
	private String nom;
	private String prenom;
	private LocalDate date_creation;
	private boolean fidelite;
	private String adresse;
	private String tel_fixe;
	private String tel_mobile;
	private String email;
	private String remarques;
	
	@Override
	public String toString() {
		return getNom() + "" + getPrenom();
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public LocalDate getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(LocalDate date_creation) {
		this.date_creation = date_creation;
	}
	public boolean isFidelite() {
		return fidelite;
	}
	public void setFidelite(boolean fidelite) {
		this.fidelite = fidelite;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTel_fixe() {
		return tel_fixe;
	}
	public void setTel_fixe(String tel_fixe) {
		this.tel_fixe = tel_fixe;
	}
	public String getTel_mobile() {
		return tel_mobile;
	}
	public void setTel_mobile(String tel_mobile) {
		this.tel_mobile = tel_mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRemarques() {
		return remarques;
	}
	public void setRemarques(String remarques) {
		this.remarques = remarques;
	}

}
