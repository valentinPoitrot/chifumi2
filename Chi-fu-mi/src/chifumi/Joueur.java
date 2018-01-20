package chifumi;

import java.util.List;

public class Joueur {

	private String pseudo;
	private List<Coup> listeDeCoup;
	private Integer score = 0;

	public Joueur() {
	}

	@Override
	public String toString() {
		return "Joueur [pseudo=" + pseudo + "]";
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public List<Coup> getListeDeCoup() {
		return listeDeCoup;
	}

	public void setListeDeCoup(List<Coup> listeDeCoup) {
		this.listeDeCoup = listeDeCoup;
	}

}