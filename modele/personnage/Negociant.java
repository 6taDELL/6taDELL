package modele.personnage;

import modele.Caracteristiques;
import modele.Personnage;

public class Negociant extends Personnage {

    public Negociant() {
        super("Négociant", 6, Caracteristiques.NEGOCIANT);
    }

    public void utiliserPouvoir() {}
    public void utiliserPouvoirAvatar() {}
}
