package application;

import java.util.ArrayList;

import modele.Abbe;
import modele.Alchimiste;
import modele.Architecte;
import modele.Archiviste;
import modele.Artiste;
import modele.Assassin;
import modele.Bailli;
import modele.Capitaine;
import modele.Cardinal;
import modele.Condottiere;
import modele.Diplomate;
import modele.Echevin;
import modele.Empereur;
import modele.Espion;
import modele.Eveque;
import modele.Joueur;
import modele.Magicienne;
import modele.Maitre_Chanteuse;
import modele.Marchande;
import modele.Navigatrice;
import modele.Negociant;
import modele.Patricien;
import modele.Personnage;
import modele.Pioche;
import modele.PlateauDeJeu;
import modele.Quartier;
import modele.Reine;
import modele.Roi;
import modele.Sorcier;
import modele.Sorciere;
import modele.Voleur;
import modele.Voyante;

public class Configuration {
    //Déclaration des Quartiers
    //Type : RELIGIEUX
    private static Quartier temple = new Quartier("temple", Quartier.TYPE_QUARTIERS[0], 1);
    private static Quartier eglise = new Quartier("église", Quartier.TYPE_QUARTIERS[0], 2);
    private static Quartier monastere = new Quartier("monastère", Quartier.TYPE_QUARTIERS[0], 3);
    private static Quartier cathedrale = new Quartier("cathédrale", Quartier.TYPE_QUARTIERS[0], 5);
    //Type : MILITAIRE
    private static Quartier tour_guet = new Quartier("tour de guet", Quartier.TYPE_QUARTIERS[1], 1);
    private static Quartier prison = new Quartier("prison", Quartier.TYPE_QUARTIERS[1], 2);
    private static Quartier caserne = new Quartier("caserne", Quartier.TYPE_QUARTIERS[1], 3);
    private static Quartier forteresse = new Quartier("forteresse", Quartier.TYPE_QUARTIERS[1], 5);
    //Type : NOBLE
    private static Quartier manoir = new Quartier("manoir", Quartier.TYPE_QUARTIERS[2], 3);
    private static Quartier chateau = new Quartier("château", Quartier.TYPE_QUARTIERS[2], 4);
    private static Quartier palais = new Quartier("palais", Quartier.TYPE_QUARTIERS[2], 5);
    //Type : COMMERCANT
    private static Quartier taverne = new Quartier("tarvene", Quartier.TYPE_QUARTIERS[3], 1);
    private static Quartier echope = new Quartier("échoppe", Quartier.TYPE_QUARTIERS[3], 2);
    private static Quartier marche = new Quartier("marché", Quartier.TYPE_QUARTIERS[3], 2);
    private static Quartier comptoir = new Quartier("comptoir", Quartier.TYPE_QUARTIERS[3], 3);
    private static Quartier port = new Quartier("port", Quartier.TYPE_QUARTIERS[3], 4);
    private static Quartier hotel_ville = new Quartier("hôtel de ville", Quartier.TYPE_QUARTIERS[3], 5);

    //Déclaration des Merveilles
    public static Quartier basilique = new Quartier("Basilique", Quartier.TYPE_QUARTIERS[4], 4, "A la fin de la partie, marquez 1 point suppl´ementaire pour chaque quartier au cout de `construction impair dans votre cit´e.");
    public static Quartier bibliotheque = new Quartier("Bibliotheque", Quartier.TYPE_QUARTIERS[4], 6, "Si vous choisissez de piocher des cartes au debut du tour, concervez-les toutes.");
    public static Quartier capitole = new Quartier("Capitole", Quartier.TYPE_QUARTIERS[4], 5, " la fin de la partie, marquez 3 points suppl´ementaires si vous avez au moins 3 quartiers du `mˆeme type (couleur) dans votre cit´e. Vous ne pouvez utiliser l’effet du capitole qu’une seule fois.");
    public static Quartier carriere = new Quartier("Carriere", Quartier.TYPE_QUARTIERS[4], 5, "Vous pouvez batir des quartiers identiques a d’autres quartiers de votre cite. Le proprietaire de la carri`ere peut batir autant de quartiers identiques qu’il le souhaite, mais ne peut pas utiliser le pouvoir de l’Echevin, du Diplomate ou du Capitaine pour acquerir des quartiers identiques.");
    public static Quartier catacombes = new Quartier("Catacombes", Quartier.TYPE_QUARTIERS[4], 0, "Les catacombes ne peuvent pas ˆetre bˆaties. A la fin de la partie, si vous avez les catacombes `dans votre main, marquez 3 points suppl´ementaires.");
    public static Quartier chantier = new Quartier("Chantier", Quartier.TYPE_QUARTIERS[4], 3, "Pour bˆatir un quartier, vous pouvez d´etruire le chantier au lieu de payer le coˆut de construction. L’Echevin ne peut pas confisquer un quartier bˆati en d´etruisant le chantier. ");
    public static Quartier courDesMiracles = new Quartier("Cour des Miracles", Quartier.TYPE_QUARTIERS[4], 2, "Pour le calcul du score final, la Cour des Miracles est consideree comme un quartier de type (couleur) de votre choix. Dans la cas ou le proprietaire la considere comme un quartier noble, militaire, marchant ou religieux, la Cour des Miracles ne peut plus etre consideree comme une merveille.");
    public static Quartier donjon = new Quartier("Donjon", Quartier.TYPE_QUARTIERS[4], 3, "Le Donjon ne peut etre affecte par les pouvoirs des personnages de rang 8.");
    public static Quartier dracoport = new Quartier("Dracoport", Quartier.TYPE_QUARTIERS[4], 6, "Marquez 2 points supplementaires a la fin de la partie.");
    public static Quartier ecoleDeMagie = new Quartier("Ecole de Magie", Quartier.TYPE_QUARTIERS[4], 6, "Pour la perception des revenus des personnages, l’Ecole de Magie est consideree comme un quartier du type (couleur) de votre choix.");
    public static Quartier ecuries = new Quartier("Ecuries", Quartier.TYPE_QUARTIERS[4], 2, "Vous pouvez bˆatir les Ecuries sans qu’elles comptent dans votre permis de construire. Si ´les Ecuries sont confisqu´ees par l’ ´ Echevin, il peut quand mˆeme bˆatir un autre quartier que ´celui-ci.");
    public static Quartier fontaineAuxSouhaits = new Quartier("Fontaine aux Souhaits", Quartier.TYPE_QUARTIERS[4], 5, " la fin de la partie, marquez 1 point supplementaire par merveille dans votre cite, y compris la Fontaine aux Souhaits");
    public static Quartier forge = new Quartier("Forge", Quartier.TYPE_QUARTIERS[4], 5, "Une fois par tour, vous pouvez payez 2 pieces d’or pour piocher 3 cartes");
    public static Quartier grandeMuraille = new Quartier("Grande Muraille", Quartier.TYPE_QUARTIERS[4], 6, "Les personnages de rang 8 doivent payer 1 pi`ece d’or suppl´ementaire pour affecter un quartier de votre cit´e. La Grande Muraille n’affecte pas le coˆut de construction des quartiers de la cit´e du Diplomate quand il utilise son pouvoir.");
    public static Quartier hospice = new Quartier("Hospice", Quartier.TYPE_QUARTIERS[4], 4, "Si vous n’avez aucune pi`ece d’or dans votre tr´esor `a la fin de votre tour, gagnez 1 pi`ece d’or. Si la Sorci`ere ne reprend pas son tour de jeu, elle ne le termine donc pas et ne peut pas utiliser l’effet de l’Hospice `a la fin de son tour. L’Alchimiste utilise l’effet de l’Hospice avant d’appliquer son propre pouvoir.");
    public static Quartier laboratoire = new Quartier("Laboratoire", Quartier.TYPE_QUARTIERS[4], 5, "Une fois par tour, vous pouvez defausser 1 carte pour recevoir 2 pieces d’or.");
    public static Quartier manufacture = new Quartier("Manufacture", Quartier.TYPE_QUARTIERS[4], 5, "Payez 1 piece d’or de moins lorsque vous batissez une autre merveille.");
    public static Quartier mineDOr = new Quartier("Mine D'Or", Quartier.TYPE_QUARTIERS[4], 6, "Si vous choisissez de recevoir des pi`eces d’or en d´ebut de tour, prenez-en 1 suppl´ementaire.");
    public static Quartier monument = new Quartier("Monument", Quartier.TYPE_QUARTIERS[4], 4, "Vous ne pouvez pas bˆatir le Monument si vous avez d´ej`a au moins 5 quartiers dans votre cit´e. Le Monument compte comme 2 quartiers pour compl´eter votre cit´e.");
    public static Quartier musee = new Quartier("Musee", Quartier.TYPE_QUARTIERS[4], 4, "Une fois par tour, vous pouvez placer une carte de votre main, face cach´ee, sous le Mus´ee. A` la fin de la partie, marquez 1 point suppl´ementaire par carte sous le Mus´ee. Si le Mus´ee est d´eplac´e d’une cit´e `a une autre, il conserve toutes les cartes qui ´etaient dessous. Si le Mus´ee est d´etruit, les cartes sont d´efauss´ees, face cach´ee, sous la pioche.");
    public static Quartier necropole = new Quartier("Necropole", Quartier.TYPE_QUARTIERS[4], 5, "Pour bˆatir la n´ecropole, vous pouvez d´etruire un quartier de votre cit´e au lieu de payer son coˆut de construction. Le Bailli ne peut pas confisquer la N´ecropole sans payer son coˆut de construction");
    public static Quartier observatoire = new Quartier("Observatoire", Quartier.TYPE_QUARTIERS[4], 4, "Si vous choisissez de piocher des cartes au d´ebut de votre tour, vous choisissez la carte parmi 3 cartes au lieu de 2.");
    public static Quartier parc = new Quartier("Parc", Quartier.TYPE_QUARTIERS[4], 6, "Si vous n’avez aucune carte en main `a la fin de votre tour, piochez 2 cartes. Si la Sorci`ere ne reprend pas son tour, elle ne peut pas utiliser l’effet du Parc `a la fin de son tour.");
    public static Quartier poudriere = new Quartier("Poudriere", Quartier.TYPE_QUARTIERS[4], 3, "Durant votre tour, vous pouvez d´etuire simultan´ement la Poudri`ere et un autre quartier de votre choix. Vous ne pouvez pas d´etruire un quartier d’une cit´e compl`ete.");
    public static Quartier salleDesCartes = new Quartier("Salle des Cartes", Quartier.TYPE_QUARTIERS[4], 5, "A la fin de la partie, marquez 1 point supplementaire par carte dans votre main.");
    public static Quartier statueEquestre = new Quartier("Statue Equestre", Quartier.TYPE_QUARTIERS[4], 3, "Si vous d´etenez le Couronne a la fin de la partie, marquez 5 points supplementaires.");
    public static Quartier theatre = new Quartier("Theatre", Quartier.TYPE_QUARTIERS[4], 6, "A la fin de la phase de s´election, vous pouvez ´echanger votre carte Personnage face cach´ee `avec celle d’un autre joueur. Le propri´etaire du Th´eˆatre choisit avec qui il fait l’´echange, sans avoir vu aucune des cartes des autres joueurs. Les cartes ´echang´ees en peuvent ˆetre r´ev´el´ees aux autres joueurs avant d’ˆetre appel´ees. Dans une partie `a 2 ou 3 joueurs, le propri´etaire du Th´eˆatre choisit le carte Personnage parmi les deux cartes du joueur choisi pour l’´echange, sans les regarder.");
    public static Quartier tourDIvoire = new Quartier("Tour D'Ivoire", Quartier.TYPE_QUARTIERS[4], 5, "Si la Tour d’Ivoir est votre unique merveille `a la fin de la partie, marquez 5 points suppl´ementaires. Si la Cour des Miracles et la Tour d’Ivoire sont les deux seules merveilles d’une cit´e, et que le joueur d´ecide de consid´erer la Cour des Miracles comme n’´etant pas plus une merveille, alors il peut b´en´eficier du bonus de la Tour d’Ivoire.");
    public static Quartier tresorImperial = new Quartier("Tresor Imperial", Quartier.TYPE_QUARTIERS[4], 5, "A la fin de la partie, marquez 1 point supplementaire par piece d’or dans votre tresor.");
    public static Quartier tripot = new Quartier("Tripot", Quartier.TYPE_QUARTIERS[4], 6, "Vous pouvez payer tout ou partie du cout de construction du Tripot en cartes de votre main, au prix de 1 carte pour 1 piece d’or. Si le Tripot est confisque par l’Echevin, le joueur n’est rembourse que de l’or qu’il a depense, pas des cartes.");
    

    //Déclaration des Personnages
    private static Personnage abbe = new Abbe();
    private static Personnage alchimiste = new Alchimiste();
    private static Personnage architecte = new Architecte();
    private static Personnage archiviste = new Archiviste();
    private static Personnage artiste = new Artiste();
    private static Personnage assassin = new Assassin();
    private static Personnage bailli = new Bailli();
    private static Personnage capitaine = new Capitaine();
    private static Personnage cardinal = new Cardinal();
    private static Personnage condottiere  = new Condottiere();
    private static Personnage diplomate = new Diplomate();
    private static Personnage echevin = new Echevin();
    private static Personnage empereur = new Empereur();
    private static Personnage espion = new Espion();
    private static Personnage eveque = new Eveque();
    private static Personnage magicienne = new Magicienne();
    private static Personnage maitre_chanteuse = new Maitre_Chanteuse();
    private static Personnage marchande = new Marchande();
    private static Personnage navigatrice = new Navigatrice();
    private static Personnage negociant = new Negociant();
    private static Personnage patricien = new Patricien();
    private static Personnage reine = new Reine();
    private static Personnage roi = new Roi();
    private static Personnage sorcier = new Sorcier();
    private static Personnage sorciere = new Sorciere();
    private static Personnage voleur = new Voleur();
    private static Personnage voyante = new Voyante();

    private int nbJoueur = 0;
    //Déclaration des Joueurs
    public void setNbJoueur(int nbJoueur){
        this.nbJoueur = nbJoueur;
    }

    public static Pioche nouvellePioche() {
        Pioche pioche = new Pioche();
        //Ajout des Quartiers en fonction de leur quantité à la pioche
        for (int i = 0; i < 2; i++) {
            pioche.ajouter(cathedrale);
            pioche.ajouter(forteresse);
            pioche.ajouter(hotel_ville);
        }
        for (int i = 0; i < 3; i++) {
            pioche.ajouter(monastere);
            pioche.ajouter(eglise);
            pioche.ajouter(temple);
            pioche.ajouter(tour_guet);
            pioche.ajouter(prison);
            pioche.ajouter(caserne);
            pioche.ajouter(palais);
            pioche.ajouter(echope);
            pioche.ajouter(comptoir);
            pioche.ajouter(port);
        }
        for (int i = 0; i < 4; i++) {
            pioche.ajouter(marche);
            pioche.ajouter(chateau);
        }
        for (int i = 0; i < 5; i++) {
            pioche.ajouter(taverne);
            pioche.ajouter(manoir);
        }

        pioche.melanger();

        return pioche;
    }


    public static PlateauDeJeu configurationDeBase(Pioche pioche) {
        PlateauDeJeu plateau = new PlateauDeJeu();
        //Ajout des Personnages au plateau de jeu
        plateau.ajouterPersonnage(architecte);
        plateau.ajouterPersonnage(assassin);
        plateau.ajouterPersonnage(condottiere);
        plateau.ajouterPersonnage(eveque);
        plateau.ajouterPersonnage(magicienne);
        plateau.ajouterPersonnage(marchande);
        plateau.ajouterPersonnage(roi);
        plateau.ajouterPersonnage(voleur);
        //Ajout des Joueurs au plateau de jeu
        

        //Ajout des Merveilles à la pioche
        pioche.ajouter(bibliotheque);
        pioche.ajouter(carriere);
        pioche.ajouter(courDesMiracles);
        pioche.ajouter(donjon);
        pioche.ajouter(dracoport);
        pioche.ajouter(ecoleDeMagie);
        pioche.ajouter(fontaineAuxSouhaits);
        pioche.ajouter(forge);
        pioche.ajouter(laboratoire);
        pioche.ajouter(manufacture);
        pioche.ajouter(salleDesCartes);
        pioche.ajouter(statueEquestre);
        pioche.ajouter(tresorImperial);
        pioche.ajouter(tripot);

        pioche.melanger();

        plateau.setPioche(pioche);

        switch(Jeu.nbJoueurs){

            case 2:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 4:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 5:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("ORDI 4"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 6:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("ORDI 4"));
                plateau.ajouterJoueur(new Joueur("ORDI 5"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 7:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("ORDI 4"));
                plateau.ajouterJoueur(new Joueur("ORDI 5"));
                plateau.ajouterJoueur(new Joueur("ORDI 6"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;


        }

        return plateau;
    }
    public static PlateauDeJeu configurationAristocrateAmbitieux(Pioche pioche){
        PlateauDeJeu plateau = new PlateauDeJeu();
        //fonctionnel
        pioche.ajouter(capitole);
        pioche.ajouter(carriere);
        pioche.ajouter(chantier);
        pioche.ajouter(courDesMiracles);
        pioche.ajouter(donjon);
        pioche.ajouter(ecoleDeMagie);
        pioche.ajouter(ecuries);
        pioche.ajouter(grandeMuraille);
        pioche.ajouter(hospice);
        pioche.ajouter(manufacture);
        pioche.ajouter(necropole);
        pioche.ajouter(parc);
        pioche.ajouter(statueEquestre);
        pioche.ajouter(tripot);

        plateau.ajouterPersonnage(echevin);
        plateau.ajouterPersonnage(voleur);
        plateau.ajouterPersonnage(sorcier);
        plateau.ajouterPersonnage(patricien);
        plateau.ajouterPersonnage(eveque);
        plateau.ajouterPersonnage(negociant);
        plateau.ajouterPersonnage(architecte);
        plateau.ajouterPersonnage(capitaine);
        if(Jeu.nbPersonnages ==9 && Jeu.nbJoueurs!=3 && Jeu.nbJoueurs!=4){
            plateau.ajouterPersonnage(reine);
    
        }else if(Jeu.nbPersonnages ==9 && (Jeu.nbJoueurs==3 || Jeu.nbJoueurs==4) ){
            plateau.ajouterPersonnage(artiste);

        }
        
        pioche.melanger();

        plateau.setPioche(pioche);

        switch(Jeu.nbJoueurs){

            case 2:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 3:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;


            case 4:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 5:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("ORDI 4"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 6:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("ORDI 4"));
                plateau.ajouterJoueur(new Joueur("ORDI 5"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 7:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("ORDI 4"));
                plateau.ajouterJoueur(new Joueur("ORDI 5"));
                plateau.ajouterJoueur(new Joueur("ORDI 6"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 8:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("ORDI 4"));
                plateau.ajouterJoueur(new Joueur("ORDI 5"));
                plateau.ajouterJoueur(new Joueur("ORDI 6"));
                plateau.ajouterJoueur(new Joueur("ORDI 7"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

        }

        return plateau;

    }
    public static PlateauDeJeu configurationIntrigantsSubtils(Pioche pioche){
        PlateauDeJeu plateau = new PlateauDeJeu();
        //fonctionnel
        pioche.ajouter(basilique);
        pioche.ajouter(carriere);
        pioche.ajouter(catacombes);
        pioche.ajouter(donjon);
        pioche.ajouter(dracoport);
        pioche.ajouter(forge);
        pioche.ajouter(hospice);
        pioche.ajouter(mineDOr);
        pioche.ajouter(monument);
        pioche.ajouter(musee);
        pioche.ajouter(necropole);
        pioche.ajouter(parc);
        pioche.ajouter(poudriere);
        pioche.ajouter(theatre);

        plateau.ajouterPersonnage(sorciere);
        plateau.ajouterPersonnage(maitre_chanteuse);
        plateau.ajouterPersonnage(magicienne);
        if(Jeu.nbJoueurs!=2 && Jeu.nbJoueurs!=3){
            plateau.ajouterPersonnage(empereur);
        }else if(Jeu.nbJoueurs==2 || Jeu.nbJoueurs==3){
            plateau.ajouterPersonnage(roi);
        }
        plateau.ajouterPersonnage(abbe);
        plateau.ajouterPersonnage(alchimiste);
        plateau.ajouterPersonnage(architecte);
        plateau.ajouterPersonnage(condottiere);
        if(Jeu.nbPersonnages ==9){
            plateau.ajouterPersonnage(bailli);
    
        }
        
        pioche.melanger();

        plateau.setPioche(pioche);

        switch(Jeu.nbJoueurs){

            case 2:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 3:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;


            case 4:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 5:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("ORDI 4"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 6:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("ORDI 4"));
                plateau.ajouterJoueur(new Joueur("ORDI 5"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 7:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("ORDI 4"));
                plateau.ajouterJoueur(new Joueur("ORDI 5"));
                plateau.ajouterJoueur(new Joueur("ORDI 6"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 8:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("ORDI 4"));
                plateau.ajouterJoueur(new Joueur("ORDI 5"));
                plateau.ajouterJoueur(new Joueur("ORDI 6"));
                plateau.ajouterJoueur(new Joueur("ORDI 7"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

        }

        return plateau;
        
    }
    
    public static PlateauDeJeu configurationEmissairesIllustres(Pioche pioche){ //fonctionnel
        PlateauDeJeu plateau = new PlateauDeJeu();
        //Pioche 

      
        pioche.ajouter(bibliotheque);
        pioche.ajouter(carriere);
        pioche.ajouter(chantier);
        pioche.ajouter(courDesMiracles);
        pioche.ajouter(donjon);
        pioche.ajouter(ecoleDeMagie);
        pioche.ajouter(forge);
        pioche.ajouter(grandeMuraille);
        pioche.ajouter(hospice);
        pioche.ajouter(manufacture);
        pioche.ajouter(musee);
        pioche.ajouter(observatoire);
        pioche.ajouter(parc);
        pioche.ajouter(tourDIvoire);
        
        //Ajout des Joueurs au plateau de jeu
        
        
        
        
        //Persos

        plateau.ajouterPersonnage(sorciere);
        plateau.ajouterPersonnage(espion);
        plateau.ajouterPersonnage(voyante);
        if(Jeu.nbJoueurs!=2 && Jeu.nbJoueurs!=3){
            plateau.ajouterPersonnage(empereur);
        }else if(Jeu.nbJoueurs==2 || Jeu.nbJoueurs==3){
            plateau.ajouterPersonnage(roi);
        }
        plateau.ajouterPersonnage(eveque);
        plateau.ajouterPersonnage(marchande);
        plateau.ajouterPersonnage(archiviste);
        plateau.ajouterPersonnage(diplomate);
        if(Jeu.nbPersonnages==9){
            plateau.ajouterPersonnage(artiste);
        }
    

        pioche.melanger();
        plateau.setPioche(pioche);
        switch(Jeu.nbJoueurs){

            case 2:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 3:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;


            case 4:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 5:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("ORDI 4"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 6:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("ORDI 4"));
                plateau.ajouterJoueur(new Joueur("ORDI 5"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 7:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("ORDI 4"));
                plateau.ajouterJoueur(new Joueur("ORDI 5"));
                plateau.ajouterJoueur(new Joueur("ORDI 6"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 8:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("ORDI 4"));
                plateau.ajouterJoueur(new Joueur("ORDI 5"));
                plateau.ajouterJoueur(new Joueur("ORDI 6"));
                plateau.ajouterJoueur(new Joueur("ORDI 7"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

        }
        return plateau;
        }

    public static PlateauDeJeu configurationDignitairesSournois(Pioche pioche){
        PlateauDeJeu plateau = new PlateauDeJeu();
        //Pioche 

      
        pioche.ajouter(catacombes);
        pioche.ajouter(chantier);
        pioche.ajouter(courDesMiracles);
        pioche.ajouter(dracoport);
        pioche.ajouter(ecuries);
        pioche.ajouter(fontaineAuxSouhaits);
        pioche.ajouter(forge);
        pioche.ajouter(laboratoire);
        pioche.ajouter(hospice);
        pioche.ajouter(manufacture);
        pioche.ajouter(necropole);
        pioche.ajouter(theatre);
        pioche.ajouter(parc);
        pioche.ajouter(tripot);
        
        //Ajout des Joueurs au plateau de jeu
        
        
        
        
        //Persos

        plateau.ajouterPersonnage(echevin);
        plateau.ajouterPersonnage(maitre_chanteuse);
        plateau.ajouterPersonnage(sorcier);
        plateau.ajouterPersonnage(roi);
        plateau.ajouterPersonnage(abbe);
        plateau.ajouterPersonnage(alchimiste);
        plateau.ajouterPersonnage(navigatrice);
        plateau.ajouterPersonnage(capitaine);

        if(Jeu.nbPersonnages ==9 && Jeu.nbJoueurs!=3 && Jeu.nbJoueurs!=4){
            plateau.ajouterPersonnage(reine);
    
        }else if(Jeu.nbPersonnages ==9 && (Jeu.nbJoueurs==3 || Jeu.nbJoueurs==4) ){
            plateau.ajouterPersonnage(artiste);

        }
    

        pioche.melanger();
        plateau.setPioche(pioche);
        switch(Jeu.nbJoueurs){

            case 2:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 3:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;


            case 4:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 5:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("ORDI 4"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 6:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("ORDI 4"));
                plateau.ajouterJoueur(new Joueur("ORDI 5"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 7:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("ORDI 4"));
                plateau.ajouterJoueur(new Joueur("ORDI 5"));
                plateau.ajouterJoueur(new Joueur("ORDI 6"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 8:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("ORDI 4"));
                plateau.ajouterJoueur(new Joueur("ORDI 5"));
                plateau.ajouterJoueur(new Joueur("ORDI 6"));
                plateau.ajouterJoueur(new Joueur("ORDI 7"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

        }

        return plateau;
    }
    
    public static PlateauDeJeu configurationOligarquesTenaces(Pioche pioche){
        PlateauDeJeu plateau = new PlateauDeJeu();
        //Ajout des Personnages au plateau de jeu
        plateau.ajouterPersonnage(assassin);
        plateau.ajouterPersonnage(espion);
        plateau.ajouterPersonnage(voyante);
        plateau.ajouterPersonnage(roi);
        plateau.ajouterPersonnage(cardinal);
        plateau.ajouterPersonnage(negociant);
        plateau.ajouterPersonnage(archiviste);
        plateau.ajouterPersonnage(diplomate);
        if(Jeu.nbPersonnages ==9){
            plateau.ajouterPersonnage(artiste);
        }
        //Ajout des Joueurs au plateau de jeu
        

        //Ajout des Merveilles à la pioche
        pioche.ajouter(fontaineAuxSouhaits);
        pioche.ajouter(forge);
        pioche.ajouter(laboratoire);
        pioche.ajouter(observatoire);
        pioche.ajouter(salleDesCartes);
        pioche.ajouter(statueEquestre);
        pioche.ajouter(tresorImperial);
        

        pioche.melanger();

        plateau.setPioche(pioche);
        switch(Jeu.nbJoueurs){

            case 2:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 3:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;


            case 4:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 5:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("ORDI 4"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 6:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("ORDI 4"));
                plateau.ajouterJoueur(new Joueur("ORDI 5"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 7:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("ORDI 4"));
                plateau.ajouterJoueur(new Joueur("ORDI 5"));
                plateau.ajouterJoueur(new Joueur("ORDI 6"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 8:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("ORDI 4"));
                plateau.ajouterJoueur(new Joueur("ORDI 5"));
                plateau.ajouterJoueur(new Joueur("ORDI 6"));
                plateau.ajouterJoueur(new Joueur("ORDI 7"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

        }

        return plateau;
    }
    
    public static PlateauDeJeu configurationNoblesRetors(Pioche pioche){
        PlateauDeJeu plateau = new PlateauDeJeu();
        //Ajout des Personnages au plateau de jeu
        plateau.ajouterPersonnage(assassin);
        plateau.ajouterPersonnage(voleur);
        plateau.ajouterPersonnage(magicienne);
        plateau.ajouterPersonnage(patricien);
        plateau.ajouterPersonnage(cardinal);
        plateau.ajouterPersonnage(marchande);
        plateau.ajouterPersonnage(navigatrice);
        plateau.ajouterPersonnage(condottiere);
        if(Jeu.nbPersonnages ==9){
            plateau.ajouterPersonnage(bailli);
        }
        //Ajout des Joueurs au plateau de jeu
        

        //Ajout des Merveilles à la pioche
        pioche.ajouter(basilique);
        pioche.ajouter(dracoport);
        pioche.ajouter(ecoleDeMagie);
        pioche.ajouter(fontaineAuxSouhaits);
        pioche.ajouter(laboratoire);
        pioche.ajouter(mineDOr);
        pioche.ajouter(monument);
        pioche.ajouter(musee);
        pioche.ajouter(poudriere);
        pioche.ajouter(salleDesCartes);
        pioche.ajouter(statueEquestre);
        pioche.ajouter(tourDIvoire);
        pioche.ajouter(tresorImperial);
        pioche.ajouter(tripot);

        pioche.melanger();

        plateau.setPioche(pioche);
        switch(Jeu.nbJoueurs){

            case 2:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 3:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;


            case 4:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 5:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("ORDI 4"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 6:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("ORDI 4"));
                plateau.ajouterJoueur(new Joueur("ORDI 5"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 7:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("ORDI 4"));
                plateau.ajouterJoueur(new Joueur("ORDI 5"));
                plateau.ajouterJoueur(new Joueur("ORDI 6"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

            case 8:
                plateau.ajouterJoueur(new Joueur("ORDI 1"));
                plateau.ajouterJoueur(new Joueur("ORDI 2"));
                plateau.ajouterJoueur(new Joueur("ORDI 3"));
                plateau.ajouterJoueur(new Joueur("ORDI 4"));
                plateau.ajouterJoueur(new Joueur("ORDI 5"));
                plateau.ajouterJoueur(new Joueur("ORDI 6"));
                plateau.ajouterJoueur(new Joueur("ORDI 7"));
                plateau.ajouterJoueur(new Joueur("Joueur"));
                break;

        }
        return plateau;
    }

}