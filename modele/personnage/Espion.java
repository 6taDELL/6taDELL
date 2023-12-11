package modele.personnage;

import modele.Caracteristiques;
import modele.Personnage;

public class Espion extends Personnage {

    public Espion() {
        super("Espion", 2, Caracteristiques.ESPION);
    }

    public void utiliserPouvoir() {}
    public void utiliserPouvoirAvatar() {}
}
