package modele;

public abstract class Personnage{
    protected String nom;
    protected int rang;
    protected String caracteristiques;
    protected Joueur joueur;
    protected boolean assassine;
    protected boolean vole;
    protected Plateau plateau;

    public Personnage(String nom, int rang, String caracteristiques) { //Constructeur
        this.nom = nom;
        this.rang = rang;
        this.caracteristiques = caracteristiques;
        joueur = null;
        assassine = false;
        vole = false;
    }
    public String getNom(){}
    public int getRang() {}
    public String getCaracteristiques() {}
    public Joueur getJoueur() {}
    public boolean getAssassine(){}
    public boolean getVole(){}
    public void setJoueur(Joueur j) {}
    public void setVole() {}
    public void setAssassine() {}
    public void ajouterPieces() {}
    public void ajouterQuartier(Quartier nouveau) { }
    public void construire(Quartier nouveau) {}
    public void percevoirRessourcesSpecifiques() {}
    public abstract void utiliserPouvoir();
    public void reinitialiser() {}

}