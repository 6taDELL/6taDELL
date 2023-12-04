package modele.personnage;

import modele.Caracteristiques;
import modele.Personnage;

public class Architecte extends Personnage {

    public Architecte() {
        super("Architecte", 6, Caracteristiques.ARCHITECTE);
    }

    public void utiliserPouvoir() {}
    public void utiliserPouvoirAvatar(){}
}