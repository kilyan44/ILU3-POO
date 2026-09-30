package testsFonctionnels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.*;

public class TestGestionCartes {

	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeCarteNonMelangee = new LinkedList<>();
		for (Carte carte : jeu.donnerCartes()) {
			listeCarteNonMelangee.add(carte);
		}

		List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
		System.out.println(listeCartes);

		listeCartes = GestionCartes.melanger(listeCartes);
		System.out.println(listeCartes);

		System.out.println(
				"liste mélangée sans erreur ? " + GestionCartes.verifierMelange(listeCarteNonMelangee, listeCartes));

		listeCartes = GestionCartes.rassembler(listeCartes);
		System.out.println(listeCartes);

		System.out.println("liste rassemblée sans erreur ? " + GestionCartes.verifierRassemblement(listeCartes));

		List<Integer> lVide = new ArrayList<>();
		List<Integer> l1 = Arrays.asList(1, 1, 2, 1, 3);
		List<Integer> l2 = Arrays.asList(1, 4, 3, 2);
		List<Integer> l3 = Arrays.asList(1, 1, 2, 3, 1);

		System.out.println("Vérification liste vide : " + GestionCartes.verifierRassemblement(lVide));
		System.out.println("Vérification [1, 1, 2, 1, 3] : " + GestionCartes.verifierRassemblement(l1));
		System.out.println("Vérification [1, 4, 3, 2] : " + GestionCartes.verifierRassemblement(l2));
		System.out.println("Vérification [1, 1, 2, 3, 1] : " + GestionCartes.verifierRassemblement(l3));
	}
}
