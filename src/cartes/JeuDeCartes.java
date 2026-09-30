package cartes;

public class JeuDeCartes {

	private static class Configuration {
		private Carte carte;
		private Integer nbExemplaires;

		private Configuration(Carte carte, Integer nbExemplaires) {
			this.carte = carte;
			this.nbExemplaires = nbExemplaires;
		}

		public Carte getCarte() {
			return carte;
		}

		public Integer getNbExemplaires() {
			return nbExemplaires;
		}
	}

	private Configuration[] typesDeCartes = { new Configuration(new Borne(25), 10),
			new Configuration(new Borne(50), 10), new Configuration(new Borne(75), 10),
			new Configuration(new Borne(100), 12), new Configuration(new Borne(200), 4),

			new Configuration(new Parade(Type.FEU), 14), new Configuration(new Attaque(Type.FEU), 5),
			new Configuration(new FinLimite(), 6), new Configuration(new Parade(Type.ESSENCE), 6),
			new Configuration(new Parade(Type.ACCIDENT), 6), new Configuration(new Attaque(Type.ESSENCE), 3),
			new Configuration(new Attaque(Type.CREVAISON), 3), new Configuration(new Attaque(Type.ACCIDENT), 3),
			new Configuration(new DebutLimite(), 4),

			new Configuration(new Botte(Type.FEU), 1), new Configuration(new Botte(Type.ESSENCE), 1),
			new Configuration(new Botte(Type.CREVAISON), 1), new Configuration(new Botte(Type.ACCIDENT), 1) };

	public String affichageJeuDeCartes() {
		StringBuilder sb = new StringBuilder();
		for (Configuration config : typesDeCartes) {
			sb.append(config.getNbExemplaires());
			sb.append(" ").append(config.getCarte()).append("\n");
		}
		return sb.toString();
	}

	public Carte[] donnerCartes() {
		int total = 0;
		for (int i = 0; i < typesDeCartes.length; i++) {
			total += typesDeCartes[i].getNbExemplaires();
		}

		Carte[] cartes = new Carte[total];
		int debut = 0;
		for (int i = 0; i < typesDeCartes.length; i++) {
			Configuration config = typesDeCartes[i];
			for (int j = 0; j < config.getNbExemplaires(); j++) {
				cartes[debut + j] = config.getCarte();
			}
			debut += config.getNbExemplaires();
		}

		return cartes;
	}
}