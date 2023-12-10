package modele.personnage;

import modele.Caracteristiques;
import modele.Personnage;

public class Alchimiste extends Personnage {
    
    public Alchimiste() {
        super("Alchimiste", 6, Caracteristiques.ALCHIMISTE);
    }

    public void utiliserPouvoir() {}
    public void utiliserPouvoirAvatar() {}
}
