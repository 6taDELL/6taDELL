package controleur;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Interaction {
	private static Scanner sc = new Scanner(System.in);

	public static int lireUnEntier() {
		int i = 0;
		boolean continu = true;
		do {
			try {
				i = sc.nextInt();
				continu = false;
			} catch (InputMismatchException e) {
				System.out.print("Veuillez rentrer un chiffre : ");
				sc.next(); // passe l'entier pour éviter de boucler
			}
		} while (continu);
		return i;
	}

	// renvoie un entier lu au clavier compris dans l'intervalle [borneMin, borneMax[
	public static int lireUnEntier(int borneMin, int borneMax) {
		int i = 0;
		boolean isValidInput = false;
		do {
			try {
				System.out.print("Veuillez entrer un entier entre " + borneMin + " et " + (borneMax - 1) + ": ");
				i = sc.nextInt();
				if (i >= borneMin && i < borneMax) {
					isValidInput = true;
				} else {
					System.out.println("La valeur entrée n'est pas dans la plage spécifiée. Veuillez réessayer.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Veuillez entrer un entier valide.");
				sc.next(); // Clear the invalid input
			}
		} while (!isValidInput);
		return i;
	}

	// lit les réponses "oui", "non", "o" ou "n" et renvoie un booléen
	public static boolean lireOuiOuNon() {
		boolean retour = true;
		// ...
		return retour;
	}

	// renvoie une chaîne de caractère lue au clavier:
	public static String lireUneChaine() {
		String retour = "";
		//...
		return retour;
	}
}
