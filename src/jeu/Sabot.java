package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte> {

	private Carte[] cartes;
	private int nbCartes;
	private int nombreOp = 0;

	public Sabot(Carte[] cartes) {
		this.cartes = cartes;
		this.nbCartes = cartes.length;
	}

	public boolean estVide() {
		return nbCartes == 0;
	}

	public void ajouterCarte(Carte carte) {
		if (nbCartes >= cartes.length) {
			throw new IllegalStateException("Le sabot est plein, impossible d'ajouter une carte.");
		}
		cartes[nbCartes] = carte;
		nbCartes++;
		nombreOp++;
	}

	@Override
	public Iterator<Carte> iterator() {
		return new SabotIterator();
	}

	public Carte piocher() {
		Iterator<Carte> it = iterator();
		if (!it.hasNext()) {
			throw new NoSuchElementException("Le sabot est vide.");
		}
		Carte carte = it.next();
		it.remove();
		return carte;
	}

	private class SabotIterator implements Iterator<Carte> {

		private int curseur = 0;
		private boolean removeAutorise = false;
		private int nombreOpRef = nombreOp;

		@Override
		public boolean hasNext() {
			return curseur < nbCartes;
		}

		@Override
		public Carte next() {
			verifierModification();
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Carte carte = cartes[curseur];
			curseur++;
			removeAutorise = true;
			return carte;
		}

		@Override
		public void remove() {
			if (!removeAutorise) {
				throw new IllegalStateException("next() doit être appelé avant remove().");
			}
			verifierModification();

			int indexASupprimer = curseur - 1;
			for (int i = indexASupprimer; i < nbCartes - 1; i++) {
				cartes[i] = cartes[i + 1];
			}
			cartes[nbCartes - 1] = null;
			nbCartes--;
			curseur--;

			nombreOp++;
			nombreOpRef = nombreOp;
			removeAutorise = false;
		}

		private void verifierModification() {
			if (nombreOp != nombreOpRef) {
				throw new ConcurrentModificationException();
			}
		}
	}
}
