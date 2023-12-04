package modele.personnage;

import java.util.Random;

import controleur.Interaction;
import modele.Caracteristiques;
import modele.Personnage;

public class Condottiere extends Personnage {


    public Condottiere() {
        super("Condottiere", 8, Caracteristiques.CONDOTTIERE);

    }

    public void percevoirRessourcesSpecifiques() {}
    public void utiliserPouvoir(){}
    public void utiliserPouvoirAvatar(){}

}
