package modele.personnage;

import java.util.concurrent.ThreadLocalRandom;

import controleur.Interaction;
import modele.Caracteristiques;
import modele.Personnage;
import modele.Quartier;

public class Abbe extends Personnage {
    
    public Abbe() {
        super("Abbé", 5, Caracteristiques.ABBE);
    }

    public void utiliserPouvoir() {
		int count = 0;
        if(this.getAssassine()){
            System.out.println("Votre personnage a été assassiné");
        }else{
            for(int i = 0; i < this.getJoueur().nbQuartiersDansCite(); i++){
                if(this.getJoueur().getCite()[i]!=null){
					if(this.getJoueur().getCite()[i].getType().equals(Quartier.TYPE_QUARTIERS[0])){
						count++;
					}
				}
            }
            System.out.println("Vous pouvez percevoir " + count + " ressources (pi�ces ou quartiers)");
            System.out.println("Veuillez saisir le nombre de pièces que vous souhaitez percevoir : "
            		+ "(si vous inscrivez le nombre maximal vous ne percevrez que des pièces"
            		+ " sinon vous percevrez le reste des ressources comme quartiers)");
            int choix = Interaction.lireUnEntier(0, count);
            this.getJoueur().ajouterPieces(choix);
            for(int i=0; i<count-choix; i++) {
            	this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
            }
            System.out.println("Vous avez reçu "+ choix + " pièces et " + (count-choix) + " quatiers");
            int id=0;
            int tresorMax = 0;
            String nomJ = "";
            for(int i=0; i<this.getPlateau().getNombreJoueurs(); i++) {
            	if(this.getPlateau().getJoueur(i).nbPieces() > tresorMax) {
            		tresorMax = this.getPlateau().getJoueur(i).nbPieces();
            		id = i;
            		nomJ = this.getPlateau().getJoueur(i).getNom();
            	}else if(this.getPlateau().getJoueur(i).nbPieces() == tresorMax && this.getPlateau().getJoueur(i).nbPieces()!=0 && !this.getPlateau().getJoueur(i).getNom().equals(this.getJoueur().getNom())) {
            		System.out.println("Deux joueurs ont le même nombre de pièces choisissez le joueur à qui vous voulez prendre des pièces");
            		System.out.println("1 - " + nomJ + "( " + tresorMax + " )");
            		System.out.println("2 - " + this.getPlateau().getJoueur(i).getNom() + "( " + this.getPlateau().getJoueur(i).nbPieces() + " )");
            		int choixJ = Interaction.lireUnEntier(1, 2);
            		if(choixJ == 2) {
            			tresorMax = this.getPlateau().getJoueur(i).nbPieces();
                		id = i;
                		nomJ = this.getPlateau().getJoueur(i).getNom();
            		}
            	}
            }
            if(!nomJ.equals(this.getJoueur().getNom())) {
            	System.out.println("Vous allez maintenat recevoir 1 pi�ce du joueur le plus riche");
            	this.getPlateau().getJoueur(id).retirerPieces(1);
            	this.getJoueur().ajouterPieces(1);
            }else {
            	System.out.println("Vous �tes le joueur le plus riche et vous ne pouvez donc pas recevoir d'or du joueur le plus riche");
            }
        }
        
		
	}

	public void utiliserPouvoirAvatar() {
		int count = 0;
        if(this.getAssassine()){
            System.out.println("Votre personnage a été assassiné");
        }else{
            for(int i = 0; i < this.getJoueur().nbQuartiersDansCite(); i++){
				if(this.getJoueur().getCite()[i]!=null){
					if(this.getJoueur().getCite()[i].getType().equals(Quartier.TYPE_QUARTIERS[0])){
						count++;
					}
				}
                
            }
            System.out.println("Vous pouvez percevoir " + count + " ressources (pièces ou quartiers)");
            System.out.println("Veuillez saisir le nombre de pièces que vous souhaitez percevoir : "
            		+ "(si vous inscrivez le nombre maximal vous ne percevrez que des pièces"
            		+ " sinon vous percevrez le reste des ressources comme quartiers)");
            int choix = ThreadLocalRandom.current().nextInt(0, count+1);
            this.getJoueur().ajouterPieces(choix);
            for(int i=0; i<count-choix; i++) {
            	this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
            }
            System.out.println("Vous avez reçu "+ choix + " pièces et " + (count-choix) + " quatiers");
            int id=0;
            int tresorMax = 0;
            String nomJ = "";
            for(int i=0; i<this.getPlateau().getNombreJoueurs(); i++) {
            	if(this.getPlateau().getJoueur(i).nbPieces() > tresorMax) {
            		tresorMax = this.getPlateau().getJoueur(i).nbPieces();
            		id = i;
            		nomJ = this.getPlateau().getJoueur(i).getNom();
            	}else if(this.getPlateau().getJoueur(i).nbPieces() == tresorMax && this.getPlateau().getJoueur(i).nbPieces()!=0 && !this.getPlateau().getJoueur(i).getNom().equals(this.getJoueur().getNom())) {
            		System.out.println("Deux joueurs ont le même nombre de pièces choisissez le joueur à qui vous voulez prendre des pièces");
            		System.out.println("1 - " + nomJ + "( " + tresorMax + " )");
            		System.out.println("2 - " + this.getPlateau().getJoueur(i).getNom() + "( " + this.getPlateau().getJoueur(i).nbPieces() + " )");
            		int choixJ = ThreadLocalRandom.current().nextInt(1, 3);
            		if(choixJ == 2) {
            			tresorMax = this.getPlateau().getJoueur(i).nbPieces();
                		id = i;
                		nomJ = this.getPlateau().getJoueur(i).getNom();
            		}
            	}
            }
            if(!nomJ.equals(this.getJoueur().getNom())) {
            	System.out.println("Vous allez maintenat recevoir 1 pièce du joueur le plus riche");
            	this.getPlateau().getJoueur(id).retirerPieces(1);
            	this.getJoueur().ajouterPieces(1);
            }else {
            	System.out.println("Vous êtes le joueur le plus riche et vous ne pouvez donc pas recevoir d'or du joueur le plus riche");
            }
        }
	}
}
