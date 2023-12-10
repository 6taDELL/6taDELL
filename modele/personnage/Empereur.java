package modele.personnage;

import modele.Caracteristiques;
import modele.Personnage;

public class Empereur extends Personnage {

    public Empereur() {
        super("Empereur", 4, Caracteristiques.EMPEREUR);
    }

    public void utiliserPouvoir() {}
    public void utiliserPouvoirAvatar() {}
}
