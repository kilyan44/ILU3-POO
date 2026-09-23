package testsFonctionnels;

import java.util.Iterator;
import cartes.Botte;
import cartes.Carte;
import cartes.JeuDeCartes;
import cartes.Type;
import jeu.Sabot;

public class TestSabot {

    public static void main(String[] args) {
        JeuDeCartes jeu = new JeuDeCartes();
        Sabot sabot = new Sabot(jeu.donnerCartes());
        while (!sabot.estVide()) {
            Carte carte = sabot.piocher();
            System.out.println("je pioche " + carte);
        }

        sabot = new Sabot(jeu.donnerCartes());
        for (Iterator<Carte> it = sabot.iterator(); it.hasNext();) {
            Carte carte = it.next();
            System.out.println("je pioche " + carte);
            it.remove();
        }

        sabot = new Sabot(jeu.donnerCartes());
        for (Iterator<Carte> it = sabot.iterator(); it.hasNext();) {
            it.next();
            sabot.piocher();
            it.remove();
        }

        sabot = new Sabot(jeu.donnerCartes());
        sabot.piocher();
        Carte asDuVolant = new Botte(Type.ACCIDENT);
        for (Iterator<Carte> it = sabot.iterator(); it.hasNext();) {
            it.next();
            sabot.ajouterCarte(asDuVolant);
            it.remove();
        }
    }
}