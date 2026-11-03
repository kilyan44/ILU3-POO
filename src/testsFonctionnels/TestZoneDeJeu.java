package testsFonctionnels;

import cartes.Borne;
import cartes.DebutLimite;
import cartes.FinLimite;
import jeu.Joueur;
import jeu.ZonedeJeu;

public class TestZoneDeJeu {

	public static void main(String[] args) {
		Joueur joueur = new Joueur("Joueur 1");
		ZonedeJeu zone = new ZonedeJeu();

		Borne b25 = new Borne(25);
		Borne b50 = new Borne(50);
		Borne b75 = new Borne(75);

		System.out.println("Deposer carte " + b25);
		joueur.deposer(b25);
		System.out.println("Deposer carte " + b50);
		joueur.deposer(b50);
		System.out.println("Deposer carte " + b75);
		joueur.deposer(b75);

		System.out.println("Total des bornes : " + joueur.donnerKmParcourus());

		System.out.println("Limite " + zone.donnerLimitationVitesse());

		zone.deposer(new DebutLimite());
		System.out.println("Limite: " + zone.donnerLimitationVitesse());

		zone.deposer(new FinLimite());
		System.out.println("Limite: " + zone.donnerLimitationVitesse());
	}
}