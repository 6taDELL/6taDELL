package modele.personnage;

import modele.Caracteristiques;
import modele.Personnage;

public class Cardinal extends Personnage {
    
    public Cardinal() {
        super("Cardinal", 5, Caracteristiques.CARDINAL);
    }

    public void utiliserPouvoir() {}
    public void utiliserPouvoirAvatar() {}
}
