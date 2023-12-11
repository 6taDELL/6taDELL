package modele.personnage;

import modele.Caracteristiques;
import modele.Personnage;

public class Archiviste extends Personnage{
    public Archiviste() {
        super("Archiviste", 7, Caracteristiques.ARCHIVISTE);
    }

    public void utiliserPouvoir() {}
    public void utiliserPouvoirAvatar() {}
}
