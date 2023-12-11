package modele.personnage;

import modele.Caracteristiques;
import modele.Personnage;

public class Sorcier extends Personnage {
    public Sorcier() {
        super("Sorcier", 3, Caracteristiques.SORCIER);
    }

    public void utiliserPouvoir() {}
    public void utiliserPouvoirAvatar() {}
}
