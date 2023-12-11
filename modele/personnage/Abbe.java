package modele.personnage;

import modele.Caracteristiques;
import modele.Personnage;

public class Abbe extends Personnage {
    
    public Abbe() {
        super("Abbé", 5, Caracteristiques.ABBE);
    }

    public void utiliserPouvoir() {}
    public void utiliserPouvoirAvatar() {}
}
