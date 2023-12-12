package modele;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import controleur.Interaction;

public class Capitaine extends Personnage{
    public Capitaine() {
        super("Capitaine", 8, Caracteristiques.CAPITAINE);
    }

    Interaction scan = new Interaction();

    public void percevoirRessourcesSpecifiques() {
        if(this.getAssassine()){
            super.percevoirRessourcesSpecifiques();
        }else{
            for(int i = 0; i < this.getJoueur().nbQuartiersDansCite(); i++){
                if(this.getJoueur().getCite()[i].getType().equals(Quartier.TYPE_QUARTIERS[1])){
                    this.getJoueur().ajouterPieces(1);
                }
            }
        }
    }

    public void utiliserPouvoir() {
        System.out.println("Vous pouvez choisir un quartier dans la cite d'un joueur avec un cout inferieur a 3");
        System.out.println("Vous pouvez l'ajouter a votre cite en payant le cout de construction a  son proprietaire");
        //implémentation de la merveille donjon
        //implémentation de la merveille Grande Muraille
        boolean aGrandeMuraille = false;
        int prixEnPlus = 0;
        boolean repeter = false;
        do{

                System.out.println("Veuillez choisir le joueur dont vous voulez prendre une carte (0 pour ne rien faire)");


                for(int i = 0; i < this.getPlateau().getNombreJoueurs(); i++){
                    System.out.println((i+1) + "." + this.getPlateau().getJoueur(i).getNom() + " : " + this.getPlateau().getJoueur(i).nbQuartiersDansCite() + " carte(s).");
                }

                int choix  = Interaction.lireUnEntier(0, this.getPlateau().getNombreJoueurs()) - 1;

                if(choix != -1){
                    if(this.getPlateau().getPersonnage(choix).nom.equals(this.nom)){
                        SelfChosen();
                    }else if(this.getPlateau().getPersonnage(choix).nom.equals("Eveque")) {
                        CantChoose();
                    }

                    Quartier[] citeJoueur = this.getPlateau().getJoueur(choix).getCite();

                    for(int i=0; i<this.getPlateau().getJoueur(choix).nbQuartiersDansCite(); i++) {
                        if(citeJoueur[i].getNom().equals("Grande Muraille")) {
                            aGrandeMuraille = true;
                        }
                    }

                    if(aGrandeMuraille) {
                        System.out.println("Vous avez choisi un joueur possedant la merveille grande muraille, les quartiers que vous essayerez de détruire auront un cout d'une piece en plus.\n");
                        prixEnPlus = 1;
                    }



                    ArrayList<Quartier> copie = new ArrayList<Quartier>();
                    for(int i=0; i<this.getPlateau().getJoueur(choix).nbQuartiersDansCite(); i++) {
                        if(citeJoueur[i].getCout()<=3 && this.getJoueur().quartierPresentDansCite(citeJoueur[i].getNom()) == false) {
                            copie.add(citeJoueur[i]);
                        }
                    }
                    if(copie.size() == 0) {
                        System.out.println("Ce joueur n'a pas de quartier rentrant dans les crit�res de votre pouvoir");
                        repeter = true;
                    }else {

                        boolean continu = false;
                        do{
                            for(int i =0; i<copie.size(); i++) {
                                System.out.println((i+1) + " - " + copie.get(i).getNom() + "[ " + copie.get(i).getType() + ", " + copie.get(i).getCout() + " ]");
                            }

                            System.out.println("Veuillez choisir le quartier a prendre (0 pour ne rien faire)");

                            int choix1 = scan.lireUnEntier(1, copie.size()) -1;

                            if(choix1 != -1){
                                if(this.getPlateau().getJoueur(choix).getCite()[choix1].getNom().equals("Donjon")){
                                    System.out.println("Vous ne pouvez pas choisir le Donjon");
                                    continu = true;

                                }else{
                                    System.out.println("Voulez vous construire " + this.getPlateau().getJoueur(choix).getCite()[choix1].getNom() + " ?");
                                    Boolean choixConstruct = scan.lireOuiOuNon();
                                    if(choixConstruct) {
                                        if(this.getJoueur().nbPieces()>= this.getPlateau().getJoueur(choix).getCite()[choix1].getCout()) {
                                            this.getJoueur().ajouterQuartierDansCite(this.getPlateau().getJoueur(choix).getCite()[choix1]);
                                            this.getJoueur().retirerPieces(this.getPlateau().getJoueur(choix).getCite()[choix1].getCout() + prixEnPlus);
                                            this.getPlateau().getJoueur(choix).ajouterPieces(this.getPlateau().getJoueur(choix).getCite()[choix1].getCout() + prixEnPlus);
                                            this.getPlateau().getJoueur(choix).retirerQuartierDansCite(this.getPlateau().getJoueur(choix).getCite()[choix1].getNom());

                                            continu = false;
                                        }else {
                                            System.out.println("Votre tresor n'est pas suffisant pour construire ce quartier");
                                            continu = true;
                                        }
                                    }
                                }

                            }else{
                                continu = false;
                                repeter = false;
                            }
                        }while(continu);

                        repeter = false;
                    }

                }else{
                    repeter = false;

                }

        }while(repeter);


    }

    public void utiliserPouvoirAvatar() {

        //implémentation de la merveille donjon
        //implémentation de la merveille Grande Muraille
        boolean aGrandeMuraille = false;
        int prixEnPlus = 0;


        Random generateur = new Random();
        System.out.println("Vous pouvez choisir un quartier dans la cité d'un joueur avec un cout inférieur à 3");
        System.out.println("Vous pouvez l'ajouter à votre cité en payant le coût de construction à  son propriétaire");
        System.out.println("Veuillez choisir le joueur dont vous voulez prendre une carte");

        boolean repeter = false;
        do{

                for(int i = 0; i < this.getPlateau().getNombreJoueurs(); i++){
                    System.out.println((i+1) + "." + this.getPlateau().getJoueur(i).getNom() + " : " + this.getPlateau().getJoueur(i).nbQuartiersDansCite() + " carte(s).");
                }
                int choix = ThreadLocalRandom.current().nextInt(0,this.getPlateau().getNombreJoueurs()+1) - 1;

                if(choix != -1){
                    if(this.getPlateau().getPersonnage(choix).nom.equals(this.nom)){
                        SelfChosen();
                    }else if(this.getPlateau().getPersonnage(choix).nom.equals("Eveque")) {
                        CantChoose();
                    }
                    Quartier[] citeJoueur = this.getPlateau().getJoueur(choix).getCite();

                    for(int i=0; i<this.getPlateau().getJoueur(choix).nbQuartiersDansCite(); i++) {
                        if(citeJoueur[i].getNom().equals("Grande Muraille")) {
                            aGrandeMuraille = true;
                        }
                    }

                    if(aGrandeMuraille) {
                        System.out.println("Vous avez choisi un joueur possedant la merveille grande muraille, les quartiers que vous essayerez de deplacer auront un cout d'une piece en plus.\n");
                        prixEnPlus = 1;
                    }


                    ArrayList<Quartier> copie = new ArrayList<Quartier>();
                    for(int i=0; i<this.getPlateau().getJoueur(choix).nbQuartiersDansCite(); i++) {
                        if(citeJoueur[i].getCout()<=3 && this.getJoueur().quartierPresentDansCite(citeJoueur[i].getNom()) == false) {
                            copie.add(citeJoueur[i]);
                        }
                    }
                    if(copie.size() == 0) {
                        System.out.println("Ce joueur n'a pas de quartier rentrant dans les critères de votre pouvoir");
                        repeter = true;
                    }else {
                        boolean continu = false;
                        do{
                            for(int i =0; i<copie.size(); i++) {
                                System.out.println((i+1) + " - " + copie.get(i).getNom() + "[ " + copie.get(i).getType() + ", " + copie.get(i).getCout() + " ]");
                            }

                            System.out.println("Veuillez choisir le quartier a prendre (0 pour ne rien faire)");

                            int choix1 = generateur.nextInt(copie.size()+1)-1;

                            if(choix1 != -1){
                                if(this.getPlateau().getJoueur(choix).getCite()[choix1].getNom().equals("Donjon")){
                                    System.out.println("Vous ne pouvez pas choisir le Donjon");
                                    continu = true;

                                }else{
                                    System.out.println("Voulez vous construire " + this.getPlateau().getJoueur(choix).getCite()[choix1].getNom() + " ?");
                                    Boolean choixConstruct = generateur.nextBoolean();
                                    if(choixConstruct) {
                                        if(this.getJoueur().nbPieces()>= this.getPlateau().getJoueur(choix).getCite()[choix1].getCout()) {
                                            this.getJoueur().ajouterQuartierDansCite(this.getPlateau().getJoueur(choix).getCite()[choix1]);
                                            this.getJoueur().retirerPieces(this.getPlateau().getJoueur(choix).getCite()[choix1].getCout() + prixEnPlus);
                                            this.getPlateau().getJoueur(choix).ajouterPieces(this.getPlateau().getJoueur(choix).getCite()[choix1].getCout() + prixEnPlus);
                                            this.getPlateau().getJoueur(choix).retirerQuartierDansCite(this.getPlateau().getJoueur(choix).getCite()[choix1].getNom());

                                            continu = false;
                                        }else {
                                            System.out.println("Votre t�sor n'est pas suffisant pour construire ce quartier");
                                            continu = true;
                                        }
                                    }
                                }

                            }else{
                                continu = false;
                                repeter = false;

                            }
                        }while(continu);

                        repeter = false;
                    }


                }else{
                    repeter = false;
                }

        }while(repeter);

    }

        private void SelfChosen() {
            System.out.println("Vous ne pouvez pas vous choisir. ");
    }

    private void CantChoose() {
            System.out.println("Vous ne pouvez pas choisir l'Eveque.");
    }

}
