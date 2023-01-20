package leSixQuiPrend;
/**
 * @author RABIARIVELO Ilo Andrianaly 
 *
 */

import java.util.ArrayList;
import java.util.Collections;

public class MainduJoueur {
	private int nombredecarte = 10;
	private ArrayList<Carte> cartes;
	private int scoretotaldeboeuf;
	
	/**
	 * @brief crée une main pour le joueur en piochant le nombre de carte correspondant dans la pioche
	 * @param pioche la pioche de la partie
	 */
	public MainduJoueur(Pioche pioche) {
		this.scoretotaldeboeuf=0;
		this.cartes = new ArrayList<>();
		for(int i=0;i<nombredecarte;i++) {
			cartes.add(pioche.piocher());
		}
		Collections.sort(cartes,Carte::compareCarte);
	}
	
	/**
	 * @brief ajoute dans le score de tête de boeuf de la main et vide la série correspondante
	 * @param serie la série dans laquel on récupère les têtes de boeufs et qui va être vidé
	 */
	public void scoredetetedeboeuf(Serie serie) {
		for(int i=0;i<serie.getSerie().size();i++) {
			this.scoretotaldeboeuf+=serie.getSerie().get(i).getTetedeboeuf();
		}
		serie.videserie();
	}
	
	/**
	 * @brief vérifie si une carte est bien dans la main du joueur
	 * @param num le numéro de la carte
	 * @return boolean vrai ou faux si elle est bien présente
	 */
	public boolean estdanslamain(int num) {
		for(int i=0;i<this.nombredecarte;i++) {
			if(num==this.cartes.get(i).getNumdecarte()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @brief joue une carte dans une série 
	 * @param num le numéro de la carte
	 * @param serie la série ou la carte va être posé
	 */
	public void jouerunecarte(int num, Serie serie) {
			for(int i=0;i<this.nombredecarte;i++) {
				if(num==this.cartes.get(i).getNumdecarte()) {
				serie.poserdanslaserie(this.cartes.get(i));
				this.cartes.remove(i);
				this.nombredecarte-=1;
				}
			}
	}
	
	/**
	 * @brief prend une carte la main et l'enlève mais qui renvoie une carte
	 * @param n le numéro de la carte correspondante
	 * @return la carte enlevé de la main
	 */
	public Carte prendrelacarte(int n) {
		Carte cartearetourner=new Carte();
		for(int i=0;i<this.nombredecarte;i++) {
			if(n==this.cartes.get(i).getNumdecarte()) {
				cartearetourner=this.cartes.get(i);
			}
		}
		return cartearetourner;
	}
	
	/**
	 * @brief permet d'accéder aux cartes de la main
	 * @return la liste de cartes qui correspond à la main
	 */
	public ArrayList<Carte> getcartes() {
		return this.cartes;
	}
	
	/**
	 * @brief permet l'accès aux scores totales de têtes de boeuf 
	 * @return l'entier correspondant au score total
	 */
	public int getScoretotaldeboeuf() {
		return scoretotaldeboeuf;
	}
	
	/**
	 * @brief affiche le contenu de la main 
	 * @return String toutes les cartes de la main
	 */
	public String toString() {
		StringBuilder lamain = new StringBuilder();
		lamain.append("- Vos cartes :");
		for(int i=0; i<cartes.size();i++) {
			lamain.append(this.cartes.get(i));
			if (this.cartes.size()-1==i) {
				lamain.append("");
			}
			else {
				lamain.append(",");
			}
		}
		return lamain.toString();
	}

	

}
