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

}