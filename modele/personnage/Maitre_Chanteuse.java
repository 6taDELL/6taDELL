package modele.personnage;

import modele.Personnage;
import modele.Caracteristiques;

public class Maitre_Chanteuse extends Personnage{

    public Maitre_Chanteuse() {
        super("Maître-Chanteuse", 2, Caracteristiques.MAITRE_CHANTEUSE);
    }

    public void utiliserPouvoir() {}
    public void utiliserPouvoirAvatar() {}
}
