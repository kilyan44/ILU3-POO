package cartes;

public abstract class Probleme extends Carte {
	protected Type type;

	protected Probleme(Type type) {
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Probleme probleme && getClass() == obj.getClass()) {
			return type.equals(probleme.getType());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return type.hashCode();
	}
}