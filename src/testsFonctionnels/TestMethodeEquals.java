package testsFonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.Carte;
import cartes.Parade;
import cartes.Type;

public class TestMethodeEquals {

	public static void main(String[] args) {
		Carte carte1 = new Borne(25);
		Carte carte2 = new Borne(25);
		System.out.println("Deux cartes de 25km sont identiques ? " + carte1.equals(carte2));
		
		Carte feu1 = new Attaque(Type.FEU);
		Carte feu2 = new Attaque(Type.FEU);
		System.out.println("Deux cartes de feux rouge sont identiques ? " + feu1.equals(feu2));
		
		Carte feuVert = new Parade(Type.FEU);
		System.out.println("La carte feu rouge et la carte feu vert sont identiques ? " + feuVert.equals(feu1));
	}
}
