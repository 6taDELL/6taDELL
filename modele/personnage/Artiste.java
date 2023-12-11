package modele.personnage;

import modele.Caracteristiques;
import modele.Personnage;

public class Artiste extends Personnage{

    public Artiste() {
        super("Artiste", 9, Caracteristiques.ARTISTE);
    }

    public void utiliserPouvoir() {}
    public void utiliserPouvoirAvatar() {}
}
