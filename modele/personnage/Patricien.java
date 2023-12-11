package modele.personnage;

import modele.Caracteristiques;
import modele.Personnage;

public class Patricien extends Personnage {

    public Patricien() {
        super("Patricien", 4, Caracteristiques.PATRICIEN);
    }

    public void utiliserPouvoir() {}
    public void utiliserPouvoirAvatar() {}
}
