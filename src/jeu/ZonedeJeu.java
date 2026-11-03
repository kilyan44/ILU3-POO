package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;

public class ZonedeJeu {
	private List<Limite> limite = new ArrayList<>();
	private List<Bataille> bataille = new ArrayList<>();
	private List<Borne> borne = new ArrayList<>();

	public int donnerLimitationVitesse() {
		if (limite.isEmpty() || limite.get(limite.size() - 1) instanceof FinLimite) {
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

	public void deposer(Carte c) {
		if (c instanceof Limite l) {
			limite.add(l);
		}
		if (c instanceof Bataille b) {
			bataille.add(b);
		}
		if (c instanceof Borne bo) {
			borne.add(bo);
		}
	}

	public boolean peutAvancer() {
		if (bataille.isEmpty()) {
			return false;
		}
		Bataille sommet = bataille.get(bataille.size() - 1);
		return Cartes.FEU_VERT.equals(sommet);
	}

	public boolean estDepotFeuVertAutorise() {
		if (bataille.isEmpty()) {
			return true;
		}
		Bataille sommet = bataille.get(bataille.size() - 1);
		if (Cartes.FEU_ROUGE.equals(sommet)) {
			return true;
		}
		return (sommet instanceof Parade) && !Cartes.FEU_VERT.equals(sommet);
	}
	
	public boolean estDepotBorneAutorise(Borne borne) {
		return peutAvancer() && borne.getKm() <= donnerLimitationVitesse() && (donnerKmParcourus() + borne.getKm() <= 1000);
	}
	
	public boolean estDepotLimiteAutorise(Limite lim) {
		if (lim instanceof DebutLimite) {
			return limite.isEmpty() || limite.get(limite.size() - 1) instanceof FinLimite;
		}
		
		if (lim instanceof FinLimite) {
			return !limite.isEmpty() || limite.get(limite.size() - 1) instanceof DebutLimite;
		}
		return false;
	}

	public boolean estDepotBatailleAutorise(Bataille bat) {
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
	
}
