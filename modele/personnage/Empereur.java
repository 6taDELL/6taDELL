package modele.personnage;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import controleur.Interaction;
import modele.Caracteristiques;
import modele.Joueur;
import modele.Personnage;

public class Empereur extends Personnage {

    public Empereur() {
        super("Empereur", 4, Caracteristiques.EMPEREUR);
    }

    public void utiliserPouvoir() {
		ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();
		for(int i=0; i<this.getPlateau().getNombreJoueurs(); i++) {
			if(this.getPlateau().getJoueur(i).getPossedeCouronne()) {
				this.getPlateau().getJoueur(i).setPossedeCouronne(false);
			}else if(!this.getPlateau().getJoueur(i).getNom().equals(this.getJoueur().getNom())) {
				listeJoueur.add(this.getPlateau().getJoueur(i));
			}
		}
		System.out.println("Veuillez choisir � qui vous voulez donner la couronne");
		for(int j=0; j<listeJoueur.size(); j++) {
			System.out.println((j+1) + " - " + listeJoueur.get(j).getNom());
		}
		int choix = Interaction.lireUnEntier(1, listeJoueur.size()+1) - 1;
		System.out.println("Vous avez choisi " + listeJoueur.get(choix).getNom() + " il va recevoir la couronne");
		listeJoueur.get(choix).setPossedeCouronne(true);
	}

	public void utiliserPouvoirAvatar() {
		ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();
		for(int i=0; i<this.getPlateau().getNombreJoueurs(); i++) {
			if(this.getPlateau().getJoueur(i).getPossedeCouronne()) {
				this.getPlateau().getJoueur(i).setPossedeCouronne(false);
			}else if(!this.getPlateau().getJoueur(i).getNom().equals(this.getJoueur().getNom())) {
				listeJoueur.add(this.getPlateau().getJoueur(i));
			}
		}
		int choix = ThreadLocalRandom.current().nextInt(0, listeJoueur.size());
		System.out.println("Vous avez choisi " + listeJoueur.get(choix).getNom() + " il va recevoir la couronne");
		listeJoueur.get(choix).setPossedeCouronne(true);
	}
}
