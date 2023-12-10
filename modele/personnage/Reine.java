package modele.personnage;

import modele.Caracteristiques;
import modele.Personnage;

public class Reine extends Personnage{

    public Reine() {
        super("Reine", 9, Caracteristiques.REINE);
    }

    public void utiliserPouvoir() {}
    public void utiliserPouvoirAvatar() {}
}
