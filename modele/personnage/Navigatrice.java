package modele.personnage;

import modele.Caracteristiques;
import modele.Personnage;

public class Navigatrice extends Personnage {
    public Navigatrice() {
        super("Navigatrice", 7, Caracteristiques.NAVIGATRICE);
    }

    public void utiliserPouvoir() {}
    public void utiliserPouvoirAvatar() {}
}
