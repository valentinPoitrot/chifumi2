package chifumi;

import java.util.List;

public class Joueur {

	private String pseudo;
	private List<Tour> listeDeTour;
	private Integer score = 0;

	public Joueur() {
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

	public List<Tour> getListeDeTour() {
		return listeDeTour;
	}

	public void setListeDeTour(List<Tour> listeDeTour) {
		this.listeDeTour = listeDeTour;
	}

}