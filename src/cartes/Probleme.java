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
		return super.equals(obj) && obj != null && ((Probleme)obj).type == type;
	}

	@Override
	public int hashCode() {
		return 31 * (super.hashCode() + type.hashCode()) ;
	}
}