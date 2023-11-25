package modele;

import java.util.ArrayList;

public class Joueur {
    private String nom;   
    private int tresor;
    private Quartier[] cite;
    private int nbQuartiers;
    private ArrayList < Quartier > main;
    private boolean possedeCouronne;    
    

    public Joueur(String nom) {}
    public Personnage getPersonnage() {}
    public String getNom() {} 
    public int nbPieces() {}
    public int nbQuartiersDansCite() {}
    public Quartier[] getCite() {}
    public ArrayList < Quartier > getMain() {}  
    public boolean isRangPlusEleve() {}
    public void setRangPlusEleve() {}
    public boolean isSimule() {}
    public void setSimule(boolean simule) {}
    public void setPremier(boolean premier) {}
    public int nbQuartiersDansMain() {}
    public boolean getPossedeCouronne() {}
    public void setPossedeCouronne(boolean b) {}
    public void ajouterPieces(int piece) {}
    public void retirerPieces(int piece) {}
    public void ajouterQuartierDansCite(Quartier quartier) {}
    public boolean quartierPresentDansCite(String quartier) {}
    public Quartier retirerQuartierDansCite(String quartier) {}
    public void ajouterQuartierDansMain(Quartier quartier) {}
    public Quartier retirerQuartierDansMain() {}
    public void reinitialiser() {}
}
  