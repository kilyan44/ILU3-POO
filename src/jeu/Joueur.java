package jeu;

public class Joueur {
	private String nom;
	private ZonedeJeu zoneDeJeu;
	
	public Joueur(String nom) {
		this.nom = nom;
		this.zoneDeJeu = new ZonedeJeu();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Joueur joueur) {
			return nom.equals(joueur.nom);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 31 * nom.hashCode();
	}
	
	@Override
	public String toString() {
		return nom;
	}
}
