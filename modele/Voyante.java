package modele;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import controleur.Interaction;

public class Voyante extends Personnage {
    public Voyante() {
        super("Voyante", 3, Caracteristiques.VOYANTE);
    }

    public void utiliserPouvoir() {
		ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();

		System.out.println("Vous allez prendre une carte aléatoirement à chaque joueur possédant des cartes dans sa main"
				+ " ensuite en redistribuer à chaque joueur librement");
		System.out.println("Voici les quartiers que vous avez récupérés ainsi que les joueurs auxquels ils appartenaient");
		for(int i=0; i<this.getPlateau().getNombreJoueurs(); i++) {
			if(this.getPlateau().getJoueur(i).getMain().size()> 0 && !this.getPlateau().getJoueur(i).getNom().equals(this.getJoueur().getNom())) {
				int index = ThreadLocalRandom.current().nextInt(0, this.getPlateau().getJoueur(i).getMain().size());
				Quartier quartier = this.getPlateau().getJoueur(i).getMain().get(index);
				this.getPlateau().getJoueur(i).retirerQuartierDansMain(quartier);
				this.getJoueur().ajouterQuartierDansMain(quartier);
				System.out.println(" - " + quartier.getNom() + " ( " + quartier.getCout() + " ) " + " / " + this.getPlateau().getJoueur(i).getNom());
				listeJoueur.add(this.getPlateau().getJoueur(i));
			}else {
				System.out.println("Le joueur " + this.getPlateau().getJoueur(i).getNom() + " n'a pas de cartes en main");
			}
		}

		System.out.println("Vous allez maintenat devoir redistribuer une carte � chaque joueur");
		for(int i = 0; i<listeJoueur.size(); i++) {
			System.out.println("Veuillez choisir un quartier à donner : " + listeJoueur.get(i).getNom());
			for(int j=0; j<this.getJoueur().getMain().size(); j++) {
				System.out.println((j+1) + " - " + this.getJoueur().getMain().get(j).getNom() + " ( " + this.getJoueur().getMain().get(j).getCout() + " ) " );
			}
			int choix = Interaction.lireUnEntier(1, this.getJoueur().getMain().size())-1;
			Quartier quartier2 = this.getJoueur().getMain().get(choix);
			this.getJoueur().retirerQuartierDansMain(quartier2);
			listeJoueur.get(i).ajouterQuartierDansMain(quartier2);
		}



	}

	@Override
	public void utiliserPouvoirAvatar() {
		ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();

		System.out.println("Vous allez prendre une carte al�atoirement � chaque joueur poss�dant des cartes dans sa main"
				+ " ensuite en redistribuer � chaque joueur librement");
		System.out.println("Voici les quartiers que vous avez r�cup�r�s ainsi que les joueurs auxquels ils appartenaient");
		for(int i=0; i<this.getPlateau().getNombreJoueurs(); i++) {
			if(this.getPlateau().getJoueur(i).getMain().size()> 0 && !this.getPlateau().getJoueur(i).getNom().equals(this.getJoueur().getNom())) {
				int index = ThreadLocalRandom.current().nextInt(0, this.getPlateau().getJoueur(i).getMain().size());
				Quartier quartier = this.getPlateau().getJoueur(i).getMain().get(index);
				this.getPlateau().getJoueur(i).retirerQuartierDansMain(quartier);
				this.getJoueur().ajouterQuartierDansMain(quartier);
				System.out.println(" - " + quartier.getNom() + " ( " + quartier.getCout() + " ) " + " / " + this.getPlateau().getJoueur(i).getNom());
				listeJoueur.add(this.getPlateau().getJoueur(i));
			}else if(this.getPlateau().getJoueur(i).getMain().size() == 0){
				System.out.println("Le joueur " + this.getPlateau().getJoueur(i).getNom() + " n'a pas de cartes en main");
			}
		}

		System.out.println("Vous allez maintenat devoir redistribuer une carte � chaque joueur");
		for(int i = 0; i<listeJoueur.size(); i++) {
			System.out.println("Veuillez choisir un quartier � donner � " + listeJoueur.get(i).getNom());
			for(int j=0; j<this.getJoueur().getMain().size(); j++) {
				System.out.println((j+1) + " - " + this.getJoueur().getMain().get(j).getNom() + " ( " + this.getJoueur().getMain().get(j).getCout() + " ) " );
			}
			int choix = ThreadLocalRandom.current().nextInt(0, this.getJoueur().getMain().size());
			Quartier quartier2 = this.getJoueur().getMain().get(choix);
			this.getJoueur().retirerQuartierDansMain(quartier2);
			listeJoueur.get(i).ajouterQuartierDansMain(quartier2);
		}

	}
}
