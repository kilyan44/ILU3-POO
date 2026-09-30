package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class GestionCartes {
	private GestionCartes() {
		/* This utility class should not be instantiated */
	}

	private static Random random = new Random();

	public static <T> T extraire(List<T> liste) {
		int index = random.nextInt(liste.size());
		return liste.remove(index);
	}

	public static <T> T extraireIterator(List<T> liste) {
		int index = random.nextInt(liste.size());
		ListIterator<T> it = liste.listIterator();
		T element = null;
		for (int i = 0; i <= index; i++) {
			element = it.next();
		}
		it.remove();
		return element;
	}

	public static <T> List<T> melanger(List<T> liste) {
		List<T> resultat = new ArrayList<>();
		while (!liste.isEmpty()) {
			resultat.add(extraire(liste));
		}
		return resultat;
	}

	public static <T> boolean verifierMelange(List<T> l1, List<T> l2) {
		if (l1.size() != l2.size()) {
			return false;
		}
		for (T element : l1) {
			if (Collections.frequency(l1, element) != Collections.frequency(l2, element)) {
				return false;
			}
		}
		return true;
	}

	public static <T> List<T> rassembler(List<T> liste) {
		List<T> resultat = new ArrayList<>();
		List<T> copie = new ArrayList<>(liste);

		while (!copie.isEmpty()) {
			T element = copie.get(0);
			ListIterator<T> it = copie.listIterator();
			while (it.hasNext()) {
				T courant = it.next();
				if (element.equals(courant)) {
					resultat.add(courant);
					it.remove();
				}
			}
		}
		return resultat;
	}

	public static <T> boolean verifierRassemblement(List<T> liste) {
		if (liste.isEmpty() || liste.size() == 1) {
			return true;
		}

		ListIterator<T> it1 = liste.listIterator();
		T courant = it1.next();

		while (it1.hasNext()) {
			T suivant = it1.next();
			if (!courant.equals(suivant)) {
				ListIterator<T> it2 = liste.listIterator(it1.nextIndex());
				while (it2.hasNext()) {
					if (courant.equals(it2.next())) {
						return false;
					}
				}
				courant = suivant;
			}
		}
		return true;
	}
}