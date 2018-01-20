package chifumi;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Jeu {
	private Joueur j1 = new Joueur();
	private Joueur j2 = new Joueur();

	public Jeu(Joueur j1, Joueur j2) {
		this.j1 = j1;
		this.j1.setPseudo("Joueur 1");
		this.j2 = j2;
		this.j2.setPseudo("Joueur 2");
	}

	public void commencer() {
		creerJoueur(this.j1);
		creerJoueur(this.j2);
	}

	public void creerJoueur(Joueur j) {
		Console co = System.console();
		System.out.println(String.format("Entrez un pseudo pour %s:\n", j.getPseudo()));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String pseudo = "";
		try {
			pseudo = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (pseudo.length() > 0) {
			j.setPseudo(pseudo);
			j.setScore(0);
			System.out.println(j.getPseudo());
		} else {
			System.out.println("Pseudo incorrect");
			creerJoueur(j);
		}
	}

	public void jouer() throws IOException {
		List<Tour> toursj1 = new ArrayList<Tour>();
		List<Tour> toursj2 = new ArrayList<Tour>();
		this.j1.setListeDeTour(toursj1);
		this.j2.setListeDeTour(toursj2);
		for (int index = 0; index < 3; index++) {
			tourJoueur(this.j1, index);
			tourJoueur(this.j2, index);
			System.out.println(verifierJeu(index));
		}
		if(this.j1.getScore()>this.j2.getScore())
		{
			System.out.println(this.j1.getPseudo()+" is the WINNER");
		}
		else if (this.j1.getScore()<this.j2.getScore())
		{
			System.out.println(this.j2.getPseudo()+" is the WINNER");
		}
		else {
			System.out.println("Egalité... On rejoue ? [O/n] \n");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String answer = br.readLine();
			if(answer.equals("") || answer.equals("O"))
			{
			jouer();
			}
			else
			{
				System.exit(0);
			}
		}
	}

	public void tourJoueur(Joueur j, int index) throws IOException {
		int indexTour = index + 1;
		System.out.println("tour " + indexTour);
		Tour tour = new Tour();
		System.out.println(j.getPseudo() + " entrez 1 pour Pierre,2 pour Feuille et 3 pour Ciseaux :\n");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String value = br.readLine();
		int valueint = 0;
		try {
			valueint = Integer.valueOf(value);
			//Integer.valueOf(value); throws a NumberFormatException if a letter is typed.
		} catch (NumberFormatException nbE) {
			System.err.println("Je n'ai pas compris ta réponse \n Essaie à nouveau: \n");
			tourJoueur(j, index);
		}
		switch (valueint) {
		case 1:
			tour.setCoup(Coup.Pierre);
			break;
		case 2:
			tour.setCoup(Coup.Feuille);
			break;
		case 3:
			tour.setCoup(Coup.Ciseaux);
			break;

		default:
			System.err.println("Je n'ai pas compris ta réponse \n Essaie à nouveau: \n");
			tourJoueur(j, index);
			break;
		}
		j.getListeDeTour().add(tour);

	}

	public String verifierJeu(int index) {
		StringBuilder sb = new StringBuilder();
		if (this.j1.getListeDeTour().get(index).getCoup().equals(Coup.Ciseaux)
				&& this.j2.getListeDeTour().get(index).getCoup().equals(Coup.Pierre)) {
			this.j2.setScore(this.j2.getScore() + 1);
			sb.append(this.j2.getPseudo());
			sb.append(" a gagné la manche \n");

		} else if (this.j1.getListeDeTour().get(index).getCoup().equals(Coup.Pierre)
				&& this.j2.getListeDeTour().get(index).getCoup().equals(Coup.Ciseaux)) {
			this.j1.setScore(this.j1.getScore() + 1);
			sb.append(this.j1.getPseudo());
			sb.append(" a gagné la manche \n");

		} else if (this.j1.getListeDeTour().get(index).getCoup().equals(Coup.Feuille)
				&& this.j2.getListeDeTour().get(index).getCoup().equals(Coup.Ciseaux)) {
			this.j1.setScore(this.j2.getScore() + 1);
			sb.append(this.j2.getPseudo());
			sb.append(" a gagné la manche \n");

		} else if (this.j1.getListeDeTour().get(index).getCoup().equals(Coup.Ciseaux)
				&& this.j2.getListeDeTour().get(index).getCoup().equals(Coup.Feuille)) {
			this.j1.setScore(this.j1.getScore() + 1);
			sb.append(this.j1.getPseudo());
			sb.append(" a gagné la manche \n");
		}

		else if (this.j1.getListeDeTour().get(index).getCoup().equals(Coup.Pierre)
				&& this.j2.getListeDeTour().get(index).getCoup().equals(Coup.Feuille)) {
			this.j2.setScore(this.j2.getScore() + 1);
			sb.append(this.j2.getPseudo());
			sb.append(" a gagné la manche \n");

		} else if (this.j1.getListeDeTour().get(index).getCoup().equals(Coup.Feuille)
				&& this.j2.getListeDeTour().get(index).getCoup().equals(Coup.Pierre)) {
			this.j1.setScore(this.j1.getScore() + 1);
			sb.append(this.j1.getPseudo());
			sb.append(" a gagné la manche \n");

		} else if (this.j1.getListeDeTour().get(index).getCoup()
				.equals(this.j2.getListeDeTour().get(index).getCoup())) {
			this.j1.setScore(this.j1.getScore() + 1);
			this.j2.setScore(this.j2.getScore() + 1);
			sb.append("égalité \n");
		}
		sb.append("\n");
		sb.append("Scores :\n");
		sb.append(this.j1.getPseudo());
		sb.append(" ");
		sb.append(this.j1.getScore());
		sb.append("\n");
		sb.append(this.j2.getPseudo());
		sb.append(" ");
		sb.append(this.j2.getScore());
		sb.append("\n");
		return sb.toString();
	}
}
