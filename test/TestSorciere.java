package test;

import modele.Caracteristiques;
import modele.Joueur;
import modele.PlateauDeJeu;
import modele.Architecte;
import modele.Sorciere;

public class TestSorciere {

	public static void main(String[] args) {
		TestSorciere test= new TestSorciere();
		test.test1();
		test.test2();	
	}
	
	public void test1(){
		System.out.println("TEST DU CONSTRUCTEUR");
		Sorciere sorciere = new Sorciere();
		Test.test(sorciere.getNom().equals("Sorciere"),"test du nom du personnage");
		Test.test(sorciere.getRang()== 1,"test du rang du personnage");
		Test.test(sorciere.getCaracteristiques().equals(Caracteristiques.SORCIERE),
				"test des caractéristiques du personnage");
		Test.test(sorciere.getJoueur()==null, "test de l'initialisation de la variable \"joueur\"");
		Test.test(sorciere.getAssassine()==false, "test de l'initialisation de la variable \"assassine\"");
		Test.test(sorciere.getVole()==false, "test de l'initialisation de la variable \"vole\"");
	}
	
	public void test2(){
		System.out.println("TEST DE L'UTILISATION DU POUVOIR");
		// on crée un plateau et on ajoute des cartes Quartier dans la pioche:		
		PlateauDeJeu plateau = new PlateauDeJeu();
		// on ajoute le personnage au plateau:
		Sorciere sorciere = new Sorciere();
		plateau.ajouterPersonnage(sorciere);
        Architecte architecte = new Architecte();
		plateau.ajouterPersonnage(architecte);
		// on ajoute le joueur au plateau:
		Joueur jSorciere = new Joueur("jSorciere");
		plateau.ajouterJoueur(jSorciere);
		sorciere.setJoueur(jSorciere);
        Joueur jArchitecte = new Joueur("jArchitecte");
        plateau.ajouterJoueur(jArchitecte);
		architecte.setJoueur(jArchitecte);

		Test.test(sorciere.getJoueur().getNom().equals("jSorciere"),
				"test du joueur ayant la sorciere");			
		sorciere.utiliserPouvoirAvatar();
        Test.test(architecte.getJoueur().getNom().equals("jSorciere"), "Test du joueur ayant l'architecte");
        
			
	}
}
