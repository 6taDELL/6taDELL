package modele.personnage;

import modele.Caracteristiques;
import modele.Personnage;

public class Diplomate extends Personnage{

    public Diplomate() {
        super("Diplomate", 8, Caracteristiques.DIPLOMATE);
    }

    public void utiliserPouvoir() {}
    public void utiliserPouvoirAvatar() {}
}
