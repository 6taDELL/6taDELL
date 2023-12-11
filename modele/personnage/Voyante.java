package modele.personnage;

import modele.Caracteristiques;
import modele.Personnage;

public class Voyante extends Personnage {
    public Voyante() {
        super("Voyante", 3, Caracteristiques.VOYANTE);
    }

    public void utiliserPouvoir() {}
    public void utiliserPouvoirAvatar() {}
}
