package modele;

public class Negociant extends Personnage {

    public Negociant() {
        super("Négociant", 6, Caracteristiques.NEGOCIANT);
    }

    public void percevoirRessourcesSpecifiques() {
        if(this.getAssassine()){
            super.percevoirRessourcesSpecifiques();
        }else{
            for(int i = 0; i < this.getJoueur().nbQuartiersDansCite(); i++){
                if(this.getJoueur().getCite()[i].getType().equals(Quartier.TYPE_QUARTIERS[3])){
                    this.getJoueur().ajouterPieces(1);
                }
            }
        }
    }
	
	public void utiliserPouvoir() {}

	public void utiliserPouvoirAvatar() {}
}
