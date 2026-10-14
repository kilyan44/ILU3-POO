package jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	private Sabot sabot;
	
	public Jeu() {
		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeCarte = new ArrayList<>();
		Collections.addAll(listeCarte, jeu.donnerCartes());
		listeCarte = GestionCartes.melanger(listeCarte);
		
		sabot = new Sabot(listeCarte.toArray(new Carte[0]));
	}
	
	public Sabot getSabot() {
		return sabot;
	}
}
