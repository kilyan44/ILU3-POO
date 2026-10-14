package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cartes.Carte;

public class MainJoueur implements Iterable<Carte> {
	private List<Carte> cartes = new ArrayList<>();
	private MainJoueur main = new MainJoueur();

	public void prendre(Carte carte) {
		cartes.add(carte);
	}

	public void jouer(Carte carte) {
		assert cartes.contains(carte);
		cartes.remove(carte);
	}

	@Override
	public Iterator<Carte> iterator() {
		return cartes.iterator();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Carte carte : cartes) {
			sb.append(carte);
			sb.append("\n");
		}
		return sb.toString();
	}

	public MainJoueur getMain() {
		return main;
	}

	public void donner(Carte carte) {
		main.prendre(carte);
	}

	public Carte prendreCarte(Sabot sabot) {
		if (sabot.estVide()) {
			return null;
		}
		Carte carte = sabot.piocher();
		donner(carte);
		return carte;
	}
}