package modele.personnage;

import modele.Caracteristiques;
import modele.Personnage;

public class Capitaine extends Personnage{
    public Capitaine() {
        super("Capitaine", 8, Caracteristiques.CAPITAINE);
    }

    public void utiliserPouvoir() {}
    public void utiliserPouvoirAvatar() {}
}
