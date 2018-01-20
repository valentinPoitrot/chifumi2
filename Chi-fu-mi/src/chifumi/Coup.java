package chifumi;

public enum Coup {

	Pierre("pierre"), Feuille("feuille"), Ciseaux("ciseaux");

	private String value;

	Coup(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}