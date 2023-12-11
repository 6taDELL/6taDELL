package modele.personnage;

import java.util.Random;

import application.Jeu;
import controleur.Interaction;
import modele.Caracteristiques;
import modele.Personnage;

public class Bailli extends Personnage{

    public Bailli() {
        super("Bailli", 9, Caracteristiques.BAILLI);
    }

    public void utiliserPouvoir(){

        if(Jeu.orDesTaxes != 0){
            boolean recupererLOr = false;
            System.out.println("Voulez-vous récupérer l'or des taxes ?");
            recupererLOr = Interaction.lireOuiOuNon();

            if(recupererLOr){
                this.getJoueur().ajouterPieces(Jeu.orDesTaxes);
                Jeu.orDesTaxes = 0;
            }
        }
        

    }
    public void percevoirRessourcesSpecifiques(){

    }

    public void utiliserPouvoirAvatar(){
        Random generateur = new Random();
        if(Jeu.orDesTaxes != 0){
            boolean recupererLOr = false;
            System.out.println("Voulez-vous récupérer l'or des taxes ?");
            recupererLOr = generateur.nextBoolean();

            if(recupererLOr){
                this.getJoueur().ajouterPieces(Jeu.orDesTaxes);
                Jeu.orDesTaxes = 0;
            }
        }
        
    }
}
