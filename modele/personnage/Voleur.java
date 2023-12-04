package modele.personnage;

import java.util.Random;

import controleur.Interaction;
import modele.Caracteristiques;
import modele.Personnage;

public class Voleur extends Personnage {

    public Voleur() {
        super("Voleur", 2, Caracteristiques.VOLEUR);
    }
    public void utiliserPouvoir() {}
    public void utiliserPouvoirAvatar() {}

}
