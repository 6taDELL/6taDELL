package modele.personnage;

import modele.Caracteristiques;
import modele.Personnage;

public class Alchimiste extends Personnage {
    
    public Alchimiste() {
        super("Alchimiste", 6, Caracteristiques.ALCHIMISTE);
    }

    public void utiliserPouvoir() {
        System.out.println("Pas de pouvoir");
        
    }

    public void utiliserPouvoirAvatar() {
        System.out.println("Pas de pouvoir");
        
    }
}
