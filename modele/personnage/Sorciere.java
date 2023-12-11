package modele.personnage;

import java.util.Random;

import controleur.Interaction;
import modele.Caracteristiques;
import modele.Joueur;
import modele.Personnage;

public class Sorciere extends Personnage {
    public Sorciere() {
        super("Sorcière", 1, Caracteristiques.SORCIERE);
    }

    public Personnage persoEnsorcele=null; 

    public void utiliserPouvoir() {
        int choix=-1;
        do {
            for(int i=0; i<this.getPlateau().getNombrePersonnages(); i++){
                System.out.println((i+1)+". "+this.getPlateau().getPersonnage(i).getNom());
            }
            System.out.println("Choisissez un personnage à ensorceler (vous ne pouvez pas vous choisir)");
            choix = Interaction.lireUnEntier(1, this.getPlateau().getNombrePersonnages())-1;
            persoEnsorcele = this.getPlateau().getPersonnage(choix);
        } while (persoEnsorcele.equals(this));
        System.out.println("Vous avez choisi: "+persoEnsorcele.getNom()+", votre tour reprendra que ce personnage sera appelé");
        
        persoEnsorcele.setEnsorcele(true);  
    }

    public void utiliserPouvoirAvatar() {
        int choix=-1;
        
        Random random = new Random();
        do {
            for(int i=0; i<this.getPlateau().getNombrePersonnages(); i++){
                System.out.println((i+1)+". "+this.getPlateau().getPersonnage(i).getNom());
            }
            System.out.println("Choisissez un personnage à ensorceler (vous ne pouvez pas vous choisir)");
            choix = random.nextInt(this.getPlateau().getNombrePersonnages());
            persoEnsorcele = this.getPlateau().getPersonnage(choix);
        } while (persoEnsorcele.equals(this));
        System.out.println("Vous avez choisi: "+persoEnsorcele.getNom()+", votre tour reprendra que ce personnage sera appelé");
        persoEnsorcele.setEnsorcele(true);
    }
    public void activationPouvoirSorciere(Joueur joueurSorciere){
        persoEnsorcele.setJoueur(joueurSorciere);
    }
}
