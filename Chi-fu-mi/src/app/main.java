package app;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

import chifumi.Jeu;
import chifumi.Joueur;

public class main {

	public static void main(String[] args) {
		Joueur j1 = new Joueur();
		Joueur j2 = new Joueur();
		Jeu jeu = new Jeu(j1, j2);
		jeu.commencer();
		try {
			jeu.jouer();
		} catch (IOException e) {
		}
	}
}
