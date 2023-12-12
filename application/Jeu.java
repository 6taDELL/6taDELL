package application;

import java.util.ArrayList;
import java.util.Random;
import controleur.Interaction;
import modele.Joueur;
import modele.Personnage;
import modele.Pioche;
import modele.PlateauDeJeu;
import modele.Quartier;

public class Jeu {

    private int joueurPersoRangMax = 0;
    private PlateauDeJeu plateauDeJeu;
    private Random generateur;
    public static int orDesTaxes;
    public static int nbPersonnages;
    public static int nbJoueurs;
    private int numeroConfiguration;
    private ArrayList<Personnage> listePersonnage = new ArrayList<Personnage>();
    private ArrayList<Personnage> listePersonnageUtilises = new ArrayList<Personnage>();
    private ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();
    private Interaction interaction = new Interaction();
    private Joueur premierAFinir;
    private Joueur joueurGagnant;
    private Personnage sorciere;
    private Joueur joueurRoiPatricien;
    private boolean construitEcurie;


    private Personnage persoFaceCachee;
    

    public static ArrayList<Quartier> quartiersSousMusee = new ArrayList<Quartier>();


    public Jeu() {
        this.plateauDeJeu = new PlateauDeJeu();
        this.generateur = new Random();
    }

    public void jouer() {
        int choix = 0;
        afficherBienvenue();
        do {
            afficherMenu();
            choix = Interaction.lireUnEntier(1, 4);
            if (choix == 1) {
                jouerPartie();
            } else if (choix == 2) {
                afficherLesRegles();
            }
        } while (choix != 3);
        quitterPartie();
    }

    private void afficherLesRegles() {
        System.out.println("Regles");
    }

    private void jouerPartie() {
        initialisation();
        do {
            tourDeJeu();
            gestionCouronne();
            reinitialisationPersonnages();
        } while (partieFinie() == false);
        calculDesPoints();
    }

    private void initialisation() {
        //or des taxes

        orDesTaxes = 0;
        //implémentation nombre de Joueurs
        nbPersonnages = 8;
        nbJoueurs = 0;

        System.out.println("Vous voulez une partie de combien de joueurs ?\n");
        nbJoueurs = Interaction.lireUnEntier(2, 8);

        if(nbJoueurs==2){

            nbPersonnages=8;

        }else if(nbJoueurs ==3){

            nbPersonnages=9;

        }else if(nbJoueurs == 8){

            nbPersonnages = 9;

        }else{
            System.out.println("Vous voulez une partie de combien de personnages ?\n");
            nbPersonnages = Interaction.lireUnEntier(8, 9);
        }

        String[] configuration = {"configuration de base", "Aristocrate ambitieux", "Intrigants Subtils", "Emissaires Illustres", "Dignitaires Sournois", "Oligarques Tenaces", "Nobles Retors"};
        
        //implémentation différentes configurations
        int configurationAChoisir = 0;
        Pioche pioche;
        int couronne;
        do {
            System.out.println("Veuillez choisir votre configuration de jeu : \n");
            for(int i = 0; i<configuration.length; i++){
                System.out.println((i+1) + ". " + configuration[i]);
            }

            
            configurationAChoisir = Interaction.lireUnEntier(1, configuration.length);
            configurationAChoisir--;

            couronne = generateur.nextInt(nbJoueurs);
            pioche = Configuration.nouvellePioche();
            if(configurationAChoisir==0 && nbPersonnages==9){
                System.out.println("Vous ne pouvez pas choisir la configuration de base avec 9 personnages.");
            }
        } while (configurationAChoisir==0 && nbPersonnages==9);
        
        switch(configurationAChoisir){
            case 0:
                this.plateauDeJeu = Configuration.configurationDeBase(pioche);
                break;
            case 1:
                this.plateauDeJeu = Configuration.configurationAristocrateAmbitieux(pioche);
                break;
            case 2:
                this.plateauDeJeu = Configuration.configurationIntrigantsSubtils(pioche);
                break;
            case 3:
                this.plateauDeJeu = Configuration.configurationEmissairesIllustres(pioche);
                break;
            case 4:
                this.plateauDeJeu = Configuration.configurationDignitairesSournois(pioche);
                break;
            case 5:
                this.plateauDeJeu = Configuration.configurationOligarquesTenaces(pioche);
                break;
            case 6:
                this.plateauDeJeu = Configuration.configurationNoblesRetors(pioche);
                break;
        }
    }

    private void gestionCouronne() {
        //on détermine le joueur qui possède la couronne et on lui enlève la couronne
        for (int i = 0; i < this.plateauDeJeu.getNombreJoueurs(); i++) {
            if (this.plateauDeJeu.getJoueur(i).getPossedeCouronne())
                this.plateauDeJeu.getJoueur(i).setPossedeCouronne(false);
        }
        //on attribue la couronne au joueur qui possède le personnage Roi
        for (int i = 0; i < this.plateauDeJeu.getNombreJoueurs(); i++) {
            if (this.plateauDeJeu.getJoueur(i).getPersonnage().getNom().equals("Roi")) {
                System.out.println("\t\n" + this.plateauDeJeu.getJoueur(i).getNom() + " possède la couronne\n");
                this.plateauDeJeu.getJoueur(i).setPossedeCouronne(true);
            }
        }
    }

    private void reinitialisationPersonnages() {
        //on réinitialise tous les personnage
        for (int i = 0; i < this.plateauDeJeu.getNombrePersonnages(); i++) {
            if (this.plateauDeJeu.getPersonnage(i).getJoueur() != null)
                this.plateauDeJeu.getPersonnage(i).reinitialiser();
        }
    }

    private boolean partieFinie() {
        //on parcoure tous les joueurs pour vérifier si un possède une cité complète
        for (int i = 0; i < this.plateauDeJeu.getNombreJoueurs(); i++) {
            if (this.plateauDeJeu.getJoueur(i).nbQuartiersDansCite() >= 7) {
                System.out.println("\t\nLa partie est terminé : " + this.plateauDeJeu.getJoueur(i).getNom() + " possède une cité complète\n");
                //on affecte l'attribut isPremier de joueur à  true pour dire qu'il est le premier à  avoir une cité complète
                this.plateauDeJeu.getJoueur(i).setPremier(true);
                this.plateauDeJeu.getJoueur(joueurPersoRangMax).setRangPlusEleve();
                return true;
            }
        }
        return false;
    }

    private void tourDeJeu() {
        //on effectue le choix des personnages
        choixPersonnages();
        for (int personnage = 0; personnage < this.plateauDeJeu.getNombrePersonnages(); personnage++) {
            System.out.println("----------------------------------------------\n" + "Le jeu appelle " + this.plateauDeJeu.getPersonnage(personnage).getNom() + "\t");
            //on vérifie si le personnage est associé à un joueur
            if (this.plateauDeJeu.getPersonnage(personnage).getJoueur() != null) {
                //on vérifie si le joueur associé au personnage n'est pas simulé par l'ordinateur en testant son attribut simule de la classe joueur
                if (!this.plateauDeJeu.getPersonnage(personnage).getJoueur().isSimule()) {
                    //on affiche la main du joueur
                    System.out.println("\n\tVoici votre Main :\n");
                    for (int i = 0; i < this.plateauDeJeu.getPersonnage(personnage).getJoueur().nbQuartiersDansMain(); i++) {
                        if (this.plateauDeJeu.getPersonnage(personnage).getJoueur().getMain().get(i) != null) {
                            System.out.println((i + 1) + " : " + this.plateauDeJeu.getPersonnage(personnage).getJoueur().getMain().get(i).getNom() + " - type : " +
                                this.plateauDeJeu.getPersonnage(personnage).getJoueur().getMain().get(i).getType() + " - pièces : " +
                                this.plateauDeJeu.getPersonnage(personnage).getJoueur().getMain().get(i).getCout());
                        }
                    }
                }
                //on affiche la cité du joueur
                System.out.println("\n\tVoici votre Cité :\n");
                if (this.plateauDeJeu.getPersonnage(personnage).getJoueur().nbQuartiersDansCite() > 0) {
                    for (int i = 0; i < this.plateauDeJeu.getPersonnage(personnage).getJoueur().nbQuartiersDansCite(); i++) {
                        System.out.println((i + 1) + " : " + this.plateauDeJeu.getPersonnage(personnage).getJoueur().getCite()[i].getNom() + " - type : " +
                            this.plateauDeJeu.getPersonnage(personnage).getJoueur().getCite()[i].getType() + " - pièces : " +
                            this.plateauDeJeu.getPersonnage(personnage).getJoueur().getCite()[i].getCout());
                    }
                } else {
                    System.out.println("\nVotre cité est vide !");
                }
                System.out.println("\tVous possédez " + this.plateauDeJeu.getPersonnage(personnage).getJoueur().nbPieces() + " pièces\n");
                //on vérifie si le personnage n'est pas assassiné
                if (!this.plateauDeJeu.getPersonnage(personnage).getAssassine()) {
                    //on vérifie si le personnage n'est pas volé
                    if (this.plateauDeJeu.getPersonnage(personnage).getVole()) {
                        System.out.println("\tLe " + this.plateauDeJeu.getPersonnage(personnage).getNom() + " est volé !\n");
                        System.out.println("\tLe " + this.plateauDeJeu.getPersonnage(personnage).getNom() + " donne toutes ses pièces au voleur !\n");
                        int nbPieces = this.plateauDeJeu.getPersonnage(personnage).getJoueur().nbPieces();
                        //si le personnage est volé il donne toutes ses pièces au voleur
                        this.plateauDeJeu.getPersonnage(personnage).getJoueur().retirerPieces(nbPieces);
                        for (int i = 0; i < this.plateauDeJeu.getNombrePersonnages(); i++) {
                            if (this.plateauDeJeu.getJoueur(i).getNom().equals("Voleur"))
                                this.plateauDeJeu.getJoueur(i).ajouterPieces(nbPieces);
                        }
                    } else {
                        //le personnage percoit les ressources (cartes ou pièces d'or)
                        percevoirRessource(personnage);
                        this.plateauDeJeu.getPersonnage(personnage).percevoirRessourcesSpecifiques();
                        System.out.println("\n\tVoulez vous utiliser votre pouvoir ? (oui/non)");
                        boolean res = false;
                        //on teste si le personnage n'est pas simulé par l'ordinateur
                        if (!this.plateauDeJeu.getPersonnage(personnage).getJoueur().isSimule())
                            res = Interaction.lireOuiOuNon();
                        else {
                            //sinon on génère un nombre aléatoire qui correspond au choix de l'ordinateur
                            res = this.generateur.nextInt(2) == 1;
                        }
                        if (res) {
                            System.out.println("\n\tLe " + this.plateauDeJeu.getPersonnage(personnage).getNom() + " utilise son pouvoir !\n");
                            if (!this.plateauDeJeu.getPersonnage(personnage).getJoueur().isSimule())
                                this.plateauDeJeu.getPersonnage(personnage).utiliserPouvoir();
                            else
                                this.plateauDeJeu.getPersonnage(personnage).utiliserPouvoirAvatar();
                                System.out.println("\n\tLe " + this.plateauDeJeu.getPersonnage(personnage).getNom() + " utilise son pouvoir !\n");
                        }
                        System.out.println("\n\tVoulez vous construire ? (oui/non)");
                        if (!this.plateauDeJeu.getPersonnage(personnage).getJoueur().isSimule())
                            res = Interaction.lireOuiOuNon();
                        else {
                            res = this.generateur.nextInt(2) == 1;
                        }
                        if (res) {
                            boolean peutConstruire = false;
                            int carte = 0;
                            do {
                                System.out.println("\tQuel quartier voulez vous construire ?\n");
                                int i = 1;
                                //on affiche la main du joueur
                                for (Quartier quartier: this.plateauDeJeu.getPersonnage(personnage).getJoueur().getMain()) {
                                    System.out.println((i) + " : " + quartier.getNom() + " - type : " + quartier.getType() +
                                        " - pièces : " + quartier.getCout());
                                    i++;
                                }
                                System.out.println("0 : Annuler la construction");
                                if (!this.plateauDeJeu.getPersonnage(personnage).getJoueur().isSimule())
                                    carte = Interaction.lireUnEntier(0,
                                        this.plateauDeJeu.getPersonnage(personnage).getJoueur().nbQuartiersDansMain() + 1);
                                else {
                                    carte = this.generateur
                                        .nextInt(this.plateauDeJeu.getPersonnage(personnage).getJoueur().nbQuartiersDansMain() + 1);
                                }
                                if (carte == 0)
                                    break;

                                //on vérifie si le joueur peut construire la carte choisie
                                if (this.plateauDeJeu.getPersonnage(personnage).getJoueur().nbPieces() >= this.plateauDeJeu.getPersonnage(personnage)
                                    .getJoueur().getMain().get(carte - 1).getCout() &&
                                    !this.plateauDeJeu.getPersonnage(personnage).getJoueur().quartierPresentDansCite(this.plateauDeJeu.getPersonnage(personnage).getJoueur().getMain().get(carte - 1).getNom()))
                                    peutConstruire = true;
                                else
                                    System.out.println(
                                        "\tVous ne pouvez pas construire ce quartier. \nVeuillez choisir un autre quartier !\n");
                            } while (!peutConstruire);
                            if (carte != 0) {
                                //on constuit le quartier choisit
                                System.out.println("\t" + this.plateauDeJeu.getPersonnage(personnage).getNom() + " a construit le " + this.plateauDeJeu.getPersonnage(personnage).getJoueur().getMain().get(carte - 1).getNom() + "\n");
                                this.plateauDeJeu.getPersonnage(personnage)
                                    .construire(this.plateauDeJeu.getPersonnage(personnage).getJoueur().getMain().get(carte - 1));
                            }
                        }
                    }
                } else {
                    System.out.println("\tLe " + this.plateauDeJeu.getPersonnage(personnage).getNom() + " est assasiné !\n");
                }
            } else {
                System.out.println("\tAucun joueur ne possède le " + this.plateauDeJeu.getPersonnage(personnage).getNom() + "\n");
            }
        }
        joueurPersoRangMax = this.plateauDeJeu.getJoueur(0).getPersonnage().getRang();
        //on détermine l'id du joueur qui possède le personnage de rang le plus élévé à la fin de la partie
        for (int j = 0; j < this.plateauDeJeu.getNombreJoueurs(); j++) {
            if (this.plateauDeJeu.getJoueur(j).getPersonnage().getRang() > joueurPersoRangMax)
                joueurPersoRangMax = j;
        }
        System.out.println("\n\tFin du tour de jeu\n");
    }

    private void choixPersonnages() {
        System.out.println("\tChoix des personnages :\n");

        int pFaceVisible = 0;
        int pFaceCachee = 0;

        if(nbPersonnages==8 && nbJoueurs!=2 && nbJoueurs!=3){
            switch(nbJoueurs){
                case 4:
                    pFaceVisible = 2;
                    pFaceCachee = 1;
                    break;
                case 5:
                    pFaceVisible = 1;
                    pFaceCachee = 1;
                    break;
                case 6:
                    pFaceVisible = 0;
                    pFaceCachee = 1;
                    break;
                case 7:
                    pFaceVisible = 0;
                    pFaceCachee = 1;
                    break;  

            }
        }else if(nbPersonnages == 9 && nbJoueurs!=2 && nbJoueurs!=3){
            switch(nbJoueurs){
                case 4:
                    pFaceVisible = 3;
                    pFaceCachee = 1;
                    break;
                case 5:
                    pFaceVisible = 2;
                    pFaceCachee = 1;
                    break;
                case 6:
                    pFaceVisible = 1;
                    pFaceCachee = 1;
                    break;
                case 7:
                    pFaceVisible = 0;
                    pFaceCachee = 1;
                    break;
                case 8:
                    pFaceVisible = 0;
                    pFaceCachee = 1;
                    break;    

            }

        }

        

        if(nbJoueurs!=2 && nbJoueurs!=3){
            for(int i = 0; i < pFaceVisible; i ++){
                int persoARetirer = generateur.nextInt(listePersonnage.size());
                Personnage perso = listePersonnage.get(persoARetirer);
                listePersonnage.remove(persoARetirer);
                System.out.println("Le personnage " + "\"" + perso.getNom() + "\"" + " est ecarte face visible\n" );
            }

            
            for(int i = 0; i < pFaceCachee; i ++){
                int persoARetirer = generateur.nextInt(listePersonnage.size());

                //partie à 7 joueurs avec 8 perso OU partie a 8 joueurs avec 9 personnages

                if((nbJoueurs == 7 && nbPersonnages==8) || (nbJoueurs == 8 && nbPersonnages==9)){
                    this.persoFaceCachee = listePersonnage.get(persoARetirer);
                }

                listePersonnage.remove(persoARetirer);
                System.out.println("Un personnage est ecarte face cachee\n");

            }
        
        }

        for(int i = 0; i < listeJoueur.size(); i++){
            if(listeJoueur.get(i).getPossedeCouronne()){
                Joueur possedeCouronne = listeJoueur.get(i);
                listeJoueur.remove(i);
                listeJoueur.add(0, possedeCouronne);
            }
        }

        for(int i = 0; i < listeJoueur.size(); i++){

            if(nbJoueurs!=2 && nbJoueurs!=3){
                if(listeJoueur.get(0).getNom().equals("Joueur") && listeJoueur.get(i).getNom().equals("Joueur")){
                    System.out.println("Vous avez la couronne !\n");

                    for(int j = 0; j < listePersonnage.size(); j++){
                        System.out.println("\n"+(j+1) + "." + listePersonnage.get(j).getNom()+" caracteristiques: "+listePersonnage.get(j).getCaracteristiques());
                    }
                    
                    System.out.println("\nQuel personnage choisissez vous ?");
                    int choix = interaction.lireUnEntier(1, listePersonnage.size()) - 1;
                    
                    System.out.println("Vous avez choisi le personnage " + this.listePersonnage.get(choix).getNom() + "\n");

                    this.listePersonnage.get(choix).setJoueur(this.listeJoueur.get(i));
                    this.listePersonnageUtilises.add(listePersonnage.get(choix));
                    listePersonnage.remove(choix); 

                }else if(listeJoueur.get(i).getNom().equals("Joueur") && !listeJoueur.get(0).getNom().equals("Joueur")) {
                    System.out.println("A vous de jouer\n");

                    for(int j = 0; j < listePersonnage.size(); j++){
                        System.out.println("\n"+(j+1) + "." + listePersonnage.get(j).getNom()+" caracteristiques: "+listePersonnage.get(j).getCaracteristiques());
                    }
                    
                    System.out.println("\nQuel personnage choisissez vous ?");
                    int choix = interaction.lireUnEntier(1, listePersonnage.size()) - 1;

                    System.out.println("Vous avez choisi le personnage " + this.listePersonnage.get(choix).getNom() + "\n");

                    this.listePersonnage.get(choix).setJoueur(this.listeJoueur.get(i));
                    this.listePersonnageUtilises.add(listePersonnage.get(choix));
                    listePersonnage.remove(choix);  

                }
            
                    //partie à 7 joueurs et 8 joueurs

                else if(((nbJoueurs == 7 && nbPersonnages==8)||(nbJoueurs == 8 && nbPersonnages == 9)) && i == (listeJoueur.size() - 1)){

                    ArrayList<Personnage> persoAChoisir = new ArrayList<Personnage>();
                    persoAChoisir.add(persoFaceCachee);
                    persoAChoisir.add(listePersonnage.get(0));

                    if(listeJoueur.get(i).getNom().equals("Joueur")){
                        for(int j = 0; j < persoAChoisir.size(); j++){
                            System.out.println((j+1) + "." + persoAChoisir.get(j).getNom());
                        }
                        
                        System.out.println("\nQuel personnage choisissez vous ?");
                        int choix = Interaction.lireUnEntier(1, persoAChoisir.size() - 1);
            
                        System.out.println("Vous avez choisi le personnage " + persoAChoisir.get(choix).getNom() + "\n");
            
                        persoAChoisir.get(choix).setJoueur(this.listeJoueur.get(i));
                        this.listePersonnageUtilises.add(persoAChoisir.get(choix));
                        listePersonnage.remove(persoAChoisir.get(choix));  

                    }else{

                        System.out.println("A " + listeJoueur.get(i).getNom() + " de jouer\n");

                        for(int j = 0; j < persoAChoisir.size(); j++){
                            System.out.println((j+1) + "." + persoAChoisir.get(j).getNom());
                        }
                        
                        
                        System.out.println("\nQuel personnage choisissez vous ?");
                        int choix = generateur.nextInt(persoAChoisir.size() - 1) + 1;
                        System.out.println(choix); 
                        choix -= 1; 

                        System.out.println("Vous avez choisi le personnage " + persoAChoisir.get(choix).getNom() + "\n");
            
                        persoAChoisir.get(choix).setJoueur(this.listeJoueur.get(i));
                        this.listePersonnageUtilises.add(persoAChoisir.get(choix));
                        listePersonnage.remove(persoAChoisir.get(choix));  


                    }

                }
                
                
                else{
                    System.out.println("A " + listeJoueur.get(i).getNom() + " de jouer\n");

                    for(int j = 0; j < listePersonnage.size(); j++){
                        System.out.println("\n"+(j+1) + "." + listePersonnage.get(j).getNom()+" caracteristiques: "+listePersonnage.get(j).getCaracteristiques());
                    }
                    
                    System.out.println("\nQuel personnage choisissez vous ?");
                    int choix = generateur.nextInt(listePersonnage.size());
                    System.out.println(choix);  

                    System.out.println("Vous avez choisi le personnage " + this.listePersonnage.get(choix).getNom() + "\n");

                    this.listePersonnage.get(choix).setJoueur(this.listeJoueur.get(i));
                    this.listePersonnageUtilises.add(listePersonnage.get(choix));
                    listePersonnage.remove(choix);
                }
            
            }
          
        }

        int joueur;

        if(nbJoueurs==2){
            for(int o=0; o<4; o++){
                if(o==0 || o==2){
                    joueur = 0;
                }else{
                    joueur = 1;
                }
                System.out.println("A " + listeJoueur.get(joueur).getNom() + " de jouer\n");

                for(int j = 0; j < listePersonnage.size(); j++){
                    System.out.println("\n"+(j+1) + "." + listePersonnage.get(j).getNom()+" caracteristiques: "+listePersonnage.get(j).getCaracteristiques());
                }
                System.out.println("Choisissez un personnage à écarter :\n");
                int choix=0;
                if(listeJoueur.get(joueur).getNom().equals("Joueur")){
                    choix = interaction.lireUnEntier(1, listePersonnage.size())-1;
                }else{
                    choix = generateur.nextInt(listePersonnage.size());
                }
                listePersonnage.remove(choix);

                for(int j = 0; j < listePersonnage.size(); j++){
                    System.out.println("\n"+(j+1) + "." + listePersonnage.get(j).getNom()+" caracteristiques: "+listePersonnage.get(j).getCaracteristiques());
                }

                System.out.println("Choisissez un personnage à prendre :`\n");
                if(listeJoueur.get(joueur).getNom().equals("Joueur")){
                    choix = interaction.lireUnEntier(1, listePersonnage.size())-1;
                }else{
                    choix = generateur.nextInt(listePersonnage.size());
                }
                this.listePersonnage.get(choix).setJoueur(this.listeJoueur.get(joueur));
                listePersonnageUtilises.add(listePersonnage.get(choix));
                listePersonnage.remove(choix);
                
            }
        }else if(nbJoueurs==3){

            for(int o=0; o<6; o++){

                if(o==0 || o==3){
                    joueur =0;
                }else if(o==1 || o==4){
                    joueur =1;
                }else{
                    joueur =2;
                }
                for(int j = 0; j < listePersonnage.size(); j++){
                    System.out.println("\n"+(j+1) + "." + listePersonnage.get(j).getNom()+" caracteristiques: "+listePersonnage.get(j).getCaracteristiques());
                }

                int choix=0;
                System.out.println("Choisissez un personnage à prendre :`\n");
                if(listeJoueur.get(joueur).getNom().equals("Joueur")){
                    choix = interaction.lireUnEntier(1, listePersonnage.size())-1;
                }else{
                    choix = generateur.nextInt(listePersonnage.size());
                }
                this.listePersonnage.get(choix).setJoueur(this.listeJoueur.get(joueur));
                listePersonnageUtilises.add(listePersonnage.get(choix));
                listePersonnage.remove(choix);
                for(int j = 0; j < listePersonnage.size(); j++){
                    System.out.println("\n"+(j+1) + "." + listePersonnage.get(j).getNom()+" caracteristiques: "+listePersonnage.get(j).getCaracteristiques());
                }

                if(o==0 || o==2){
                    System.out.println("Choisissez un personnage à écarter :\n");
                    if(listeJoueur.get(joueur).getNom().equals("Joueur")){
                        choix = interaction.lireUnEntier(1, listePersonnage.size())-1;
                    }else{
                        choix = generateur.nextInt(listePersonnage.size());
                    }
                    listePersonnage.remove(choix);
                }
                
            }
            listePersonnage.remove(0);
        }

        for(int i = 0; i < this.listeJoueur.size(); i++){
            if(this.listeJoueur.get(i).nbQuartiersDansCite()>0){
                for(int j = 0; j < this.listeJoueur.get(i).nbQuartiersDansCite(); j++){
                    if(this.listeJoueur.get(i).getCite()[j]!=null){
                        if(this.listeJoueur.get(i).getCite()[j].equals(Configuration.theatre)){
                            System.out.println("Vous avez la merveille Theatre.\nVous pouvez choisir d'echanger votre personnage avec un autre joueur.\nVoulez-vous echanger ?");
    
                            boolean echangerPerso;
    
                            if(this.listeJoueur.get(i).getNom().equals("Joueur")){
                                echangerPerso = Interaction.lireOuiOuNon();
                            }else{
                                echangerPerso = generateur.nextBoolean();
                            }
    
                            if(echangerPerso){
                                for(int k = 0; k < this.listeJoueur.size(); k++){
                                    System.out.println((k+1) + ". " + this.listeJoueur.get(k).getNom());
                                }
    
                                System.out.println("Avec quel joueur voulez-vous echanger votre personnage ?");
    
                                boolean choisiLuiMeme = false;
                                int echangerAvecJoueur = 0;
    
                                do{
    
                                    choisiLuiMeme = false;
    
                                    if(this.listeJoueur.get(i).getNom().equals("Joueur")){
                                        echangerAvecJoueur = Interaction.lireUnEntier(1, this.listeJoueur.size());
                                        echangerAvecJoueur--;
                                    }else{
                                        echangerAvecJoueur = generateur.nextInt(this.listeJoueur.size());
                                    }
    
                                    if(this.listeJoueur.get(echangerAvecJoueur).equals(this.listeJoueur.get(i))){
                                        choisiLuiMeme = true;
                                        System.out.println("Vous ne pouvez pas vous choisir vous-même");
                                    }
    
                                }while(choisiLuiMeme);
                                Personnage persoEchange1 = this.listeJoueur.get(echangerAvecJoueur).getPersonnage();
                                Personnage persoEchange2 = this.listeJoueur.get(i).getPersonnage();
    
                                persoEchange1.setJoueur(this.listeJoueur.get(i));
                                persoEchange2.setJoueur(this.listeJoueur.get(echangerAvecJoueur));
    
                                System.out.println("Les personnages ont bien ete echanges.");
    
                            }
                        }
                    }
                    
            
                }
            }
                
        }

        

        System.out.println(
            "\n\tLe choix des personnages est terminé.\n" +
            "\tLe tour commence : \n" +
            "----------------------------------------------\n"
        );
    }

    private void percevoirRessource(int personnage) {
        System.out.println("\tVoulez-vous percevoir des cartes ou des pièces d'or ?\t");
        System.out.println("1 : deux cartes");
        System.out.println("2 : deux pièces d'or");
        int response = 0;
        if (!this.plateauDeJeu.getPersonnage(personnage).getJoueur().isSimule())
            response = Interaction.lireUnEntier(1, 3);
        else {
            do {
                response = this.generateur.nextInt(3);
            } while (response == 0);
        }
        if (response == 1) {

            System.out.println("\tVous avez pioché deux cartes\n");

            Quartier[] quartiers = new Quartier[2];
            for (int i = 0; i < quartiers.length; i++) {
                quartiers[i] = this.plateauDeJeu.getPioche().piocher();
            }
            System.out.println("\tVoici les cartes que vous avez pioché : ");
            for (int i = 0; i < quartiers.length; i++) {
                System.out.println((i + 1) + " : " + quartiers[i].getNom() + " - type : " +
                    quartiers[i].getType() + " - pièces : " + quartiers[i].getCout());
            }
            System.out.println("\tQuelle carte voulez-vous garder ? : ");
            int carte = 0;
            if (!plateauDeJeu.getPersonnage(personnage).getJoueur().isSimule())
                carte = Interaction.lireUnEntier(1, 3);
            else {
                do {
                    carte = this.generateur.nextInt(3);
                } while (carte == 0);
            }
            plateauDeJeu.getPersonnage(personnage).ajouterQuartier(quartiers[carte - 1]);
            for (int i = 0; i < quartiers.length; i++) {
                if (!quartiers[carte - 1].getNom().equals(quartiers[i].getNom())) {
                    plateauDeJeu.getPioche().ajouter(quartiers[i]);
                    break;
                }
            }
        } else {
            System.out.println("\tVous avez perçu deux pièces d'or\n");
            this.plateauDeJeu.getPersonnage(personnage).ajouterPieces();
        }
    }

    private void calculDesPoints() {
        int[][] scores = new int[this.plateauDeJeu.getNombreJoueurs()][1];
        int score = 0;
        for (int i = 0; i < this.plateauDeJeu.getNombreJoueurs(); i++) {
            ArrayList < String > quartiers = new ArrayList < > ();
            for (int j = 0; j < this.plateauDeJeu.getJoueur(i).nbQuartiersDansCite(); j++) {
                score += this.plateauDeJeu.getJoueur(i).getCite()[j].getCout();
                if (!quartiers.contains(this.plateauDeJeu.getJoueur(i).getCite()[j].getType()))
                    quartiers.add(this.plateauDeJeu.getJoueur(i).getCite()[j].getType());
            }
            if (quartiers.size() >= 5)
                score += 3;
            if (this.plateauDeJeu.getJoueur(i).isPremier())
                score += 4;
            else {
                if (this.plateauDeJeu.getJoueur(i).nbQuartiersDansCite() >= 7)
                    score += 2;
            }
            scores[i][0] = score;
            System.out.println("\t"+this.plateauDeJeu.getJoueur(i).getNom() + " a un total de " + score + " points !\n");
        }
        int joueurMax = 0;
        int scoreMax = scores[0][0];
        for (int i = 0; i < scores.length; i++) {
            if (scores[i][0] >= scoreMax) {
                if (scores[i][0] == scoreMax) {
                    if (this.plateauDeJeu.getJoueur(i).isRangPlusEleve()) {
                        scoreMax = scores[i][0];
                        joueurMax = i;
                    }
                } else {
                    scoreMax = scores[i][0];
                    joueurMax = i;
                }
            }
        }
        System.out.println("\t"+this.plateauDeJeu.getJoueur(joueurMax).getNom() + " a remporté la partie avec un total de " + scoreMax + " points.\n");
        System.out.println("\tFélicitation " + this.plateauDeJeu.getJoueur(joueurMax).getNom() + "!!!\n");
    }

    private void afficherBienvenue() {
        System.out.println("----------------------------------------------\n"+"\tBienvenue dans Citadelles\n"+"----------------------------------------------\n");
    } 

    private void afficherMenu() {
        System.out.println("Veuillez entrer le chiffre correspondant à  votre choix !");
        System.out.println("	1 : 	Jouer une nouvelle partie. ");
        System.out.println("	2 : 	Afficher les règles du jeu. ");
        System.out.println("	3 : 	Quitter l'application. ");
    }

    private void quitterPartie() {
        System.out.println("\tÀ bientôt dans Citadelles !");
        System.exit(0);
    }
}