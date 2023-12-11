package modele.personnage;

import modele.Caracteristiques;
import modele.Personnage;

public class Echevin extends Personnage {
    public Echevin() {
        super("Echevin", 1, Caracteristiques.ECHEVIN);
    }

    public void utiliserPouvoir() {}
    public void utiliserPouvoirAvatar() {}
}
