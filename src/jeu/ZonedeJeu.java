package jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;
import cartes.Type;

public class ZonedeJeu {
	private List<Limite> limite;
	private List<Bataille> bataille;
	private List<Borne> borne;
	private Set<Botte> bottes;

	public ZonedeJeu() {
		this.limite = new LinkedList<>();
		this.bataille = new LinkedList<>();
		this.borne = new ArrayList<>();
		this.bottes = new HashSet<>();
	}

	public int donnerLimitationVitesse() {
		if (limite.isEmpty() || limite.get(limite.size() - 1) instanceof FinLimite || estPrioritaire()) {
			return 200;
		}
		return 50;
	}

	public int donnerKmParcourus() {
		int totalKm = 0;
		for (Borne b : borne) {
			totalKm += b.getKm();
		}
		return totalKm;
	}

	public void deposer(Carte carte) {
		if (carte instanceof Limite l) {
			limite.add(l);
		} else if (carte instanceof Bataille b) {
			bataille.add(b);
		} else if (carte instanceof Borne bo) {
			borne.add(bo);
		} else if (carte instanceof Botte botte) {
			bottes.add(botte);
		}

	}

	public boolean peutAvancer() {
		if (bataille.isEmpty()) {
			return estPrioritaire();
		}
		Bataille sommet = bataille.get(bataille.size() - 1);
		if (Cartes.FEU_VERT.equals(sommet)) {
			return true;
		}
		if (sommet instanceof Parade && estPrioritaire()) {
			return true;
		}
		if (sommet instanceof Attaque && sommet.getType() == Type.FEU && estPrioritaire()) {
			return true;
		}
		if (sommet instanceof Attaque && aBottePourType(sommet.getType()) && estPrioritaire()) {
			return true;
		}
		return false;
	}

	public boolean estDepotFeuVertAutorise() {
		if (estPrioritaire()) {
			return false;
		}
		if (bataille.isEmpty()) {
			return true;
		}
		Bataille sommet = bataille.get(bataille.size() - 1);
		if (Cartes.FEU_ROUGE.equals(sommet)) {
			return true;
		}
		if (sommet instanceof Parade && !Cartes.FEU_VERT.equals(sommet)) {
			return true;
		}
		if (sommet instanceof Attaque && aBottePourType(sommet.getType())) {
			return true;
		}
		return false;
	}

	private boolean estDepotBorneAutorise(Borne borne) {
		return peutAvancer() && borne.getKm() <= donnerLimitationVitesse()
				&& (donnerKmParcourus() + borne.getKm() <= 1000);
	}

	private boolean estDepotLimiteAutorise(Limite lim) {
		if (estPrioritaire()) {
			return false;
		}
		if (lim instanceof DebutLimite) {
			return limite.isEmpty() || limite.get(limite.size() - 1) instanceof FinLimite;
		}

		if (lim instanceof FinLimite) {
			return !limite.isEmpty() || limite.get(limite.size() - 1) instanceof DebutLimite;
		}
		return false;
	}

	private boolean estDepotBatailleAutorise(Bataille bat) {
		if (aBottePourType(bat.getType())) {
			return false;
		}
		if (bat instanceof Attaque) {
			return peutAvancer();
		}
		if (bat instanceof Parade) {
			if (Cartes.FEU_VERT.equals(bat)) {
				return estDepotFeuVertAutorise();
			}
			if (!bataille.isEmpty()) {
				Bataille sommet = bataille.get(bataille.size() - 1);
				return (sommet instanceof Attaque) && sommet.getType().equals(bat.getType());
			}
		}
		return false;
	}

	public boolean estDepotAutorise(Carte carte) {
		if (carte instanceof Botte) {
			return true;
		}
		if (carte instanceof Borne borne) {
			return estDepotBorneAutorise(borne);
		}
		if (carte instanceof Limite limite) {
			return estDepotLimiteAutorise(limite);
		}
		if (carte instanceof Bataille bataille) {
			return estDepotBatailleAutorise(bataille);
		}
		return false;
	}

	public boolean estPrioritaire() {
		return bottes.contains(Cartes.PRIORITAIRE);
	}

	private boolean aBottePourType(Type type) {
		return bottes.contains(new Botte(type));
	}

}
