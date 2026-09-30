package testsFonctionnels;

import cartes.JeuDeCartes;

public class TestJeuDeCartes {

	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		System.out.println(jeu.affichageJeuDeCartes());
		System.out.println("Le nombre de cartes est correct ? " + jeu.checkCount());
	}
}