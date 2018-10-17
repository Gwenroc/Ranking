package RankingBO;

public class Connexion {
	
	private String nom;
	private String motPasse;
	private String admin;
	
	
	
	public Connexion(String nom, String motPasse, String admin) {
		super();
		this.nom = nom;
		this.motPasse = motPasse;
		this.admin = admin;
	}

	public Connexion() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMotPasse() {
		return motPasse;
	}

	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}

	public String getRole() {
		return admin;
	}

	public void setRole(String admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Connexion [nom=" + nom + ", motPasse=" + motPasse + ", admin=" + admin + "]";
	}
	
	


	
	
	

}
