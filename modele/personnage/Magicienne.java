package modele;

import java.util.ArrayList;
import java.util.Random;

import controleur.Interaction;

public class Magicienne extends Personnage {

	public Magicienne() {
		super("Magicienne", 3, Caracteristiques.MAGICIENNE);
	}

	public void utiliserPouvoir() {
//         Si l’utilisateur veut ´echanger toutes ses cartes avec celles d’un adversaire :
// — Afficher tous les joueurs pr´esents en affichant le nombre de cartes de leurs mains (pas le
// contenu de la main).
// — Demander `a l’utilisateur de choisir un joueur (la magicienne ne peut pas se choisir).
// — Faire une copie de la main de la magicienne et une copie de la main du joueur choisi
// — Vider la main (originale) de la magicienne ainsi que celle du joueur choisi
// — Ajouter le contenu des copies dans les mains (originales).
// — Sinon, si l’utilisateur n’a pas de cartes dans sa main, ne rien faire
// — Sinon, demander `a l’utilisateur le nombre de cartes nb qu’il veut remplacer :
// — si nb vaut 0, ne rien faire
// — si nb correspond au nombre de cartes de la main de la magicienne
// — Faire une copie de la main de la magicienne
// — Retirer un `a un les quartiers de la main (originale) et les ajouter dans la pioche
// — Ajouter autant de cartes de la pioche dans la main
// — sinon :
// — Faire une copie de la main de la magicienne
// — Afficher toutes les cartes de la copie
// — Faire nb fois :
// — Demander `a l’utilisateur de choisir une carte
// — Supprimer la carte de la copie et l’ajouter dans la pioche.
// — Ajouter nb cartes de la pioche dans la copie
// — Vider la main (originale) de la magicienne
// — Ajouter toutes les cartes de la copie dans la main (originale)
    }
    public void utiliserPouvoirAvatar(){

    }
}