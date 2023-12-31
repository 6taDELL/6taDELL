package test;

import modele.Caracteristiques;
import modele.Joueur;
import modele.PlateauDeJeu;
import modele.Quartier;
import modele.Artiste;

public class TestArtiste {

	public static void main(String[] args) {
		TestArtiste test= new TestArtiste();
		test.test1();
		test.test2();	
	}
	
	public void test1(){
		System.out.println("TEST DU CONSTRUCTEUR");
		Artiste artiste = new Artiste();
		Test.test(artiste.getNom().equals("Artiste"),"test du nom du personnage");
		Test.test(artiste.getRang()== 9,"test du rang du personnage");
		Test.test(artiste.getCaracteristiques().equals(Caracteristiques.ARTISTE),
				"test des caract�ristiques du personnage");
		Test.test(artiste.getJoueur()==null, "test de l'initialisation de la variable \"joueur\"");
		Test.test(artiste.getAssassine()==false, "test de l'initialisation de la variable \"assassine\"");
		Test.test(artiste.getVole()==false, "test de l'initialisation de la variable \"vole\"");
	}
	public void test2() {
		System.out.println("TEST DU POUVOIR");
		PlateauDeJeu plateau = new PlateauDeJeu();
        Artiste artiste = new Artiste();
        Joueur jArtiste = new Joueur("jArtiste");
        artiste.setJoueur(jArtiste);
        plateau.ajouterPersonnage(artiste);
        plateau.ajouterJoueur(jArtiste);
		jArtiste.ajouterPieces(2);
        Test.test(jArtiste.nbPieces()==2 , "Test des trésors avant utilisation du pouvoir");
		jArtiste.ajouterQuartierDansCite(new Quartier("temple", Quartier.TYPE_QUARTIERS[0], 1));
        jArtiste.ajouterQuartierDansCite(new Quartier("église", Quartier.TYPE_QUARTIERS[0], 2));

		artiste.utiliserPouvoir();
        Test.test(jArtiste.nbPieces()<=2, "Test des trésors après utilisation du pouvoir");
		if(jArtiste.getCite()[0].getEmbelli()){
			Test.test(jArtiste.getCite()[0].getCout()==2 , "Augmentation du cout du temple");
		}else{
			Test.test(jArtiste.getCite()[0].getCout()==1 , "Cout du temple inchangé");
		}
		if(jArtiste.getCite()[1].getEmbelli()){
			Test.test(jArtiste.getCite()[1].getCout()==3 , "Augmentation du cout de l'église");
		}else{
			Test.test(jArtiste.getCite()[1].getCout()==2 , "Cout de l'église inchangé");
		}
        
	}
}