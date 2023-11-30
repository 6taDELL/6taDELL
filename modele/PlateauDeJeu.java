package modele;

public class PlateauDeJeu {
    protected Personnage[] listePersonnages;
    private Joueur[] listeJoueurs;
    private Pioche pioche;
    private int nombrePersonnages;
    private int nombreJoueurs;

    public PlateauDeJeu() { //Constructeur
        this.listePersonnages = new Personnage[9];
        this.listeJoueurs = new Joueur[9];
        this.nombreJoueurs = 0;
        this.nombrePersonnages = 0;
        this.pioche = new Pioche();
    }
    public int getNombrePersonnages() {}
    public int getNombreJoueurs() {}
    public Pioche getPioche() {}
    public Personnage getPersonnage(int i) {}
    public Joueur getJoueur(int i){}
    public void ajouterPersonnage(Personnage personnage, Joueur joueur){}
    public void ajouterJoueur(Joueur joueur){}
    
}
