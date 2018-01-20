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
		this.j2 = j2;
	}

	public void commencer() {
		creerJoueur(this.j1);
		creerJoueur(this.j2);
	}

	public void creerJoueur(Joueur j) {
		Console co = System.console();
		System.out.println("Entrez un pseudo:\n");
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
		
		}
	}

public void setTours(List<Tour> tours, int index) {
	for (int index = 0; index < 3; index++) {
		System.out.println("tour " + index + 1);
		Tour tour = new Tour();
		System.out.println("Entrez 1 pour Pierre,2 pour Feuille et 3 pour Ciseaux :\n");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String value = br.readLine();
		int valueint = Integer.parseInt(value);
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
			System.err.println("C est 1,2 ou 3, espèce de SISR va, du coup bah t 'as pierre");
			tour.setCoup(Coup.Pierre);
			break;
		}		
		tours.add(tour);
}

}
