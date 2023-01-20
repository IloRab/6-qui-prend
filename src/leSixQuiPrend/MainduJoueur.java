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
	 * @brief cr�e une main pour le joueur en piochant le nombre de carte correspondant dans la pioche
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
	 * @brief ajoute dans le score de t�te de boeuf de la main et vide la s�rie correspondante
	 * @param serie la s�rie dans laquel on r�cup�re les t�tes de boeufs et qui va �tre vid�
	 */
	public void scoredetetedeboeuf(Serie serie) {
		for(int i=0;i<serie.getSerie().size();i++) {
			this.scoretotaldeboeuf+=serie.getSerie().get(i).getTetedeboeuf();
		}
		serie.videserie();
	}
	
	/**
	 * @brief v�rifie si une carte est bien dans la main du joueur
	 * @param num le num�ro de la carte
	 * @return boolean vrai ou faux si elle est bien pr�sente
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
	 * @brief joue une carte dans une s�rie 
	 * @param num le num�ro de la carte
	 * @param serie la s�rie ou la carte va �tre pos�
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
	 * @brief prend une carte la main et l'enl�ve mais qui renvoie une carte
	 * @param n le num�ro de la carte correspondante
	 * @return la carte enlev� de la main
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
	 * @brief permet d'acc�der aux cartes de la main
	 * @return la liste de cartes qui correspond � la main
	 */
	public ArrayList<Carte> getcartes() {
		return this.cartes;
	}
	
	/**
	 * @brief permet l'acc�s aux scores totales de t�tes de boeuf 
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
