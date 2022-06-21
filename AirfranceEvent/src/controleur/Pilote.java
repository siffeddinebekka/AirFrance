package controleur;

public class Pilote {
	private int idpilote ; 
	private String nom, prenom, adresse; 
	private int nbheuresvol; 
	private String bip;
	
	public Pilote(int idpilote, String nom, String prenom, String adresse, int nbheuresvol, String bip) {
		this.idpilote = idpilote;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.nbheuresvol = nbheuresvol;
		this.bip = bip;
	} 
	public Pilote( String nom, String prenom, String adresse, int nbheuresvol, String bip) {
		this.idpilote = 0;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.nbheuresvol = nbheuresvol;
		this.bip = bip;
	}
	
	public int getIdpilote() {
		return idpilote;
	}
	public void setIdpilote(int idpilote) {
		this.idpilote = idpilote;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getNbheuresvol() {
		return nbheuresvol;
	}
	public void setNbheuresvol(int nbheuresvol) {
		this.nbheuresvol = nbheuresvol;
	}
	public String getBip() {
		return bip;
	}
	public void setBip(String bip) {
		this.bip = bip;
	} 
	
	
}
