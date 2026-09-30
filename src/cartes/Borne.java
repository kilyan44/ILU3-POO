package cartes;

public class Borne extends Carte {
	private Integer km;

	public Borne(Integer km) {
		this.km = km;
	}

	public Integer getKm() {
		return km;
	}

	@Override
	public String toString() {
		return km + " km";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Borne borne) {
			return km.equals(borne.getKm());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return km.hashCode();
	}
}