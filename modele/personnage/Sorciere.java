package modele.personnage;

import modele.Caracteristiques;
import modele.Personnage;

public class Sorciere extends Personnage {
    public Sorciere() {
        super("Sorcière", 1, Caracteristiques.SORCIERE);
    }

    public void utiliserPouvoir() {}
    public void utiliserPouvoirAvatar() {}
}
