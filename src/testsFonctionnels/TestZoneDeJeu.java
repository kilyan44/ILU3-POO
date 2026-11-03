package testsFonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.Botte;
import jeu.Joueur;
import jeu.Cartes;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Parade;
import cartes.Type;
import cartes.Carte;
import jeu.ZonedeJeu;

public class TestZoneDeJeu {

	public static void main(String[] args) {
//		Joueur joueur = new Joueur("Joueur 1");
//		ZonedeJeu zone = new ZonedeJeu();
//
//		Borne b25 = new Borne(25);
//		Borne b50 = new Borne(50);
//		Borne b75 = new Borne(75);

//		System.out.println("Deposer carte " + b25);
//		joueur.deposer(b25);
//		System.out.println("Deposer carte " + b50);
//		joueur.deposer(b50);
//		System.out.println("Deposer carte " + b75);
//		joueur.deposer(b75);
//
//		System.out.println("Total des bornes : " + joueur.donnerKmParcourus());
//
//		System.out.println("Limite " + zone.donnerLimitationVitesse());
//
//		zone.deposer(new DebutLimite());
//		System.out.println("Limite: " + zone.donnerLimitationVitesse());
//
//		zone.deposer(new FinLimite());
//		System.out.println("Limite: " + zone.donnerLimitationVitesse());

		// TP3 PARTIE 3

//		boolean depotOK = false;
//		ZonedeJeu zoneDeJeu = new ZonedeJeu();
//		// Feu rouge
//		System.out.println("Deposer carte Feu rouge");
//		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_ROUGE);
//		System.out.println("dépot ok ? " + depotOK);
//		if (depotOK) {
//			zoneDeJeu.deposer(Cartes.FEU_ROUGE);
//		}
//		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		// accident
//		System.out.println("Deposer carte attaque - accident");
//		depotOK = zoneDeJeu.estDepotAutorise(new Attaque(Type.ACCIDENT));
//		System.out.println("dépot ok ? " + depotOK);
//		if (depotOK) {
//			zoneDeJeu.deposer(new Attaque(Type.ACCIDENT));
//		}
//		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		// Feu vert
//		System.out.println("Deposer carte Feu vert");
//		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_VERT);
//		System.out.println("dépot ok ? " + depotOK);
//		if (depotOK) {
//			zoneDeJeu.deposer(Cartes.FEU_VERT);
//		}
//		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		// panne d'essence
//		System.out.println("Deposer carte attaque - essence");
//		depotOK = zoneDeJeu.estDepotAutorise(new Attaque(Type.ESSENCE));
//		System.out.println("dépot ok ? " + depotOK);
//		if (depotOK) {
//			zoneDeJeu.deposer(new Attaque(Type.ESSENCE));
//		}
//		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		// roue de secours
//		System.out.println("Deposer carte parade - roue de secours");
//		depotOK = zoneDeJeu.estDepotAutorise(new Parade(Type.CREVAISON));
//		if (depotOK) {
//			zoneDeJeu.deposer(new Parade(Type.CREVAISON));
//		}
//		System.out.println("dépot ok ? " + depotOK);
//		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		// bidon d'essence
//		System.out.println("Deposer carte parade - essence");
//		depotOK = zoneDeJeu.estDepotAutorise(new Parade(Type.ESSENCE));
//		if (depotOK) {
//			zoneDeJeu.deposer(new Parade(Type.ESSENCE));
//		}
//		System.out.println("dépot ok ? " + depotOK);
//		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		// Feu vert
//		System.out.println("Deposer carte Feu vert");
//		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_VERT);
//		System.out.println("dépot ok ? " + depotOK);
//		if (depotOK) {
//			zoneDeJeu.deposer(Cartes.FEU_VERT);
//		}
//		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		// D�pot 100 bornes
//		System.out.println("Deposer carte borne - 100");
//		depotOK = zoneDeJeu.estDepotAutorise(new Borne(100));
//		System.out.println("dépot ok ? " + depotOK);
//		if (depotOK) {
//			zoneDeJeu.deposer(new Borne(100));
//		}
//		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		// D�pot limitation de vitesse 50 bornes
//		System.out.println("Deposer carte limite - 50");
//		depotOK = zoneDeJeu.estDepotAutorise(new DebutLimite());
//		System.out.println("dépot ok ? " + depotOK);
//		if (depotOK) {
//			zoneDeJeu.deposer(new DebutLimite());
//		}
//		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		// D�pot 100 bornes
//		System.out.println("Deposer carte borne - 100");
//		depotOK = zoneDeJeu.estDepotAutorise(new Borne(100));
//		System.out.println("dépot ok ? " + depotOK);
//		if (depotOK) {
//			zoneDeJeu.deposer(new Borne(100));
//		}
//		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		// Depot 25 bornes
//		System.out.println("Deposer carte borne - 25");
//		depotOK = zoneDeJeu.estDepotAutorise(new Borne(25));
//		System.out.println("dépot ok ? " + depotOK);
//		if (depotOK) {
//			zoneDeJeu.deposer(new Borne(25));
//		}
//		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		// D�pot fin limitation
//		System.out.println("Deposer carte fin limite - 50");
//		depotOK = zoneDeJeu.estDepotAutorise(new FinLimite());
//		System.out.println("dépot ok ? " + depotOK);
//		if (depotOK) {
//			zoneDeJeu.deposer(new FinLimite());
//		}
//		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		// D�pot 100 bornes
//		System.out.println("Deposer carte borne - 100");
//		depotOK = zoneDeJeu.estDepotAutorise(new Borne(100));
//		System.out.println("dépot ok ? " + depotOK);
//		if (depotOK) {
//			zoneDeJeu.deposer(new Borne(100));
//		}
//		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());

		// TP4 Partie 1
		ZonedeJeu zoneDeJeu = new ZonedeJeu();
		boolean depotOK = false;

		// Feu rouge
		System.out.println("Deposer carte Feu rouge");
		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_ROUGE);
		System.out.println("dépôt ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(Cartes.FEU_ROUGE);
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());

		// Botte Véhicule prioritaire
		System.out.println("Deposer carte Vehicule prioritaire");
		depotOK = zoneDeJeu.estDepotAutorise(Cartes.PRIORITAIRE);
		System.out.println("dépôt ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(Cartes.PRIORITAIRE);
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());

		// Attaque - accident
		System.out.println("Deposer carte attaque - accident");
		Carte attaqueAccident = new Attaque(Type.ACCIDENT);
		depotOK = zoneDeJeu.estDepotAutorise(attaqueAccident);
		System.out.println("dépôt ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(attaqueAccident);
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());

		// Botte - roue de secours
		System.out.println("Deposer botte - roue de secours");
		Carte botteCrevaison = new Botte(Type.CREVAISON);
		depotOK = zoneDeJeu.estDepotAutorise(botteCrevaison);
		if (depotOK) {
			zoneDeJeu.deposer(botteCrevaison);
		}
		System.out.println("dépôt ok ? " + depotOK);
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());

		// Botte - as du volant
		System.out.println("Deposer carte as du volant");
		Carte botteAccident = new Botte(Type.ACCIDENT);
		depotOK = zoneDeJeu.estDepotAutorise(botteAccident);
		if (depotOK) {
			zoneDeJeu.deposer(botteAccident);
		}
		System.out.println("dépôt ok ? " + depotOK);
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());

		// Feu vert
		System.out.println("Deposer carte Feu vert");
		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_VERT);
		System.out.println("dépôt ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(Cartes.FEU_VERT);
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());

		// Dépôt attaque accident
		System.out.println("Deposer carte accident");
		depotOK = zoneDeJeu.estDepotAutorise(attaqueAccident);
		System.out.println("dépôt ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(attaqueAccident);
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());

		// Dépôt limitation de vitesse 50 bornes
		System.out.println("Deposer carte limite - 50");
		Carte debutLimite = new DebutLimite();
		depotOK = zoneDeJeu.estDepotAutorise(debutLimite);
		System.out.println("dépôt ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(debutLimite);
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());

	}
}